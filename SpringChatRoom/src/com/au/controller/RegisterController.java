package com.au.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
public class RegisterController {

	@RequestMapping(value="/register",method=RequestMethod.GET)
	@ResponseBody
	public Register register(@RequestParam("name")String name,@RequestParam("pass")String password){
		
		Register register = new Register();
		register.setUsername(name);
		register.setPassword(password);
	    return register;
	}
	
}
