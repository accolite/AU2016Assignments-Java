package com.accolite.xmlJAXB;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="employees")
public class Employees {
	private List<Address> addresses;
	
	public Employees() {
		
	}
	
	public Employees(ArrayList<Address> list) {
		this.addresses = list;
	}

	@XmlElement
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}  
}
