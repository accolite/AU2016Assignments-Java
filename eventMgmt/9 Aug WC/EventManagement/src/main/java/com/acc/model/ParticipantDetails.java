package com.acc.model;

public class ParticipantDetails {
	private Participant participant;
	private Group group;
	private User user;
	
	public ParticipantDetails() {
		super();
	}
	
	public ParticipantDetails(Participant participant, Group group, User user) {
		super();
		this.participant = participant;
		this.group = group;
		this.user = user;
	}
	
	public Participant getParticipant() {
		return participant;
	}
	public void setParticipant(Participant participant) {
		this.participant = participant;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "ParticipantDetails [participant=" + participant + ", group=" + group + ", user=" + user + "]";
	}
	
	
	
}
