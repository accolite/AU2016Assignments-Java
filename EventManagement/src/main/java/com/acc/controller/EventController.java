/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Aug 10, 2016
*
*  @author :: Monika Dangi
* ***************************************************************************
*/
package com.acc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acc.model.EventDetails;
import com.acc.model.Person;
import com.acc.service.EventServices;
import com.acc.service.ParticipantServices;


/**
 * The Class EventController.
 */
@Controller
public class EventController {
	
	/** The event service. */
	@Autowired
    private EventServices eventService;

	/** The participant services. */
	@Autowired
	private ParticipantServices participantServices;
	
	public EventServices getEventService() {
		return eventService;
	}

	public void setEventService(EventServices eventService) {
		this.eventService = eventService;
	}

	public ParticipantServices getParticipantServices() {
		return participantServices;
	}

	public void setParticipantServices(ParticipantServices participantServices) {
		this.participantServices = participantServices;
	}

	
	 /**
	  * method addEventController exposed at /addEvent
	  * to add an event
	  * @param eventDetails
	  * @param request
	  * @param model
	  * @return event added
	  */
	@RequestMapping(value = "/addEvent", method = RequestMethod.POST)
	 @ResponseBody
	 public EventDetails addEventController(@RequestBody EventDetails eventDetails, HttpServletRequest request,Model model){
		 if(request.getSession(false)!=null && request.getSession(false).getAttribute("type")=="admin")
			 return eventService.addEvent(eventDetails);
		 else
			 return null;
	 }
	
	 /**
	  * method deleteEventController exposed at /deleteEvent/{eventId}
	  * to delete an event
	  * @param eventId
	  * @param request
	  * @param model
	  * @return status of deletion
	  */
	@RequestMapping(value = "/deleteEvent/{eventId}", method = RequestMethod.POST)
	 @ResponseBody
	 public Integer deleteEventController(@PathVariable int eventId, HttpServletRequest request, Model model){
		 if(request.getSession(false)!=null && request.getSession(false).getAttribute("type")=="admin")
				return eventService.deleteEvent(eventId);
		 else
			 return null;
	 }
	 
	 /**
	  * method viewAllEventController exposed at /viewEvent
	  * to view all events
	  * @param model
	  * @return all events
	  */
	 @RequestMapping(value = "/viewEvent", method = RequestMethod.GET)
	 @ResponseBody
	 public List<EventDetails> viewAllEventController(Model model){
		 return eventService.viewAllEvents();
	 }
	 
	 /**
	  * method updateEventController exposed at /updateEvent
	  * to update an event
	  * @param eventDetails
	  * @param request
	  * @param model
	  * @return status of update
	  */
	@RequestMapping(value = "/updateEvent", method = RequestMethod.POST)
	 @ResponseBody
	 public Integer updateEventController(@RequestBody EventDetails eventDetails, HttpServletRequest request, Model model){
		 if(request.getSession(false)!=null 
				 && (request.getSession(false).getAttribute("type")=="admin"
				 		|| ( request.getSession(false).getAttribute("user")!=null && eventDetails!=null 
				 			&& eventDetails.getEvent()!=null 
				 			&& eventDetails.getEvent().get_id()!=0
				 			&& participantServices.isOrganizer(((Person)request.getSession(false).getAttribute("user")).getEmail(), eventDetails.getEvent().get_id()))
				 		)
				 )
			 return eventService.updateEvent(eventDetails);
		 else
			 return null;
	 }

}
