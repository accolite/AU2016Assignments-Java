/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 27, 2016

*

*  @author :: Udit Mehata

* ***************************************************************************

*/
package com.au.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.au.dao.MessageDao;
import com.au.dao.UserDao;
import com.au.model.Message;
import com.au.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Class Service.
 */
public class Service {
	/** The mdao. */
	@Autowired
	private static MessageDao mdao;

	/** The udao. */
	@Autowired
	private static UserDao udao;

	/**
	 * Register user.
	 *
	 * @param usern the usern
	 * @return true, if successful
	 */
	public boolean registerUser(String usern) {
		User u = new User(usern, 0);
		udao.registerUser(u);
		return true;
	}

	/**
	 * Login user.
	 *
	 * @param usern the usern
	 * @return true, if successful
	 */
	public boolean loginUser(String usern) {
		if (udao.getSpecificUser(usern) != null) {
			udao.activateUser(usern);
			return true;
		} else
			return false;
	}

	/**
	 * Gets the messages.
	 *
	 * @return the messages
	 */
	public List<Message> getMessages() {
		return mdao.getFullChat();
	}

	/**
	 * Post message.
	 *
	 * @param usern the usern
	 * @param message the message
	 * @return true, if successful
	 */
	public boolean postMessage(String usern, String message) {
		Message m = new Message(null, null, null);
		m.setUser(usern);
		m.setMessage(message);
		mdao.postMessage(m);
		return true;
	}
}
