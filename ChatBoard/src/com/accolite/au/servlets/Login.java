package com.accolite.au.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext context = getServletConfig().getServletContext();
		HashMap<String, String> map = (HashMap<String, String>) context.getAttribute("userdata");
		
		PrintWriter out = response.getWriter();

		response.setContentType("text/html");

		String username = request.getParameter("lusername");
		String password = request.getParameter("lpassword");

		if (map != null) {
			if (map.get(username) != null) {
				if (map.get(username).equals(password)) {

					HttpSession session = request.getSession(false);
					if (session == null) {
						session = request.getSession();
						session.setAttribute("user", username);

					}
					response.sendRedirect("MainChat.html");
				} else {
					out.print("Wrong username or password!");
					response.sendRedirect("login.html");
				}
			} else {
				response.sendRedirect("register.html");
			}
		} else {
			response.sendRedirect("register.html");
		}
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
