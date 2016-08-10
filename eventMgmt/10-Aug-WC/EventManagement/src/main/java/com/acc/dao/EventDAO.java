package com.acc.dao;

import java.util.List;

import com.acc.model.EventDetails;

public interface EventDAO {
	
	public List<EventDetails> getAllEvents();
	public EventDetails InsertEvent(EventDetails eventDetails);
	public int deleteEvent(int eventId);
	public Integer updateEvent(EventDetails eventDetails);
	
}
