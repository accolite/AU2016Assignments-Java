package com.accolite.soaprest;

public class Comment {
	private int message_id;
	private String content;
	private int user_id;
	private String name;
	
	
	public Comment() {
		super();
	}
	public Comment(int message_id,String content, int user_id, String name) {
		super();
		this.message_id=message_id;
		this.content = content;
		this.user_id = user_id;
		this.name = name;
	}
	
	public int getMessage_id() {
		return message_id;
	}
	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
