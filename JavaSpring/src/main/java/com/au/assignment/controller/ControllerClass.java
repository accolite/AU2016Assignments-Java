package com.au.assignment.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.au.assignment.jdbctemplate.JDBCTemplateDAO;
import com.au.assignment.jdbctemplate.Message;
import com.au.assignment.jdbctemplate.UserDetail;
import com.au.assignment.service.ServiceClass;


@Controller
public class ControllerClass {

	@Autowired
	private JDBCTemplateDAO jdbc;private ServiceClass service;
	@RequestMapping(value = "/login/{username}{password}",method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public boolean vaildatateUser(@PathVariable("username")String username,@PathVariable("password")String password){
		return(service.vaildatateUserService(username,password));
		 
		 
	}
	@RequestMapping(value = "/register/{username}{password}",method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public void registerUser(@PathVariable("username")String username,@PathVariable("password")String password)
	{
		UserDetail user=new UserDetail();
		user.setUsername(username);
		user.setPassword(password);
		service.registerUserService(user);
	}
	@RequestMapping(value = "/logout/{username}",method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public void logoutUser(@PathVariable("username")String username)
	{
		UserDetail user=new UserDetail();
		user.setUsername(username);
		service.SetInActiveUserService(user);
	}
	@RequestMapping(value = "/postMessage/{message}{username}",method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public void PostMessage(@PathVariable("message")String message,@PathVariable("username")String username)
	{
		Message msg=new Message();
		msg.setMessage(message);
		msg.setUsername(username);
		service.postMessageService(msg);
	}
	@RequestMapping(value = "/getChatList",method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public List<Message> getChatListMessage()
	{
		List<Message>messagesBox=null;
		messagesBox=service.getChatListService();
		return messagesBox;
		
	}
}
