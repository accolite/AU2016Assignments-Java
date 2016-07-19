package org.au.xmlAssignment;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Address {

	private Name name;
	private String email;
	private Long phone;
	private Birthday birthday;
	@XmlElement
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
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
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	@XmlElement
	public Birthday getBirthday() {
		return birthday;
	}
	public void setBirthday(Birthday birthday) {
		this.birthday = birthday;
	}
	public Address(Name name, String email, Long phone, Birthday birthday) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.birthday = birthday;
	}
	public Address() {
		super();
	}
	
	public Address(String fname, String lname, String email, Long phone, int y, int m , int d) {
		super();
		this.name = new Name(fname,lname);
		this.email = email;
		this.phone = phone;
		this.birthday = new Birthday(y,m,d);
	}
	@Override
	public String toString() {
		return "Address [name=" + name + ", email=" + email + ", phone=" + phone + ", birthday=" + birthday + "]";
	}

	
	
	
	
}
