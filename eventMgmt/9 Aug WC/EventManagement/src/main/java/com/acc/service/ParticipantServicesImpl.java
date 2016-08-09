package com.acc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.dao.ParticipantDAO;
import com.acc.model.Group;
import com.acc.model.ParticipantDetails;

@Service
public class ParticipantServicesImpl implements ParticipantServices {
	@Autowired
	ParticipantDAO participantDAO;
	
	public Integer registerParticipant(List<ParticipantDetails> participantDetails){
		Integer returner = 1;
		for(ParticipantDetails participantDetail : participantDetails) 
			returner*=participantDAO.insertParticipant(participantDetail);
		return returner;
	}
	
	public Integer insertOrganizer(String event_id,String emailId){
		return participantDAO.insertOrganizer(event_id, emailId);
	}
	
	public Integer deregisterParticipant(String event_id, String emailId){
		return participantDAO.removeParticipant(event_id, emailId);
		
	}

	public Integer removeOrganizer(String event_id, String emailId){
		return participantDAO.removeOrganizer(event_id, emailId);
	}
	
	public List<ParticipantDetails> getAllParticipants(int eventId){
		return participantDAO.getAllParticipants(eventId);
	}
	
	public List<Group> getAllGroups(Integer eventId){
		return participantDAO.getGroups(eventId);
	}
	
	public Integer addPoints(String event_id, String group_id,String points){
		return participantDAO.addPoints(event_id, group_id, points);
	}

	public boolean isOrganizer(String email, Integer event_id) {
		if(participantDAO.isOrganizer(email, event_id))
			return true;
		return false;
	}
}
