package com.spring.Model;

public class User {
	String username;
	int active;
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
		// TODO Auto-generated constructor stub
	}
	
}
