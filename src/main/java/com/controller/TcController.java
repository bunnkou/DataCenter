package com.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.fkit.domain.ItTask;
import org.fkit.domain.Timecard;
import org.fkit.service.TcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TcController {
	
	@Autowired
	private TcService tcService;
	
	@RequestMapping(value="/Timecard", method=RequestMethod.GET)
	public String index(Model model, HttpServletRequest request)
	{
		request.setAttribute("CURRENT_PAGE_NAME", "Timecard");
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		model.addAttribute("inputEndDatetime", DateFormatUtils.format(cal.getTime() , "yyyy-MM-dd") );
		cal.add(Calendar.MONTH, -1);
		model.addAttribute("inputStartDatetime", DateFormatUtils.format(cal.getTime() , "yyyy-MM-dd") );
		
		return "Timecard/index";
	}
	
	@RequestMapping(value="/Timecard/show")
	@ResponseBody
	public Map<String, Object> query(HttpServletRequest request) throws IOException
	{
		String inputStartDatetime = request.getParameter("inputStartDatetime"),
			   inputEndDatetime = request.getParameter("inputEndDatetime"),
			   inputKeyword = request.getParameter("inputKeyword"),
			   pageNumber = request.getParameter("pageNumber"),
			   pageSize = request.getParameter("pageSize");
		int page = pageNumber==null|pageNumber.equals("")?0:Integer.parseInt(pageNumber),
			rows = pageSize==null|pageSize.equals("")?0:Integer.parseInt(pageSize);
		Calendar sdt = Calendar.getInstance();
		Calendar edt = Calendar.getInstance();
		sdt.setTime(string2date(inputStartDatetime));
		edt.setTime(string2date(inputEndDatetime));
		List<Integer> yearLst = new ArrayList<Integer>();
		while( sdt.get(Calendar.YEAR) <= edt.get(Calendar.YEAR)  )
		{
			yearLst.add( sdt.get(Calendar.YEAR) );
			sdt.add(Calendar.YEAR, 1);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", tcService.countBySpec(yearLst, inputStartDatetime, inputEndDatetime, inputKeyword));
		map.put("rows", tcService.findWithDate(yearLst, inputStartDatetime, inputEndDatetime, inputKeyword, page, rows));
		return map;
	}
	
	public static Date string2date(String dateStr)
	{
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = fmt.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
}
