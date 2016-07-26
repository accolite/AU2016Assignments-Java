package com.au.servletandjsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	public static HashMap<String,String> userDetails=new HashMap<String,String>();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		PrintWriter out = response.getWriter();  
        
	    String username=request.getParameter("user");  
	    String password=request.getParameter("pass");  
	    
	    
	    if(userDetails.isEmpty())
	    {
	    	userDetails.put(username, password);
	   
	    	/*HttpSession session=request.getSession();  
	        session.setAttribute("name",username);*/
	        LoginServlet.loggedUsers.add(username);
	        System.out.println("New User - "+username+" Registered");
	    	
	    	 /*RequestDispatcher rd=request.getRequestDispatcher("chat.html");  
	    	rd.forward(request, response);*/
	    	
	    	response.sendRedirect("http://localhost:8080/ServletAndJsp/index.html");
	    	
	    }
	    else if(userDetails.containsKey(username))
	    {
	    	 RequestDispatcher rd=request.getRequestDispatcher("index.html");  
	         rd.include(request,response);  
	    }
	    else
	    {
	    	userDetails.put(username, password);
	   
	    	/* HttpSession session=request.getSession();  
	         session.setAttribute("name",username);*/
	         LoginServlet.loggedUsers.add(username);
	    	System.out.println("Added");
	    	
/*RequestDispatcher rd=request.getRequestDispatcher("chat.html"); 
	    rd.forward(request, response);*/
	    	
	    	response.sendRedirect("http://localhost:8080/ServletAndJsp/index.html");
	    }
	    
	    
	}

}
