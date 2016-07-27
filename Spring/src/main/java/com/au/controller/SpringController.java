package com.au.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.au.jdbctemplate.JDBCTemplateDao;
import com.au.jdbctemplate.Users;
import com.au.services.SpringService;


@Controller
public class SpringController {

	@Autowired
	private SpringService serv;
	
	@RequestMapping(value = "/register",method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public void insertUser(){
		 serv.insertUser();
		 student.setStudentId(15);
		 student.setStudentName("Accolite");
		 return student;
	}
	
	@RequestMapping(value="/loginUser",method=RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public boolean loginUser(@RequestParam("uname")String uname,@RequestParam("password")String password){

	    return serv.verifyUser(uname, password);
	}
	


}
