package com.au.servlet.bean;

public class Employee {
	
	String name;
	int id;
	String designation;
	String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Employee() {
	}
	public Employee(String name, int id, String designation, String email) {
		this.name = name;
		this.id = id;
		this.designation = designation;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
}
