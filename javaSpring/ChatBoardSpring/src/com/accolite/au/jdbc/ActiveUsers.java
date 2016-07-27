package com.accolite.au.jdbc;

import java.util.HashSet;
import java.util.Set;

public class ActiveUsers {
	
	Set<String> activeUserList;
	
	public ActiveUsers(){
		activeUserList = new HashSet<String>();
	}
	
	public boolean addToActiveSet(String username){
		return activeUserList.add(username);
	}
	
	public Set<String> getActiveUserList(){
		return activeUserList;
	}
	
	public void removeFromActiveList(String username){
		activeUserList.remove(username);
	}
}
