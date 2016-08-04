package com.au.adportal.util;

import com.au.adportal.model.CurrentUser;
import com.au.adportal.model.Post;

public interface MailSender {

	public void sendMail(String to, String subject, String message);
	
	public void sendContactMail(CurrentUser user, Post post, String message);
}
