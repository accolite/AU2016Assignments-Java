package com.accolite.au;

public class Employee {
	
	String name;
	String email;
	
	
	public Employee(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	
	public Employee(){
		
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
