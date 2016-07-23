package com.au.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Like {
	int id;
	int msgId;
	int userId;
	public Like(int id, int msgId, int userId) {
		super();
		this.id = id;
		this.msgId = msgId;
		this.userId = userId;
	}
	public Like() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	

}
