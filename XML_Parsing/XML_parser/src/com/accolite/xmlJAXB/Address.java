package com.accolite.xmlJAXB;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="address")
public class Address {

	private String name;
	private String email;
	private String phone;
	private String id;
	
	@XmlElement
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Address() {
		
	}
	
	public Address(String name, String email, String phone, String id) {
		super(); 
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@XmlElement
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	
}
