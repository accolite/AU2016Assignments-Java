package com.accolite.au.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.accolite.au.services.Service;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	Service chatBoardService;
	
	@RequestMapping(value="/activelist", method=RequestMethod.GET, produces="text/plain")
	@ResponseBody
	public String getActiveUsers(HttpSession session){
		return chatBoardService.getActiveUserList();
	}
	
	@RequestMapping(value="/chats", method=RequestMethod.GET, produces="text/plain")
	@ResponseBody
	public String getChatList(HttpSession session){
		return chatBoardService.getAllMessages();
	}
	
	@RequestMapping(value="/post", method=RequestMethod.GET, produces="text/plain")
	@ResponseBody
	public void postMessage(@RequestParam("msg")String msg, HttpSession session){
		String user = session.getAttribute("user").toString();
		chatBoardService.addMessage(user, msg);
	}
	
	@RequestMapping(value="/move", method=RequestMethod.POST)
	public ModelAndView entrypoint(@RequestParam("username")String username, @RequestParam("password")String password, @RequestParam("operation")String operation, HttpSession session){
		ModelAndView mav = new ModelAndView();
		
			if(operation.equals("Login")){
				if(chatBoardService.loginValidation(username, password)){
					mav.addObject("user", username);
					mav.setViewName("chatboard");
					session.setAttribute("user", username);
					chatBoardService.addMessage("", "<small><b>User "+session.getAttribute("user")+" joined the chatboard</b></small><br/>");
					chatBoardService.addUserToActiveList(username);
				}
				else{
					mav.addObject("errormsg", "Login failed. Try again");
					mav.setViewName("error");
				}
			}
			else if(operation.equals("Register")){
				if(chatBoardService.addUser(username, password)){
					session.setAttribute("user", username);
					chatBoardService.addUserToActiveList(username);
					chatBoardService.addMessage("", "User "+session.getAttribute("user")+" joined the chatboard");
					mav.setViewName("chatboard");
				}
				else{
					mav.addObject("errormsg", "Registration failed. Username already exist. Try again");
					mav.setViewName("error");
				}
			}
			else{
				mav.addObject("errormsg", "Invalid operation. Try again");
				mav.setViewName("error");
			}

		return mav;
	}
	
}
