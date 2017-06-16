package com.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.fkit.Utils.ExcelUtil;
import org.fkit.domain.ItTask;
import org.fkit.service.ItTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ItTaskController {
	
	@Autowired
	private ItTaskService itTaskService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(Model model)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		model.addAttribute("inputEndDatetime", DateFormatUtils.format(cal.getTime() , "yyyy-MM-dd") );
		cal.add(Calendar.MONTH, -1);
		model.addAttribute("inputStartDatetime", DateFormatUtils.format(cal.getTime() , "yyyy-MM-dd") );
		return "ItTasks/index";
	}
	
	@RequestMapping(value="/ItTasks", method=RequestMethod.POST)
	public String query(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String inputStartDatetime = request.getParameter("inputStartDatetime"),
			   inputEndDatetime = request.getParameter("inputEndDatetime"),
			   inputKeyword = request.getParameter("inputKeyword"),
			   inputOperate = request.getParameter("inputOperate");
		List<ItTask> task_list = itTaskService.findWithCDateTime(inputStartDatetime, inputEndDatetime, inputKeyword);

		if(inputOperate.equals("1")){
			String fileName = new Date().getTime() + ".xls",
				   colTitle[] = {"申请人","申请时间","申请内容","处理人","完成时间","评分","耗时（分钟）",""},
				   Keys[] = {"Rname_R", "RDateTime", "FDetail", "DName_R", "CDateTime", "MtGrade", "TakingTime"};
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			
			long ttAvg = 0;
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			for ( ItTask o : task_list ){
				Map<String, String> map = new HashMap<String, String>();
				map.put("Rname_R", o.getRname_R());
				map.put("RDateTime", o.getRDateTime());
				map.put("FDetail", o.getFDetail());
				map.put("DName_R", o.getDName_R());
				map.put("CDateTime", o.getCDateTime());
				map.put("MtGrade", o.getMtGrade());
				map.put("TakingTime", o.getTakingTime());
				ttAvg += Long.parseLong(o.getTakingTime());
				list.add(map);
			}
			String AvgTitle = "平均耗时：" + ( ttAvg/task_list.size() );
			colTitle[7] = AvgTitle;
			
			try {
				ExcelUtil.createWorkBook(list, Keys, colTitle).write(os);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			byte[] content = os.toByteArray();
			InputStream is = new ByteArrayInputStream(content);
			
			response.reset();
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "iso-8859-1") );
			ServletOutputStream out = response.getOutputStream();
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			try {
				bis = new BufferedInputStream(is);
				bos = new BufferedOutputStream(out);
				byte[] buff = new byte[2048];
				int bytesRead;
				while (-1 != (bytesRead = bis.read(buff, 0, buff.length))){
					bos.write(buff, 0, bytesRead);
				}
			} catch (final IOException e) {
				throw e;
			}finally{
				if ( bis != null ) bis.close();
				if ( bos != null ) bos.close();
			}
			return null;
		}
		
		model.addAttribute("inputStartDatetime", inputStartDatetime);
		model.addAttribute("inputEndDatetime", inputEndDatetime);
		model.addAttribute("inputKeyword", inputKeyword);
		model.addAttribute("task_list", task_list);
		return "ItTasks/index";
	}
	
	
}
