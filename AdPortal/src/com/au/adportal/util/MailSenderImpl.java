package com.au.adportal.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.au.adportal.dao.DaoInterface;
import com.au.adportal.model.CurrentUser;
import com.au.adportal.model.Post;

@Component
public class MailSenderImpl implements MailSender{

	@Autowired
	JavaMailSender javaMailSender;
	
	@Autowired
	DaoInterface dao;
	
	@Autowired
	Environment env;
	
	@Override
	public void sendMail(String to, String subject, String message){
	    MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            helper.setReplyTo(env.getProperty("spring.mail.replyTo"));
            helper.setFrom(env.getProperty("spring.mail.username"));
            helper.setSubject(subject);
            helper.setText(message, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        } finally {}
        javaMailSender.send(mail);
	}
	
	@Async
	@Override
	public void sendContactMail(CurrentUser user, Post post, String message){

		String toMail = dao.getUser(post.getUserid()).getEmail();
		String subject = "AdPortal : Interested in "+post.getTitle();

		sendMail(toMail, subject, message);
	}
	
}
