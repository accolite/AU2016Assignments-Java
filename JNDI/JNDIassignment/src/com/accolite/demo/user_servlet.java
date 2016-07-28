package com.accolite.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;

import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.catalina.Session;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

// TODO: Auto-generated Javadoc
/**
 * The Class user_servlet.
 */
public class user_servlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");

		Context initialContext;
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		try {
			initialContext = new InitialContext();
			Context envContext = (Context) initialContext.lookup("java:/comp/env");
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/dataSource");
			Connection connection = dataSource.getConnection();
			Statement stmt = connection.createStatement();
			String sql = "insert into  dbo.employee values " + "('" + name + "','" + email + "')";
			stmt.executeUpdate(sql);
			sendMailPlease(email);
			response.sendRedirect("index.html");

		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}

	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		   javax.mail.Session session = (javax.mail.Session) envContext.lookup("mail/Session");
		   String email = "ankushdhama5@gmail.com";

		   javax.mail.Message message = new MimeMessage(session);
		   message.setFrom(new InternetAddress(email));
		   InternetAddress dests[] = new InternetAddress[] { new InternetAddress(toEmail) };
		   message.setRecipients(javax.mail.Message.RecipientType.TO, dests);
		   message.setSubject("JavaMail works through Tomcat");
		   message.setContent("Welcome", "text/plain");
		   Transport.send(message);
		   

		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		 }
	
}
