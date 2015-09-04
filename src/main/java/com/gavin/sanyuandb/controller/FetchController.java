package com.gavin.sanyuandb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FetchController {

	@RequestMapping(value = "/fetch")
	public String helloWorld(ModelMap map) {
		return "fetch";
	}

	@RequestMapping(value = "/get")
	public String getmenus(ModelMap map) {
		return "get";
	}
}
