package com.springchat.service;

import com.springchat.dao.User;
import com.springchat.dao.Message;
import com.springchat.dao.JDBCTemplateDao;

import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springchat.dao.ActiveUsers;

@org.springframework.stereotype.Service

public class Service {

	@Autowired
	private JDBCTemplateDao jdbc = new JDBCTemplateDao();

	@Autowired
	ActiveUsers active = new ActiveUsers();

	public boolean validUser(String uname) {
		if (!jdbc.validUser(uname)) {
			return true;
		} else
			return false;
	}

	public boolean addUser(String uname, String pass) {
		User user = new User();
		user.setUsername(uname);
		user.setPassword(pass);
		if (jdbc.registerUserUsingPreparedStatement(user))
			return true;
		else
			return false;
	}

	public boolean addMessage(String username, String message) {

		if (jdbc.addMessage(username, message) > 0)
			return true;
		else {
			return false;
		}
	}

	public boolean validate(String username, String password) {
		/*
		 * User user=new User(); user.setUsername(username);
		 * user.setPassword(password);
		 */
		if (jdbc.validateUser(username, password))
			return true;
		else
			return false;
	}

	public String getMessage() {
		ArrayList<Message> arrayList = (ArrayList<Message>) jdbc.getAllMessages();
		String allMessage = "";
		for (Message msg : arrayList) {
			String username = msg.getUsername();
			String message = msg.getMessage();
			allMessage += username + ":" + message + "\n";
		}
		return allMessage;
	}

	public boolean addToActiveUserList(String username) {
		if (active.addUserToActiveUsersList(username))
			return true;
		else
			return false;
	}

	public boolean removeToActiveUserList(String username) {
		if (active.removeUserToActiveUsersList(username))
			return true;
		else
			return false;
	}

	public String activeUserList() {
		HashSet<String> hashSet = (HashSet<String>) active.getActiveUsersList();
		String listuser = "";
		for (String s : hashSet) {

			listuser += s + "\n";
		}
		return listuser;
	}

}
