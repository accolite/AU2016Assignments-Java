package com.accolite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accolite.classfiles.Messages;
import com.accolite.classfiles.Users;
import com.accolite.jdbctemplate.JDBCTemplateDao;

@Controller
public class ChatController {
	private static ApplicationContext applicationContext;
	@Autowired
	private JDBCTemplateDao jdbcTemplate;
		
	@RequestMapping(value = "/RegisterUser",method=RequestMethod.GET,produces="text/plain")
	@ResponseBody
	public String addUser(){
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate =  (JDBCTemplateDao) applicationContext.getBean("jdao");
		Users user=new Users();
		user.setName("Jegan");
		user.setPassword("Muthaiah");
		user.setRole("Admin");
		user.setStatus("loggedin");
		String result=jdbcTemplate.addUser(user);
		System.out.println("User Registration:"+result);
		return result;
	}
	
//	@RequestMapping(value = "/LoginUser",method=RequestMethod.GET,produces="text/plain")
//	@ResponseBody
//	public String userLogin(){
//		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		jdbcTemplate =  (JDBCTemplateDao) applicationContext.getBean("jdao");
//		Users user=new Users();
//		user.setName("Jegan");
//		user.setPassword("Muthaiah");
//		user.setRole("Admin");
//		user.setStatus("loggedin");
//		String result=jdbcTemplate.addUser(user);
//		System.out.println("User Registration:"+result);
//		return result;
//	}
//	
	
	@RequestMapping(value = "/Message",method=RequestMethod.GET,produces="text/plain")
	@ResponseBody
	public String addMessage(){
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate =  (JDBCTemplateDao) applicationContext.getBean("jdao");
		Messages msg=new Messages();
		msg.setAuthor("Jegan");
		msg.setMessage("Its Jegan");
		String result=jdbcTemplate.addMessage(msg);
		System.out.println("User Registration:"+result);
		return result;
	}
	
	
}
