/**
 * 
 */
package com.accolite.chatterbox;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class ChatterData.
 *
 * @author Lokesh K
 */
public class ChatterData {

	/** The chatter data. */
	private static volatile ChatterData chatterData;
	
	/** The users. */
	private ArrayList<String> users;
	
	/** The messages. */
	private String messages;
	
	/** The filters. */
	private ArrayList<String> filters;
	
	/** The active users. */
	private Set<String> activeUsers;

	/**
	 * Instantiates a new chatter data.
	 */
	private ChatterData() {
		users = new ArrayList<String>();
		filters = new ArrayList<String>();
		activeUsers = new HashSet<String>();
		messages = "";
		users.add("admin:e=mc2");
		users.add("lokesh:log10");
		users.add("jegan:muthu");
	}

	/**
	 * Gets the chatter data instance.
	 *
	 * @return the chatter data instance
	 */
	public static ChatterData getChatterDataInstance() {
		if (chatterData == null) {
			synchronized (ChatterData.class){
				if (chatterData == null)
					chatterData = new ChatterData();
			}
		}
		return chatterData;
	}

	/**
	 * Do authorize.
	 *
	 * @param name the name
	 * @param password the password
	 * @return true, if successful
	 */
	public boolean doAuthorize(String name, String password) {
		for (String u : users) {
			if (u.equals(name + ":" + password))
				return true;
		}
		return false;
	}

	/**
	 * Adds the user.
	 *
	 * @param name the name
	 * @param password the password
	 */
	public void addUser(String name, String password) {
		if (!doAuthorize(name, password))
			users.add(name + ":" + password);
	}

	/**
	 * Adds the filter.
	 *
	 * @param words the words
	 */
	public void addFilter(String words) {
		String[] word = words.split(",");
		for (String w : word) {
			filters.add(w);
		}
	}

	/**
	 * Adds the message.
	 *
	 * @param user the user
	 * @param message the message
	 */
	public void addMessage(String user, String message) {
		messages = user + ":" + message + "<br>" + messages;
	}

	/**
	 * Gets the messages.
	 *
	 * @return the messages
	 */
	public String getMessages() {
		return messages;
	}

	/**
	 * Gets the filters.
	 *
	 * @return the filters
	 */
	public String[] getFilters() {
		String[]filters=new String[this.filters.size()];
		this.filters.toArray(filters);
		return filters;
	}
	
	/**
	 * Gets the active users.
	 *
	 * @return the active users
	 */
	public String[] getActiveUsers() {
		String[]activeUsers=new String[this.activeUsers.size()];
		this.activeUsers.toArray(activeUsers);
		return activeUsers;
	}

	/**
	 * Adds the active user.
	 *
	 * @param activeUser the active user
	 */
	public void addActiveUser(String activeUser) {
		this.activeUsers.add(activeUser);
	}
	
	/**
	 * Removes the active user.
	 *
	 * @param inActiveUser the inactive user
	 */
	public void removeActiveUser(String inActiveUser) {
		this.activeUsers.remove(inActiveUser);
	}
}
