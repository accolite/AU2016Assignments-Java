/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 24, 2016

*

*  @author :: Ravi Kalmodia

* ***************************************************************************

*/
package com.au.chat;

import java.util.List;

import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

// TODO: Auto-generated Javadoc
/**
 * The Class Message.
 */
public class Message {

	/** The creator. */
	String creator;
	
	/** The message. */
	String message;
	
	/** The msgid. */
	String msgid;
	
	/** The no likes. */
	Integer noLikes;
	
	/** The likes. */
	List<Like> likes;
	
	/** The comments. */
	List<Comment> comments;
	
	/**
	 * Gets the creator.
	 *
	 * @return the creator
	 */
	public String getCreator() {
		return creator;
	}
	
	/**
	 * Gets the no likes.
	 *
	 * @return the no likes
	 */
	public Integer getNoLikes() {
		return noLikes;
	}
	
	/**
	 * Sets the no likes.
	 *
	 * @param noLikes the new no likes
	 */
	public void setNoLikes(Integer noLikes) {
		this.noLikes = noLikes;
	}
	
	/**
	 * Sets the creator.
	 *
	 * @param creator the new creator
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Gets the msgid.
	 *
	 * @return the msgid
	 */
	public String getMsgid() {
		return msgid;
	}
	
	/**
	 * Sets the msgid.
	 *
	 * @param msgid the new msgid
	 */
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
	
	/**
	 * Gets the likes.
	 *
	 * @return the likes
	 */
	public List<Like> getLikes() {
		return likes;
	}
	
	/**
	 * Sets the likes.
	 *
	 * @param likes the new likes
	 */
	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}
	
	/**
	 * Gets the comments.
	 *
	 * @return the comments
	 */
	public List<Comment> getComments() {
		return comments;
	}
	
	/**
	 * Sets the comments.
	 *
	 * @param comments the new comments
	 */
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	/**
	 * Instantiates a new message.
	 *
	 * @param creator the creator
	 * @param message the message
	 * @param msgid the msgid
	 * @param noLikes the no likes
	 * @param likes the likes
	 * @param comments the comments
	 */
	public Message(String creator, String message, String msgid, int noLikes, List<Like> likes, List<Comment> comments) {
		this.creator = creator;
		this.message = message;
		this.msgid = msgid;
		this.likes = likes;
		this.comments = comments;
		this.noLikes = 0;
	}
	
	/**
	 * Instantiates a new message.
	 */
	public Message() {
	}
	
	
}
