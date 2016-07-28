package servlet;

import java.io.IOException;

import javax.mail.Message;
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
import javax.websocket.Session;

/**
 * Servlet implementation class MailServlet
 */
@WebServlet("/MailServlet")
public class MailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String toEmail = "accolite.assignment@gmail.com";
		Context initialContext;
		  Context envContext = null;
		  try {
		   initialContext = new InitialContext();
		   envContext = (Context) initialContext.lookup("java:/comp/env");
		   javax.mail.Session session = (javax.mail.Session) envContext.lookup("mail/Session");
		 //  System.out.println("HERE smtp.user: " + session.getProperty("mail.smtp.user"));
		  // System.out.println("to email : " + toEmail);
		   String email = request.getParameter("email");

		   Message message = new MimeMessage(session);
		   message.setFrom(new InternetAddress(email));
		   InternetAddress dests[] = new InternetAddress[] { new InternetAddress(toEmail) };
		   message.setRecipients(Message.RecipientType.TO, dests);
		   message.setSubject("Brace yourself");
		   message.setContent("Welcome To our organisation, May you have a happy stay.", "text/plain");
		   Transport.send(message, "accolite.assignment@gmail.com", "mitulkapoor");
		   response.sendRedirect("ManageServlet");

		  } catch (Exception e) {
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
