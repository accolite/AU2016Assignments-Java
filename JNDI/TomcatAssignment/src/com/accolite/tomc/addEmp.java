package com.accolite.tomc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

/**
 * Servlet implementation class addEmp
 */
@WebServlet("/addEmp")
public class addEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void addEmployee(String name,String mail) throws NamingException{
    	try {
    		
			Context initialContext=new InitialContext();
			Context envContext=(Context) initialContext.lookup("java:/comp/env");
			DataSource dataSource=(DataSource) envContext.lookup("jdbc/MyDatabase");
			Connection connection=dataSource.getConnection();
			Statement stmt=connection.createStatement();
			String sql="Insert Into dbo.Employee(EmpName,Email) Values('"+name+"','"+mail+"')";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
    }
    
    public void sendMail(String mail){
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("ename");
		String mail=request.getParameter("email");
		try {
			addEmployee(name, mail);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
    		Context initCtx = new InitialContext();
    		Context envCtx = (Context) initCtx.lookup("java:comp/env");
    		Session session = (Session) envCtx.lookup("mail/Session");

    		Message message = new MimeMessage(session);
    		message.setFrom(new InternetAddress("hellojava15@gmail.com"));
    		InternetAddress to[] = new InternetAddress[1];
    		to[0] = new InternetAddress(mail);
    		message.setRecipients(Message.RecipientType.TO, to);
    		message.setSubject(request.getParameter("subject"));
    		message.setContent("Your account has been activated", "text/plain");
    		Transport.send(message, to, "hellojava15@gmail.com", "q1w2e3r4t5y6u7i8");
  		
    		
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.sendRedirect("manager.html");
	}

}
