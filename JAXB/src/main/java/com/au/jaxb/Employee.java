package com.au.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Employee")
@XmlAccessorType (XmlAccessType.FIELD)
public class Employee 
{
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private Birthday birthday=null;
	
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setBirthday(Birthday birthday){
		this.birthday = birthday;
	}
	public Birthday getBirthday(){
		return birthday;
	}
	
	@XmlRootElement(name = "Birthday")
	@XmlAccessorType (XmlAccessType.FIELD)
	public static class Birthday{
		private int day;
		private int month;
		public int getDay() {
			return day;
		}
		public void setDay(int day) {
			this.day = day;
		}
		public int getMonth() {
			return month;
		}
		public void setMonth(int month) {
			this.month = month;
		}
		public int getYear() {
			return year;
		}
		public void setYear(int year) {
			this.year = year;
		}
		private int year;
		
	}
	
}
