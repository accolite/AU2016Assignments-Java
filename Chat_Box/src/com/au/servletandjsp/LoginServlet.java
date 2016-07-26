package com.au.servletandjsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
	public static List<String> loggedUsers=new LinkedList<String>();
	public static List<String> activeUsers=new ArrayList<String>();
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		StringBuilder users=new StringBuilder("");
		int i;
		for(i = 0; i < activeUsers.size(); i++) {
			users.append(activeUsers.get(i) + " ");
		}
		response.getWriter().println(users);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
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
	    	 HttpSession session=request.getSession(false);  
	    	 if(session==null)
	    	 {
	    		 session=request.getSession();  
	    		 session.setAttribute("name",username);
	    		 loggedUsers.add(username);
	    		 activeUsers.add(username);
	    		 if(HomeServlet.msg==null)
	    			 HomeServlet.msg=new StringBuilder("");
	    		 HomeServlet.msg.append(username+"Logged in");
	    		 response.sendRedirect("http://localhost:8080/ServletAndJsp/chat.html");
	    	 }
	    	 else
	    	 {
	    		response.sendRedirect("http://localhost:8080/ServletAndJsp/index.html");
	    	 }
	    	
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
