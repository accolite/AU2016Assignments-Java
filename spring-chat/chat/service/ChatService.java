/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 27, 2016

*

*  @author :: Balaji P

* ***************************************************************************

*/
package com.accolite.chat.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.codehaus.jettison.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.chat.dao.JdbcConnectDao;

// TODO: Auto-generated Javadoc
/**
 * The Class ChatService.
 */
@Service
public class ChatService {
	
	/** The jdbc connect dao. */
	@Autowired
	private JdbcConnectDao jdbcConnectDao;
	
	/**
	 * Gets the jdbc connect dao.
	 *
	 * @return the jdbc connect dao
	 */
	public JdbcConnectDao getJdbcConnectDao() {
		return jdbcConnectDao;
	}

	/**
	 * Sets the jdbc connect dao.
	 *
	 * @param jdbcConnectDao the new jdbc connect dao
	 */
	public void setJdbcConnectDao(JdbcConnectDao jdbcConnectDao) {
		this.jdbcConnectDao = jdbcConnectDao;
	}

	/**
	 * Creates the user.
	 *
	 * @param username the username
	 * @param password the password
	 * @return true, if successful
	 */
	public boolean createUser(String username, String password) {
		return jdbcConnectDao.createUser(username, password);
	}
	
	
	/**
	 * Send message.
	 *
	 * @param username the username
	 * @param message the message
	 * @return true, if successful
	 */
	public boolean sendMessage(String username, String message){
		ArrayList<String> words = jdbcConnectDao.getWords();
		
		ArrayList<String> messageWords = new ArrayList<String>();
		
		Iterator<String> messageIterator = messageWords.iterator();
		
		while(messageIterator.hasNext()){
			Iterator<String> iterator = words.iterator();
			while(iterator.hasNext()){
				if(iterator.next().equals(messageIterator.next())){
					messageIterator.remove();
				}
			}
		}
		
		String finalMessage = "";
		messageIterator = messageWords.iterator();
		
		while(messageIterator.hasNext()){
			finalMessage = finalMessage+" "+messageIterator.next();
		}
		
		return jdbcConnectDao.sendMessage(username, finalMessage);
		
	}
	
	/**
	 * Gets the messages.
	 *
	 * @param id the id
	 * @return the messages
	 */
	public JSONArray getMessages(int id){
		return jdbcConnectDao.getMessages(id);
	}
	
	/**
	 * Login.
	 *
	 * @param username the username
	 * @param password the password
	 * @return true, if successful
	 */
	public boolean login(String username, String password){
		if(jdbcConnectDao.getPassword(username).equals(password)){
			jdbcConnectDao.startSession(username);
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Logout.
	 *
	 * @param username the username
	 * @return true, if successful
	 */
	public boolean logout(String username){
		return jdbcConnectDao.stopSession(username);
	}
	
	/**
	 * Adds the words.
	 *
	 * @param words the words
	 */
	public void addWords(String words){
		ArrayList<String> prohibitedWords = new ArrayList<String>();
		StringTokenizer stringTokenizer = new StringTokenizer(words);
		
		while(stringTokenizer.hasMoreTokens()){
			prohibitedWords.add(stringTokenizer.nextToken());
		}
		
		jdbcConnectDao.addWords(prohibitedWords);
	}
	
	/**
	 * Gets the active users.
	 *
	 * @return the active users
	 */
	public ArrayList<String> getActiveUsers(){
		return jdbcConnectDao.getActiveUsers();
	}
	
	
	public boolean adminLogin(String username, String password){
		if(jdbcConnectDao.getAdminPassword(username).equals(password)){
			return true;
		}
		else {
			return false;
		}
	}
}
