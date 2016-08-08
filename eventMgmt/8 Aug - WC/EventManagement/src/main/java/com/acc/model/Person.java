package com.acc.model;

public class Person {
	private int _id;
	private String name;
	private String email;
	
	public Person() {
		super();
	}

	public Person(int _id, String name, String email) {
		super();
		this._id = _id;
		this.name = name;
		this.email = email;
	}
	
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
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

	
}
