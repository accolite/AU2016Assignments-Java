/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Momin Yadav

* ***************************************************************************

*/
package com.accolite.xml;

import javax.xml.bind.annotation.XmlRootElement;

// TODO: Auto-generated Javadoc
/**
 * The Class Name.
 */
@XmlRootElement(name = "name")
public class Name {

	/** The first. */
	String first;

	/** The last. */
	String last;

	/**
	 * Gets the first.
	 *
	 * @return the first
	 */
	public String getFirst() {
		return first;
	}

	/**
	 * Sets the first.
	 *
	 * @param first
	 *            the new first
	 */
	public void setFirst(String first) {
		this.first = first;
	}

	/**
	 * Gets the last.
	 *
	 * @return the last
	 */
	public String getLast() {
		return last;
	}

	/**
	 * Sets the last.
	 *
	 * @param last
	 *            the new last
	 */
	public void setLast(String last) {
		this.last = last;
	}

}
