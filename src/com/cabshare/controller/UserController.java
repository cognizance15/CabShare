package com.cabshare.controller;

import javax.servlet.http.HttpServletRequest;

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
			HttpServletRequest httpServletRequest){
		
		User user = new User();
		if(userType==0){
			user.setType("p");
		}else{
			user.setType("d");
		}
		
		boolean uniqueness = userService.validateUsername(username);
		if(uniqueness){
			user.setUsername(username);
			user.setEmail(email);
			user.setPassword(password);
			if(userService.register(user)){
				httpServletRequest.getSession().setAttribute("username", username);
				if(user.getType().equals("p"))
					return "homepage";
				else{
					return "dhomepage";
				}
			}
		}else{
			httpServletRequest.getSession().setAttribute("usernameNotUnique", true);
		}
		return "register";
	}
	
	@RequestMapping(value="/updateDetails.htm", method=RequestMethod.POST)
	public String updateDetails(@RequestParam("name") String name, 
						@RequestParam("age") int age,
						@RequestParam("gender") String gender,
						@RequestParam("mobile") int mobile,
						HttpServletRequest httpServletRequest){
		System.out.println("UserController.save()");
		httpServletRequest.getSession();
		//default annotation handler mapping will pass this request
		
		
		
		User user = new User();
		String username = (String)httpServletRequest.getSession().getAttribute("username");
		System.out.println(username);
		user.setUsername(username);
		user.setName(name);
		user.setAge(age);
		user.setGender(gender);
		user.setMobNo(mobile);

		System.out.println(user);
		if(userService.updateDetails(user)){
			return "homepage";
		}
		return "updateDetails";
	}
	
	@RequestMapping(value="/checkLogin.htm", method=RequestMethod.POST)
	public String checkLogin(@RequestParam("username") String username, 
						@RequestParam("password") String password,
						@RequestParam("userType") int userType,
						HttpServletRequest httpServletRequest){
		String type=userType>0?"d":"p";
		boolean status = userService.login(username, password, type);
		passenger.setUsername(username);
		//default annotation handler mapping will pass this request
		if(status){
			httpServletRequest.getSession().setAttribute("username", username);
			if(userType==0){
				return "homepage";
			}else{
				return "dhomepage";
			}
			
		}
		httpServletRequest.getSession().setAttribute("loginStatus", false);
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
		System.out.println(size);
		System.out.println(source);
		System.out.println(destination);
		
		System.out.println(submit);
		if(submit==1){
			System.out.println("UserController.takeride()");
			boolean status = passService.takeRide(passenger);
			model.addAttribute(passenger);
			System.out.println(status);
			if(status){
				return "ontrip";
			}
			
		}else if(submit==0){
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
	
	@RequestMapping(value="/driverAction.htm", method=RequestMethod.POST)
	public String driverAction(){
		
		return null;
	}
}
