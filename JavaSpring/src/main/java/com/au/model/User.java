package com.au.model;

public class User {
	private String username;
	private int active;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String username, int active, String password) {
		super();
		this.username = username;
		this.active = active;
		this.password = password;
	}
	public User() {
		super();
	}
	
	


}
