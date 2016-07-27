package com.au.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
public class AdminController {

	@RequestMapping(value="/admin",method=RequestMethod.GET)
	@ResponseBody
	public Admin admin(@RequestParam("name")String name,@RequestParam("pass")String password){
		
		Admin admin = new Admin();
		admin.setUsername(name);
		admin.setPassword(password);
	    return admin;
	}
	
}
