package com.au.proma.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.au.proma.model.Project;
import com.au.proma.model.User;

public class SendMailTLS {

	public void sendMail(String userEmail, Project p, String msg) {
		// TODO Auto-generated method stub
		final String username = "saumyadeepjndi@gmail.com";
		final String password = "jndijndi123123";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("asdasd@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(userEmail));
			message.setSubject(msg);
			String content = "Project Details : "+"\n" + "Project id : "+p.getProjectid() + "\n"
					+"Project name : "+p.getProjectname() + "\n"
					+"Project resource working : "+p.getResourceworking() + "\n"
					 + "\n";
			message.setText(content);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
