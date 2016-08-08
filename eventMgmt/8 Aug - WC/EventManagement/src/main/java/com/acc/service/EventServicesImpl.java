package com.acc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.dao.EventDAO;
import com.acc.model.EventDetails;


@Service
public class EventServicesImpl implements EventServices{
	@Autowired
	EventDAO eventDAO;

	public EventDetails addEvent(EventDetails eventDetails){
		return eventDAO.InsertEvent(eventDetails);
	}
	public List<EventDetails> viewAllEvents(){
		List<EventDetails> events=eventDAO.getAllEvents();
		return events;
		
	}
	
	public Integer deleteEvent(int eventId){
		return eventDAO.deleteEvent(eventId);
	}
	
	public Integer updateEvent(EventDetails eventDetails) {
		return eventDAO.updateEvent(eventDetails);
	}				
}
