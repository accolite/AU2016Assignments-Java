package com.accolite.SpringChatApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceClass {

	@Autowired 
	ActiveUsers activeusers;
	
	@Autowired
	LoginUser loginuser;
	
	@Autowired
	RegisterUser r;
	
	String listofActiveUsers()
	{
		return activeusers.activeUsers();
	}
	void login(String userName,String userPassword)
	{
		loginuser.validateUser(userName, userPassword);
	}
	
	void register(String userName,String userPassword)
	{
		UserInfo user=new UserInfo();
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		r.addUser(user);
	}
	
	
}
