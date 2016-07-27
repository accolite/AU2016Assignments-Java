package com.smruti.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.smruti.jdbctemplate.JDBCTemplateDao;
import com.smruti.jdbctemplate.Message;
import com.smruti.jdbctemplate.User;
import com.smruti.services.UserServices;

@Controller
public class LoginController {
	@Autowired
	private JDBCTemplateDao jdbc;
	
	@RequestMapping(value="/getUserWithId",method=RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public User getUser(@RequestParam("id")int id){
		User user = jdbc.getUser(id);
	    return user;
	}
	
	@RequestMapping(value="/getMessageWithId",method=RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public Message getMessage(@RequestParam("id")int id){
		Message msg = jdbc.getMessage(id);
	    return msg;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView getLogin(){
		ModelAndView model = new ModelAndView("login");
		return model;
	}
	
	@RequestMapping(value="logged", method=RequestMethod.POST)
	public ModelAndView submitLogin(@RequestParam("id") String name,
			@RequestParam("password")String password){
		ModelAndView model = new ModelAndView("logged");
		User pageUser= new User();
		pageUser.setName(name);
		pageUser.setPassword(password);
		
		Boolean flag = false;
		UserServices us = new UserServices();
		flag = us.validity(pageUser);
		
		if(flag == true)
			return model;
		else{
			ModelAndView model1 = new ModelAndView("login");
			return model1;
		}
	}
}
