/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 24, 2016

*

*  @author :: Ravi Kalmodia

* ***************************************************************************

*/
package com.au.chat;

public class Comment {
	String creator, message;

	public Comment(){}
	
	/**
	 * Instantiates a new comment.
	 *
	 * @param creator the creator
	 * @param message the message
	 */
	public Comment(String creator, String message) {
		this.creator = creator;
		this.message = message;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
