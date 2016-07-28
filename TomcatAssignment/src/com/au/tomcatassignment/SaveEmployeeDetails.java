package com.au.tomcatassignment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

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
 * Servlet implementation class SaveEmployeeDetails
 */
@WebServlet("/SaveEmployeeDetails")
public class SaveEmployeeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveEmployeeDetails() {
        super();
        // TODO Auto-generated constructor stub
    }
    public static void sendMail(String email){
    	
    	
		String EmailTo = "keshri.kartik.94@gmail.com";
		String password="myPassword";
		try {
			InitialContext initCtx = new InitialContext();
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.from", "keshri.kartik.94@gmail.com");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.port", "587");
			props.setProperty("mail.debug", "true");
			javax.mail.Session session = javax.mail.Session.getInstance(props);
			MimeMessage msg = new MimeMessage(session);
			msg.setRecipients(Message.RecipientType.TO, email);
			msg.setSubject("Test Mail");
			msg.setSentDate(new Date());
			msg.setText("Testing mail for JNDI assignment\n");
			Transport transport = session.getTransport("smtp");

			transport.connect(EmailTo, password);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mail = null ;
		try {
    		Context initialContext = new InitialContext();
    		Context envContext = (Context) initialContext.lookup("java:/comp/env");
    		DataSource dataSource = (DataSource)envContext.lookup("jdbc/MyDatabase");
    		
    		Connection connection = dataSource.getConnection();
    		//System.out.println(connection);
    		Statement stmt = connection.createStatement();
    		String name = request.getParameter("name");
    		String id = request.getParameter("empID");
    	    mail = request.getParameter("mail");
    		int idd = Integer.parseInt(id);
    		
    		String sql = "Use SpringChatBox insert into Employee values("+idd+",'"+name+"','"+mail+"')";
            System.out.println(sql);
    		stmt.executeUpdate(sql);
    		
    	
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
		sendMail(mail.toString());
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
