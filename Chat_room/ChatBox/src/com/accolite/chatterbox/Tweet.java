package com.accolite.chatterbox;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Tweet
 * 
 * Servlet which called for putting the tweet i.e the message.
 * Actually the request reaches this servlet only after the filter so message is just added to the storage.
 * There is no doGet, hence user have to POST the message that way it's appropriate
 * 
 */
@WebServlet(description = "servlet to put the tweet", urlPatterns = { "/tweet" })
public class Tweet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tweet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * doPost method where POST request is handled
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ChatterData a singleton class where the data persist
		ChatterData cdata=ChatterData.getChatterDataInstance();
		HttpSession session=request.getSession(false); //get session object
		//if there is no session object then it's an invalid user or 
		//if session is there and user is logged out then the message must be coming from invalid user
		if(session==null||session.getAttribute("status").equals("loggedout")){ 
			response.sendRedirect("error.html");	//make the response redirect to error.html
			return; //return, since you're not going to post a message from an invalid user
		}
		//session exits and user logged in
		String user=(String)session.getAttribute("username");
		String message=(String)request.getAttribute("message");
		//adding the message to the cdata where the data persists
		cdata.addMessage(user, message);
		//redirect the response to FeedMe where updated information is given to the user
		response.sendRedirect("feedme");
	}

}
