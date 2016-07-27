/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 27, 2016

*

*  @author :: Udit Mehata

* ***************************************************************************

*/
package com.au.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.au.dao.MessageDao;
import com.au.dao.UserDao;
import com.au.model.Message;
import com.au.model.User;
import com.au.service.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class ChatroomController.
 */
@Controller
public class ChatroomController {

	/** The s. */
	static Service s = new Service();

	
	/**
	 * Register user.
	 *
	 * @param usern the usern
	 * @return true, if successful
	 */
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public boolean registerUser(@RequestParam("usern") String usern) {
		return s.registerUser(usern);
	}


	/**
	 * Login user.
	 *
	 * @param usern the usern
	 * @return true, if successful
	 */
	@RequestMapping(value = "/loginUser", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public boolean loginUser(@RequestParam("usern") String usern) {
		return s.loginUser(usern);
	}


	/**
	 * Gets the messages.
	 *
	 * @return the messages
	 */
	@RequestMapping(value = "/getMessages", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Message> getMessages() {
		return s.getMessages();
	}


	/**
	 * Post message.
	 *
	 * @param usern the usern
	 * @param message the message
	 * @return true, if successful
	 */
	@RequestMapping(value = "/postMessage", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public boolean postMessage(@RequestParam("usern") String usern, @RequestParam("message") String message) {
		return s.postMessage(usern, message);
	}
}
