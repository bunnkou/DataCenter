package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItTaskController {
	@RequestMapping("/ItTasks")
	public String index(){
		return "ItTasks/index";
	}
}
