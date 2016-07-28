package com.accolite.controllerservlet;

import java.io.IOException;
import java.security.Principal;
import java.util.Hashtable;

import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Employee
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Employee" })
public class Employee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Employee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 Hashtable env=new Hashtable();
		  Context init;
		  Context envContext;
		  //PrintWriter pw=response.getWriter();
		  //pw.append("Hello");
		  Principal p = request.getUserPrincipal();
		  String username = p.getName();
		  if (request.isUserInRole("manager")){
		    System.out.println("gksbvj");
		     response.sendRedirect("addorshow.html");
		    }
		    else if(request.isUserInRole("employee")){
		    	response.getWriter().println("You are employee");
		    }
		   
		
		
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
