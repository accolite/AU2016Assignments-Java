/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Aug 10, 2016
*
*  @author :: Monika Dangi, Sharukh Mohamed
* ***************************************************************************
*/
package com.acc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.dao.EventDAO;
import com.acc.dao.ParticipantDAO;
import com.acc.model.EventDetails;
import com.acc.model.Group;
import com.acc.model.ParticipantDetails;

// TODO: Auto-generated Javadoc
/**
 * The Class ParticipantServicesImpl.
 */
@Service
public class ParticipantServicesImpl implements ParticipantServices {
	
	@Autowired
	ParticipantDAO participantDAO;
	
	@Autowired
	EventDAO eventDAO;
	
	public EventDAO getEventDAO() {
		return eventDAO;
	}

	public void setEventDAO(EventDAO eventDAO) {
		this.eventDAO = eventDAO;
	}

	public ParticipantDAO getParticipantDAO() {
		return participantDAO;
	}

	public void setParticipantDAO(ParticipantDAO participantDAO) {
		this.participantDAO = participantDAO;
	}

	/* (non-Javadoc)
	 * @see com.acc.service.ParticipantServices#registerParticipant(java.util.List)
	 */
	public Integer registerParticipant(List<ParticipantDetails> participantDetails){
		Integer returner = 1;
		List<ParticipantDetails> participantDetailsCopy = new ArrayList<ParticipantDetails>();
		for(ParticipantDetails participantDetail : participantDetails){
			Integer present = participantDAO.insertParticipant(participantDetail);
			
			if(present!=0) participantDetailsCopy.add(participantDetail);	
			returner*=present;
		}
		if(!participantDetailsCopy.isEmpty()){
			EventDetails event = eventDAO.getEvent(participantDetails.get(0).getParticipant().getEvent_id());
			com.acc.util.Mailer.mailAllOnRegister(participantDetailsCopy, event);
		}
		return returner;
	}
	
	/* (non-Javadoc)
	 * @see com.acc.service.ParticipantServices#insertOrganizer(java.lang.String, java.lang.String)
	 */
	public Integer insertOrganizer(String event_id,String emailId){
		return participantDAO.insertOrganizer(event_id, emailId);
	}
	
	/* (non-Javadoc)
	 * @see com.acc.service.ParticipantServices#deregisterParticipant(java.lang.String, java.lang.String)
	 */
	public Integer deregisterParticipant(String event_id, String emailId){
		return participantDAO.removeParticipant(event_id, emailId);
		
	}

	/* (non-Javadoc)
	 * @see com.acc.service.ParticipantServices#removeOrganizer(java.lang.String, java.lang.String)
	 */
	public Integer removeOrganizer(String event_id, String emailId){
		return participantDAO.removeOrganizer(event_id, emailId);
	}
	
	public List<ParticipantDetails> getAllParticipants(int eventId){
		return participantDAO.getAllParticipants(eventId);
	}
	
	/* (non-Javadoc)
	 * @see com.acc.service.ParticipantServices#getAllGroups(java.lang.Integer)
	 */
	public List<Group> getAllGroups(Integer eventId){
		return participantDAO.getGroups(eventId);
	}
	
	/* (non-Javadoc)
	 * @see com.acc.service.ParticipantServices#addPoints(java.lang.String, java.lang.String, java.lang.String)
	 */
	public Integer addPoints(String event_id, String group_id,String points){
		return participantDAO.addPoints(event_id, group_id, points);
	}

	/* (non-Javadoc)
	 * @see com.acc.service.ParticipantServices#isOrganizer(java.lang.String, java.lang.Integer)
	 */
	public boolean isOrganizer(String email, Integer event_id) {
		if(participantDAO.isOrganizer(email, event_id))
			return true;
		return false;
	}
	
	 
}
