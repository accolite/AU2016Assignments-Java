package org.au.JDBCAssignment.domain;

public class Citizen {
	
	private int citizenID;
	private String name;
	private int districtID;
	private int age;
	private int status;
	public int getCitizenID() {
		return citizenID;
	}
	public void setCitizenID(int citizenID) {
		this.citizenID = citizenID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDistrictID() {
		return districtID;
	}
	public void setDistrictID(int districtID) {
		this.districtID = districtID;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
