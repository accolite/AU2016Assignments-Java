package com.accolite.au.VideoPortal.model;

import java.sql.Date;

public class Event {
	private int event_id;
	private String event_name;
	private Date DateOfEvent;

	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public Date getDateOfEvent() {
		return DateOfEvent;
	}

	public void setDateOfEvent(Date dateOfEvent) {
		DateOfEvent = dateOfEvent;
	}

}
