package com.accolite.chatapp.service;

import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;

import com.accolite.chatapp.jdbc.ActiveUsers;
import com.accolite.chatapp.jdbc.JDBCTemplateDao;
import com.accolite.chatapp.jdbc.Message;
import com.accolite.chatapp.jdbc.User;

@org.springframework.stereotype.Service
public class ChatServices {
	
	@Autowired
	private JDBCTemplateDao jdbcTemplateDao=new JDBCTemplateDao();
	
	@Autowired
	private ActiveUsers activeUsers=new ActiveUsers();
	
	public boolean addUser(String username,String password){
		
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		
		if(jdbcTemplateDao.addUser(user))
			return true;
		else
			return false;
	}
	
	public boolean addMessage(String username,String message){
		
		if(jdbcTemplateDao.addMessage(username, message)>0)
			return true;
		else {
			return false;
		}
	}
	
	public boolean validate(String username,String password){
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		if(jdbcTemplateDao.validate(user))
			return true;
		else
			return false;
	}
	
	public boolean validUser(String username){
		if(jdbcTemplateDao.validUser(username))
			return true;
		else
			return false;
	}
	
	public String getMessage(){
		ArrayList<Message> arrayList=(ArrayList<Message>)jdbcTemplateDao.getAllMessages();
		String allMessage="";
		for(Message msg:arrayList){
			String username=msg.getUsername();
			String message=msg.getMessage();
			allMessage+=username+":"+message+"\n";	
		}
		return allMessage;
	}
	
	public boolean addToActiveUserList(String username){
		if(activeUsers.addUserToActiveUsersList(username))
			return true;
		else
			return false;
	}
	
	public boolean removeToActiveUserList(String username){
		if(activeUsers.removeUserToActiveUsersList(username))
			return true;
		else
			return false;
	}
	
	public String activeUserList(){
		HashSet<String> hashSet=(HashSet<String>) activeUsers.getActiveUsersList();
		String auser="";
		for(String s:hashSet){
			
			auser+=s+"\n";
		}
		return auser;
	}

}
