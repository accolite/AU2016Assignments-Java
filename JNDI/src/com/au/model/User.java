package com.au.model;

public class User {
	private String name;
	private String email;
	private int ismanager;
	public User(String name, String email, int ismanager) {
		super();
		this.name = name;
		this.email = email;
		this.ismanager = ismanager;
	}
	public User() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIsmanager() {
		return ismanager;
	}
	public void setIsmanager(int ismanager) {
		this.ismanager = ismanager;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", ismanager=" + ismanager + "]";
	}
	

}
