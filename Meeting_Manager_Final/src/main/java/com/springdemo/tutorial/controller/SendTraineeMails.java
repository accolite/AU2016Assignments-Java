/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Aug 10, 2016

*

*  @author :: Udit Mehata

* ***************************************************************************

*/
package com.springdemo.tutorial.controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

// TODO: Auto-generated Javadoc
/**
 * The Class SendTraineeMails.
 */
public class SendTraineeMails {
	
	/** The email ID. */
	String emailID;
	
	/** The subject. */
	String subject;
	
	/** The body. */
	String body;

	/**
	 * Instantiates a new send trainee mails.
	 */
	public SendTraineeMails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new send trainee mails.
	 *
	 * @param emailID the email ID
	 * @param subject the subject
	 * @param body the body
	 */
	public SendTraineeMails(String emailID, String subject, String body) {
		super();
		this.emailID = emailID;
		this.subject = subject;
		this.body = body;
	}

	/**
	 * Gets the email ID.
	 *
	 * @return the email ID
	 */
	public String getEmailID() {
		return emailID;
	}

	/**
	 * Sets the email ID.
	 *
	 * @param emailID the new email ID
	 */
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	/**
	 * Gets the subject.
	 *
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Sets the subject.
	 *
	 * @param subject the new subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * Gets the body.
	 *
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * Sets the body.
	 *
	 * @param body the new body
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * Mailsend.
	 */
	public void mailsend() {
		final String username = "YOUR EMAIL HERE";
		final String password = "YOUR PASSWORD HERE";

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
			message.setFrom(new InternetAddress("ENTER YOUR EMAIL HERE"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailID)); // emailID
			message.setSubject(subject);
			message.setText(body);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
