package com.tomcat;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.mail.Message;
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
 * Servlet implementation class GetDetails
 */
@WebServlet("/GetDetails")
public class GetDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	 public  void getDbConnection(String name,int age,String address,String email)
	    {				String s="";


	    	try {
				Context context=new InitialContext();
				Context envcontext=(Context)context.lookup("java:/comp/env");
				DataSource ds=(DataSource)envcontext.lookup("jdbc/MyDatabase");
				Connection connection=ds.getConnection();
				Statement stmt=connection.createStatement();
				String sql="insert into dbo.Employee (name,age,address,email,role)values('"+name+"',"+age+",'"+address+"','"+email+"',2);";
				stmt.executeUpdate(sql);
				
				Session session = (Session) envcontext.lookup("mail/Session");

				   Message message = new MimeMessage(session);
				   message.setFrom(new InternetAddress("paduramesh1995@gmail.com"));
				   InternetAddress to[] = new InternetAddress[1];
				   System.out.println(email);
				   to[0] = new InternetAddress(email);
				   message.setRecipients(Message.RecipientType.TO, to);
				   message.setSubject("Happy Fun Friday");
				   message.setContent("vellore welcomes you", "text/plain");
				   Transport.send(message);
				   
				   
				   
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    }
    public GetDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		int age = Integer.parseInt(request.getParameter("age"));
		String email=request.getParameter("email");
		getDbConnection(name, age, address, email);
		response.getWriter().append("added successfully").append(request.getContextPath());

		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
