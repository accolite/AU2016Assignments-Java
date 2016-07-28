package com.au.jndi;

public class Student {
	private String name;
	private int id;
	private String school_name;
	
	public Student(){
		
	}
	public Student(String name, int id, String school_name) {
		super();
		this.name = name;
		this.id = id;
		this.school_name = school_name;
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
	public String getSchool_name() {
		return school_name;
	}
	public void setSchool_name(String value) {
		this.school_name = value;
	}
	

}
