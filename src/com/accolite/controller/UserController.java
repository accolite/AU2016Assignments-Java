package com.accolite.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.dao.Userdao;
import com.accolite.model.User;
import com.springdemo.tutorial.jdbctemplate.Student;



@RestController
public class UserController {
	
	@Autowired
	private Userdao jdbc;
	
	@RequestMapping(value="/getUser/{id}",method=RequestMethod.GET,produces = "text/html")
	@ResponseBody
	public User getUser(@PathVariable("id")int id){
	    return jdbc.getUser(1);
	}
	
	@RequestMapping(value="/Login",method=RequestMethod.GET,produces = "text/html")
	@ResponseBody
	public User Login(@PathVariable("username")String username,@PathVariable("password")String password){
		
	}
	
	@RequestMapping(value = "/Register",method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public User Register(@PathVariable("id")int id,@PathVariable("username")String username,@PathVariable("password")String password){
		 User user = new User();
		 user.setId(id);
		 user.setName(username);
		 user.setPassword(password);
		 return user;
	}

}
