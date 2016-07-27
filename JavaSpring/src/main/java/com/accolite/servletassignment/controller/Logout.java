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

@Controller
public class Logout {
	
	
	@RequestMapping(value = "/Logout",method=RequestMethod.GET, produces="text/plain")
	@ResponseBody
	public String logout(@RequestParam("id") int id) {
		@SuppressWarnings("resource")
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");  
		UserDAO pdao = (UserDAO)ctx.getBean("udao");
		User user_login = new User();
		user_login.setUser_id(id);
		User user = pdao.getUserLogout(user_login);
		return (user==null?new Integer(0): user.getActive()==-1?"Not logged in":new Integer(1)).toString();
	}

}
