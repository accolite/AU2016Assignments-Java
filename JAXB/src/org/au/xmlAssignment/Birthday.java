package org.au.xmlAssignment;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Birthday {
	private int year;
	private int month;
	private int day;
	@XmlElement
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@XmlElement
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	@XmlElement
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public Birthday(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}
	public Birthday() {
		super();
	}
	@Override
	public String toString() {
		return "Birthday [year=" + year + ", month=" + month + ", day=" + day + "]";
	}
	
	
	

}
