package com.accolite.xmlparsingex;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Addresses {
	ArrayList<Address> list_of_addresses=null;

	public Addresses() {
		super();
	}
	public Addresses(ArrayList<Address> list_of_addresses) {
		//this.list_of_addresses=new ArrayList<>();
		this.list_of_addresses = list_of_addresses;
	}
	@XmlElement
	public ArrayList<Address> getList_of_addresses() {
		return list_of_addresses;
	}

	public void setList_of_addresses(ArrayList<Address> list_of_addresses) {
		this.list_of_addresses = list_of_addresses;
	}
	
	

}
