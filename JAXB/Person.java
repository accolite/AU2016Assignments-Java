package com.accolite.assignment;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Person")
public class Person {
	private Name name;
	private DOB dob;
	private Address address;
	private int age;
	
	public Person(Name name, DOB dob, Address address, int age){
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.age = age;
	}

	public Person(){
		
	}
	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public DOB getDob() {
		return dob;
	}

	public void setDob(DOB dob) {
		this.dob = dob;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
