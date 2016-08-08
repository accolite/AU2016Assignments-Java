package com.acc.dao;

import java.util.List;

import com.acc.model.Group;
import com.acc.model.ParticipantDetails;

public interface ParticipantDAO {
	public Integer insertParticipant(ParticipantDetails participantDetails);
	public int insertOrganizer(String event_id, String emailId);
	public Integer removeParticipant(String event_id, String emailId);
	public int removeOrganizer(String event_id, String emailId);
	public List<ParticipantDetails> getAllParticipants(int eventId);
	public int addPoints(String event_id, String group_id,String points);
	public List<Group> getGroups(int eventId);
}
