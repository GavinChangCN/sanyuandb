package com.gavin.springmvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelpController {

	@RequestMapping(value = "/help")
	public String helloWorld(ModelMap map) {
		return "help";
	}

}
