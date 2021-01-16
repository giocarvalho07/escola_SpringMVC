package com.escola.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeralController {

	
	@GetMapping("/")
	public String menu() {
		return "index";
	}

}
