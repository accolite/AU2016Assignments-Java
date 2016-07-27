package com.accolite.au.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.accolite.au.jdbc.ActiveUsers;
import com.accolite.au.jdbc.JDBCTemplateDao;
import com.accolite.au.jdbc.Message;
import com.accolite.au.jdbc.User;

@org.springframework.stereotype.Service
public class Service {
	
	@Autowired
	JDBCTemplateDao dao = new JDBCTemplateDao(); 
	
	@Autowired
	ActiveUsers activeUsersDao = new ActiveUsers();
	
	/*
	 * Dao 
	 */
	public boolean addUser(String username, String password){
		
		User user = new User(username,password);
		return dao.addUser(user);
	}
	
	public boolean addMessage(String username, String message){
		Message messageObj = new Message(username, message);
		return (dao.addMessage(messageObj) >0);
	}
	
	public boolean userAlreadyRegistered(String username){
		
		return dao.validateUser(username);
	}
	
	public String getAllMessages(){
		List<Message> list = dao.retrieveMessages();
		
		String si;
		String total = " ";
		for(Message s: list){
			
			si=s.getMessage();
			total = total + si + "\n";
		}
		
		return total;
	}
	
	public boolean loginValidation(String username, String password){
		
		User tmp = new User(username,password);
		User userdb = dao.loginValidation(tmp);
		
		if(userdb.getUsername().equals(username) && userdb.getPassword().equals(password) )
			return true;
		else
			return false;
	}
	
	/*
	 * ActiveUsersDao 
	 */
	
	public String getActiveUserList(){
		Set<String> set = activeUsersDao.getActiveUserList();
		
		String total = " ";
		for(String s: set){
			total = total + s + "\n";
		}
		
		return total;
	}
	
	public boolean addUserToActiveList(String username){
		return activeUsersDao.addToActiveSet(username);
	}
	
	public void removeFromActiveList(String username){
		activeUsersDao.removeFromActiveList(username);
	}
	
}
