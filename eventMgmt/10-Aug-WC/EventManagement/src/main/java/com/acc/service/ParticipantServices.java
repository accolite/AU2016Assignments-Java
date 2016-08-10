package com.acc.service;

import java.util.List;

import com.acc.model.Group;
import com.acc.model.ParticipantDetails;

public interface ParticipantServices {
	public Integer registerParticipant(List<ParticipantDetails> participantDetails);
	
	public Integer insertOrganizer(String event_id,String emailId);
	
	public Integer deregisterParticipant(String event_id, String emailId);
	public Integer removeOrganizer(String event_id, String emailId);
	
	public List<ParticipantDetails> getAllParticipants(int eventId);
	
	public List<Group> getAllGroups(Integer eventId);
	
	public Integer addPoints(String event_id, String group_id,String points);
	
	public boolean isOrganizer(String email, Integer event_id);
}