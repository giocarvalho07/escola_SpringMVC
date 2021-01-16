package com.escola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.escola.model.User;
import com.escola.service.UserService;

@Controller
@RequestMapping("/app")
public class UserController {
	
	@Autowired
	private UserService userSerice;

	@GetMapping("/user/{login}/{pwd}")
	public ModelAndView getUser(@PathVariable("login") String login, @PathVariable("pwd") String pwd) {
		ModelAndView model = new ModelAndView("userView");
		User user = userSerice.getUserByLogin(login, pwd);
		model.addObject("user", user);
		return model;
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public ModelAndView loginForm(@ModelAttribute User user) {
		ModelAndView model = new ModelAndView();
		user = userSerice.getUserByLogin(user.getLogin(), user.getPwd());
		
		if(user == null) {
			model.setViewName("erro");
		} else {
			model.setViewName("index");
		}
		
		model.addObject("user", user);
		return model;
		
		// receber os dados do formulário dentro do objeto user
		// @modelatributes
	}
	
	
	
	
	
}
