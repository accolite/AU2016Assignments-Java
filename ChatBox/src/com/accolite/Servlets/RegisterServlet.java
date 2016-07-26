/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 25, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************
*/

package com.accolite.Servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class RegisterServlet.
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The mainclass. */
	mainClass mainclass=new mainClass();
    
	/**
	 * Instantiates a new register servlet.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
    
	public RegisterServlet() {
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
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		Map<String, String> users=mainclass.getUsers();
		Set<String> activeUsers=mainClass.getActiveUsers(); 
		response.setContentType("text/plains");
	    response.setCharacterEncoding("UTF-8");
		if(activeUsers.contains(name)){
	    	String result="failed";
	    	response.getWriter().write(result);

		}
		else{
			users.put(name,password);
			//activeUsers.add(name);
			HttpSession session=request.getSession(false);
			if(session==null)
				session=request.getSession();
			session.setAttribute("username", name);
			session.setAttribute("status", "loggedin");
			String msg="-----"+name+" is online-----";
			List<String> Messages=mainclass.getMessages();
			Messages.add(msg);
			String result="success";
			response.getWriter().write(result);
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
