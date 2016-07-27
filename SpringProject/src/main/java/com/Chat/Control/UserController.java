package com.Chat.Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Chat.Model.UserDao;
import com.Chat.Model.Users;

@Controller
public class UserController {
	@Autowired
	private UserDao jdbc;

	
//	@RequestMapping(value = "/Login",method=RequestMethod.POST,produces="text/html")
//	@ResponseBody
//	public String getStudents(@RequestParam(value="userName")String userName,@RequestParam(value="password")String password){
//	 Users user = jdbc.Login(userName,password);
//	 if(user!=null)
//	 {
//		 return "user not found";
//	 }
//	 else
//	 {
//		 jdbc.setStatus(user.getUserName());
//		 return "user login successful";
//	 }
//	}
	@RequestMapping(value = "/Login",method=RequestMethod.GET,produces="text/html")
	@ResponseBody
	public String login()
	{
		return "sussess";
	}
	}
	

