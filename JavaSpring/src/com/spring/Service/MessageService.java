package com.spring.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

import com.spring.Dao.MessageDao;
import com.spring.Model.Message;

public class MessageService {
	private MessageDao messageDao=null;

	public MessageDao getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	public MessageService(MessageDao messageDao) {
		super();
		this.messageDao = messageDao;
	}

	public List<Message> printmessages(){
		return messageDao.printmessages();
	}
	public Boolean putMessage(Message message){
		return messageDao.putMessage(message);
		 }

	public MessageService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
