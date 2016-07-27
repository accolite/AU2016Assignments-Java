package com.au.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.au.model.Message;
import com.au.model.User;
import com.au.service.MessageService;
import com.au.service.UserService;

@Controller
public class MainController {
	
	@RequestMapping(value = "/doChat",method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public List<Message> doChat(){
		MessageService ms = new MessageService();
		return ms.getAllMessages();
	}
	
	@RequestMapping(value = "/doRegister",method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public Boolean doRegister(User user){
		UserService us = new UserService();
		return us.registerUser(user);
	}
	
	@RequestMapping(value = "/fetchUser",method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public List<user> fetchLoggedInUsers(){
		UserService us = new UserService();
		return us.getListofLoggedInUsers();
	}

}
