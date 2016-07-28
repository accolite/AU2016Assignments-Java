package com.au.ass;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(description = "1st time user's register", urlPatterns = { "/RegisterServlet" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
   void addmail(String email){
	   try{
		   InitialContext initCtx = new InitialContext();
		   
		   String username = "ravi.kalmodia@accoliteindia.com";
		      String password = "ravik5253";
		      
		      Properties props = new Properties();
		      props.put("mail.smtp.host", "smtp.gmail.com");
		      props.put("mail.from", "ravi.kalmodia@accoliteindia.com");
		      props.put("mail.smtp.starttls.enable", "true");
		      props.put("mail.smtp.port", "587");
		      props.setProperty("mail.debug", "true");

		      javax.mail.Session session = javax.mail.Session.getInstance(props);
		      MimeMessage msg = new MimeMessage(session);

		      msg.setRecipients(Message.RecipientType.TO,email);
		      msg.setSubject("Added to server");
		      msg.setSentDate(new Date());
		      msg.setText("Congrats you are added !!\n");

		      Transport transport = session.getTransport("smtp");

		      transport.connect(username, password);
		      transport.sendMessage(msg, msg.getAllRecipients());
		      transport.close();
		  
		  }catch(Exception e){
		   e.printStackTrace();
		  }
   }
    private void addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
		Context initialContext;
			try {
				initialContext = new InitialContext();
				Context envContext = (Context) initialContext.lookup("java:/comp/env");
				DataSource datasource = (DataSource) envContext.lookup("jdbc");
				Connection connection = (Connection) datasource.getConnection();
				Statement stmt = ((java.sql.Connection) connection).createStatement();
				String sql ="insert into dbo.Employees(Id,Name,EmailId) values('"+emp.getId()+"','"+emp.getName()+"','"+emp.getEmailId()+"')";
				stmt.execute(sql);
			} catch (NamingException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        Employee emp=new Employee();
        emp.setEmailId(request.getParameter("email"));
        emp.setId(request.getParameter("id"));
        emp.setName(request.getParameter("name"));
        
        RegisterServlet rs= new  RegisterServlet();
        rs.addEmployee(emp);
        rs.addmail(emp.getEmailId());
        request.getRequestDispatcher("admin.html").include(request, response);  

        out.close();    
	}
	
}
