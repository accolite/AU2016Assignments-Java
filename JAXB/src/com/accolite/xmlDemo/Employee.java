/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 19, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************
*/
package com.accolite.xmlDemo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;

// TODO: Auto-generated Javadoc
/**
 * The Class Employee.
 */
@XmlType
public class Employee
{
    
    /** The id. */
    private String id;

    /** The name. */
    private String name;
    
    /** The designation. */
    private String designation;

	/** The contact. */
	private String contact;
	
	/** The email. */
	private String email;
	
	/** The hometown. */
	private String hometown;
	
    
    /**
     * Instantiates a new employee.
     */
    public Employee() {
		super();
	}

    /**
     * Instantiates a new employee.
     *
     * @param name the name
     * @param id the id
     * @param designation the designation
     * @param contact the contact
     * @param email the email
     * @param hometown the hometown
     */
    public Employee( String name,String id, String designation, String contact, String email, String hometown) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.contact = contact;
		this.email = email;
		this.hometown = hometown;
	}


    

	/**
	 * Gets the employee id.
	 *
	 * @return the id
	 */
	@XmlElement
    public String getId ()
    {
        return id;
    }

    /**
     * Sets the employee id.
     *
     * @param id the new id
     */
    public void setId (String id)
    {
        this.id = id;
    }
    
    /**
     * Gets the employee name.
     *
     * @return the name
     */
    @XmlElement
    public String getName ()
    {
        return name;
    }

    /**
     * Sets the employee name.
     *
     * @param name the new name
     */
    public void setName (String name)
    {
        this.name = name;
    }
    
    /** 
     * Gets the employee contact.
     *
     * @return the contact
     */
    @XmlElement
    public String getContact ()
    {
        return contact;
    }

    /**
     * Sets the employee contact.
     *
     * @param contact the new contact
     */
    public void setContact (String contact)
    {
        this.contact = contact;
    }
   
    /**
     * Gets the employee email.
     *
     * @return the email
     */
    @XmlElement
    public String getEmail() {
		return email;
	}

	/**
	 * Sets the employee email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	
	/**
	 * Gets the employee hometown.
	 *
	 * @return the hometown
	 */
	@XmlElement
	public String getHometown() {
		return hometown;
	}

	/**
	 * Sets the employee hometown.
	 *
	 * @param hometown the new hometown
	 */
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	/**
	 * Gets the employee designation.
	 *
	 * @return the designation
	 */
	@XmlElement
	public String getDesignation() {
		return designation;
	}

	/**
	 * Sets the employee designation.
	 *
	 * @param designation the new designation
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
