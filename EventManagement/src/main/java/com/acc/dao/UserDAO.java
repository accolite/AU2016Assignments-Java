/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Aug 10, 2016
*
*  @author :: Ravi Kalmodia
* ***************************************************************************
*/
package com.acc.dao;

import com.acc.model.Person;
import com.acc.model.User;

/**
 * The Interface UserDAO.
 */
public interface UserDAO {
	/**
	 * method insertUser
	 * to insert a user
	 * @param person
	 * @return status of user insert
	 */
	public int insertUser(Person person);
	/**
	 * method getUser
	 * to get user details
	 * @param person
	 * @return the user
	 */
	public User getUser(Person person);
	
}
