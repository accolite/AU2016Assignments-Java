package com.accolite.chat;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Register
 */

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    String username=request.getParameter("user");
	    String password=request.getParameter("pass");
	    ServletContext servletContext=getServletConfig().getServletContext();
	    HashMap<String, String> hashMap=(HashMap<String, String>)servletContext.getAttribute("User");
	    if(hashMap==null){
	    	hashMap=new HashMap<>();
	    }
	    if(hashMap.containsKey(username)){
	    	out.println("Already Registered");
	    }else{
	    	hashMap.put(username, password);
	    	out.println("Successfully Registered");
	    	servletContext.setAttribute("User", hashMap);
	    	request.getRequestDispatcher("index.html").include(request, response);
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
