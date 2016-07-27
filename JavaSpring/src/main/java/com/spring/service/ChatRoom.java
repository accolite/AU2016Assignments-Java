package com.spring.service;

import java.util.List;

import com.spring.dao.SpringChatDao;

public class ChatRoom {
	
	private SpringChatDao dao = new SpringChatDao();
	public boolean Register(String name,String pass){
		return dao.Register(name,pass);
	}
	public boolean Login(String name, String password) {
		// TODO Auto-generated method stub
		return dao.Login(name, password);
		
	}
	public boolean Talk(String name, String msg) {
		// TODO Auto-generated method stub
		//return false;
		return dao.Talk(name, msg);
	}
	public List<String> Chat() {
		// TODO Auto-generated method stub
		//return false;
		return dao.Chat();
	}
	public String Users() {
		// TODO Auto-generated method stub
		return dao.Users();
	}
	public boolean Logout(String name) {
		// TODO Auto-generated method stub
		return dao.Logout(name);
		
	}
}
