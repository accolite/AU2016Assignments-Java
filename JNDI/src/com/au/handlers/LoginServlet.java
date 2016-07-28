package com.au.handlers;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import javax.mail.Message;
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
import javax.xml.bind.DatatypeConverter;

import com.au.dao.UserDao;
import com.au.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		Hashtable env = new Hashtable<>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		byte[] temp = DatatypeConverter.parseBase64Binary(request.getHeader("authorization").split(" ")[1]);
		String username = new String(temp).split(":")[0];
		// response.getWriter().append(username);
		UserDao userDao = new UserDao();
		if (username.equals("man")) {

			response.getWriter().append("<html>	<body>");

			List<User> l = userDao.getAllUsers();
			for (User user : l) {
				response.getWriter().append(user.toString()).append("<br>");
			}

			response.getWriter().append("<hr><h2>Add User</h2><form method='post' action='login'>");
			response.getWriter().append("<input type='name' name='name' placeholder='Name'><br>");
			response.getWriter().append("<input type='email' name='email' placeholder='Email'><br><input type='submit' value='Add User'>");
			response.getWriter().append("</form>");

			response.getWriter().append("</body></html>");
		} else if (username.equals("emp")) {

			User user = new User(username, "", 0);

			response.getWriter().append(userDao.getEmail(user));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User u = new User(request.getParameter("name"), request.getParameter("email"), 0);
		UserDao udao = new UserDao();
		udao.addUser(u);
		sendMailPlease(u.getEmail());
		response.sendRedirect("login");

	}

	public void sendMailPlease(String toEmail) {
		Context initialContext;
		Context envContext = null;
		try {
			initialContext = new InitialContext();
			envContext = (Context) initialContext.lookup("java:/comp/env");
			Session session = (Session) envContext.lookup("mail/Session");
			System.out.println("HERE smtp.user: " + session.getProperty("mail.smtp.user"));
			System.out.println("to email : " + toEmail);
			String email = "saumyadeepjndi@gmail.com";

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			InternetAddress dests[] = new InternetAddress[] { new InternetAddress(toEmail) };
			message.setRecipients(Message.RecipientType.TO, dests);
			message.setSubject("Brace yourself");
			message.setContent("Welcome To our organisation, May you have a happy stay.", "text/plain");
			Transport.send(message, "saumyadeepjndi@gmail.com", "jndijndi123123");
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
