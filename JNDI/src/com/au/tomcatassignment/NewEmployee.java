package com.au.tomcatassignment;

import java.io.IOException;
import java.security.Principal;
import java.sql.ResultSet;
import java.util.Hashtable;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class NewEmployee
 */
@WebServlet("/newEmployee")
public class NewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Hashtable env=new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
		
		try{
			
		    String name=(String) request.getParameter("name");
		    String pass=(String) request.getParameter("pass");
		    String role=(String) request.getParameter("role");
		    String email=(String) request.getParameter("email");
		    
			
			Context initialContext=new InitialContext(env);
			Context envContext=(Context) initialContext.lookup("java:/comp/env");
			DataSource dataSource=(DataSource) envContext.lookup("jdbc/MyDatabase");
			java.sql.Connection connection=dataSource.getConnection();
			java.sql.Statement stmt=connection.createStatement();
			String sql="insert into Employee values('"+name+"','"+pass+"','"+role+"','"+email+"');";
			int result=stmt.executeUpdate(sql);
			if(result==1)
			{
				System.out.println("Succesfully inserted");
				try {  
					 Session session = null;
					 try {
						 Context initCtx = new InitialContext();
						   Context envCtx = (Context) initCtx.lookup("java:comp/env");
						   session = (Session) envCtx.lookup("mail/Session");
						   Message message = new MimeMessage(session);
						   message.setFrom(new InternetAddress("gouthami.mogili@gmail.com"));
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
					 }  
				
			}
		catch(Exception e)
		{
			System.out.println("Error in Adding new EMployee");
			e.printStackTrace();
			}
		}
		}catch(Exception e)
		{
			e.printStackTrace();
			}
		}

}
