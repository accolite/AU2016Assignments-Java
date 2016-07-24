package com.rest.demo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
private String value;
private int id;
public String getValue() {
	return value;
}
public void setValue(String value) {
	this.value = value;
}

public void setId(int id) {
	this.id = id;
}
public int getId() {
	// TODO Auto-generated method stub
	return id;
}
}
