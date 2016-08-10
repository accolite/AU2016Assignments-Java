package com.accolite.au.VideoPortal.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.au.VideoPortal.DAO.EventDAO;
import com.accolite.au.VideoPortal.model.Event;

@Service
public class EventService {
	@Autowired
	private EventDAO jdbc;
	public boolean AddEvent(String eventname, Date DateOfEvent) {
		if (jdbc.RetrieveEvent(eventname) == null) {
			Event event=new Event();
			event.setEvent_name(eventname);
			event.setDateOfEvent(DateOfEvent);
			int result = jdbc.CreateEvent(event);
			System.out.println("result="+result);
			
			
			if (result == 1)
				return true;
			else
				return false;
		}
		return false;
	}

	public boolean RemoveEvent(String event_name) {
		if (jdbc.RetrieveEvent(event_name) != null) {
			Event event=new Event();
			event.setEvent_name(event_name);
			int result = jdbc.DeleteEvent(event);
			if (result == 1)
				return true;
			else
				return false;
		}
		return false;
	}
}
