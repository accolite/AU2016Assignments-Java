/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 26, 2016

*

*  @author :: Mohit Devda

* ***************************************************************************

*/
package com.accolite.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class Login.
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
    /**
     * Instantiates a new login.
     *
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext servletContext=getServletConfig().getServletContext();
		HashMap<String, String> hashMap=(HashMap<String, String>)servletContext.getAttribute("User");
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    String username=request.getParameter("user");
	    String password=request.getParameter("pass");
	    ArrayList<String> activeuser=(ArrayList<String>)servletContext.getAttribute("active");
	    if(hashMap.containsKey(username)&&(hashMap.get(username)).equals(password)){
	    	
	    	HttpSession session=request.getSession(false);
	    	if(session==null){
	    		session=request.getSession();
	    		session.setAttribute("user", username);
	    	}
	    	if(activeuser==null){
	    		activeuser=new ArrayList<>();
	    	}
	    	activeuser.add(username);
	    	servletContext.setAttribute("active", activeuser);
	    	
	    	out.println("Welcome, "+username);
	    	
	    	request.getRequestDispatcher("chat.html").include(request, response);
	        
	    }
	    else{
	    	out.println("Wrong Username or password");
	    	request.getRequestDispatcher("index.html").include(request, response);
	    }
	}

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
