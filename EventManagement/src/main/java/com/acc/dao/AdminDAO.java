/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Aug 10, 2016
*
*  @author :: Sharukh Mohamed
* ***************************************************************************
*/
package com.acc.dao;

import com.acc.model.Admin;
import com.acc.model.Person;

/**
 * The Interface AdminDAO.
 */
public interface AdminDAO {
	/**
	 * method insertAdmin
	 * to insert a new admin
	 * @param person
	 * @return status of new admin insertion
	 */
	public Integer insertAdmin(Person person);
	/**
	 * method getAdmin
	 * to get the admin details
	 * @param person
	 * @return
	 */
	public Admin getAdmin(Person person);
}
