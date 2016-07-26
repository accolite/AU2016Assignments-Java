/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 26, 2016

*

*  @author :: Momin Yadav

* ***************************************************************************

*/
package com.accolite.chatdemo;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class Listener_Session implements HttpSessionListener {

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
	 */
	@Override
	  public void sessionCreated(HttpSessionEvent event) {
		
		
		
		System.out.println("sessionCreated - add one session into counter");
	  }

	  @Override
	  public void sessionDestroyed(HttpSessionEvent event) {
		
		  Chat chat=new Chat(event.getSession().getAttribute("name").toString(), event.getSession().getAttribute("name")+"left");
			ArrayChat.chats.add(chat);
		System.out.println("sessionDestroyed - deduct one session from counter");
	  }	
	
}
