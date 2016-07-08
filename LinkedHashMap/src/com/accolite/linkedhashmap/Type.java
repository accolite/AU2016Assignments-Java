/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 8, 2016

*

*  @author :: SaiCharan Movva

* ***************************************************************************

*/
package com.accolite.linkedhashmap;

// TODO: Auto-generated Javadoc
/**
 * The Class Type.
 */
public class Type {
	
	/** The key. */
	Integer key;
	
	/** The value. */
	Integer value;
	
	/** The prev. */
	Type next,prev;
	
	/**
	 * Instantiates a new type.
	 *
	 * @param key the key
	 * @param value the value
	 * @param next1 the next 1
	 */
	Type(Integer key,Integer value,Type next1){
		this.key=key;
		this.value=value;
	}
}
