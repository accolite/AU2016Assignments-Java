package com.accolite.au.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetMessage extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext context = getServletConfig().getServletContext();
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect("login.html");
		} else {
			String savedUserName = (String) session.getAttribute("user");
			String messagecon = (String) context.getAttribute("messages");
			
			if(messagecon ==null)
			{
				context.setAttribute("messages", " ");
			}else{
				
				response.getWriter().write(messagecon);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
