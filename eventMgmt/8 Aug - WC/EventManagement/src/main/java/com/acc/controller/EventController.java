package com.acc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acc.model.EventDetails;
import com.acc.service.EventServices;


@Controller
public class EventController {
	@Autowired
    private EventServices eventService;
	
	
	
	 @RequestMapping(value = "/addEvent", method = RequestMethod.POST)
	 @ResponseBody
	 public EventDetails addEventController(@RequestBody EventDetails eventDetails, Model model){
		 System.out.println(eventDetails.toString());
		 return eventService.addEvent(eventDetails);
	 }
	
	 @RequestMapping(value = "/deleteEvent/{eventId}", method = RequestMethod.POST)
	 @ResponseBody
	 public Integer deleteEventController(@PathVariable int eventId, Model model){
		 return eventService.deleteEvent(eventId);
	 }
	 
	 @RequestMapping(value = "/viewEvent", method = RequestMethod.GET)
	 @ResponseBody
	 public List<EventDetails> viewAllEventController(Model model){
		 return eventService.viewAllEvents();
	 }
	 
	 @RequestMapping(value = "/updateEvent", method = RequestMethod.POST)
	 @ResponseBody
	 public Integer updateEventController(@RequestBody EventDetails eventDetails, Model model){
		 return eventService.updateEvent(eventDetails);
	 }

}
