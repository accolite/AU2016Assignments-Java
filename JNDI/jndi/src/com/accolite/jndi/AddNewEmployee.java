package com.accolite.jndi;

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
 * Servlet implementation class AddNewEmployee
 */
@WebServlet("/AddNewEmployee")
public class AddNewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewEmployee() {
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
			String name = request.getParameter("ename");
			String email = request.getParameter("email");
			System.out.println(name + "\t" + email);
			updateEmp(name,email);
			sendEmail(email);
	}
	
	public void updateEmp(String name,String email)
	{
		try{
			Context initialContext = new InitialContext();
			Context envContext = (Context) initialContext.lookup("java:/comp/env");
			DataSource dataSource =  (DataSource)envContext.lookup("jdbc/MyDatabase");
			Connection connection = dataSource.getConnection();
			Statement stmt =   connection.createStatement();
			String sql = "INSERT into dbo.Employees(emp_name,email_id,role) VALUES(" + "'" + name + "'" + "," + "'" + email + "'" +","+ 0 +")";
			if(stmt.executeUpdate(sql) == 1)
					System.out.println("Success");;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void sendEmail(String email)
	{
		Context initialContext;
		  Context envContext = null;
		  try {
		   initialContext = new InitialContext();
		   envContext = (Context) initialContext.lookup("java:/comp/env");
		   Session session = (Session) envContext.lookup("mail/Session");
		   System.out.println("HERE smtp.user: " + session.getProperty("mail.smtp.user"));
		   System.out.println("to email : " + email);
		   String email1 = "drogon324@gmail.com";

		   Message message = new MimeMessage(session);
		   message.setFrom(new InternetAddress(email1));
		   InternetAddress dests[] = new InternetAddress[] { new InternetAddress(email) };
		   message.setRecipients(Message.RecipientType.TO, dests);
		   message.setSubject("Brace yourself");
		   message.setContent("Welcome To our organisation, May you have a happy stay.", "text/plain");
		   Transport.send(message,"drogon324@gmail.com","dracarys*");
		   

		  } catch (Exception e) {
		   e.printStackTrace();
	}

}
}