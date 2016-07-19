package com.accolite.assignment;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DOB")
public class DOB {
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public DOB(){
		
	}
	
	private String date;
	private String month;
	private String year;
	
	public DOB(String date,String month, String year){
		this.date = date;
		this.month = month;
		this.year = year;
	}
	
}
