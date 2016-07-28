package com.accolite.controllerservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Hashtable;

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



/**
 * Servlet implementation class AddEmployee
 */
@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name=request.getParameter("employee_name");
		String email=request.getParameter("employee_email");
		//Integer id=Integer.parseInt(request.getParameter("id"));
		Hashtable  env=new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
		
		try{
			
			Context initialContext =new InitialContext(env);
			Context envContext=(Context)initialContext.lookup("java:/comp/env");
			javax.sql.DataSource name1=(javax.sql.DataSource)envContext.lookup("database");
			Connection conn=name1.getConnection();
			java.sql.Statement stmt=conn.createStatement();
			System.out.println("hi");
			String sql="insert into dbo.employee(employee_name,employee_email) "
					+ "values(" + "'"+name+"','"+email+"')";
			stmt.executeUpdate(sql);	
			
			Session mailsession=(Session)envContext.lookup("mail/Session");
			
			Message message = new MimeMessage(mailsession);
            message.setFrom(new InternetAddress("bansal.chirrag12@gmail.com"));
            
            InternetAddress dests[] = new InternetAddress[]
        			{ new InternetAddress(email) };
            message.setRecipients(Message.RecipientType.TO,
                dests);
            message.setSubject("A testing mail header !!!");
            message.setText("Dear Mail Crawler,"
                + "\n\n No spam to my email, please!");

            Transport.send(message);

            System.out.println("Done");
            
			
		
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
