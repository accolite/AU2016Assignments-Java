package com.accolite.jndi.assignment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.Hashtable;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import sun.applet.resources.MsgAppletViewer;

/**
 * Servlet implementation class CreateEmployee
 */
@WebServlet(description = "Creates a new employee and sends mail", urlPatterns = { "/CreateEmployee" })
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");

		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//response.getWriter().append("Hello world!!!");
		Context initialContext;

		try {

			initialContext = (Context) new InitialContext(env);
			Context envContext = (Context) (initialContext).lookup("java:/comp/env");

			DataSource dataSource = (DataSource) envContext.lookup("jdbc/MyDatabase");
			Connection connection = dataSource.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(
					"use EmployeeDB insert into employee( employeeName, employeeEmailId, employeeMobileNo) values(?,?,?)");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, mobile);
			
			preparedStatement.executeUpdate();
			
			response.getWriter().append("Success");
			
			Session mailSession = (Session) envContext.lookup("mail/Session");
			
			Message message = new MimeMessage(mailSession);
			message.setSubject("New Employee Created!!!");
			message.setSentDate(new Date());
			message.setFrom();
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email, false));
			
			MimeBodyPart mbp = new MimeBodyPart();
			
			mbp.setText("name is: "+name+" mobile is: "+mobile);
			
			Multipart mp = new MimeMultipart();
			mp.addBodyPart(mbp);
			
			message.setContent(mp);
			
			Transport.send(message);	
			
			
			response.sendRedirect("managerHome.html");
			
		} catch (Exception e) {
			response.getWriter().append("Failure");
			e.printStackTrace();
		}

	}

}
