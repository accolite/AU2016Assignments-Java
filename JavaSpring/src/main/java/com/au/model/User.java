package com.au.model;

public class User {
	private String usern;
	private int active;
	/**
	 * @return the usern
	 */
	public String getUsern() {
		return usern;
	}
	/**
	 * @param usern the usern to set
	 */
	public void setUsern(String usern) {
		this.usern = usern;
	}
	/**
	 * @return the active
	 */
	public int getActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(int active) {
		this.active = active;
	}
	public User(String usern, int active) {
		super();
		this.usern = usern;
		this.active = active;
	}

	
	

}
