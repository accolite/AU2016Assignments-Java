package com.au.restandsoap.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ListPerson {
	List <Person> listperson;

	public List<Person> getListperson() {
		return listperson;
	}

	public void setListperson(List<Person> listperson) {
		this.listperson = listperson;
	}
	
}
