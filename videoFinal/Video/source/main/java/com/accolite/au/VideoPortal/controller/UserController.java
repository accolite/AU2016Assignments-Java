package com.accolite.au.VideoPortal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accolite.au.VideoPortal.DAO.UserDAO;
import com.accolite.au.VideoPortal.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserDAO jdbc;
	@Autowired
	private UserService service;

	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void addUser(@RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname, @RequestParam("email_id") String email_id,
			HttpServletRequest servletRequest) {
//	System.out.println("userId" + user_id);
		System.out.println("firstname" + firstname);
	System.out.println("lastname" + lastname);
	System.out.println("email_id" + email_id);
		
		if (service.AddUser(firstname, lastname, email_id))
			System.out.println("User added");
		else
			System.out.println("User cannot be added");

	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void removeUser(@RequestParam("user_id") int user_id, HttpServletRequest servletRequest) {
		System.out.println("userId" + user_id);

		if (service.RemoveUser(user_id))
			System.out.println("User removed");
		else
			System.out.println("User cannot be removed");

	}
}
