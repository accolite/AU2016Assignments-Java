/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 27, 2016

*

*  @author :: Udit Mehata

* ***************************************************************************

*/
package com.au.model;

import java.sql.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Message.
 */
public class Message {
	
	/** The user. */
	private String user;

	/**
	 * Instantiates a new message.
	 *
	 * @param user the user
	 * @param message the message
	 * @param time the time
	 */
	public Message(String user, String message, Date time) {
		super();
		this.user = user;
		this.message = message;
		this.time = time;
	}

	/** The message. */
	private String message;
	
	/** The time. */
	private Date time;

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user            the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Gets the time.
	 *
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * Sets the time.
	 *
	 * @param time            the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}

}
