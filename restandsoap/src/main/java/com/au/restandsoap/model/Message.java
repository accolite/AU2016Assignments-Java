package com.au.restandsoap.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	private int messageID;
	private String message;
	private int personID;
	public int getMessageID() {
		return messageID;
	}
	public Message(int msgID,int pID,String msg){
		this.messageID = msgID;
		this.message = msg;
		this.personID = pID;
	}
	

	public Message() {
		super();
	}

	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getPersonID() {
		return personID;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	
	
}
