/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Aug 10, 2016
*
*  @author :: Sharukh Mohamed
* ***************************************************************************
*/
package com.acc.util;

import java.util.Comparator;

import com.acc.model.EventDetails;

/**
 * The Class CustomDateComparator.
 */
public class CustomDateComparator implements Comparator<EventDetails> {

	public int compare(EventDetails o1, EventDetails o2) {
		return o1.getEvent().getStart_time().compareTo(o2.getEvent().getStart_time());
	}

}
