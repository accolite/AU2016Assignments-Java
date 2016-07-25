package com.au.servletandjsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet1
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
	public static List<String> loggedUsers=new LinkedList<String>();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		PrintWriter out = response.getWriter();  
        
	    String username=request.getParameter("user");  
	    String password=request.getParameter("pass");  
	    
	    String pass=RegisterServlet.userDetails.get(username);
	    	
	    
	    if(pass.equals(password))
	    {
	    	RequestDispatcher rd=request.getRequestDispatcher("chat.html");
	    	 HttpSession session=request.getSession();  
	         session.setAttribute("name",username);
	         loggedUsers.add(username);
	    	rd.forward(request, response);
	    	
	     }
	    else
	    {
	    	PrintWriter pw=response.getWriter();
	    	pw.append("Not a valid user");
	    	RequestDispatcher rd=request.getRequestDispatcher("index.html");  
	         rd.include(request,response);  
	    }
	          
	}

}
