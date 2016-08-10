package com.acc.model;

public class Participant {
	private int user_id;
	private int event_id;
	private int group_id;
	
	public Participant() {
		super();
	}

	public Participant(int user_id, int event_id, int group_id) {
		super();
		this.user_id = user_id;
		this.event_id = event_id;
		this.group_id = group_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	@Override
	public String toString() {
		return "Participant [user_id=" + user_id + ", event_id=" + event_id + ", group_id=" + group_id + "]";
	}
	
	
}
