package org.au.JDBCAssignment.domain;

public class District {
	
	private int districtID;
	private String name;
	private int districtHeadID;
	private int stateID;
	private int status;
	public int getDistrictID() {
		return districtID;
	}
	public void setDistrictID(int districtID) {
		this.districtID = districtID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDistrictHeadID() {
		return districtHeadID;
	}
	public void setDistrictHeadID(int districtHeadID) {
		this.districtHeadID = districtHeadID;
	}
	public int getStateID() {
		return stateID;
	}
	public void setStateID(int stateID) {
		this.stateID = stateID;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
