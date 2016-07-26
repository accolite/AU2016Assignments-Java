package com.accolite.au.chatboard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class EntryPoint.
 */
@WebServlet("/move")
public class EntryPoint extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
    /**
     * Instantiates a new entry point.
     *
     * @see HttpServlet#HttpServlet()
     */
    public EntryPoint() {
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
		response.getWriter().write("Not a valid operation");
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
		String op =request.getParameter("operation");
		RequestDispatcher rdr;
		if(op.equals("Login")){
			rdr = request.getRequestDispatcher("Login");
			rdr.forward(request, response);
		}
		else if(op.equals("Register")){
			rdr = request.getRequestDispatcher("Register");
			rdr.forward(request, response);
		}
		else if(op.equals("Admin Login")){
			rdr = request.getRequestDispatcher("Admin");
			rdr.forward(request, response);
		}
		response.setContentType("text/html");
		response.getWriter().write("Not a valid operation. <a href=\"/WebChat/\">Login</a> please");
	}

}
