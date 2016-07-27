package com.au.springchat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.au.services.ChatServices;
import com.au.springchat.dao.JDBCTemplatedao;
import com.au.springchat.resources.UserData;

@Controller
public class SpringController {

	@Autowired
	private JDBCTemplatedao jdbc;

	@RequestMapping(value = "/Register", method = RequestMethod.POST)
	@ResponseBody
	public void RegisterUser(@RequestParam("userData")UserData usrData) {
		ChatServices cs = new ChatServices();
		cs.RegisterUser(usrData);
	}
	

	@RequestMapping(value = "/Register", method = RequestMethod.POST)
	@ResponseBody
	public void insertMessage(@RequestParam("userData")UserData usrData) {
		ChatServices cs = new ChatServices();
		cs.insertMessage(usrData);
	}
	
	@RequestMapping(value="/getChat",method=RequestMethod.GET)
	@ResponseBody
	public List<String> getChatHistory(){
		ChatServices cs = new ChatServices();
	   return cs.ChatHistory();
	}
	
	@RequestMapping(value="/validate",method=RequestMethod.GET)
	@ResponseBody
	public boolean validateCred(@RequestParam("usrname")String usrname,@RequestParam("password")String password){
		ChatServices cs = new ChatServices();
	   return cs.validateCredentials(usrname,password);
	}
	
}
