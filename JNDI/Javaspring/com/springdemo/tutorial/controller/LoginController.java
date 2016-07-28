package com.springdemo.tutorial.controller;

import com.springdemo.tutorial.jdbctemplate.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.springdemo.tutorial.controller.*;
import com.springdemo.tutorial.jdbctemplate.*;


@Controller
public class LoginController {
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView getLogin(){
		ModelAndView model = new ModelAndView("login");
		return model;
	}
	
	@RequestMapping(value="logged", method=RequestMethod.POST)
	public ModelAndView submitLogin(@RequestParam("id") String name,
			@RequestParam("password")String password){
		ModelAndView model = new ModelAndView("logged");
		Users user= new Users();
		user.setUsr(name);
		user.setPwd(password);
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		JDBCTemplateDao userDao = (JDBCTemplateDao) context.getBean("userDAO");
		Users dbUser=userDao.getUserDetails(user);
		if(dbUser.getUsr().equals(user.getUsr()))
		{
			if(dbUser.getPwd().equals(user.getPwd())){
				System.out.println("Success");
			}
			else
				System.out.println("Invalid pwd");
		}
		
		else {
			ModelAndView model1 = new ModelAndView("login");
			return model1;
			
		}
		return model;
	}
	

}
