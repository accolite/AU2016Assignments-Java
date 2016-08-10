package com.accolite.au.VideoPortal.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accolite.au.VideoPortal.DAO.EventDAO;
import com.accolite.au.VideoPortal.DAO.UserDAO;
import com.accolite.au.VideoPortal.service.EventService;
import com.accolite.au.VideoPortal.service.UserService;

@Controller
public class EventController {
	
	@Autowired
	private EventService service;

	@RequestMapping(value = "/addEvent", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public void addEvent(@RequestParam("event_name") String event_name,
			@RequestParam("date_of_event") Date dateOfEvent,
			HttpServletRequest servletRequest) {
		System.out.println("eventname" + event_name);
	System.out.println("Date_of_event" + dateOfEvent);
	
		
		if (service.AddEvent(event_name, dateOfEvent))
			System.out.println("Event added");
		else
			System.out.println("Event cannot be added");

	}

	@RequestMapping(value = "/deleteEvent", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public void removeEvent(@RequestParam("eventname") String eventname, HttpServletRequest servletRequest) {
		System.out.println("eventname" + eventname);

		if (service.RemoveEvent(eventname))
			System.out.println("Event removed");
		else
			System.out.println("Event cannot be removed");

	}
}