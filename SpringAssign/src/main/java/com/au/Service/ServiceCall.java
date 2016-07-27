package com.au.Service;

import java.util.List;

import com.au.JdbcTemplate.Chat;
import com.au.JdbcTemplate.JdbcTemplateDao;
import com.au.JdbcTemplate.UserDetails;


public class ServiceCall 
{
	private JdbcTemplateDao jdbc;
	public void registerUser(UserDetails user) {
		// TODO Auto-generated method stub
		jdbc.register(user);
	}

	public boolean validateUserCredentials(String username, String password) {
		// TODO Auto-generated method stub
		UserDetails user=jdbc.login(username);
		if(user.getUsername().equals(username) && user.getPassword().equals(password))
		{
			jdbc.SetActiveUser(user);
			return true;	
		}
			else
			return false;
	}

	public void addMessage(Chat message) {
		// TODO Auto-generated method stub
		jdbc.insertMessage(message);
		
	}

	public void setInactiveUser(UserDetails user) {
		// TODO Auto-generated method stub
		jdbc.SetInActiveUser(user);
		
	}

	public List<Chat> getChatList() {
		// TODO Auto-generated method stub
		List<Chat>users=jdbc.GetChatList();
		return users;
	}

	

	
	


}
