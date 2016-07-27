package com.au.chatboard.bean;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class ActiveList {
	
	Set<String> activeUsers;
	
	ActiveList(){
		activeUsers = new HashSet<>();
	}
	
	public Set<String> getActiveUsers() {
		return activeUsers;
	}

	public void setActiveUsers(Set<String> activeUsers) {
		this.activeUsers = activeUsers;
	}
	
}
