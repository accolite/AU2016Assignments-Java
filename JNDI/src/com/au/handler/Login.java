package com.au.handler;

import java.io.IOException;
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
import javax.xml.bind.DatatypeConverter;

import com.au.dao.UserDao;
import com.au.model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Override
	 public void init() throws ServletException {
	  Hashtable env = new Hashtable<>();
	  env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
	 }
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		byte[] temp = DatatypeConverter.parseBase64Binary(request.getHeader("authorization").split(" ")[1]);
		  String username = new String(temp).split(":")[0];
		  response.getWriter().append(username);
		  response.setContentType("text/html");
		  UserDao userDao = new UserDao();
		  response.getWriter().append("<html><body>");
		  if (username.equals("manager")) {
			  List<User> users = userDao.getAllUsers();
			  for (User user : users) {
				  response.getWriter().append(user.getName() + " , " + user.getEmail() + "<br>");
				
			}
			  
		response.getWriter().append("<hr><h2>Add User</h2><form method='post' action='Login'>");
	    response.getWriter().append("<input type='name' name='name' placeholder='Name'><br>");
	    response.getWriter().append("<input type='email' name='email' placeholder='Email'><br><input type='submit' value='Add User'>");
	    response.getWriter().append("</form>");
	     response.getWriter().append("</body></html>");
		  } else if (username.equals("employee")) {
		   User user = new User(username, "", 0);   
		   response.getWriter().append(userDao.getEmail(user));
		  }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		User u = new User(name,email,0);
		UserDao udao = new UserDao();
		udao.addUser(u);
		sendMail(u.getEmail());
		response.sendRedirect("Login");
		
	}
	public void sendMail(String to) {
		  Context initialContext;
		  Context envContext = null;
		  Session session = null ;
		  try {
		   initialContext = new InitialContext();
		   envContext = (Context) initialContext.lookup("java:/comp/env");
		   session = (Session) envContext.lookup("mail/Session");
		   Message message = new MimeMessage(session);
		   message.setFrom(new InternetAddress("arnikat0@gmail.com"));
		   InternetAddress dests[] = new InternetAddress[] { new InternetAddress(to) };
		   message.setRecipients(Message.RecipientType.TO, dests);
		   message.setSubject("Send the Mail");
		   message.setContent("Mail Sent", "text/plain");

		   Transport.send(message,"arnikat0@gmail.com","lovetwilight");
		  } catch (NamingException | MessagingException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
		 
		 }
}
