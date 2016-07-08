/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 8, 2016

*

*  @author :: Udit Mehata

* ***************************************************************************

*/
package com.accolite.collectionimplementations;

// TODO: Auto-generated Javadoc
/**
 * The Class Entry.
 */
public class Entry {
	
	/** The key. */
	private Object key;
	
	/** The Value. */
	private Object Value;
	
	/** The previous entry. */
	private Object previous_entry;
	
	/** The next entry. */
	private Object next_entry;
	
	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public Object getKey() 
	{
		return key.toString();
	}

	/**
	 * Sets the key.
	 *
	 * @param key the new key
	 */
	public void setKey(Object key) 
	{
		this.key = key;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public Object getValue() 
	{
		return Value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(Object value) 
	{
		Value = value;
	}

	/**
	 * Gets the previous entry.
	 *
	 * @return the previous entry
	 */
	public Object getPrevious_entry() 
	{
		return previous_entry;
	}

	/**
	 * Sets the previous entry.
	 *
	 * @param previous_entry the new previous entry
	 */
	public void setPrevious_entry(Object previous_entry) 
	{
		this.previous_entry = previous_entry;
	}

	/**
	 * Gets the next entry.
	 *
	 * @return the next entry
	 */
	public Object getNext_entry() 
	{
		return next_entry;
	}

	/**
	 * Sets the next entry.
	 *
	 * @param next_entry the new next entry
	 */
	public void setNext_entry(Object next_entry) 
	{
		this.next_entry = next_entry;
	}
	

}
