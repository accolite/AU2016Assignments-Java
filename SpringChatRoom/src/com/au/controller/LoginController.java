package com.au.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
public class LoginController {

	@RequestMapping(value="/login",method=RequestMethod.GET)
	@ResponseBody
	public Login login(@RequestParam("name")String name,@RequestParam("pass")String password){
		
		Login login = new Login();
	    login.setUsername(name);
	    login.setPassword(password);
	    return login;
	}
	
}
