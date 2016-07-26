package com.au;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class ChatListner
 *
 */
@WebListener
public class ChatListner implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public ChatListner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
    	ChatBoardData cbd=ChatBoardData.getDataInstance();
		String activeUser=(String) arg0.getSession().getAttribute("username");
		String status=(String) arg0.getSession().getAttribute("status");
		if(activeUser!=null&&status!=null){
			if(status.equals("loggedin"))
				cbd.makeUserActive(activeUser);
			else if(status.equals("loggedout"))
				cbd.removeActiveUser(activeUser);
		}
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
         
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
    	ChatBoardData cbd=ChatBoardData.getDataInstance();
		String activeUser=(String) arg0.getSession().getAttribute("username");
		String status=(String) arg0.getSession().getAttribute("status");
		if(activeUser!=null&&status!=null){
			if(status.equals("loggedin"))
				cbd.makeUserActive(activeUser);
			else if(status.equals("loggedout"))
				cbd.removeActiveUser(activeUser);
		}
    
    }
	
}
