package org.au.JDBCAssignment.domain;

public class Relation {
	
	private int relationID;
	private int citizenID;
	private int relatorID;
	private String relation;
	public int getRelationID() {
		return relationID;
	}
	public void setRelationID(int relationID) {
		this.relationID = relationID;
	}
	public int getCitizenID() {
		return citizenID;
	}
	public void setCitizenID(int citizenID) {
		this.citizenID = citizenID;
	}
	public int getRelatorID() {
		return relatorID;
	}
	public void setRelatorID(int relatorID) {
		this.relatorID = relatorID;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	
	
	
}
