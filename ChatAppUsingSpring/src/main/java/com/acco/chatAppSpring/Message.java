package com.acco.chatAppSpring;

public class Message {

	private String message;
	private String username;
	public String getMessage() {
		return message;
	}

	public String getUserName() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
