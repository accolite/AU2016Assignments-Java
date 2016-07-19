package com.accolite.au.jaxb.util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee{
	
	@XmlAttribute(name="id")
	int id;
	
	@XmlElement(name="Name")
	Name name;
	
	int age;
	
	@XmlElement(name="Address")
	Address address;
	
	public Employee() {
	}
	
	public Employee(int id, Name name, int age, Address address) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}

