package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	@RequestMapping(value="/ItTasks", method=RequestMethod.GET)
	public String index()
	{
		return "ItTasks/index";
	}
	
	@RequestMapping(value="/ItTasks", method=RequestMethod.POST)
	public String query(Model model, HttpServletRequest request)
	{
		
		List<ItTask> task_list = itTaskService.findWithCDateTime(
				request.getParameter("inputStartDatetime"), 
				request.getParameter("inputEndDatetime")
		);
		
		model.addAttribute("task_list", task_list);
		return "ItTasks/index";
	}
}
