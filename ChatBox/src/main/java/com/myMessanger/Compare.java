package com.myMessanger;

import java.util.Comparator;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

class Compare implements Comparator<Sort> {
	@Override
	public int compare(Sort o1, Sort o2) {
		DateTime date1 = DateTime.parse(o1.time,DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss"));
		DateTime date2 = DateTime.parse(o2.time,DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss"));
		System.out.println(date1.toString() + date2.toString());
	    if(date1.isBefore(date2)) {
	    	System.out.println("hi");
	        return 1;
	    } else if (date2.isBefore(date1)) {
	    	System.out.println("hello");
	        return -1;
	    }
	    return 0;
	}

}