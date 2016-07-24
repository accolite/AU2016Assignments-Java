package com.au.restandsoap.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Friend {
	 private int personID;
	    private int friendID;

	    public Friend(){
	        super();
	    }

	    public void setPersonID(int personID) {
	        this.personID = personID;
	    }

	    public void setFriendID(int friendID) {
	        this.friendID = friendID;
	    }

	    public int getPersonID() {
	        return personID;
	    }

	    public int getFriendID() {
	        return friendID;
	    }
}
