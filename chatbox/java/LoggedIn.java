package com.accolite.servletassignment;

import java.io.PrintWriter;
import java.util.HashMap;
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
public class LoggedIn implements HttpSessionAttributeListener, HttpSessionListener  {

    /**
     * Default constructor. 
     */
	
    public LoggedIn() {
        // TODO Auto-generated constructor stub  
    }

   



	@Override
	public void attributeAdded(HttpSessionBindingEvent HSE) {
		// TODO Auto-generated method stub
		Map<String, String> logged_in = (HashMap<String, String>) HSE.getSession().getServletContext().getAttribute("logged_in"); 
    	String username = (String) HSE.getSession().getAttribute("username");
    	if(username!=null){
			logged_in.put((String) HSE.getSession().getAttribute("id"), (String) HSE.getSession().getAttribute("username"));
	    	System.out.println((String) HSE.getSession().getAttribute("username") + "logged in");
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





	@Override
	public void sessionDestroyed(HttpSessionEvent HSE) {
		// TODO Auto-generated method stub
		Map<String, String> logged_in = (HashMap<String, String>) HSE.getSession().getServletContext().getAttribute("logged_in"); 
    	String username = (String) HSE.getSession().getAttribute("username");
		PrintWriter out = new PrintWriter(HSE.)
		try{
			logged_in.remove((String) HSE.getSession().getServletContext().getAttribute("id"));
		}catch(Exception e){
			
		}
	}

	
}
