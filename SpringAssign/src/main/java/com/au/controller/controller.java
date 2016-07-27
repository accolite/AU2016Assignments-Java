package com.au.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.au.JdbcTemplate.Chat;
import com.au.JdbcTemplate.JdbcTemplateDao;
import com.au.JdbcTemplate.UserDetails;
import com.au.Service.ServiceCall;

@Controller
public class controller
{
	@Autowired
	private JdbcTemplateDao jdbc;
	private ServiceCall service;
	
	@RequestMapping(value = "/login/{username}{password}",method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	 public boolean vaildateLogin(@PathVariable("username")String username,@PathVariable("password")String password){
	 return(service.validateUserCredentials(username,password));
	 }
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerUser(@PathVariable("username")String username,@PathVariable("password")String password)
	 {
	  UserDetails user=new UserDetails();
	  user.setUsername(username);
	  user.setPassword(password);
	  service.registerUser(user);
	 }
	   
	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public void addMessage(@PathVariable("username")String username,@PathVariable("message")String message)
	{
		Chat message1 = new Chat();
		message1.setUsername(username);
		message1.setMessage(message);
		service.addMessage(message1);
		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout(@PathVariable("username")String username)
	{
		UserDetails user= new UserDetails();
		service.setInactiveUser(user);
	}
	
	@RequestMapping(value = "/Listmessage", method = RequestMethod.GET)
	@ResponseBody
	 public List<Chat> getChatListMessage()
	 {
	  List<Chat>messagesBox=null;
	  messagesBox=service.getChatList();
	  return messagesBox;
	  
	 }
	
	
	

}
