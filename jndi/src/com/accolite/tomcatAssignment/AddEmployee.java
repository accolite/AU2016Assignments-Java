package com.accolite.tomcatAssignment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;

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

import com.accolite.demo.Student;

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
		Hashtable env=new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
		Context initialContext;
		try {
			initialContext = new InitialContext(env);
			Context envcontext=(Context) initialContext.lookup("java:/comp/env");
				DataSource dataSource=(DataSource) envcontext.lookup("jdbc/MyDatabase");
				Connection connection;
				try {
					connection = dataSource.getConnection();
					Statement stmt;
					stmt = connection.createStatement();
					String name=request.getParameter("name");
					String id=request.getParameter("id");
					String address=request.getParameter("address");
					String email=request.getParameter("email");
					String sql="use JNDI insert into Employee values('"+name+"','"+id+"','"+address+"','"+email+"')";
					//ResultSet rs=stmt.executeQuery(sql);
					
					Session session = (Session) envcontext.lookup("mail/Session");

					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress("jeganmuthaiah@gmail.com"));
					InternetAddress to[] = new InternetAddress[1];
					to[0] = new InternetAddress(email);
					message.setRecipients(Message.RecipientType.TO, to);
					message.setSubject("Accolite");
					message.setContent("Your Account is Activated", "text/plain");
					Transport.send(message);
					Boolean flag=stmt.execute(sql);
					if(flag){
						response.getWriter().write("success");
					}
					else
						response.getWriter().write("failed");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		//PrintWriter pw=response.getWriter();
		//pw.print("<br/>HelloWorld");
}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
