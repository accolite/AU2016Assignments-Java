/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Udit Mehata

* ***************************************************************************

*/
package com.marshallunmarshall;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// TODO: Auto-generated Javadoc
/**
 * The Class College.
 */
@XmlRootElement
public class College {
	
	/** The city. */
	private String city;
	
	/** The name. */
	private String name;

	/**
	 * Instantiates a new college.
	 */
	public College() {
	}

	/**
	 * Instantiates a new college.
	 *
	 * @param city the city
	 * @param name the name
	 */
	public College(String city, String name) {
		this.city = city;
		this.name = name;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	@XmlElement
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	@XmlElement
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
}
