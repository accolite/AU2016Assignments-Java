package comm.accolite.Servlets;

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
public class SessionListener implements HttpSessionListener {

	@Override
	  public void sessionCreated(HttpSessionEvent event) {
		Chat chat=new Chat(event.getSession().getAttribute("name").toString(), event.getSession().getAttribute("name")+"joined");
		ChatArray.chats.add(chat);
		
		
		System.out.println("sessionCreated - add one session into counter");
	  }

	  @Override
	  public void sessionDestroyed(HttpSessionEvent event) {
		
		  Chat chat=new Chat(event.getSession().getAttribute("name").toString(), event.getSession().getAttribute("name")+"left");
			ChatArray.chats.add(chat);
		System.out.println("sessionDestroyed - deduct one session from counter");
	  }	
	
}
