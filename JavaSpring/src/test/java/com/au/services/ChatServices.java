package com.au.services;

import java.util.List;

import com.au.springchat.dao.JDBCTemplatedao;
import com.au.springchat.resources.UserData;

public class ChatServices {
	JDBCTemplatedao dao;
	
	ChatServices cs=new ChatServices();
	
	public void RegisterUser(UserData usrData){
		dao.Register(usrData);
	}
	
	public void insertMessage(UserData usrData){
		dao.InsertMessage(usrData);
	}
	
	public List<String> ChatHistory(){
		return dao.getChatHistory();
	}
	
	public String retrievePassword(String username){
		return dao.getPassword(username);
		
	}
	
	public boolean validateCredentials(String username,String password){
		String s=cs.retrievePassword(username);
		return s.equals(password);
	}
	
}
