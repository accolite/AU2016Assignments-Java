package com.accolite.chatterbox;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 * 
 * Servlet which takes the user to next level
 * there three possible cases
 * 1. user might want to login
 * 2. user might want to register newly and login
 * 3. admin might want to login
 * 
 * here session details get manipulated appropriately 
 * 
 */
@WebServlet(description = "handles the login process", urlPatterns = { "/login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * POST method handled here. request contains various parameters regarding the login
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ChatterData a singleton class where the data persist
		ChatterData cdata=ChatterData.getChatterDataInstance();
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		String mode=request.getParameter("mode"); //mode is nothing but whether user wants to login, register or admin login
		switch(mode){
		case "login":
			if(cdata.doAuthorize(name, password)==1){ //Authorize the user
				//look for session
				HttpSession session=request.getSession(false);
				//if not found create one
				if(session==null)
					session=request.getSession();
				//set the attributes username the name and status loggedin
				//this will trigger the listener BookKeeper
				session.setAttribute("username", name);
				session.setAttribute("status", "loggedin");
			}else{//if user not authorized i.e getting value -1(user not found) or 0(wrong password)
				//set response to redirect to error.html page
				response.sendRedirect("error.html");
				return;
			}
			//set response to redirect to tweeter.jsp page
			response.sendRedirect("tweeter.jsp");
			break;
		case "admin":
			if(name.equals("admin")&&cdata.doAuthorize(name, password)==1){ //Authorize the user
				HttpSession session=request.getSession(false);
				if(session==null)
					session=request.getSession();
				session.setAttribute("username", "admin");
				session.setAttribute("status", "loggedin");
			}else{
				response.sendRedirect("error.html");
				return;
			}
			//set response to redirect to admin.html page
			response.sendRedirect("admin.html");
			break;
		case "register":
			if(cdata.doAuthorize(name, password)>=0){ //Authorize the new user 0 or 1-user name exits
				//since user name exist you register with this name, so redirect to error.html
				response.sendRedirect("error.html");
				return;
			}
			//add the user to the chatter box
			cdata.addUser(name, password);
			//get the session
			HttpSession session=request.getSession(false);
			if(session==null)//not found create one
				session=request.getSession();
			//set the attributes username the name and status loggedin
			//this will trigger the listener BookKeeper
			session.setAttribute("username", name);
			session.setAttribute("status", "loggedin");
			//set response to redirect to tweeter.jsp page
			//since user registered he is a valid user to join the chat
			response.sendRedirect("tweeter.jsp");
			break;
		default:
			//in case of invalid mode
			response.sendRedirect("error.html");
		}
	}

}