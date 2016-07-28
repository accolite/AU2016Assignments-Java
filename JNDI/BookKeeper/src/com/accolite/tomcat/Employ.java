package com.accolite.tomcat;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
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
 * Servlet implementation class Employ
 * 
 * Employ servlet where given employee details updated to database and a welcoming mail sent to the employee
 * 
 */
@WebServlet(description = "employ a new employee", urlPatterns = { "/employ" })
public class Employ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Employ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * post method where employee details getting added to the database
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Context initContext;
		try {
			//server context
			initContext = new InitialContext();
			//environment context
			Context envContext=(Context)initContext.lookup("java:/comp/env");
			//getting DataSource through JNDI
			// jdbc/MyDatabase is the resource defined in the server.xml
			DataSource dataSource=(DataSource)envContext.lookup("jdbc/MyDatabase");
			Connection con=dataSource.getConnection();
			//prepared statement for inserting the new employee details
			PreparedStatement pstmt=con.prepareStatement("use BookKeeper insert into employee values(?,?,?)");
			//getting parameters from the form post
			String id=request.getParameter("id");
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			pstmt.setString(1,id );
			pstmt.setString(2,name );
			pstmt.setString(3,email );
			pstmt.executeUpdate(); //row insert
			//mail session, which is again a resource obtained via JNDI
			//the username and password where set in the server.xml itself
			Session session = (Session) envContext.lookup("mail/Session");
			//the message object
			Message message = new MimeMessage(session);
			//setting the from emailId
			message.setFrom(new InternetAddress("lokesh7f95@gmail.com"));
			//setting the to emailId
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
			//setting the subject of the mail
			message.setSubject("Happy Fun Friday");
			//content of the mail
			message.setContent("You being employed in our company enjoy you weekends", "text/plain");
			//sending the message
			Transport.send(message);
			
			response.getWriter().append("Employee added");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
