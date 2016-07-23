package com.accolite.Assignment;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Users {

	private int id;
	private String profileName;
	private Date date;
	

	public Users() {
		super();
	}
	

	public Users(int id, String profileName, Date date) {
		super();
		this.id = id;
		this.profileName = profileName;
		this.date = date;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getProfileName() {
		return profileName;
	}


	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}


	public Date getCreated() {
		return date;
	}


	public void setCreated(Date date) {
		this.date = date;
	}

	
}
