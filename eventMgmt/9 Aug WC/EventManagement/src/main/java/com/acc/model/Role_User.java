package com.acc.model;

public class Role_User {
	private int user_id;
	private int event_id;
	private int role_id;
	
	public Role_User() {
		super();
	}
	public Role_User(int user_id, int event_id, int role_id) {
		super();
		this.user_id = user_id;
		this.event_id = event_id;
		this.role_id = role_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	
	
}
