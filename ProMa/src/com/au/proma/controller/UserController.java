package com.au.proma.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.au.proma.model.User;
import com.au.proma.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
//	@RequestMapping(method=RequestMethod.POST,consumes = "application/json",produces="application/json")
//	public @ResponseBody String addUser(@RequestBody User user){
//		Boolean isSuccess = userService.addUser(user);
//		return isSuccess == true ? "Success" : "Failure";
//	}
}
