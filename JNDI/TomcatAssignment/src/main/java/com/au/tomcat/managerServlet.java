package com.au.tomcat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.au.tomcatDAO.ManagerDao;

@WebServlet("/manager")
public class managerServlet extends HttpServlet {
	ManagerDao dao = new ManagerDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in the gertr");
		List<String> employees = new ArrayList<String>();
		employees = dao.getAllEmployees();
		response.getWriter().println(employees);

	}

	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { System.out.println(
	 * "in the posot"); String name = request.getParameter("username"); String
	 * email = request.getParameter("email");
	 * 
	 * 
	 * dao.addEmployee(name, email);
	 * 
	 * 
	 * }
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		 System.out.println("in the posot");
			String name1 = request.getParameter("username");
			String email1 = request.getParameter("email");
					
			dao.addEmployee(name1, email1);
			response.sendRedirect("manager.jsp");
			/*Hashtable env= new Hashtable();
			  env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");*/
			
			 
			      String email="you are added";
			      
			   
			    System.out.println("Succesfully inserted");
			    Session session = null;
			      try {
			       Context initCtx = new InitialContext();
			         Context envCtx = (Context) initCtx.lookup("java:comp/env");
			         session = (Session) envCtx.lookup("mail/Session");
			         Message message = new MimeMessage(session);
			         message.setFrom(new InternetAddress("pawan.prakash305@gmail.com"));
			         InternetAddress to[] = new InternetAddress[1];
			         to[0] = new InternetAddress(email);
			         message.setRecipients(Message.RecipientType.TO, to);
			         
			         message.setSubject("You are registered By Manager!");  
			         message.setText("Hello,You are now an Employee! Congratulations");  
			         message.setContent("Your are added to employee list by manager", "text/plain");
			        
			      //send message  
			      Transport.send(message);  
			       
			      System.out.println("Done");  
			       
			      } catch (MessagingException e) {  
			         throw new RuntimeException(e);  
			      } catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
		
	}
}