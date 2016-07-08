/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
* Created date :: Jul 8, 2016
*  @author :: Lokesh K
* ***************************************************************************
*/
package com.accolite.collection;

import java.util.Iterator;

// TODO: Auto-generated Javadoc
/**
 * The Class LinkedHashmap.
 */
public class LinkedHashmap {
	
	/** The bucket. */
	private Node[] bucket = new Node[1000];
	
	/** The head node. */
	private Node headNode;
	
	/** The current node. */
	private Node currentNode;

	/**
	 * Iterator.
	 *
	 * @return the iterator
	 */
	public Iterator iterator() {
		return new LinkedHashmapIterator(headNode);
	}

	/**
	 * Gets the.
	 *
	 * @param key the key
	 * @return the object
	 */
	public Object get(Object key) {
		int hash = key.hashCode() % 1000;
		if (bucket[hash] != null) {// bucket has a list to search
			Node node = bucket[hash];
			while (node != null && !node.getKey().equals(key)) {
				node = node.next;
			}
			if (node != null && node.getKey().equals(key)) //key exist
				return node.getValue();
			else //key doesn't exist
				return null;
		} else {// bucket is empty, so element is not there
			return null;
		}
	}

	/**
	 * Put.
	 *
	 * @param key the key
	 * @param value the value
	 */
	public void put(Object key, Object value) {
		int hash = key.hashCode() % 1000;
		if (bucket[hash] != null) {// bucket already having a list
			Node node = bucket[hash];
			while (node.next != null) {
				if (node.getKey().equals(key)) {// if key already exist it
												// updates the value
					node.setValue(value);
					return;
				}
				node = node.next;
			}
			if (node.getKey().equals(key)) {// if key already exist it
							// updates the value
				node.setValue(value);
				return;
			}
			// reached end of the list
			Node newNode = new Node(key, value, node, currentNode);
			node.next = newNode; //linking new node to the existing list
			currentNode.afterNode=newNode; //linking new node to the insert order list
			currentNode = newNode;
		} else {// bucket is empty
			bucket[hash] = new Node(key, value, null, currentNode);
			if(currentNode!=null)
				currentNode.afterNode=bucket[hash]; //linking new node to the insert order list
			currentNode = bucket[hash];
			if (headNode == null)
				headNode = currentNode; //initializing head node of the insert order list
		}
	}
}
