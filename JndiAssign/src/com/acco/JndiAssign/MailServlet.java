package com.acco.JndiAssign;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MailServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		InitialContext initCtx;
		try {
			initCtx = new InitialContext();
			Session session = (Session) initCtx.lookup("java:comp/env/mail/Session");

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(request.getParameter("from")));
			InternetAddress to[] = new InternetAddress[1];
			to[0] = new InternetAddress(request.getParameter("to"));
			message.setRecipients(Message.RecipientType.TO, to);
			message.setSubject(request.getParameter("subject"));
			message.setContent(request.getParameter("content"), "text/plain");
			Transport transport = session.getTransport("smtp");
			transport.connect("smtp.gmail.com", "vishalgoyal2612", "ramcharitmanas");
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			Transport.send(message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
