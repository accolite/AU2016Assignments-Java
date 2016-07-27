package com.springdemo.tutorial.servlets;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class Listener
 *
 */
@WebListener
public class Listener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public Listener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	String s=(String) arg0.getSession().getAttribute("name");
    	if(s==null||s.equals("null")||s.equals("")){
    		return;
    	}
    	tempstuffs.getActiveusers().remove(s);
    	tempstuffs.setChat(tempstuffs.getChat()+"</br><b>"+s+" has left the chat room</b></br>");
    	arg0.getSession().getServletContext().setAttribute("chats",tempstuffs.getChat());
    	//arg0.getSession().gets
    }
	
}
