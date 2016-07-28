/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 28, 2016

*

*  @author :: Udit Mehata

* ***************************************************************************

*/
package com.au.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * Servlet implementation class CreateEmployee
 */
@WebServlet("/CreateEmployee")
public class CreateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		PrintWriter out = response.getWriter();
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
		try
    	{
    		Context initialContext = new InitialContext(env);
			Context envContext = (Context) initialContext.lookup("java:/comp/env");
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/MyDatabase");
			Connection conn = dataSource.getConnection();
			Statement s = conn.createStatement();
			String query = "INSERT INTO tomcatapp VALUES ('" + name + "','" + email + "', 0)";
			System.out.println(query);
			s.executeUpdate(query);
			
			Session session = (Session)envContext.lookup("mail/Session");
			System.out.println("HERE smtp.user: " + session.getProperty("mail.smtp.user"));
			
			
			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress("udit034034@gmail.com"));
			InternetAddress dests[] = new InternetAddress[]
			{ new InternetAddress(email) };
			message.setRecipients(Message.RecipientType.TO, dests);
			message.setSubject("JavaMail works through Tomcat");
			message.setContent("Ultimate Swag", "text/plain");
			Transport.send(message, "udit034034@gmail.com", "034meowmeow");
    	}
		catch( Exception e )
		{
			e.printStackTrace();
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
