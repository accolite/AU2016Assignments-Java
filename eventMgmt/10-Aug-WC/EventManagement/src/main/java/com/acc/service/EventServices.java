package com.acc.service;

import java.util.List;

import com.acc.model.EventDetails;

public interface EventServices {
	public EventDetails addEvent(EventDetails eventDetails);
	public List<EventDetails> viewAllEvents();
	public Integer deleteEvent(int eventId);
	public Integer updateEvent(EventDetails eventDetails);
}
