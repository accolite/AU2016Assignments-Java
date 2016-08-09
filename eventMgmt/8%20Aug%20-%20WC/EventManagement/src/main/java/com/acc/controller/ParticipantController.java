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

import com.acc.model.Group;
import com.acc.model.ParticipantDetails;
import com.acc.service.ParticipantServices;

@Controller
public class ParticipantController {

	@Autowired
	private ParticipantServices participantServices;

	@RequestMapping(value = "/registerParticipant", method = RequestMethod.POST)
	@ResponseBody
	public Integer registerParticipant(@RequestBody List<ParticipantDetails> participantDetails, Model model){
		return participantServices.registerParticipant(participantDetails);
	}


	@RequestMapping(value = "/deregisterParticipant/{event_id}", method = RequestMethod.POST)
	@ResponseBody
	public Integer deregisterParticipant(@PathVariable("event_id") String event_id, @RequestBody String emailId, Model model){
		return participantServices.deregisterParticipant(event_id, emailId);

	}

	@RequestMapping(value = "/getAllParticipants/{eventId}", method = RequestMethod.GET)
	@ResponseBody
	public List<ParticipantDetails> getAllParticipants(@PathVariable("eventId") int eventId, Model model){
		return participantServices.getAllParticipants(eventId);

	}
	

	@RequestMapping(value = "/insertOrganizer/{event_id}", method = RequestMethod.POST)
	@ResponseBody
	public Integer insertOrganizer(@PathVariable("event_id") String event_id, @RequestBody String emailId, Model model){
		return participantServices.insertOrganizer(event_id, emailId);
	}

	@RequestMapping(value = "/removeOrganizer/{event_id}", method = RequestMethod.POST)
	@ResponseBody
	public Integer removeOrganizer(@PathVariable("event_id") String event_id, @RequestBody String emailId, Model model){
		return participantServices.removeOrganizer(event_id, emailId);
	}
	
	@RequestMapping(value = "/viewGroups/{event_id}", method = RequestMethod.POST)
	@ResponseBody
	public List<Group> viewGroups(@PathVariable("event_id") String event_id, Model model){
		return participantServices.getAllGroups(Integer.parseInt(event_id));
	}

	@RequestMapping(value = "/addPoints/{event_id}/{group_id}/{points}", method = RequestMethod.POST)
	@ResponseBody
	public Integer addPoints(@PathVariable("event_id") String event_id, @PathVariable("group_id") String group_id, @PathVariable("points") String points, Model model){
		return participantServices.addPoints(event_id, group_id, points);
	}



}
