package com.au.jndi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Hashtable env =new Hashtable();
		List<employee> list=new ArrayList();
	
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
		try {
			
			Context initialContext =new InitialContext(env);
			Context envContext =(Context)initialContext.lookup("java:/comp/env");
			DataSource datasource =(DataSource)envContext.lookup("jdbc/MyDatabase");
			Connection connection=datasource.getConnection();
			Statement stmt=connection.createStatement();
			int empid=Integer.parseInt(request.getParameter("empid"));
			int salary=Integer.parseInt(request.getParameter("empid"));
			String name=request.getParameter("empname");
			String email=request.getParameter("empemail");
			String profile="empl";
			String sql="use Servlet ; insert into dbo.Information (empid,name,profile,salary,email) values (" + empid + ",'" + name + "','" + profile + "',"+ salary + ",'"+ email +"');" ;
			int r=stmt.executeUpdate(sql);
			if(r==1)
			{
				System.out.println("added");
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
				         
				         message.setSubject("Added !");  
				         message.setText("Hello,Now you are now an Employee");  
				         message.setContent("Your are added to employee list by manager", "text/plain");
				        
				      //send message  
				      Transport.send(message);  
				       
				      System.out.println("Done");  
				       
				      } catch (MessagingException e) {  
				         throw new RuntimeException(e);  
				      }  
				
				   }catch (Exception e)
				{
					 System.out.println(e);  
				}
			}
			
			
	}catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
