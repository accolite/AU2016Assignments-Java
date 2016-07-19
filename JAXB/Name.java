package com.accolite.assignment;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;;

//@XmlAccessorType (XmlAccessType.FIELD)
@XmlRootElement(name = "Name")
public class Name {
	private String firstName;
	private String lastName;
	
	public Name(){
		
	}
	public Name(String firstName,String lastName) {
		// TODO Auto-generated constructor stub
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
