package com.chat;

import java.util.LinkedList;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LinkedList<String> list = new LinkedList<String>();
       
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   // doGet(request, response);
	    String usr = request.getParameter("User");
	    String pwd = request.getParameter("Password");
	    if(RegisterServlet.hash.isEmpty() == false) {
	     String password = RegisterServlet.hash.get(usr);
	     System.out.println(password);
	     System.out.println(usr);
	     if(password == null || !(password.equals(pwd))) 
	     {
	      System.out.println("incorrect password or user");
	      RequestDispatcher rd=request.getRequestDispatcher("Index.html");  
		     rd.include(request,response);
	     }
	      else {
	      
	     System.out.println("entered");
	    	  HttpSession session=request.getSession();  
	        session.setAttribute("name",usr); 
	        list.add(usr);
	        System.out.println("Added");
	        response.sendRedirect("http://localhost:8080/chat/Chathtml.html");
	        //RequestDispatcher rd=request.getRequestDispatcher("Chathtml.html");  
		    // rd.include(request,response);
	        
	     }
	     
	 	
	    } 
	   
	}

}
