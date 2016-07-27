package com.accolite.servletassignment.controller;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accolite.servletassignment.dao.UserDAO;
import com.accolite.servletassignment.model.User;

/**
 * Servlet implementation class Login
 */

@Controller
public class Login{
	
	@RequestMapping(value = "/Login",method=RequestMethod.GET, produces="text/plain")
	@ResponseBody
	public String login(@RequestParam("name")String username, @RequestParam("password")String password) {
		@SuppressWarnings("resource")
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");  
		UserDAO pdao = (UserDAO)ctx.getBean("udao");
		User user_login = new User();
		user_login.setPassword(password);
		user_login.setName(username);
		User user = pdao.getUserLogin(user_login);
		return (user==null?new Integer(0): new Integer(1)).toString();
	}

}
