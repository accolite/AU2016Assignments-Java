package com.au.model;

import java.sql.Date;

public class Message {
	private int id;
	private String body;
	private Date created;
	private String username;
	public Message(int id, String body, Date created, String username) {
		super();
		this.id = id;
		this.body = body;
		this.created = created;
		this.username = username;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	
	

}
