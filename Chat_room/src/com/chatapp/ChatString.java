/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 25, 2016

*

*  @author :: Udit Mehata

* ***************************************************************************

*/
package com.chatapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class ChatString.
 */
@WebServlet("/ChatString")
public class ChatString extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new chat string.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public ChatString() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Do get.
	 *
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		// creating ServletContext object
		ServletContext context = getServletContext();
		// Getting the value of the initialization parameter and printing it
		String ChatString = (String) context.getAttribute("ChatString");
		pw.println(ChatString);
		pw.close();
	}

	/**
	 * Do post.
	 *
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = request.getParameter("uname");
		//String message = request.getParameter("message");
		String message = (String) request.getAttribute("Fmsg");
		ServletContext context = getServletContext();
		if (context.getAttribute("ChatString") == null)
			context.setAttribute("ChatString", "");
		String chatstring = (String) context.getAttribute("ChatString");
		chatstring = chatstring + "<b>" + uname + "</b> : " + message + "<br>";
		context.setAttribute("ChatString", chatstring);
	}

}
