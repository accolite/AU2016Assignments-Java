package com.accolite.servletassignment.model;

public class Blocked {

	private int blocked_id;
	private String blocked_word;
	
	public Blocked(){
		
	}
	
	public Blocked(int blocked_id, String blocked_word) {
		super();
		this.blocked_id = blocked_id;
		this.blocked_word = blocked_word;
	}
	public int getBlocked_id() {
		return blocked_id;
	}
	public void setBlocked_id(int blocked_id) {
		this.blocked_id = blocked_id;
	}
	public String getBlocked_word() {
		return blocked_word;
	}
	public void setBlocked_word(String blocked_word) {
		this.blocked_word = blocked_word;
	}

	
}
