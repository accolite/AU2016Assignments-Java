package com.accolite;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class NewMessage {
	private int messageID;
	private String message;
	private int personPostingID;
	//private Date time;


	public NewMessage(int msgID,String msg,int pID){
		this.messageID = msgID;
		this.message = msg;
		this.personPostingID = pID;
	}
	

	public NewMessage() {
		super();
	}


	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}

	public void setPersonPostingID(int personPostingID) {
		this.personPostingID = personPostingID;
	}

	/*public void setTime(Date time) {
		this.time = time;
	}
*/
	public int getMessageID() {
		return messageID;
	}

	public int getPersonPostingID() {
		return personPostingID;
	}

/*
	public Date getTime() {
		return time;
	}
*/
}
