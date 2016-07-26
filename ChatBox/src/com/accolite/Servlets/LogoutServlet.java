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
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class LogoutServlet.
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
       /** The mainclass. */
       mainClass mainclass=new mainClass();
    
    /**
     * Instantiates a new logout servlet.
     *
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("status").equals("loggedout")){
			response.sendRedirect("index.html");
			return;
		}
		String name=(String) session.getAttribute("username");
		session.setAttribute("status", "loggedout");
		//session.invalidate();
		String msg="-----"+name+" went offline-----";
		List<String> Messages=mainclass.getMessages();
		Messages.add(msg);
		Set<String> activeUsers=mainClass.getActiveUsers(); 
		activeUsers.remove(name);
		response.sendRedirect("index.html");
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
