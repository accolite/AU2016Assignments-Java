package com.springchat.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springchat.service.*;

@Controller
public class MainController {

		@Autowired
		Service chatservice;
		
		@RequestMapping(value="/activelist", method=RequestMethod.GET, produces="text/plain")
		@ResponseBody
		public String getActiveUsers(){
			return chatservice.activeUserList();
		}
		
		@RequestMapping(value="/chats", method=RequestMethod.GET, produces="text/plain")
		@ResponseBody
		public String getChatList(HttpSession session){
			return chatservice.getMessage();
		}
		
		@RequestMapping(value="/post", method=RequestMethod.GET, produces="text/plain")
		@ResponseBody
		public void postMessage(@RequestParam("msg")String msg, HttpSession session){
			String user = session.getAttribute("user").toString();
			chatservice.addMessage(user, msg);
		}
		
		@RequestMapping(value="/move", method=RequestMethod.POST)
		public ModelAndView entrypoint(@RequestParam("username")String username, @RequestParam("password")String password, @RequestParam("operation")String operation, HttpSession session){
			ModelAndView mav = new ModelAndView();
				if(operation.equals("Login")){
					if(chatservice.validate(username, password)){
						mav.addObject("user", username);
						mav.setViewName("chatboard");
						session.setAttribute("user", username);
						chatservice.addMessage("", "<small><b>User "+session.getAttribute("user")+" joined the chatboard</b></small><br/>");
						chatservice.addToActiveUserList(username);
					}
					else{
						mav.addObject("errormsg", "Login failed. Try again");
						mav.setViewName("index");
					}
				}
				else if(operation.equals("Register")){
					if(chatservice.addUser(username, password)){
						session.setAttribute("user", username);
						chatservice.addToActiveUserList(username);
						chatservice.addMessage("", "User "+session.getAttribute("user")+" joined the chatboard");
						mav.setViewName("chatboard");
					}
					else{
						mav.addObject("errormsg", "Registration failed. Username already exist. Please Try again");
						mav.setViewName("index");
					}
				}
				/*else if(operation.equals("Admin Login")){
					if(username.equals("admin")&&password.equals("admin")){
						mav.addObject("wordslist", chatservice.getRestrictedWords());
						mav.setViewName("admin");
					}
					else{
						mav.addObject("errormsg", "Login failed. Try again");
						mav.setViewName("error");
					}
				}*/
				else{
					mav.addObject("errormsg", "Invalid operation. Try again");
					mav.setViewName("index");
				}
//			}
			return mav;
		}
		
		@RequestMapping(value="/logout", method=RequestMethod.GET)
		public ModelAndView goLogout(HttpSession session){
			if(session.getAttribute("user")!=null)
				chatservice.addMessage("", "<small><b>User "+session.getAttribute("user")+" left the chatboard</b></small><br/>");
			session.invalidate();
			ModelAndView mav = new ModelAndView();
			mav.setViewName("logout");
			return mav;
		}
		
	}

