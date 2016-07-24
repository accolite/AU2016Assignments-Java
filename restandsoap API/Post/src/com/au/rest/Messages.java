package com.au.rest;

public class Messages {

 
	private String value;
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Message {value=" + value + ", id=" + id + "}";
	}

	public void setValue(String value) {
		this.value = value;
	}

}