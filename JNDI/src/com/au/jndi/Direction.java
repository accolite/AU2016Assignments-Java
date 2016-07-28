package com.au.jndi;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Direction
 */
@WebServlet("/Direction")
public class Direction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Direction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Principal principal = request.getUserPrincipal();
		 String username = principal.getName();
		 String employee ="Employee";
		 String manager="Manager";
		 System.out.println(username);
		   if(manager.equals(username))
		   {
			   RequestDispatcher rd=request.getRequestDispatcher("employeeDetail");  
			     rd.forward(request,response);
		   }
		   else if(employee.equals(username))
		   {
			   RequestDispatcher rd=request.getRequestDispatcher("employeeDetail");  
			     rd.forward(request,response);
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
