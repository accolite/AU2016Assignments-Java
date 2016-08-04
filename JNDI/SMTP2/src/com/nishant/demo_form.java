package com.nishant;

import java.io.IOException;
import java.sql.ResultSet;
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
 * Servlet implementation class demo_form
 */
@WebServlet("/demo_form")
public class demo_form extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public demo_form() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println(name);
		try{
			Context initialContext=new InitialContext();
			Context envContext=(Context) initialContext.lookup("java:/comp/env");
			DataSource ds=(DataSource) envContext.lookup("jdbc/MyDatabase");
			java.sql.Connection connection=ds.getConnection();
			Statement stmt=connection.createStatement();
			String sql="";
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			sql="insert into Users2 values('"+name+"','"+email+"',0)";
			stmt.execute(sql);
			Session session = (Session) envContext.lookup("mail/Session");

			   Message message = new MimeMessage(session);
			   message.setFrom(new InternetAddress("nishant123adhikari@gmail.com"));
			   InternetAddress to[] = new InternetAddress[1];
			   System.out.println(email);
			   to[0] = new InternetAddress(email);
			   message.setRecipients(Message.RecipientType.TO, to);
			   message.setSubject("Joined");
			   message.setContent("You have been joined", "text/plain");
			   Transport.send(message);
			return ;
			//Integer count=(Integer) envContext.lookup("count");
			//System.out.println("Count: "+count);
		}
		
		catch(Exception e){
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
