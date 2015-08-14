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
	
	
	@RequestMapping(value="/index.htm")
	public String goToIndex(){
		System.out.println("UserController.goToIndex()");
		return "index";
	}
	
		
	@RequestMapping(value="/login.htm")
	public String goTologin(){
		System.out.println("UserController.checkEntry()");
		return "login";
	}
	private Passenger passenger= new Passenger();

	
	@RequestMapping(value="/register.htm")
	public String goToregister(){
		System.out.println("UserController.goToregister()");
		return "register";
	}
	
	@RequestMapping(value="/save.htm")
	public String goToUpdateDetails(@RequestParam("username") String username, 
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("userType") int userType,
			Model model){
		
		User user = new User();
		if(userType==0){
			user.setType("p");
		}else{
			user.setType("d");
		}
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		
		
		
		if(userService.register(user)){
			model.addAttribute("username", username);
			return "updateDetails";
		}
		model.addAttribute("username", username);
		return "register";
	}
	
	@RequestMapping(value="/updateDetails.htm", method=RequestMethod.POST)
	public String updateDetails(@RequestParam("username") String username,
						@RequestParam("name") String name, 
						@RequestParam("age") int age,
						@RequestParam("gender") String gender,
						@RequestParam("mobile") int mobile,
						Model model){
		System.out.println("UserController.save()");
		//default annotation handler mapping will pass this request
		
		
		
		User user = new User();
		user.setUsername(username);
		user.setName(name);
		user.setAge(age);
		user.setGender(gender);
		user.setMobNo(mobile);
		model.addAttribute(user);

		System.out.println(user);
		if(userService.updateDetails(user)){
			return "homepage";
		}
		model.addAttribute("saveStatus", false);
		return "updateDetails";
	}
	
	@RequestMapping(value="/checkLogin.htm", method=RequestMethod.POST)
	public String checkLogin(@RequestParam("username") String username, 
						@RequestParam("password") String password,
						Model model){
		System.out.println("UserController.goToLogin()");
		boolean status = userService.login(username, password);
		//default annotation handler mapping will pass this request
		if(status){
			model.addAttribute("username", username);
			passenger.setUsername(username);
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
