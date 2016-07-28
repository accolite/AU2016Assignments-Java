package com.au;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class entryServlet
 */
@WebServlet("/entry")
public class EntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EntryServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Principal user = request.getUserPrincipal();
		if (user.getName().equalsIgnoreCase("employee")) {
			response.sendRedirect("employee");
			
		}
		else if(user.getName().equalsIgnoreCase("manager")) {
			response.sendRedirect("manager");
			
		}	
		else {
			response.sendRedirect("index.html");
			System.out.println(" user is not a valid user");
		}	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
