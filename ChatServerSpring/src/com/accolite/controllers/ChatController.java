package com.accolite.controllers;
import com.accolite.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChatController {
	
	@RequestMapping(value = "/register",method=RequestMethod.POST,produces="text")
	@ResponseBody
	public ModelAndView addUser(@RequestParam("name")String name,@RequestParam("pass")String pass)
	{
		Register reg=new Register();
		if(reg.add(name,pass)==1)
			return new ModelAndView("FrontPage.html", "message", "inserted");
		else
			return new ModelAndView("FrontPage.html", "message", " not inserted");
		
		
	}
}
