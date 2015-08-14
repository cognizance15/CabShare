package com.cabshare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cabshare.entity.Passenger;
import com.cabshare.entity.User;
import com.cabshare.service.PassengerService;
import com.cabshare.service.UserService;

@Controller
public class UserController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	
	@Autowired
	@Qualifier("passService")
	private PassengerService passService;
	
	private Passenger passenger= new Passenger();

	
	@RequestMapping(value="/register.htm")
	public String goToregister(){
		System.out.println("UserController.goToregister()");
		return "register";
	}
	
	@RequestMapping(value="/save.htm", method=RequestMethod.POST)
	public String save(@RequestParam("name") String name, 
						@RequestParam("username") String username, 
						@RequestParam("password") String password,
						@RequestParam("email") String email,
						@RequestParam("age") int age,
						@RequestParam("gender") String gender,
						@RequestParam("mobile") int mobile,
						Model model){
		System.out.println("UserController.save()");
		//default annotation handler mapping will pass this request
		User user = new User(name, username, password, email, mobile, age, gender);
		passenger.setAge(age);
		passenger.setEmail(email);
		passenger.setGender(gender);
		passenger.setName(username);
		passenger.setUsername(username);
		passenger.setPassword(password);
		
		model.addAttribute(user);
		System.out.println(user);
		if(userService.register(user)){
			return "homepage";
		}
		model.addAttribute("saveStatus", false);
		return "register";
	}
	
	@RequestMapping(value="/checkLogin.htm", method=RequestMethod.POST)
	public String goToLogin(@RequestParam("username") String username, 
						@RequestParam("password") String password,
						Model model){
		System.out.println("UserController.goToLogin()");
		boolean status = userService.login(username, password);
		//default annotation handler mapping will pass this request
		if(status){
			return "homepage";
		}
		model.addAttribute("loginStatus", false);
		return "login"; 
	}
	
	
	@RequestMapping(value="/takearide.htm", method=RequestMethod.POST)
	public String takearide(@RequestParam("source") int source, 
						@RequestParam("destination") int destination,
						@RequestParam("ride") int submit,
						@RequestParam("size") int size,
						Model model){
		
		passenger.setDestination(destination);
		passenger.setSource(source);
		passenger.setSize(size);
		System.out.println(submit);
		if(submit==0){
			System.out.println("UserController.takeride()");
			boolean status = passService.takeRide(passenger);
			model.addAttribute(passenger);
			System.out.println(status);
			if(status){
				return "ontrip";
			}
			
		}else if(submit==1){
			System.out.println("UserController.joinride()");
			boolean status = passService.joinRide(passenger);
			model.addAttribute(passenger);
			System.out.println(status);
			if(status){
				return "joinride";
			}

		}
		return "homepage"; 
	}
	
	
}
