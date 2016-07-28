/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 28, 2016

*

*  @author :: Sachin Gupta

* ***************************************************************************

*/
package com.jndi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;

import javax.mail.Message;
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

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class AddEmployees.
 */
@WebServlet("/AddEmployees")
public class AddEmployees extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddEmployees() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		Hashtable env=new Hashtable();
		Context init;
		Context envContext;
		PrintWriter pw=response.getWriter();
		
			try {
				init = new InitialContext(env);
				envContext = (Context) init.lookup("java:comp/env");
				DataSource dataSource=(DataSource) envContext.lookup("jdbc/jndiAssign");
				Connection conn=dataSource.getConnection();
				String name=request.getParameter("name");
				String password=request.getParameter("pass");
				String email=request.getParameter("email");
				Statement stmt=conn.createStatement();
				String query="Insert into Employees Values('"+name+"','"+password+"','"+email+"')";
				stmt.executeUpdate(query);
				sendMailPlease("sgsachin1794@gmail.com");
				response.sendRedirect("LoginScreen1.html");			
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
					  
	}

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/**
	 * Send mail please.
	 *
	 * @param toEmail the to email
	 */
	public void sendMailPlease(String toEmail) {
		  Context initialContext;
		  Context envContext = null;
		  try {
		   initialContext = new InitialContext();
		   envContext = (Context) initialContext.lookup("java:/comp/env");
		   Session session = (Session) envContext.lookup("mail/Session");
		   System.out.println("HERE smtp.user: " + session.getProperty("mail.smtp.user"));
		   System.out.println("to email : " + toEmail);
		   String email = "sgsachin1794@gmail.com";

		   Message message = new MimeMessage(session);
		   message.setFrom(new InternetAddress(email));
		   InternetAddress dests[] = new InternetAddress[] { new InternetAddress(toEmail) };
		   message.setRecipients(Message.RecipientType.TO, dests);
		   message.setSubject("Added Employee");
		   message.setContent("Welcome To our organisation, May you have a happy stay.", "text/plain");
		   Transport.send(message);
		   return ;

		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		 }
}
