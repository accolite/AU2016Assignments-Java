package com.accolite.soaprest;

public class Like {
 private String name;
 private int id;
 private int message_id;
 
public Like() {
	super();
}
public Like(String name, int id,int message_id) {
	super();
	this.name = name;
	this.id = id;
	this.message_id=message_id;
}

public int getMessage_id() {
	return message_id;
}
public void setMessage_id(int message_id) {
	this.message_id = message_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
 
}
