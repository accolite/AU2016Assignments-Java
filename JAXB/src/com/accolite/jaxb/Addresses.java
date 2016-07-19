package com.accolite.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class Addresses {
	
	int id;
	String location;
	List<Address> addresses;
	
	Addresses()
	{
		
	}
	
	Addresses(int id,String location,List<Address> addresses)
	{
		this.id=id;
		this.location=location;
		this.addresses=addresses;
	}
	
	
	@XmlAttribute
	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	@XmlElement
	public String getLocation() {
		return location;
	}
	
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	@XmlElement
	public List<Address> getAddresses() {
		return addresses;
	}
	
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	
}
