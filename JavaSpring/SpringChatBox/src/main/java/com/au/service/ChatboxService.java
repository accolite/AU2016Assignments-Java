package com.au.service;

import java.util.List;

import com.au.dao.ChatboxDAO;

public class ChatboxService {

	private ChatboxDAO dao = new ChatboxDAO();
	public boolean register(String userName, String password) {
		return dao.register(userName, password);
		
	}
	public boolean login(String userName, String password) {
		
		return dao.login(userName, password);
	}
	public boolean addMessage(String userName, String message) {
		return dao.addMessage(userName, message);
	}
	public List<String> getChat() {
		return dao.getChat();
	}
	public List<String> getActiveUser() {
		// TODO Auto-generated method stub
		return dao.getActiveUser();
	}
	public boolean logout(String userName) {
		// TODO Auto-generated method stub
		return dao.logout(userName);
	}
}

