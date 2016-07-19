package com.accolite.xmlparsingex;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
@XmlType
public class Name {
	private String first;
	private String last;
	public Name(String first, String last) {
		super();
		this.first = first;
		this.last = last;
	}
	public Name() {
		super();
	}
	@XmlElement
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	@XmlElement
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	

}
