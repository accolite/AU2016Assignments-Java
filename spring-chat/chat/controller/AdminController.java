package com.accolite.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accolite.chat.service.ChatService;

@Controller
public class AdminController {
	
	@Autowired
	private ChatService chatService;
	
	@RequestMapping(value = "/AdminLogin",method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public String login(@RequestParam("username") String username, @RequestParam("password") String password){
		if(chatService.adminLogin(username, password)){
			return username;
		}
		else {
			return "failure";
		}
	}
	
	/*
	 * Sends a comma seperated list of prohibited words to ChatService
	 */
	@RequestMapping(value = "/AddWords",method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public void addWords(@RequestParam("prohWords") String prohWords){
		chatService.addWords(prohWords);
	}
}
