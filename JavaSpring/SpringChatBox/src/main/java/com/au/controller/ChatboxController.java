package com.au.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.au.dao.ChatboxDAO;
import com.au.service.ChatboxService;


@Controller
public class ChatboxController {

	
	@Autowired
	private ChatboxDAO jdbc;
	private ChatboxService cs = new ChatboxService();
	
	@RequestMapping(value = "/register/{userName}/{password}",method=RequestMethod.GET)
	@ResponseBody
	public boolean register(@RequestParam("userName") String userName, @RequestParam("password") String password){
		 
		 return cs.register(userName, password);
	}
	
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	@ResponseBody
	public boolean login(@RequestParam("userName") String userName, @RequestParam("password") String password){
		 
		 return cs.login(userName, password);
	}
	
	@RequestMapping(value = "/addMessage",method=RequestMethod.POST)
	@ResponseBody
	public boolean addMessage(@RequestParam("userName") String userName, @RequestParam("message") String message){
		 String msg = filterMessage(message);
		 return cs.addMessage(userName, msg);
	}
	
	private String filterMessage(String msg) {
		String[] wordslist = {"ab", "bc", "dd"};
		
		if(wordslist!=null){
			for(String word: wordslist){
				if(!word.trim().equals("")){
					msg = msg.replaceAll(word.trim(), " ");
					
				}
			}
		}
		return msg;
		
	}

	@RequestMapping(value = "/getChat",method=RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<String> getChat(){
		 
		 return cs.getChat();
	}
	
	@RequestMapping(value = "/activeUser",method=RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<String> getActiveUser(){
		 
		 return cs.getActiveUser();
	}
	
	@RequestMapping(value = "/logout",method=RequestMethod.GET)
	@ResponseBody
	public boolean logout(@RequestParam("userName") String userName){
		 
		 return cs.logout(userName);
	}
}
