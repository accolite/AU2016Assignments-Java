package com.accolite.au.chatboard.listener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements ServletContextListener, HttpSessionListener {

	private ServletContext ctxt;
	
    /**
     * Default constructor. 
     */
    public SessionListener() {
        
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
        String user = (String) arg0.getSession().getAttribute("user");
        if(user!=null){
        	System.out.println("From listener");
			Set<String> activeList = (HashSet<String>)this.ctxt.getAttribute("activeUsers");
			activeList.remove(user);
			List<String> chatboard = (ArrayList<String>)this.ctxt.getAttribute("chatboard");
			chatboard.add("<br/><small>User <b>"+user+"</b> left the chatboard</small><br/>");
		}
    }

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		this.ctxt = arg0.getServletContext();
	}
	
}
