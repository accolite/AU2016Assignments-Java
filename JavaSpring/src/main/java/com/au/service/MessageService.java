package com.au.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.au.dao.MessageDao;
import com.au.model.Message;

public class MessageService {
	private MessageDao messageDao;

	public MessageService(MessageDao messageDao) {
		super();
		this.messageDao = messageDao;
	}

	public MessageService() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

		messageDao = (MessageDao) ac.getBean("mdao");
	}
	
	public List<Message> getAllMessages(){
		return messageDao.getAllMessages();
	}
	
	public Boolean putMessage(Message message){
		return messageDao.putMessage(message);
	}

}
