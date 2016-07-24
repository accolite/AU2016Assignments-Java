package com.au.restandsoap.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
	public int personID;
	public String personName;
	  public Person(){
	        super();
	    }

	    public void setPersonoID(int personID) {
	        this.personID = personID;
	    }
	public int getPersonID() {
		return personID;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
}
