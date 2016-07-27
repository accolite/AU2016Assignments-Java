package com.au.chatboard.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.au.chatboard.service.ChatBoardService;

@Controller
public class MainController {

	@Autowired
	ChatBoardService chatBoardService;
	
	@RequestMapping(value="/activelist", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public String getActiveUsers(HttpSession session){
		return chatBoardService.getUsersList(session.getAttribute("user").toString());
	}
	
	@RequestMapping(value="/chats", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public String getChatList(HttpSession session){
		return chatBoardService.getChatList(session.getAttribute("user").toString());
	}
	
	@RequestMapping(value="/post", method=RequestMethod.GET)
	public void postMessage(@RequestParam("msg")String msg, HttpSession session){
		String user = session.getAttribute("user").toString();
		chatBoardService.addMessage(user, msg);
	}
	
	@RequestMapping(value="/move", method=RequestMethod.POST)
	public ModelAndView entrypoint(@RequestParam("username")String username, @RequestParam("password")String password, @RequestParam("operation")String operation, HttpSession session){
		ModelAndView mav = new ModelAndView();
		if(session.getAttribute("user")!=null){
			session.invalidate();
			mav.addObject("errormsg", "already a session exist. Please try again");
			mav.setViewName("error");
		}
		else{
			if(operation.equals("Login")){
				if(chatBoardService.validate(username, password)){
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
					if(chatBoardService.addUserToActiveList(username))
						chatBoardService.addMessage("", "User "+session.getAttribute("user")+" joined the chatboard");
					mav.setViewName("chatboard");
				}
				else{
					mav.addObject("errormsg", "Registration failed. Username already exist. Try again");
					mav.setViewName("error");
				}
			}
			else if(operation.equals("Admin Login")){
				if(username.equals("admin")&&password.equals("admin")){
					mav.addObject("wordslist", chatBoardService.getRestrictedWords());
					mav.setViewName("admin");
				}
				else{
					mav.addObject("errormsg", "Login failed. Try again");
					mav.setViewName("error");
				}
			}
			else{
				mav.addObject("errormsg", "Invalid operation. Try again");
				mav.setViewName("error");
			}
		}
		return mav;
	}
	
	@RequestMapping(value="/addrw", method=RequestMethod.GET)
	public ModelAndView addRestrictedWords(@RequestParam("words")String words){
		ModelAndView mav = new ModelAndView();
		chatBoardService.addRestrictedWords(words);
		mav.addObject("wordslist", chatBoardService.getRestrictedWords());
		mav.setViewName("admin");
		return mav;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public ModelAndView goLogout(HttpSession session){
		if(session.getAttribute("user")!=null)
			chatBoardService.addMessage("", "<small><b>User "+session.getAttribute("user")+" left the chatboard</b></small><br/>");
		session.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("logout");
		return mav;
	}
	
}
