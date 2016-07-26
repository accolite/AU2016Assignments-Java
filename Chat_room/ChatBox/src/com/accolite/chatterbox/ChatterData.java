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
 * A singleton class that stores all the chatter box's data and have methods to manipulate and retrieve it
 * @author Lokesh K
 */
public class ChatterData {

	/** The chatter data. the singleton instance*/
	private static volatile ChatterData chatterData;
	
	/** The users. */
	private ArrayList<String> users;
	
	/** The messages. all the messages are concatenated in this string*/
	private String messages;
	
	/** The filters. list of filter words*/
	private ArrayList<String> filters;
	
	/** The active users. set of active users in chatter box*/
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
	 * static method to get the instance of this singleton class
	 * either any servlet, filter or listener in the web container might invoke this
	 * threadsafe so you can access it from multi-threaded environment also
	 *
	 * @return the chatter data instance
	 */
	public static ChatterData getChatterDataInstance() {
		if (chatterData == null) {
			//synchronizing to make it thread safe
			synchronized (ChatterData.class){
				//chatterData might have been instantiated in some other thread while for waiting to get the lock
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
	 * @return the int 1-user exist, 0-username exist and -1-user not found
	 */
	public int doAuthorize(String name, String password) {
		for (String u : users) {
			//user stored in as string with ':' separating name and password
			String []userAuth=u.split(":");
			if(userAuth[0].equals(name)){
				if(userAuth[1].equals(password))
					return 1;
				else return 0;
			}
		}
		return -1;
	}

	/**
	 * Adds the user.
	 *
	 * @param name the username
	 * @param password the password
	 */
	public void addUser(String name, String password) {
		//adding user name and password as single entity for simplicity purpose
		users.add(name + ":" + password);
	}

	/**
	 * Adds the filter.
	 *
	 * @param words the filter words
	 */
	public void addFilter(String words) {
		//it comes as comma separated
		String[] word = words.split(",");
		for (String w : word) {
			filters.add(w);
		}
	}

	/**
	 * Adds the message.
	 *
	 * @param user the username
	 * @param message the message
	 */
	public void addMessage(String user, String message) {
		//concatenating to the message string, in order to display recent message at the top, the older message attached at the end
		//the <br> is the html break tag, again for simplicity purpose storing the message in single entity
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
	 * @return the filters, not the actual list but the copy of the list as an array
	 */
	public String[] getFilters() {
		String[]filters=new String[this.filters.size()];
		this.filters.toArray(filters);
		return filters;
	}
	
	/**
	 * Gets the active users.
	 *
	 * @return the active users, not the actual set but the copy of the set as an array
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
