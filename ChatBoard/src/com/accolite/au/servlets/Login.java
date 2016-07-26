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

public class Login extends HttpServlet{
				
		private static final long serialVersionUID = 1L;
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			ServletContext context = getServletConfig().getServletContext();
			HashMap<String, String> map = (HashMap<String, String>) context.getAttribute("Userdata");
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			String username = request.getParameter("lusername");
			String password = request.getParameter("lpassword");
			
			
			if (map.get(username).equals(password)) {
					out.println("Successfully Logged In ");
				} else {
					out.print("Sorry, username or password error!");
					request.getRequestDispatcher("login.html");
				}
			
			out.close();
		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}
}


