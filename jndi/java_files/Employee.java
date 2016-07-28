package com.accolite.jndi;

public class Employee {
	private int emp_id;
	private String name;
	private String email;
	private int age;
	
	public Employee(){
		
	}
	
	public Employee(int emp_id, String name, String email, int age) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.email = email;
		this.age = age;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
