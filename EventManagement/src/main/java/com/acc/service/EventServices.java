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

import com.acc.model.EventDetails;

/**
 * The Interface EventServices.
 */
public interface EventServices {
	
	/**
	 * Adds the event.
	 *
	 * @param eventDetails the event details
	 * @return the event details
	 */
	public EventDetails addEvent(EventDetails eventDetails);
	
	/**
	 * View all events.
	 *
	 * @return the list
	 */
	public List<EventDetails> viewAllEvents();
	
	/**
	 * Delete event.
	 *
	 * @param eventId the event id
	 * @return the status of delete event
	 */
	public Integer deleteEvent(int eventId);
	
	/**
	 * Update event.
	 *
	 * @param eventDetails the event details
	 * @return the status of update event
	 */
	public Integer updateEvent(EventDetails eventDetails);
}
