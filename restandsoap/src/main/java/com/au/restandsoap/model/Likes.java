package com.au.restandsoap.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Likes {
	private int likeID;
	private int personID;
	private int messageID;
	public Likes(){
		super();
	}

    public Likes(int messageID){
        this.messageID = messageID;
    }
	
	public int getLikeID() {
		return likeID;
	}
	public void setLikeID(int likeID) {
		this.likeID = likeID;
	}
	public int getPersonID() {
		return personID;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	public int getMessageID() {
		return messageID;
	}
	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}
	
}
