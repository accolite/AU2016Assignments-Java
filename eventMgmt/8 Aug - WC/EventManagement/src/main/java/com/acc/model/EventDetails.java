package com.acc.model;

import java.util.List;

public class EventDetails {
	private Event event;
	private List<User> organizers;
	
	
	public EventDetails() {
		super();
	}
	
	
	
	public EventDetails(Event event, List<User> organizers) {
		super();
		this.event = event;
		this.organizers = organizers;
	}



	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public List<User> getOrganizers() {
		return organizers;
	}
	public void setOrganizers(List<User> organizers) {
		this.organizers = organizers;
	}



	@Override
	public String toString() {
		return "EventDetails [event=" + event + ", organizers=" + organizers + "]";
	}
	
	
	
}
