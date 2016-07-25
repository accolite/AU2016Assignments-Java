package com.au.servletandjsp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminServlet {
public static List<String> blockedWords=new ArrayList<String>();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		//PrintWriter out = response.getWriter();  
		if(blockedWords!=null)
			blockedWords.clear();
        
	    String words=request.getParameter("words");  
	    blockedWords= Arrays.asList(words.split(" , "));
	    RequestDispatcher rd=request.getRequestDispatcher("index.html");  
        rd.forward(request,response); 
	}

}
