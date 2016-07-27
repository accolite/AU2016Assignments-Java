package com.spring.Model;

import java.sql.Date;

public class Message {
	int id;
	String body;
	Date created;
	String username;
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(int id, String body, Date created, String username) {
		super();
		this.id = id;
		this.body = body;
		this.created = created;
		this.username = username;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
