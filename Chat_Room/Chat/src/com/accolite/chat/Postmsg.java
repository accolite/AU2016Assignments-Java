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

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class Post.
 */
@WebServlet("/Postmsg")
public class Postmsg extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
    /**
     * Instantiates a new postmsg.
     *
     * @see HttpServlet#HttpServlet()
     */
    public Postmsg() {
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
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();
        String string=request.getParameter("umsg");
		ServletContext servletContext=getServletConfig().getServletContext();
		ArrayList<String> message=(ArrayList<String>)servletContext.getAttribute("msg");
		

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

		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();
        String string=request.getParameter("umsg");
        String name=(String) request.getSession().getAttribute("user");
        String string2=name+" : "+string;
		ServletContext servletContext=getServletConfig().getServletContext();
		ArrayList<String> message=(ArrayList<String>)servletContext.getAttribute("msg");
		if(message==null){
			message=new ArrayList<>();
		}
		message.add(string2);
		servletContext.setAttribute("msg", message);
	}

}
