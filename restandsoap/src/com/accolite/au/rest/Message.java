package com.accolite.au.rest;

import java.util.List;

import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Message {

	String creator;
	String message;
	String msgid;
	Integer noLikes;
	
	List<Like> likes;
	
	List<Comment> comments;
	public String getCreator() {
		return creator;
	}
	public Integer getNoLikes() {
		return noLikes;
	}
	public void setNoLikes(Integer noLikes) {
		this.noLikes = noLikes;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMsgid() {
		return msgid;
	}
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
	public List<Like> getLikes() {
		return likes;
	}
	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public Message(String creator, String message, String msgid, int noLikes, List<Like> likes, List<Comment> comments) {
		this.creator = creator;
		this.message = message;
		this.msgid = msgid;
		this.likes = likes;
		this.comments = comments;
		this.noLikes = 0;
	}
	public Message() {
	}
	
	
}
