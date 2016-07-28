package com.au.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Hashtable;

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

import com.au.servlet.bean.Employee;

/**
 * Servlet implementation class AddEmployee
 */
@WebServlet("/addnew")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Incorrect opeation");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String designation = request.getParameter("designation");
		Employee e = new Employee(name, 0, designation, email);
		addEmployee(e);
		response.setContentType("text/html");
		response.getWriter().println("Employee details added. Click <a href=\"/TomcatAssignment/\">here </a> to go back");
	}
	
	public void addEmployee(Employee e){
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
		Context initialContext;
		try {
			initialContext = new InitialContext(env);
			Context envContext = (Context) initialContext.lookup("java:/comp/env");
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/dataSource");
			Connection connection = dataSource.getConnection();
			String sql = "insert into employee (name, designation, email) values (?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, e.getName());
			pstmt.setString(2, e.getDesignation());
			pstmt.setString(3, e.getEmail());
			pstmt.executeUpdate();
			sendMail(e);
		}
		catch(SQLException | NamingException exc){
			exc.printStackTrace();
		}
	}
	
	public void sendMail(Employee e){
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
		Context initialContext;
		System.out.println("Trying to send mail");
		try {
			initialContext = new InitialContext(env);
			Context envContext = (Context) initialContext.lookup("java:/comp/env");
			Session session = (Session) envContext.lookup("mail/Session");
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("rajesh10tks@gmail.com"));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(e.getEmail()));
			message.setSubject("Employee data added");
			String content = "Hi "+e.getName()+"<br/><br/>";
			content += "This is to inform you that your details are successfully added.";
			message.setContent(content, "text/html;charset=UTF-8");
			Transport.send(message);
			System.out.println("Mail sent");
		}
		catch(NamingException | MessagingException exc){
			exc.printStackTrace();
		}
	}
	
	
}
