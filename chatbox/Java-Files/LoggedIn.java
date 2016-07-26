/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 26, 2016
*
*  @author :: Sharukh Mohamed
* ***************************************************************************
*/
package com.accolite.servletassignment;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class LoggedIn
 *
 */
@WebListener
public class LoggedIn implements HttpSessionAttributeListener, HttpSessionListener, HttpSessionBindingListener  {

    /**
     * Default constructor. 
     */
	
    public LoggedIn() {
        // TODO Auto-generated constructor stub  
    }

   



	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionAttributeListener#attributeAdded(javax.servlet.http.HttpSessionBindingEvent)
	 */
    /**
     * Adding user to logged_in for first user
     */
	@Override
	public void attributeAdded(HttpSessionBindingEvent HSE) {
		// TODO Auto-generated method stub
		Map<String, String> logged_in = (HashMap<String, String>) HSE.getSession().getServletContext().getAttribute("logged_in"); 
    	String username = (String) HSE.getSession().getAttribute("username");
    	if(username!=null){
			logged_in.put((String) HSE.getSession().getAttribute("id"), (String) HSE.getSession().getAttribute("username"));
    	}
		
	}


	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
	}


	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
	}





	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	/**
	 * When session is invalidated, user leaves the room. It is notified as a message
	 */

	@Override
	public void sessionDestroyed(HttpSessionEvent HSE) {
		// TODO Auto-generated method stub
		/**
		 * Get list of logged in users
		 */
		
		Map<String, String> logged_in = (HashMap<String, String>) HSE.getSession().getServletContext().getAttribute("logged_in"); 
    	String username = (String) HSE.getSession().getAttribute("username");
    	try{
    		/**
    		 * Delete leaving users from active users
    		 */
			while (logged_in.values().remove(username));
		}catch(Exception e){
			e.printStackTrace();
		}
    	/**
    	 * Get all posts from application
    	 */
    	Map<String, Map<String, String>> all_posts = (LinkedHashMap<String, Map<String, String>>) HSE.getSession().getServletContext().getAttribute("all_posts");
		Map<String, String> user = new HashMap<>();

		/**
		 * Removed user notification
		 */
		user.put("removed", "<h1>User "+ username + " left</h1>");
		Integer toInsert = new Integer(all_posts.size());
		if(all_posts.get(toInsert.toString())!=null)
				toInsert+=all_posts.size();
		/**
		 * New unique id for notification
		 */
		all_posts.put("2222-"+new Date().toString()+"-"+toInsert.toString(), user);
		//System.out.println("Size here "+all_posts.size());
	}





	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub'
		
		
	}





	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
