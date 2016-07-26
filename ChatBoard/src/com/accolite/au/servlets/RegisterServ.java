package com.accolite.au.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterServ extends HttpServlet{
				
		private static final long serialVersionUID = 1L;
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String username = request.getParameter("rlusername");
			String password = request.getParameter("rlpassword");	
			
			ServletContext context = getServletConfig().getServletContext();
			HashMap<String, String> map =new HashMap<String, String>();
			
			map = (HashMap<String, String>) context.getAttribute("Userdata");
			map.put(username, password);
			
			context.setAttribute("userdata", map);
		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}
}


