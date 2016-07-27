package com.accolite.SpringChatApp;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ControllerClass {
	
	@Autowired
	ServiceClass serviceClass;
	
	
	@RequestMapping(value = "/getUsers",method=RequestMethod.GET,produces="text/plain")
	@ResponseBody
	public String getActiveUsers(){
		
		return serviceClass.listofActiveUsers();
		
		
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST,produces = "text/plain")
	@ResponseBody
	public void addUser(HttpSession session){
		String a=session.getAttribute("name").toString();
		String b=session.getAttribute("password").toString();
		serviceClass.login(a,b);
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST,produces = "text/plain")
	@ResponseBody
	public void register(HttpSession session){
		String a=session.getAttribute("name").toString();
		String b=session.getAttribute("password").toString();
		serviceClass.register(a, b);
	}
	
	
	
	

	
	
	

}
