/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
* Created date :: Jul 24, 2016
*  @author :: Lokesh K
* ***************************************************************************
*/
package com.accolite.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// TODO: Auto-generated Javadoc
/**
 * The Class JSONHandler.
 */
public class JSONHandler {
	
	/** The parser. */
	JSONParser parser;
	
	/** The user array. Array of all  the users*/
	JSONArray userArray;
	
	/** The user. current user who requires our service*/
	JSONObject user;
	
	/** The user index. */
	int userIndex;
	
	/** The file where data stored. */
	File f;

	/**
	 * Instantiates a new JSON handler.
	 *
	 * @param name the name
	 */
	// @SuppressWarnings("unchecked")
	@SuppressWarnings("unchecked")
	public JSONHandler(String name) {
		parser = new JSONParser();
		f = new File("FBdata.json");
//		 f.delete();
		if (f.exists()) {
			try {
				userIndex = 0;
				userArray = (JSONArray) parser.parse(new FileReader(f));
				for (Object u : userArray) {
					JSONObject usr = (JSONObject) u;
					if (name.equals((String) usr.get("name"))) {
						user = usr;
						break;
					}
					userIndex++;
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				f.createNewFile();
				userArray = new JSONArray();
				//user1
				user = new JSONObject();
				user.put("name", "log10");
				JSONArray userMessage = new JSONArray();
				JSONObject message = new JSONObject();
				message.put("id", 0);
				message.put("message", "Happy Fun Friday");
				message.put("like", 0);
				message.put("likers", new JSONArray());
				JSONArray messageComment = new JSONArray();
				JSONObject comment = new JSONObject();
				comment.put("id", 0);
				comment.put("name", "jegan");
				comment.put("comment", "boring pa!");
				messageComment.add(comment);
				message.put("comment", messageComment);
				userMessage.add(message);
				user.put("message", userMessage);
				userArray.add(user);
				//user2
				user = new JSONObject();
				user.put("name", "jegan");
				userMessage = new JSONArray();
				message = new JSONObject();
				message.put("id", 0);
				message.put("message", "Ethan peruda ithaiye kepinga");
				message.put("like", 0);
				message.put("likers", new JSONArray());
				messageComment = new JSONArray();
				message.put("comment", messageComment);
				userMessage.add(message);
				user.put("message", userMessage);
				userArray.add(user);
				//user3
				user = new JSONObject();
				user.put("name", "srithar");
				userMessage = new JSONArray();
				user.put("message", userMessage);
				userArray.add(user);
				//writing json into file
				FileWriter fw = new FileWriter(f);
				userArray.writeJSONString(fw);
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Adds the message.
	 *
	 * @param message the message
	 */
	@SuppressWarnings("unchecked")
	public void addMessage(String message) {
		JSONObject msg = new JSONObject();
		JSONArray userMsg = (JSONArray) user.get("message");
		msg.put("id", "" + userMsg.size() + 1);
		msg.put("message", message);
		msg.put("like", 0);
		msg.put("likers", new JSONArray());
		msg.put("comment", new JSONArray());
		userMsg.add(msg);
		user.put("message", userMsg);
		userArray.set(userIndex, user);
		try {
			FileWriter fw = new FileWriter(f);
			userArray.writeJSONString(fw);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		JSONArray userMsg = (JSONArray) user.get("message");
		return userMsg.toJSONString();
	}

	/**
	 * Gets all user's message.
	 *
	 * @return the all message
	 */
	public String getAllMessage() {
		return userArray.toJSONString();
	}

	/**
	 * Adds the comment.
	 *
	 * @param messageID the message ID
	 * @param comment the comment
	 * @param name the name
	 */
	@SuppressWarnings("unchecked")
	public void addComment(int messageID, String comment, String name) {
		JSONArray userMsg = (JSONArray) user.get("message");
		JSONObject message = (JSONObject) userMsg.get(messageID);
		if (message == null)
			return;
		JSONArray comments = (JSONArray) message.get("comment");
		JSONObject cmnt = new JSONObject();
		cmnt.put("id", "" + comments.size() + 1);
		cmnt.put("name", name);
		cmnt.put("comment", comment);
		comments.add(cmnt);
		message.put("comment", comments);
		userMsg.set(messageID, message);
		user.put("message", userMsg);
		userArray.set(userIndex, user);
		try {
			FileWriter fw = new FileWriter(f);
			userArray.writeJSONString(fw);
			fw.close();
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the comment.
	 *
	 * @param messageID the message ID
	 * @param commentID the comment ID
	 * @return the comment
	 */
	public String getComment(int messageID, int commentID) {
		JSONArray userMsg = (JSONArray) user.get("message");
		JSONObject message = (JSONObject) userMsg.get(messageID);
		if (message == null)
			return "";
		JSONArray comments = (JSONArray) message.get("comment");
		JSONObject comment = (JSONObject) comments.get(commentID);
		if (comment != null)
			return comment.toJSONString();
		return "";
	}

	/**
	 * Gets the all comment.
	 *
	 * @param messageID the message ID
	 * @return the all comment
	 */
	public String getAllComment(int messageID) {
		JSONArray userMsg = (JSONArray) user.get("message");
		JSONObject message = (JSONObject) userMsg.get(messageID);
		if (message == null)
			return "";
		JSONArray comments = (JSONArray) message.get("comment");
		return comments.toJSONString();
	}

	/**
	 * Adds the like.
	 *
	 * @param messageID the message ID
	 * @param whoLiked the who liked
	 */
	@SuppressWarnings("unchecked")
	public void addLike(int messageID,String whoLiked) {
		JSONArray userMsg = (JSONArray) user.get("message");
		JSONObject message = (JSONObject) userMsg.get(messageID);
		if (message == null)
			return;
		int likes = -1;
		try {
			likes = ((Integer) message.get("like")).intValue();
		} catch (ClassCastException e) {
			likes = ((Long) message.get("like")).intValue();
		}
		message.put("like", likes + 1);
		JSONArray likers=(JSONArray)message.get("likers");
		likers.add(whoLiked);
		message.put("likers", likers);
		userMsg.set(messageID, message);
		user.put("message", userMsg);
		userArray.set(userIndex, user);
		try {
			FileWriter fw = new FileWriter(f);
			userArray.writeJSONString(fw);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the likers.
	 *
	 * @param messageID the message ID
	 * @return the likers
	 */
	public String getLikers(int messageID) {
		JSONArray userMsg = (JSONArray) user.get("message");
		JSONObject message = (JSONObject) userMsg.get(messageID);
		if (message == null)
			return "";
		JSONArray likers = (JSONArray) message.get("likers");
		return likers.toJSONString();
	}
}
