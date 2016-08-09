package com.acc.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.dao.EventDAO;
import com.acc.model.EventDetails;
import com.acc.util.CustomDateComparator;


@Service
public class EventServicesImpl implements EventServices{
	@Autowired
	EventDAO eventDAO;

	public EventDetails addEvent(EventDetails eventDetails){
		return eventDAO.InsertEvent(eventDetails);
	}
	public List<EventDetails> viewAllEvents(){
		List<EventDetails> events=eventDAO.getAllEvents();
		List<EventDetails> eventsSorted = new ArrayList<EventDetails>();
		java.util.Date date= new java.util.Date();
		Timestamp currentTime = new Timestamp(date.getTime());
		for(EventDetails event: events){
			if(event.getEvent().getStart_time().compareTo(currentTime)>-1)
				eventsSorted.add(event);
		}
		Collections.sort(eventsSorted, new CustomDateComparator());
		events.removeAll(eventsSorted);
		Collections.sort(events, new CustomDateComparator());
		eventsSorted.addAll(events);
		return eventsSorted;
		
	}
	
	public Integer deleteEvent(int eventId){
		return eventDAO.deleteEvent(eventId);
	}
	
	public Integer updateEvent(EventDetails eventDetails) {
		return eventDAO.updateEvent(eventDetails);
	}				
}
