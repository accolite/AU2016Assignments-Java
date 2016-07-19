package com.accolite.xmlparsingex;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class Address {
	private Name name;
	private String phone_no;
	private String birth_date;
	public Address() {
		super();
	}
	public Address(Name name, String phone_no, String date) {
		super();
		this.name = name;
		this.phone_no = phone_no;
		this.birth_date = date;
	}
	@XmlElement
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	@XmlElement
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	@XmlElement
	public String getDate() {
		return birth_date;
	}
	public void setDate(String date) {
		this.birth_date = date;
	}
	

}
