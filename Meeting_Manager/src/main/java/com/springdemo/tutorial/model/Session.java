/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 31, 2016

*

*  @author :: Mohit Devda

* ***************************************************************************

*/
package com.springdemo.tutorial.model;

// TODO: Auto-generated Javadoc
/**
 * The Class Session.
 */
public class Session {

	/** The Session ID. */
	private int SessionID;

	/** The Session name. */
	private String SessionName;

	/** The Trainer ID. */
	private int TrainerID;

	/** The Date. */
	private java.sql.Date Date;

	/** The Start time. */
	private String StartTime;

	/** The End time. */
	private String EndTime;

	/**
	 * Gets the session ID.
	 *
	 * @return the sessionID
	 */
	public int getSessionID() {
		return SessionID;
	}

	/**
	 * Sets the session ID.
	 *
	 * @param sessionID
	 *            the sessionID to set
	 */
	public void setSessionID(int sessionID) {
		SessionID = sessionID;
	}

	/**
	 * Gets the session name.
	 *
	 * @return the sessionName
	 */
	public String getSessionName() {
		return SessionName;
	}

	/**
	 * Sets the session name.
	 *
	 * @param sessionName
	 *            the sessionName to set
	 */
	public void setSessionName(String sessionName) {
		SessionName = sessionName;
	}

	/**
	 * Gets the trainer ID.
	 *
	 * @return the trainer ID
	 */
	public int getTrainerID() {
		return TrainerID;
	}

	/**
	 * Sets the trainer ID.
	 *
	 * @param trainerID
	 *            the new trainer ID
	 */
	public void setTrainerID(int trainerID) {
		TrainerID = trainerID;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public java.sql.Date getDate() {
		return Date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date
	 *            the date to set
	 */
	public void setDate(java.sql.Date date) {
		Date = date;
	}

	/**
	 * Gets the start time.
	 *
	 * @return the startTime
	 */
	public String getStartTime() {
		return StartTime;
	}

	/**
	 * Sets the start time.
	 *
	 * @param startTime
	 *            the startTime to set
	 */
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}

	/**
	 * Gets the end time.
	 *
	 * @return the endTime
	 */
	public String getEndTime() {
		return EndTime;
	}

	/**
	 * Sets the end time.
	 *
	 * @param endTime
	 *            the endTime to set
	 */
	public void setEndTime(String endTime) {
		EndTime = endTime;
	}

}
