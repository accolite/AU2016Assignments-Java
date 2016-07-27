/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 25, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************
*/

package com.accolite.Servlets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class mainClass.
 */
public class mainClass {
	
	/** The Users. */
	private static Map<String, String> Users = new HashMap<String, String>();
	
	/** The Messages. */
	private static List<String> Messages = new ArrayList<String>();
	
	/** The Active users. */
	private static Set<String> ActiveUsers = new HashSet<String>();
	
	/** The Filters. */
	private static List<String> Filters = new ArrayList<String>();
	
	/**
	 * Gets the filters.
	 *
	 * @return the filters
	 */
	public static List<String> getFilters() {
		return Filters;
	}

	/**
	 * Sets the filters.
	 *
	 * @param filters the new filters
	 */
	public static void setFilters(List<String> filters) {
		Filters = filters;
	}

	
	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	public static Map<String, String> getUsers() {
		return Users;
	}

	/**
	 * Sets the users.
	 *
	 * @param users the users
	 */
	public static void setUsers(Map<String, String> users) {
		Users = users;
	}

	
	/**
	 * Gets the active users.
	 *
	 * @return the active users
	 */
	public static Set<String> getActiveUsers() {
		return ActiveUsers;
	}

	/**
	 * Sets the active users.
	 *
	 * @param activeUsers the new active users
	 */
	public static void setActiveUsers(Set<String> activeUsers) {
		ActiveUsers = activeUsers;
	}

	/**
	 * Gets the messages.
	 *
	 * @return the messages
	 */
	public static List<String> getMessages() {
		return Messages;
	}

	/**
	 * Sets the messages.
	 *
	 * @param messages the new messages
	 */
	public static void setMessages(List<String> messages) {
		Messages = messages;
	}
	
	
	
}
