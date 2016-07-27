package com.au.chatboard.bean;

public class Message {
	String username, message;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Message(String username, String message) {
		this.username = username;
		this.message = message;
	}

	public Message() {
	}
	
}
