package com.accolite.jaxb;
/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
* Created date :: Jul 19, 2016
*  @author :: Lokesh K
* ***************************************************************************
*/
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// TODO: Auto-generated Javadoc
/**
 * The Class Employee.
 */
@XmlRootElement
public class Employee {
	
	/** The address. */
	private Address address;

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	@XmlElement
	public Address getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * Instantiates a new employee.
	 */
	public Employee() {
	}

	/**
	 * Instantiates a new employee.
	 *
	 * @param address the address
	 */
	public Employee(Address address) {
		super();
		this.address = address;
	}
}
