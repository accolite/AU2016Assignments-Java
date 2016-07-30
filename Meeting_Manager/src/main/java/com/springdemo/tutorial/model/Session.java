package com.springdemo.tutorial.model;

public class Session {
	private int SessionID;
	private String SessionName;
	private java.sql.Date Date;
	private String StartTime;
	private String EndTime;
	/**
	 * @return the sessionID
	 */
	public int getSessionID() {
		return SessionID;
	}
	/**
	 * @param sessionID the sessionID to set
	 */
	public void setSessionID(int sessionID) {
		SessionID = sessionID;
	}
	/**
	 * @return the sessionName
	 */
	public String getSessionName() {
		return SessionName;
	}
	/**
	 * @param sessionName the sessionName to set
	 */
	public void setSessionName(String sessionName) {
		SessionName = sessionName;
	}
	/**
	 * @return the date
	 */
	public java.sql.Date getDate() {
		return Date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(java.sql.Date date) {
		Date = date;
	}
	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return StartTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return EndTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		EndTime = endTime;
	}
	
	

}
