/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: SaiCharan Movva

* ***************************************************************************

*/
package com.au.Unmarshaller;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// TODO: Auto-generated Javadoc
/**
 * The Class Table.
 */
@XmlRootElement(name = "table")
@XmlAccessorType(XmlAccessType.FIELD)
public class Table {
	
	/** The firstname. */
	private String firstname;
	
	/** The lastname. */
	private String lastname;
	
	/** The nickname. */
	private String nickname;
	
	/** The marks. */
	private int marks;
	
	/** The rollno. */
	private int rollno;
	
	/**
	 * Gets the firstname.
	 *
	 * @return the firstname
	 */
	//@XmlElement
	public String getFirstname() {
		return firstname;
	}
	
	/**
	 * Sets the firstname.
	 *
	 * @param firstname the new firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	/**
	 * Gets the lastname.
	 *
	 * @return the lastname
	 */
	//@XmlElement
	public String getLastname() {
		return lastname;
	}
	
	/**
	 * Sets the lastname.
	 *
	 * @param lastname the new lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	/**
	 * Gets the nickname.
	 *
	 * @return the nickname
	 */
	//@XmlElement
	public String getNickname() {
		return nickname;
	}
	
	/**
	 * Sets the nickname.
	 *
	 * @param nickname the new nickname
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	/**
	 * Gets the marks.
	 *
	 * @return the marks
	 */
	//@XmlElement
	public int getMarks() {
		return marks;
	}
	
	/**
	 * Sets the marks.
	 *
	 * @param marks the new marks
	 */
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	/**
	 * Gets the rollno.
	 *
	 * @return the rollno
	 */
	//@XmlAttribute
	public int getRollno() {
		return rollno;
	}
	
	/**
	 * Sets the rollno.
	 *
	 * @param rollno the new rollno
	 */
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
		
}
