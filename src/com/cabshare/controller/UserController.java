package com.cabshare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cabshare.entity.User;
import com.cabshare.service.UserService;

@Controller(value="UserController")
public class UserController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@RequestMapping(value="/save.htm", method=RequestMethod.POST)
	public String save(@RequestParam("name") String name, 
						@RequestParam("username") String username, 
						@RequestParam("password") String password,
						@RequestParam("email") String email,
						@RequestParam("mobNo") int mobNo,
						@RequestParam("age") int age,
						@RequestParam("gender") String gender,
						Model model){
		//default annotation handler mapping will pass this request
		User user = new User(name, username, password, email, mobNo, age, gender);
		userService.register(user);
		model.addAttribute("user", user);
		return "save";
	}
	
}
