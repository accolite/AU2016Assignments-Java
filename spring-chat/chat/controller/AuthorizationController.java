package com.accolite.chat.controller;

import java.util.ArrayList;

import org.codehaus.jettison.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accolite.chat.service.ChatService;

@Controller
public class AuthorizationController {
	
	@Autowired
	private ChatService chatService;
	
	 /*
	  * The method will call the ChatService login method. It returns username on successful
	  * login which can be stored and used during future messages and failure on 
	  * unsuccessful login.
	  */
		@RequestMapping(value = "/Login",method=RequestMethod.GET,produces="application/json")
		@ResponseBody
		public String login(@RequestParam("username") String username, @RequestParam("password") String password){
			if(chatService.login(username, password)){
				return username;
			}
			else {
				return "failure";
			}
		}
		
		
		/*
		 * returns success on successful logout, the string can be matched and used to clear 
		 * the username that is stored during login, returns failure on unsuccessful logout. 
		 */
		@RequestMapping(value = "/Logout",method=RequestMethod.GET,produces="application/json")
		@ResponseBody
		public String logout(@RequestParam("username") String username){
			if(chatService.logout(username)){
				return "success";
			}
			else{
				return "failure";
			}
		}
		
		/*
		 *adds a new user into the database 
		 */
		@RequestMapping(value = "/Register",method=RequestMethod.GET,produces="application/json")
		@ResponseBody
		public String register(@RequestParam("username") String username, @RequestParam("password") String password){
			if(chatService.createUser(username, password)){
				return "success";
			}
			else{
				return "false";
			}
			
		}
		
		/*
		 * Sends the list of active users
		 */
		@RequestMapping(value = "/ActiveUsers",method=RequestMethod.GET,produces="application/json")
		@ResponseBody
		public ArrayList<String> activeUsers(){
			return chatService.getActiveUsers();
		}
		
		@RequestMapping(value = "/test",method=RequestMethod.GET,produces="application/json")
		@ResponseBody
		public String helloWorld(){
			return "hello world";
		}
}
