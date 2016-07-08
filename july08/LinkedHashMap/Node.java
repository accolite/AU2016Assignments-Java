/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 8, 2016
*
*  @author :: Sharukh Mohamed
* ***************************************************************************
*/
package com.accolite.LinkedHashMap;

// TODO: Auto-generated Javadoc
/**
 * The Class Node.
 */
public class Node {
	
	/** The prev. */
	private Node prev;
	
	/** The ordered prev. */
	private Node orderedPrev;
	
	/** The value. */
	private Object key,value;
	
	/** The next. */
	private Node next;
	
	/** The ordered next. */
	private Node orderedNext;
	
	
	
	public Object getKey() {
		return key;
	}

	public void setKey(Object key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	Node(Object key, Object value){
		this.key = key;
		this.value = value;
	}
	
	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public Node getOrderedPrev() {
		return orderedPrev;
	}

	public void setOrderedPrev(Node orderedPrev) {
		this.orderedPrev = orderedPrev;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getOrderedNext() {
		return orderedNext;
	}

	public void setOrderedNext(Node orderedNext) {
		this.orderedNext = orderedNext;
	}

	
}
