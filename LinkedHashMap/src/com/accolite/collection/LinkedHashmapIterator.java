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
 * The Class LinkedHashmapIterator.
 */
public class LinkedHashmapIterator implements Iterator {
	
	/** The node. */
	private Node node;

	/**
	 * Instantiates a new linked hashmap iterator.
	 *
	 * @param node the node
	 */
	public LinkedHashmapIterator(Node node) {
		super();
		this.node = node;
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		return node != null;
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#next()
	 */
	@Override
	public Object next() {
		Node tempNode = node;
		node = node.afterNode;
		return tempNode.getValue();
	}

}
