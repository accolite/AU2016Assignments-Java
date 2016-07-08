/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 8, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************
*/

package com.accolite.LinkedHMap;

// TODO: Auto-generated Javadoc
/**
 * The Class Node.
 */
public class Node {

	/** The prev in order. */
	public Node prev,next,nextInOrder,prevInOrder;
	
	/** The value. */
	Object key,value;
	
	/**
	 * Instantiates a new node.
	 *
	 * @param nextInOrder the next in order
	 * @param prevInOrder the prev in order
	 * @param key the key
	 * @param value the value
	 */
	public Node(Node nextInOrder, Node prevInOrder, Object key, Object value) {
		super();
		this.prev = null;
		this.next = null;
		this.nextInOrder = nextInOrder;
		this.prevInOrder = prevInOrder;
		this.key = key;
		this.value = value;
	}
	
	/**
	 * Gets the prev.
	 *
	 * @return the prev
	 */
	public Node getPrev() {
		return prev;
	}
	
	/**
	 * Sets the prev.
	 *
	 * @param prev the new prev
	 */
	public void setPrev(Node prev) {
		this.prev = prev;
	}
	
	/**
	 * Gets the next.
	 *
	 * @return the next
	 */
	public Node getNext() {
		return next;
	}
	
	/**
	 * Sets the next.
	 *
	 * @param next the new next
	 */
	public void setNext(Node next) {
		this.next = next;
	}
	
	/**
	 * Gets the value.
	 *
	 * @param key the key
	 * @return the value
	 */
	public Object getValue(Object key) {
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
