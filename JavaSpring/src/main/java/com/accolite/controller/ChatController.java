package com.accolite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChatController {
	
	Services services=new Services();

	@RequestMapping(value = "/login/{username}{password}",method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public boolean validate(@PathVariable("username")String username,@PathVariable("password")String password)
	{
	if(services.vaildateLogin(username,password))
	{
		services.Active(username);
		return true;
	}
	else
		return false;
	}	 
	 
	 @RequestMapping(value = "/register", method = RequestMethod.GET)
	 public void register(@PathVariable("username")String username,@PathVariable("password")String password)
	  {
	   services.registerUser(username, password);
	  }
	    
	    
	 public void addMessage(@PathVariable("username")String username,@PathVariable("message")String message)
	 {
	 services.putMessage(username, message);
	  
	 }

}
