package com.au.chatbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.au.chatbox.dao.UserDao;
import com.au.chatbox.model.User;
import com.au.chatbox.service.UserService;

@Controller
public class ChatBoxController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView getLogin(){
		ModelAndView model = new ModelAndView("login");
		return model;
	}
	
	@RequestMapping(value="/logged", method=RequestMethod.POST)
	public ModelAndView onSubmit(@RequestParam("id") String name,
			@RequestParam("password")String password)
	{
		ModelAndView model = new ModelAndView("logged");
		User pageUser= new User();
		pageUser.setUsername(name);
		pageUser.setPassword(password);
		boolean result=userService.checkUserDetails(pageUser);
		if (result) {
			model.addObject("name","Hello!");
		}
		else {
			ModelAndView model2 = new ModelAndView("login");
			return model2;
			
		}
		return model;
		
	}

		
	}

