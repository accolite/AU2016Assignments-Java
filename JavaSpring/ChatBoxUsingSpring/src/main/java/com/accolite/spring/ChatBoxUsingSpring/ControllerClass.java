/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 27, 2016

*

*  @author :: Sachin Gupta

* ***************************************************************************

*/
package com.accolite.spring.ChatBoxUsingSpring;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


// TODO: Auto-generated Javadoc
/**
 * The Class ControllerClass.
 */
@Controller
public class ControllerClass {
	
	/** The service class. */
	@Autowired
	ServiceClass serviceClass;
	
	
	/**
	 * Gets the active users.
	 *
	 * @return the active users
	 */
	@RequestMapping(value = "/getUsers",method=RequestMethod.GET,produces="text/plain")
	@ResponseBody
	public String getActiveUsers(){
		
		return serviceClass.listofActiveUsers();
		
		
	}
	
	/**
	 * Adds the user.
	 *
	 * @param session the session
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST,produces = "text/plain")
	@ResponseBody
	public void addUser(HttpSession session){
		String a=session.getAttribute("name").toString();
		String b=session.getAttribute("password").toString();
		serviceClass.login(a,b);
	}
	
	/**
	 * Register.
	 *
	 * @param session the session
	 */
	@RequestMapping(value="/register",method=RequestMethod.POST,produces = "text/plain")
	@ResponseBody
	public void register(HttpSession session){
		String a=session.getAttribute("name").toString();
		String b=session.getAttribute("password").toString();
		serviceClass.register(a, b);
	}
	
	
	/**
	 * Gets the chats.
	 *
	 * @return the chats
	 */
	@RequestMapping(value="/chats",method=RequestMethod.GET,produces = "text/plain")
	@ResponseBody
	public String getChats(){
		return serviceClass.chats();
	}
	
	/*@RequestMapping(value="/addmessage",method=RequestMethod.POST,produces = "text/plain")
	@ResponseBody
	public String addMessage(HttpSession session){
		
		
	}*/
	
	
	
	
	
	

	
	
	

}
