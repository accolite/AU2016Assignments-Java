/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 27, 2016

*

*  @author :: Sachin Gupta

* ***************************************************************************

*/
package com.accolite.spring.ChatBoxUsingSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceClass.
 */
@Service
public class ServiceClass {

	/** The activeusers. */
	@Autowired 
	ActiveUsers activeusers;
	
	/** The loginuser. */
	@Autowired
	LoginUser loginuser;
	
	/** The r. */
	@Autowired
	RegisterUser r;
	
	/** The c. */
	@Autowired
	Chats c;
	
	
	/**
	 * Listof active users.
	 *
	 * @return the string
	 */
	String listofActiveUsers()
	{
		return activeusers.activeUsers();
	}
	
	/**
	 * Login.
	 *
	 * @param userName the user name
	 * @param userPassword the user password
	 */
	void login(String userName,String userPassword)
	{
		loginuser.validateUser(userName, userPassword);
	}
	
	/**
	 * Register.
	 *
	 * @param userName the user name
	 * @param userPassword the user password
	 */
	void register(String userName,String userPassword)
	{
		UserInfo user=new UserInfo();
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		r.addUser(user);
	}
	
	/**
	 * Chats.
	 *
	 * @return the string
	 */
	String chats()
	{
		return c.getChats();
	}
	
	
}
