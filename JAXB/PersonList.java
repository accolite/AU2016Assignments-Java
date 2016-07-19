package com.accolite.assignment;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="persons")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonList {
	private ArrayList<Person> aList = new ArrayList<Person>();

	public ArrayList<Person> getaList() {
		return aList;
	}

	public void setaList(ArrayList<Person> aList) {
		this.aList = aList;
	}
	
	
}
