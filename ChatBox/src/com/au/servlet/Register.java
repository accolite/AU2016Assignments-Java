package com.au.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().write("Not a valid operation");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		ServletContext context = getServletConfig().getServletContext();
		Map<String, String> userslist = (HashMap<String, String>) context.getAttribute("users");

		if (userslist == null) {
			userslist = new HashMap<String, String>();

		}
		if (userslist.containsKey(username)) {
			System.out.println("User Already registered");
			response.setContentType("text/html");
			response.getWriter()
					.write("The username is already registered. Please <a href=\"/ChatBox/\">try</a> again");
		} else {
			userslist.put(username, password);
			System.out.println("Successfully added");
			context.setAttribute("users", userslist);
			response.setContentType("text/html");
			response.getWriter().write("Successfully registered. Please <a href=\"/ChatBoard/\">login</a> now");
		}

	}

}
