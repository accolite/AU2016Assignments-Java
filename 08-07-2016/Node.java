/*
 * /****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 8, 2016

*

*  @author :: Loghithavani

* ***************************************************************************

 */
package com.accolite.model;

public class Node {
	public int key;
	public int value;
	public Node previous; // Points to previous node
	public Node next;     // Points to next node
	public Node after;    // Points to next node with same hash code
	
	/**
	 * Instantiates a new node.
	 *
	 * @param key the key
	 * @param value the value
	 */
	public Node(int key,int value){
		this.key = key;
		this.value = value;
		this.previous = null;
		this.next = null;
		this.after = null;
	}
	
}
