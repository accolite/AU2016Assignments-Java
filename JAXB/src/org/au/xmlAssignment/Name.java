package org.au.xmlAssignment;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Name {
	private String first;
	private String last;
	
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
	public Name(String first, String last) {
		super();
		this.first = first;
		this.last = last;
	}
	public Name() {
		super();
	}
	@Override
	public String toString() {
		return "Name [first=" + first + ", last=" + last + "]";
	}
	
	
	
	

}
