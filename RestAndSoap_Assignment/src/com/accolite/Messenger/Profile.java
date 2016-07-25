/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 24, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************/

package com.accolite.Messenger;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


// TODO: Auto-generated Javadoc
/**
 * The Class Profile.
 */
@XmlRootElement
public class Profile
{
	
	/** The id. */
	private long id;


	/** The profile name. */
	private String profileName;
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The created. */
	private Date created;

	/**
	 * Instantiates a new profile.
	 */
	public Profile()
	{
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new profile.
	 *
	 * @param id the id
	 * @param profileName the profile name
	 * @param firstName the first name
	 * @param lastName the last name
	 */
	public Profile(long id, String profileName, String firstName, String lastName)
	{
		super();
		this.id = id;
		this.profileName = profileName;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId()
	{
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id)
	{
		this.id = id;
	}

	/**
	 * Gets the profile name.
	 *
	 * @return the profile name
	 */
	public String getProfileName()
	{
		return profileName;
	}

	/**
	 * Sets the profile name.
	 *
	 * @param profileName the new profile name
	 */
	public void setProfileName(String profileName)
	{
		this.profileName = profileName;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName()
	{
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName()
	{
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	/**
	 * Gets the created.
	 *
	 * @return the created
	 */
	public Date getCreated()
	{
		return created;
	}

	/**
	 * Sets the created.
	 *
	 * @param created the new created
	 */
	public void setCreated(Date created)
	{
		this.created = created;
	}

}
