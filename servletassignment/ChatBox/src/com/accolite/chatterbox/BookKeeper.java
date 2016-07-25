package com.accolite.chatterbox;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class BookKeeper
 *
 */
@WebListener
public class BookKeeper implements HttpSessionAttributeListener {
	
    /**
     * Default constructor. 
     */
    public BookKeeper() {
    }

    /**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
    	ChatterData cdata=ChatterData.getChatterDataInstance();
		String activeUser=(String) event.getSession().getAttribute("username");
		String status=(String) event.getSession().getAttribute("status");
		if(activeUser!=null&&status!=null){
			if(status.equals("loggedin"))
				cdata.addActiveUser(activeUser);
			else if(status.equals("loggedout"))
				cdata.removeActiveUser(activeUser);
		}
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	ChatterData cdata=ChatterData.getChatterDataInstance();
		String activeUser=(String) event.getSession().getAttribute("username");
		String status=(String) event.getSession().getAttribute("status");
		if(activeUser!=null&&status!=null){
			if(status.equals("loggedin"))
				cdata.addActiveUser(activeUser);
			else if(status.equals("loggedout"))
				cdata.removeActiveUser(activeUser);
		}
    }
	
}
