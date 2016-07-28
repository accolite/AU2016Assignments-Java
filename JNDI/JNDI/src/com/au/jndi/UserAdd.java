package com.au.jndi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
import javax.sql.DataSource;

/**
 * Servlet implementation class UserAdd
 */
@WebServlet("/UserAdd")
public class UserAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String unit = request.getParameter("unit");
		try{
		 
		 String username = "shailendra.kumar@accoliteindia.com";
		    String password = "mypassword";
		    
		    Properties props = new Properties();
		    props.put("mail.smtp.host", "smtp.gmail.com");
		    props.put("mail.from", "shailendra.kumar@accoliteindia.com");
		    props.put("mail.smtp.starttls.enable", "true");
		    props.put("mail.smtp.port", "587");
		    props.setProperty("mail.debug", "true");

		    javax.mail.Session session = javax.mail.Session.getInstance(props);
		    MimeMessage msg = new MimeMessage(session);

		    msg.setRecipients(Message.RecipientType.TO, email);
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
		addDatabase(name,email,unit);
		response.getWriter().append("Added and sent a mail to : "+name +"   "+email+"   "+unit+"\n");
	}

	private void addDatabase(String name, String email, String unit) {
		// TODO Auto-generated method stub
		try {
    		Hashtable env = new Hashtable();
    		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
			Context initialContext= new InitialContext();
			Context context=(Context)initialContext.lookup("java:/comp/env");
			DataSource dataSource =(DataSource)context.lookup("jdbc");
			Connection connection=dataSource.getConnection();
			Statement stmt=connection.createStatement();
			String sql="insert into dbo.Users(EmployeeName,EmployeeEmail,Unit) values ('"+name+"','"+email+"','"+unit+"');";
			String result="";
			stmt.execute(sql);
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
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
