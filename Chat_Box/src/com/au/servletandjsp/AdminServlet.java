package com.au.servletandjsp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminServlet extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public static List<String> blockedWords=new ArrayList<String>();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		//PrintWriter out = response.getWriter();  
		if(blockedWords.size()!=0)
			blockedWords.clear();
        
	    String words=request.getParameter("words");  
	    blockedWords= Arrays.asList(words.split(","));
	    System.out.println(blockedWords.size());
	    /*RequestDispatcher rd=request.getRequestDispatcher("index.html");  
        rd.forward(request,response); */
	    response.sendRedirect("http://localhost:8080/ServletAndJsp/index.html");
	}

}
