package com.au.messenger.model;

import java.util.Date;

import java.util.List;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	int id;
	String body;
	Date created;
	int author;
	List<Comment> comments = null;
	List<Like> likes = null; 
	
	public Message(int id, String body, int author) {
		super();
		this.id = id;
		this.body = body;
		this.created = new Date();
		this.author = author;
	}
	public Message() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<Like> getLikes() {
		return likes;
	}
	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}
	
	
	
	

}
