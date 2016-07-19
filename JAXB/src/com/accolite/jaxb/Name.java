package com.accolite.jaxb;
/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
* Created date :: Jul 19, 2016
*  @author :: Lokesh K
* ***************************************************************************
*/
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

// TODO: Auto-generated Javadoc
/**
 * The Class Name.
 */
@XmlType
public class Name {
	
	/**
	 * Instantiates a new name.
	 */
	public Name() {
		super();
	}

	/** The first. */
	private String first;
	
	/** The last. */
	private String last;

	/**
	 * Instantiates a new name.
	 *
	 * @param first the first
	 * @param last the last
	 */
	public Name(String first, String last) {
		super();
		this.first = first;
		this.last = last;
	}

	/**
	 * Gets the first.
	 *
	 * @return the first
	 */
	@XmlElement
	public String getFirst() {
		return first;
	}

	/**
	 * Sets the first.
	 *
	 * @param first the new first
	 */
	public void setFirst(String first) {
		this.first = first;
	}

	/**
	 * Gets the last.
	 *
	 * @return the last
	 */
	@XmlElement
	public String getLast() {
		return last;
	}

	/**
	 * Sets the last.
	 *
	 * @param last the new last
	 */
	public void setLast(String last) {
		this.last = last;
	}
}
