/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
* Created date :: Jul 8, 2016
*  @author :: Lokesh K
* ***************************************************************************
*/
package com.accolite.collection;

// TODO: Auto-generated Javadoc
/**
 * The Class Node.
 */
public class Node {
	
	/** The key. */
	private Object key;
	
	/** The value. */
	private Object value;
	
	/** The previous. */
	public Node previous;
	
	/** The next. */
	public Node next;
	
	/** The prior node. */
	public Node priorNode;
	
	/** The after node. */
	public Node afterNode;

	/**
	 * Instantiates a new node.
	 *
	 * @param key the key
	 * @param value the value
	 * @param previous the previous
	 * @param priorNode the prior node
	 */
	public Node(Object key, Object value, Node previous, Node priorNode) {
		super();
		this.key = key;
		this.value = value;
		this.previous = previous;
		this.priorNode = priorNode;
		next = afterNode = null;
	}

	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public Object getKey() {
		return key;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(Object value) {
		this.value = value;
	}
}
