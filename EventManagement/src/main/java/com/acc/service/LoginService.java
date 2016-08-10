/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Aug 10, 2016
*
*  @author :: Sharukh Mohamed
* ***************************************************************************
*/
package com.acc.service;

import javax.servlet.http.HttpServletRequest;

import com.acc.model.Person;
import com.acc.util.GooglePOJO;

/**
 * The Interface LoginService.
 */
public interface LoginService {
	
	/**
	 * Check login.
	 *
	 * @param googlePojo the google pojo
	 * @param request the request
	 * @return the person
	 */
	public Person checkLogin(GooglePOJO googlePojo, HttpServletRequest request);
}
