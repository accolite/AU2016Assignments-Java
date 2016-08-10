/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Aug 10, 2016
*
*  @author :: Ravi Kalmodia, Sharukh Mohamed
* ***************************************************************************
*/
package com.acc.dao;

import java.util.List;

import com.acc.model.Group;
import com.acc.model.ParticipantDetails;

/**
 * The Interface ParticipantDAO.
 */
public interface ParticipantDAO {
	/**
	 * method insertParticipant
	 * to insert a participant
	 * @param participantDetails
	 * @return status of insertion of participant
	 */
	public Integer insertParticipant(ParticipantDetails participantDetails);
	/**
	 * method insertOrganizer
	 * to insert an organizer
	 * @param event_id
	 * @param emailId
	 * @return status of insertion of organizer
	 */
	public int insertOrganizer(String event_id, String emailId);
	/**
	 * method removeParticipant
	 * to remove a participant from event_id
	 * @param event_id
	 * @param emailId
	 * @return status of removal of participant
	 */
	public Integer removeParticipant(String event_id, String emailId);
	/**
	 * method removeOrganizer
	 * to remove an organizer from event_id
	 * @param event_id
	 * @param emailId
	 * @return status of removal of organizer
	 */
	public int removeOrganizer(String event_id, String emailId);
	/**
	 * method getAllParticipants
	 * to get all participants of event_id
	 * @param eventId
	 * @return all participants of eventId
	 */
	public List<ParticipantDetails> getAllParticipants(int eventId);
	/**
	 * method addPoints
	 * to add points to group_id of event_id with {points}
	 * @param event_id
	 * @param group_id
	 * @param points
	 * @return status of add points
	 */
	public int addPoints(String event_id, String group_id,String points);
	/**
	 * method getGroups
	 * to get all groups of eventId
	 * @param eventId
	 * @return all groups of eventId
	 */
	public List<Group> getGroups(int eventId);
	/**
	 * method isOrganizer
	 * to check if an email is organizer of  event_id
	 * @param email
	 * @param event_id
	 * @return is organizer condition
	 */
	public boolean isOrganizer(String email, Integer event_id);
}
