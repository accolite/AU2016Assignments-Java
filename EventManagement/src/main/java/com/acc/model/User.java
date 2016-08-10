package com.acc.model;

public class User extends Person{
	public User(){
		super();
	}
	
	public User(int _id, String name, String email) {
		super(_id, name, email);
	}
	
	@Override
	public String toString() {
		return "User [name=" + getName() + ", email=" + getEmail() + "]";
	}
	

	
}
