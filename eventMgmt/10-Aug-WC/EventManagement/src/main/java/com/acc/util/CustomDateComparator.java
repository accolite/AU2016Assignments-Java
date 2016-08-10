package com.acc.util;

import java.util.Comparator;

import com.acc.model.EventDetails;

public class CustomDateComparator implements Comparator<EventDetails> {

	public int compare(EventDetails o1, EventDetails o2) {
		return o1.getEvent().getStart_time().compareTo(o2.getEvent().getStart_time());
	}

}
