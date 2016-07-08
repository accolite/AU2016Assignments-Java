/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 8, 2016

*

*  @author :: Pawan Prakash

* ***************************************************************************

*/
package linkedHashmap;

// TODO: Auto-generated Javadoc
/**
 * The Class Node.
 */
public class Node {
	
	/**
	 * Gets the prev node.
	 *
	 * @return the prev node
	 */
	public Node getPrevNode() {
		return prevNode;
	}
	
	/**
	 * Sets the prev node.
	 *
	 * @param prevNode the new prev node
	 */
	public void setPrevNode(Node prevNode) {
		this.prevNode = prevNode;
	}
	
	/**
	 * Gets the next node.
	 *
	 * @return the next node
	 */
	public Node getNextNode() {
		return nextNode;
	}
	
	/**
	 * Sets the next node.
	 *
	 * @param nextNode the new next node
	 */
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	
	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public int getKey() {
		return key;
	}
	
	/**
	 * Sets the key.
	 *
	 * @param key the new key
	 */
	public void setKey(int key) {
		this.key = key;
	}
	
	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/** The prev node. */
	private Node prevNode;
	
	/** The next node. */
	private Node nextNode;
	
	/** The key. */
	private int key;
	
	/** The value. */
	private int value;
}


