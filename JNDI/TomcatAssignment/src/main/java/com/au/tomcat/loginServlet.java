package com.au.tomcat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

import com.au.tomcatDAO.ManagerDao;

@WebServlet("/login")
public class loginServlet extends HttpServlet{
	
	
	ManagerDao dao = new ManagerDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getUserPrincipal().getName();
		
		if(request.isUserInRole("manager"))
		  {
			//System.out.println("you are in manager");
			response.sendRedirect("manager.jsp");
		   
		  }
		  else
		  {
			  	HttpSession session = request.getSession();
			  	session.setAttribute("name", name);
			  //System.out.println("you are a employee");
			 response.sendRedirect("employee.jsp");
		  }
		
	}
	
	
}
