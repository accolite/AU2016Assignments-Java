package com.au.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comment {
	int id;
	int userId;
	int msgId;
	String body;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Comment(int id, int msgId, int userId, String body) {
		super();
		this.id = id;
		this.msgId = msgId;
		this.userId = userId;
		this.body = body;
	}
	public Comment() {
		super();
	}
	public int getMsgId() {
		return msgId;
	}
	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
}
