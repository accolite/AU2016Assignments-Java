/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 18, 2016
*
*  @author :: Sharukh Mohamed
* ***************************************************************************
*/
package com.accolite.assignmentthread;

import java.util.HashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class Constants.
 */
public class Constants {
	
	/** The Constant mapping of fruits */
	public final static Map<Integer,String> mapping = new HashMap<>();
	static{
		mapping.put(1, "Apple");
		mapping.put(2, "Orange");
		mapping.put(3, "Grape");
		mapping.put(4, "Watermelon");
		
	}
	
	/** The capacity of each fruits. */
	public static int[] capacity={0, 0, 0, 0};
}
