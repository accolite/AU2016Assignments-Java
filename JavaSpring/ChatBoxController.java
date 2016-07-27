package com.au.chatboxspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.au.chatboxspring.dao.ChatBoxDAO;
import com.au.chatboxspring.model.User;
import com.au.chatboxspring.service.ChatBoxService;

@Controller
@RequestMapping("/chatbox")
public class ChatBoxController {

	@Autowired
	ChatBoxService chatBoxService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public int userLogin(@RequestBody User user)
	{
		return chatBoxService.loginService(user);
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public void userRegister(@RequestBody User user)
	{
		 chatBoxService.registerService(user);
	}
}
