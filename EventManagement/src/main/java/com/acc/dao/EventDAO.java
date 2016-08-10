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

import com.acc.model.EventDetails;

/**
 * The Interface EventDAO.
 */
public interface EventDAO {
	
	/**
	 * method getAllEvents
	 * to get all events
	 * @return list of events
	 */
	public List<EventDetails> getAllEvents();
	/**
	 * method InsertEvent
	 * to insert an event
	 * @param eventDetails
	 * @return inserted event
	 */
	public EventDetails InsertEvent(EventDetails eventDetails);
	/**
	 * method deleteEvent
	 * to delete an event
	 * @param eventId
	 * @return status of event deletion
	 */
	public int deleteEvent(int eventId);
	/**
	 * method updateEvent
	 * to update an event
	 * @param eventDetails
	 * @return status of event updation
	 */
	public Integer updateEvent(EventDetails eventDetails);
	/**
	 * method getEvent
	 * get Event by Id
	 * @param eventId
	 * @return the event
	 */
	public EventDetails getEvent(Integer eventId);
}
