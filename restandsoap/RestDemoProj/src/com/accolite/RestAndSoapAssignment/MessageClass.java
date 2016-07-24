package com.accolite.RestAndSoapAssignment;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MessageClass {
	int messageId;
	int personId;
	String message;
	String date;
	ArrayList<Comment>comment;
	ArrayList<Likes>like;
	private int likes;

	MessageClass()
	{
		this.comment = new ArrayList<Comment>();
		this.like = new ArrayList<Likes>();
	}
public int getMessageId() {
	return messageId;
}
public void setMessageId(int messageId) {
	this.messageId = messageId;
}
public int getPersonId() {
	return personId;
}
public void setPersonId(int personId) {
	this.personId = personId;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public ArrayList<Comment> getComment() {
	return comment;
}
public void setComment(ArrayList<Comment> comment) {
	this.comment = comment;
}
public ArrayList<Likes> getLike() {
	return like;
}
public void setLike(ArrayList<Likes> like) {
	this.like = like;
}
public int getLikes() {
	return likes;
}
public void setLikes(int likes) {
	this.likes = likes;
}
}
