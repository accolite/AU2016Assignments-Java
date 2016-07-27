package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.dao.SpringChatDao;
import com.spring.service.ChatRoom;
import com.spring.dao.*;
//import com.springdemo.tutorial.jdbctemplate.Student;

@Controller
public class SpringChatController {
	
	@Autowired
	private SpringChatDao jdbc;
	private ChatRoom chr = new ChatRoom();
	@RequestMapping(value = "/reg/{user_name}/{pass}",method=RequestMethod.GET)
	@ResponseBody
	public boolean Register(@RequestParam("user_name") String user_name,@RequestParam("pass") String pass){
		 String name = user_name;
		 String password = pass;
		 return chr.Register(name,password);
	}	
	
	@RequestMapping(value = "/login/{user_name}/{pass}",method=RequestMethod.GET)
	@ResponseBody
	public boolean Login(@RequestParam("user_name") String user_name,@RequestParam("pass") String pass){
		 String name = user_name;
		 String password = pass;
		 return chr.Login(name,password);
	}
	
	@RequestMapping(value = "/chatroom/{user_name}/{msg}",method=RequestMethod.GET)
	@ResponseBody
	public boolean Talk(@RequestParam("user_name") String user_name,@RequestParam("msg") String msg){
		 String name = user_name;
		 String message = msg;
		 return chr.Talk(name,msg);
	}
	
	@RequestMapping(value = "/chat",method=RequestMethod.GET)
	@ResponseBody
	public List<String> Chat(){
		 return chr.Chat();
	}
	
	@RequestMapping(value = "/users",method=RequestMethod.GET)
	@ResponseBody
	public String Users(){
		 return chr.Users();
	}
	
	@RequestMapping(value = "/logout/{user_name}",method=RequestMethod.GET)
	@ResponseBody
	public boolean Logout(@RequestParam("user_name")){
		 String name = user_name;
		 return chr.Logout(name);
	}
}
