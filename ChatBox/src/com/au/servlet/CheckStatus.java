package com.au.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckStatus
 */
@WebServlet("/CheckStatus")
public class CheckStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CheckStatus() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd;
		
		if(request.getParameter("option").equals("login")) {
		
			rd = request.getRequestDispatcher("Login");
			rd.forward(request, response);
	
		} else if(request.getParameter("option").equals("register")) {
		
			rd = request.getRequestDispatcher("Register");
			rd.forward(request, response);
			
		} else if(request.getParameter("option").equals("admin")) {
			rd = request.getRequestDispatcher("Admin");
			rd.forward(request, response);
		}
		response.setContentType("text/html");
		response.getWriter().write("Not a valid operation. <a href=\"/ChatBoard/\">Login</a> please");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
