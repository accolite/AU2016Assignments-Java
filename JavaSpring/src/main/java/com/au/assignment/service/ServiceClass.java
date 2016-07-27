package com.au.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.au.assignment.jdbctemplate.JDBCTemplateDAO;
import com.au.assignment.jdbctemplate.Message;
import com.au.assignment.jdbctemplate.UserDetail;

public class ServiceClass {
	@Autowired
	private JDBCTemplateDAO jdbc;
	public boolean vaildatateUserService(String username,String password)
	{
		UserDetail user=jdbc.vaildatateUser(username);
		if(user==null)
			return false;
		else{
		 if(((user.getUsername()).equals(username))&& ((user.getPassword()).equals(password)))
		 {
			 jdbc.SetActiveUser(user);
		 return true;
		 }
		 else 
			 return false;
	
		}
	}
	public void registerUserService(UserDetail user) {
		jdbc.registerUser(user);
		
	}
	public void SetInActiveUserService(UserDetail user) {
		jdbc.SetInActiveUser(user);
		
	}
	public void postMessageService(Message msg) {
		jdbc.PostMessageTable(msg);
		
	}
	public List<Message> getChatListService() {
		return(jdbc.GetChatList());
	}
}
