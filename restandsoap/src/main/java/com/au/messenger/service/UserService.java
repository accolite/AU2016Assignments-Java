package com.au.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.au.messenger.database.DatabaseClass;
import com.au.messenger.model.User;

public class UserService {
	
	private Map<Integer,User> users = DatabaseClass.getUsers();
	
	public List<User> getAllUsers(){
		return new ArrayList<User>(users.values());	
	}
	
	public User getUser(int id){
		return users.get(id);
	}
	
}
