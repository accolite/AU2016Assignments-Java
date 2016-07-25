package com.acco.groupSkype;

import java.util.HashMap;

public class UserInformation {
	private static HashMap<String,String>tot_users = new HashMap<String,String>();	
	
	public int addNewUser(String username,String password){
		if(tot_users.containsKey(username))
			return Constants.DUPLICATE_USER_NAME;
		tot_users.put(username, password);
		return Constants.USER_ADDED_SUCCESSFULLY;
	}
	
	public int checkUser(String username,String password){
		System.out.println(tot_users.size());
		if(!tot_users.containsKey(username))
			return Constants.USER_NOT_FOUND;
		if(!tot_users.get(username).equals(password))
			return Constants.PASSWORD_MISMATCH;
		return Constants.USER_FOUND;
	}
}
