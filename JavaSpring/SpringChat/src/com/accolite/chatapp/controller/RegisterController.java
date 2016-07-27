package com.accolite.chatapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accolite.chatapp.jdbc.User;
import com.accolite.chatapp.service.ChatServices;

@Controller
public class RegisterController {
	
	@Autowired
	private ChatServices chatServices=new ChatServices();
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public ModelAndView displayregister(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView model = new ModelAndView("register");
		User user=new User();
		model.addObject("user", user);
		return model;
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user")User user)
	{
		ModelAndView model= null;
		try
		{
			boolean ValidUser = chatServices.validUser(user.getUsername());
			if(ValidUser)
			{
				chatServices.addUser(user.getUsername(), user.getPassword());
				System.out.println("Successfully Register");
				request.setAttribute("RegisteredUser", user.getUsername());
				model = new ModelAndView("Login");
			}
			else
			{
				model = new ModelAndView("register");
				model.addObject("user", user);
				request.setAttribute("message", "Already Registered");
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return model;
	}

}
