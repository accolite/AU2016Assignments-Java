package com.au;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;

import javax.mail.*;
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
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String EmpId = request.getParameter("empid");
		String EmpName = request.getParameter("empname");
		String EmpEmail = request.getParameter("empemail");
		String EmailTo = "gaganjha93@gmail.com";
		String password="iam@1325A";
		try {
			InitialContext initCtx = new InitialContext();
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.from", "gagan.jha@accoliteindia.com");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.port", "587");
			props.setProperty("mail.debug", "true");
			javax.mail.Session session = javax.mail.Session.getInstance(props);
			MimeMessage msg = new MimeMessage(session);
			msg.setRecipients(Message.RecipientType.TO, EmpEmail);
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
		adduser(EmpId, EmpName, EmpEmail);
	}

	private void adduser(String EmpId, String EmpName, String EmpEmail) {
		try {
			Hashtable env = new Hashtable();
			env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
			Context initialContext = new InitialContext();
			Context context = (Context) initialContext.lookup("java:/comp/env");
			DataSource dataSource = (DataSource) context.lookup("jdbc");
			Connection connection = dataSource.getConnection();
			Statement stmt = connection.createStatement();
			String sql = "insert into dbo.JNDIEmp(EmpName,EmpEmail,EmpId) values ('" + EmpName + "','" + EmpEmail
					+ "','" + EmpId + "');";
			String result = "";
			stmt.execute(sql);
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
