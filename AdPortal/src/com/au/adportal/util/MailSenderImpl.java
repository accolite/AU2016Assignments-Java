package com.au.adportal.util;

import java.util.List;

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
import com.au.adportal.viewmodel.ViewPost;

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
	
	@Async
	@Override
	public void sendSubscriptionMail(Post post, String currentMail) {
		
		ViewPost viewPost=postToViewPost(post);
		List<String> mails = dao.getMailsForSubscription(post.getCategory());
		for(String toMail: mails){
			if(!toMail.equals(currentMail)){
				String subject = "New post on the category "+dao.getCategoryName(post.getCategory());
				String message = "Post title : "+post.getTitle();
				message += "<br/>Posted by : "+viewPost.getUsername();
				message += "<br/>Location : "+viewPost.getLocation();
				if(viewPost.getPrice()!=0){
					message += "<br/>Price : "+viewPost.getPrice();
				}
				message += "<br/><br/><a href='"+Constants.server+"#/'>Sign in to View</a>";
				sendMail(toMail, subject, message);				
			}
		}
	}
	
	public ViewPost postToViewPost(Post post){
		ViewPost viewpost=new ViewPost();
		   viewpost.setPostid(post.getPostid());
		   viewpost.setTitle(post.getTitle());
		   viewpost.setCategory(dao.getCategoryName(post.getCategory()));
		   viewpost.setDescription(post.getDescription());
		   viewpost.setStatus(post.getStatus());
		   viewpost.setPrice(post.getPrice());
		   viewpost.setLocation(dao.getLocationName(post.getLocation()));
		   viewpost.setCreatedDate(post.getCreatedDate());
		   viewpost.setUsername(dao.getUser(post.getUserid()).getUsername());
		   viewpost.setUserid(post.getUserid());
		   return viewpost;
	}
	
}
