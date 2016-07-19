/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Diksha Garg

* ***************************************************************************

*/
package com.accolite.marshallingUnmarshalling;

import javax.xml.bind.annotation.XmlElement;

// TODO: Auto-generated Javadoc
/**
 * The Class Employee.
 */
public class Employee {
	
	/** The id. */
	private int id;
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The phone number. */
	private long phoneNumber;
	
	/** The address. */
	private String address;
	
	/** The pincode. */
	private int pincode;
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@XmlElement
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	@XmlElement
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	@XmlElement
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Gets the phone number.
	 *
	 * @return the phone number
	 */
	@XmlElement
	public long getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * Sets the phone number.
	 *
	 * @param phoneNumber the new phone number
	 */
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	@XmlElement
	public String getAddress() {
		return address;
	}
	
	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Gets the pincode.
	 *
	 * @return the pincode
	 */
	@XmlElement
	public int getPincode() {
		return pincode;
	}
	
	/**
	 * Sets the pincode.
	 *
	 * @param pincode the new pincode
	 */
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	

}
