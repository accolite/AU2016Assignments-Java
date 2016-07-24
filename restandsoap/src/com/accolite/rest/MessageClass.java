/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 24, 2016

*

*  @author :: Mohit Devda

* ***************************************************************************

*/
package com.accolite.rest;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageClass.
 */
@XmlRootElement
public class MessageClass {
 
 /** The message id. */
 int messageId;
 
 /** The person id. */
 int personId;
 
 /** The message. */
 String message;
 
 /** The date. */
 String date;
 
 /** The comment. */
 ArrayList<Comment>comment;

/** The like. */
ArrayList<Likes>like;

/** The likes. */
private int likes;

/**
 * Gets the message id.
 *
 * @return the message id
 */
public int getMessageId() {
	return messageId;
}

/**
 * Sets the message id.
 *
 * @param messageId the new message id
 */
public void setMessageId(int messageId) {
	this.messageId = messageId;
}

/**
 * Gets the person id.
 *
 * @return the person id
 */
public int getPersonId() {
	return personId;
}

/**
 * Sets the person id.
 *
 * @param personId the new person id
 */
public void setPersonId(int personId) {
	this.personId = personId;
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
 * Gets the date.
 *
 * @return the date
 */
public String getDate() {
	return date;
}

/**
 * Sets the date.
 *
 * @param date the new date
 */
public void setDate(String date) {
	this.date = date;
}

/**
 * Gets the comment.
 *
 * @return the comment
 */
public ArrayList<Comment> getComment() {
	return comment;
}

/**
 * Sets the comment.
 *
 * @param comment the new comment
 */
public void setComment(ArrayList<Comment> comment) {
	this.comment = comment;
}

/**
 * Gets the like.
 *
 * @return the like
 */
public ArrayList<Likes> getLike() {
	return like;
}

/**
 * Sets the like.
 *
 * @param like the new like
 */
public void setLike(ArrayList<Likes> like) {
	this.like = like;
}

/**
 * Gets the likes.
 *
 * @return the likes
 */
public int getLikes() {
	return likes;
}

/**
 * Sets the likes.
 *
 * @param likes the new likes
 */
public void setLikes(int likes) {
	this.likes = likes;
}
}
