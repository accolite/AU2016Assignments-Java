/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Aug 10, 2016
*
*  @author :: Sharukh Mohamed
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

import com.acc.model.Group;
import com.acc.model.ParticipantDetails;
import com.acc.model.Person;
import com.acc.service.ParticipantServices;

/**
 * The Class ParticipantController.
 */
@Controller
public class ParticipantController {

	/** The participant services. */
	@Autowired
	private ParticipantServices participantServices;

	public ParticipantServices getParticipantServices() {
		return participantServices;
	}


	public void setParticipantServices(ParticipantServices participantServices) {
		this.participantServices = participantServices;
	}


	/**
	 * method registerParticipant exposed at /registerParticipant
	 * to register a participant
	 * @param participantDetails
	 * @param model
	 * @return status of registration
	 */
	@RequestMapping(value = "/registerParticipant", method = RequestMethod.POST)
	@ResponseBody
	public Integer registerParticipant(@RequestBody List<ParticipantDetails> participantDetails, Model model){
		return participantServices.registerParticipant(participantDetails);
	}


	/**
	 * method deregisterParticipant exposed at /deregisterParticipant/{event_id}
	 * to deregister a participant from event_id
	 * @param event_id
	 * @param emailId
	 * @param model
	 * @return status of deregistration
	 */
	@RequestMapping(value = "/deregisterParticipant/{event_id}", method = RequestMethod.POST)
	@ResponseBody
	public Integer deregisterParticipant(@PathVariable("event_id") String event_id, @RequestBody String emailId, Model model){
		return participantServices.deregisterParticipant(event_id, emailId);

	}

	/**
	 * method getAllParticipants exposed at /getAllParticipants/{eventId}
	 * to get all participants of eventId
	 * @param eventId
	 * @param model
	 * @return all participants of eventId
	 */
	@RequestMapping(value = "/getAllParticipants/{eventId}", method = RequestMethod.GET)
	@ResponseBody
	public List<ParticipantDetails> getAllParticipants(@PathVariable("eventId") int eventId, Model model){
		return participantServices.getAllParticipants(eventId);

	}
	

	/**
	 * method insertOrganizer exposed at /insertOrganizer/{event_id}
	 * to insert an organizer for {event_id}
	 * @param request
	 * @param event_id
	 * @param emailId
	 * @param model
	 * @return status of organizer insert
	 */
	@RequestMapping(value = "/insertOrganizer/{event_id}", method = RequestMethod.POST)
	@ResponseBody
	public Integer insertOrganizer(HttpServletRequest request, @PathVariable("event_id") String event_id, @RequestBody String emailId, Model model){
		if(request.getSession(false)!=null && request.getSession(false).getAttribute("type")=="admin")
			return participantServices.insertOrganizer(event_id, emailId);
		else
			return null;
	}

	/**
	 * method insertOrganizer exposed at /removeOrganizer/{event_id}
	 * to remove an organizer for {event_id}
	 * @param request
	 * @param event_id
	 * @param emailId
	 * @param model
	 * @return staus of removal of organizer
	 */
	@RequestMapping(value = "/removeOrganizer/{event_id}", method = RequestMethod.POST)
	@ResponseBody
	public Integer removeOrganizer(HttpServletRequest request, @PathVariable("event_id") String event_id, @RequestBody String emailId, Model model){
		if(request.getSession(false)!=null && request.getSession(false).getAttribute("type")=="admin")
			return participantServices.removeOrganizer(event_id, emailId);
		else
			return null;
	}
	
	/**
	 * method viewGroups exposed at /viewGroups/{event_id}
	 * to view all groups of event_id
	 * @param event_id
	 * @param model
	 * @return all groups of event_id
	 */
	@RequestMapping(value = "/viewGroups/{event_id}", method = RequestMethod.POST)
	@ResponseBody
	public List<Group> viewGroups(@PathVariable("event_id") String event_id, Model model){
		return participantServices.getAllGroups(Integer.parseInt(event_id));
	}

	/**
	 * method addPoints exposed at /addPoints/{event_id}/{group_id}/{points}
	 * to add points to {group_id} of event {event_id} with {points}
	 * @param request
	 * @param event_id
	 * @param group_id
	 * @param points
	 * @param model
	 * @return status of add points
	 */
	@RequestMapping(value = "/addPoints/{event_id}/{group_id}/{points}", method = RequestMethod.POST)
	@ResponseBody
	public Integer addPoints(HttpServletRequest request, @PathVariable("event_id") String event_id, @PathVariable("group_id") String group_id, @PathVariable("points") String points, Model model){
		System.out.println((Person)request.getSession(false).getAttribute("user"));
		if(request.getSession(false)!=null 
				 && (request.getSession(false).getAttribute("type")=="admin"
				 		|| ( request.getSession(false).getAttribute("user")!=null
				 			&& participantServices.isOrganizer(((Person)request.getSession(false).getAttribute("user")).getEmail(), Integer.parseInt(event_id)))
				 		)
				 )
			return participantServices.addPoints(event_id, group_id, points);
		else
			return null;
	}



}
