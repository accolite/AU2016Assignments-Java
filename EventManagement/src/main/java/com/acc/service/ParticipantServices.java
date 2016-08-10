/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Aug 10, 2016
*
*  @author :: Sharukh Mohamed
* ***************************************************************************
*/
package com.acc.service;

import java.util.List;

import com.acc.model.Group;
import com.acc.model.ParticipantDetails;

public interface ParticipantServices {
	
	/**
	 * Register participant.
	 *
	 * @param participantDetails the participant details
	 * @return the integer
	 */
	public Integer registerParticipant(List<ParticipantDetails> participantDetails);
	
	/**
	 * Insert organizer.
	 *
	 * @param event_id the event id
	 * @param emailId the email id
	 * @return the integer
	 */
	public Integer insertOrganizer(String event_id,String emailId);
	
	/**
	 * Deregister participant.
	 *
	 * @param event_id the event id
	 * @param emailId the email id
	 * @return the integer
	 */
	public Integer deregisterParticipant(String event_id, String emailId);
	
	/**
	 * Removes the organizer.
	 *
	 * @param event_id the event id
	 * @param emailId the email id
	 * @return the integer
	 */
	public Integer removeOrganizer(String event_id, String emailId);
	
	/**
	 * Gets the all participants.
	 *
	 * @param eventId the event id
	 * @return the all participants
	 */
	public List<ParticipantDetails> getAllParticipants(int eventId);
	
	/**
	 * Gets the all groups.
	 *
	 * @param eventId the event id
	 * @return the all groups
	 */
	public List<Group> getAllGroups(Integer eventId);
	
	/**
	 * Adds the points.
	 *
	 * @param event_id the event id
	 * @param group_id the group id
	 * @param points the points
	 * @return the integer
	 */
	public Integer addPoints(String event_id, String group_id,String points);
	
	/**
	 * Checks if is organizer.
	 *
	 * @param email the email
	 * @param event_id the event id
	 * @return true, if is organizer
	 */
	public boolean isOrganizer(String email, Integer event_id);
}