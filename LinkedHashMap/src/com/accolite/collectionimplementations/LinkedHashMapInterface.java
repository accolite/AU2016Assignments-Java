/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 8, 2016

*

*  @author :: Udit Mehata

* ***************************************************************************

*/
package com.accolite.collectionimplementations;

public interface LinkedHashMapInterface 
{
	public void putEntry( Object key, Object value);
	
	/**
	 * Gets the entry.
	 *
	 * @param key the key
	 * @return the entry
	 */
	public Object getEntry( Object key );
	public void printLinkedHashMap();
}
