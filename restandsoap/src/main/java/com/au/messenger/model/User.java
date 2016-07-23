package com.au.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	int id;
	String name;
	public User(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	public User() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	 
}
