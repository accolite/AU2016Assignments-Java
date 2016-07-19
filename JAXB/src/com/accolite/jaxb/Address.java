package com.accolite.jaxb;
/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
* Created date :: Jul 19, 2016
*  @author :: Lokesh K
* ***************************************************************************
*/
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

// TODO: Auto-generated Javadoc
/**
 * The Class Address.
 */
@XmlType
public class Address {
	
	/** The name. */
	private Name name;
	
	/** The email. */
	private List<String> email;
	
	/** The phone. */
	private String phone;
	
	/** The birthday. */
	private Birthday birthday;

	/**
	 * Instantiates a new address.
	 */
	public Address() {
		super();
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	@XmlElement
	public Name getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(Name name) {
		this.name = name;
	}

	/**
	 * Instantiates a new address.
	 *
	 * @param name the name
	 * @param email the email
	 * @param phone the phone
	 * @param birthday the birthday
	 */
	public Address(Name name, List<String> email, String phone, Birthday birthday) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.birthday = birthday;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	@XmlElement
	public List<String> getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(List<String> email) {
		this.email = email;
	}

	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	@XmlElement
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone.
	 *
	 * @param phone the new phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Gets the birthday.
	 *
	 * @return the birthday
	 */
	@XmlElement
	public Birthday getBirthday() {
		return birthday;
	}

	/**
	 * Sets the birthday.
	 *
	 * @param birthday the new birthday
	 */
	public void setBirthday(Birthday birthday) {
		this.birthday = birthday;
	}
}
