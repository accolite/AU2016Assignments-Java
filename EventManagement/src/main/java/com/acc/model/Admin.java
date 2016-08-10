package com.acc.model;

public class Admin extends Person{
	
	public Admin(){
		super();
	}
	
	public Admin(int _id, String name, String email) {
		super(_id, name, email);
	}
	
	@Override
	public String toString() {
		return "Admin [name=" + getName() + ", email=" + getEmail() + "]";
	}
	
}
