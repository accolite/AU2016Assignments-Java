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


@Controller
public class EventController {
	@Autowired
    private EventServices eventService;
	
	@Autowired
	private ParticipantServices participantServices;
	
	 @RequestMapping(value = "/addEvent", method = RequestMethod.POST)
	 @ResponseBody
	 public EventDetails addEventController(@RequestBody EventDetails eventDetails, HttpServletRequest request,Model model){
		 if(request.getSession(false)!=null && request.getSession(false).getAttribute("type")=="admin")
			 return eventService.addEvent(eventDetails);
		 else
			 return null;
	 }
	
	 @RequestMapping(value = "/deleteEvent/{eventId}", method = RequestMethod.POST)
	 @ResponseBody
	 public Integer deleteEventController(@PathVariable int eventId, HttpServletRequest request, Model model){
		 if(request.getSession(false)!=null && request.getSession(false).getAttribute("type")=="admin")
				return eventService.deleteEvent(eventId);
		 else
			 return null;
	 }
	 
	 @RequestMapping(value = "/viewEvent", method = RequestMethod.GET)
	 @ResponseBody
	 public List<EventDetails> viewAllEventController(Model model){
		 return eventService.viewAllEvents();
	 }
	 
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
