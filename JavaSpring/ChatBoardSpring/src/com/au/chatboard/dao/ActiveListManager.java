package com.au.chatboard.dao;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.au.chatboard.bean.ActiveList;

@Component
public class ActiveListManager {

	@Autowired
	ActiveList activeList;
	
	public boolean addUser(String username){
		Set<String> activeUsers = activeList.getActiveUsers();
		if(!activeUsers.contains(username)){
			activeUsers.add(username);
			activeList.setActiveUsers(activeUsers);
			return true;
		}
		return false;
	}
	
	public String getUsersList(String username){
		Set<String> activeUsers = activeList.getActiveUsers();
		if(activeUsers.isEmpty())
			return null;
		StringBuilder sb = new StringBuilder();
		for(String user: activeUsers)
			if(user.equals(username))
				sb.append("<b>"+user+"</b><br/>");
			else
				sb.append(user+"<br/>");
		return sb.toString();
	}
	
}
