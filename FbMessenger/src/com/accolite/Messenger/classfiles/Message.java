/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 24, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************/

package com.accolite.Messenger.classfiles;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


// TODO: Auto-generated Javadoc
/**
 * The Class Message.
 */
@XmlRootElement
public class Message
{

	/** The id. */
	private long id;
	
	/** The message. */
	private String message;
	
	/** The created. */
	private Date created;
	
	/** The author. */
	private String author;

	/** The comments. */
	private Map<Long, Comment> comments = new HashMap<>();

	/**
	 * Instantiates a new message.
	 */
	public Message()
	{
		// TODO Auto-generated constructor stub
	}


	/**
	 * Instantiates a new message.
	 *
	 * @param id the id
	 * @param message the message
	 * @param author the author
	 */
	public Message(long id, String message, String author)
	{
		super();
		this.id = id;
		this.message = message;
		this.created = new Date();
		this.author = author;
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
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage()
	{
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message)
	{
		this.message = message;
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

	/**
	 * Gets the author.
	 *
	 * @return the author
	 */
	public String getAuthor()
	{
		return author;
	}

	/**
	 * Sets the author.
	 *
	 * @param author the new author
	 */
	public void setAuthor(String author)
	{
		this.author = author;
	}

	/**
	 * Gets the comments.
	 *
	 * @return the comments
	 */
	@XmlTransient
	public Map<Long, Comment> getComments()
	{
		return comments;
	}


	/**
	 * Sets the comments.
	 *
	 * @param comments the comments
	 */
	public void setComments(Map<Long, Comment> comments)
	{
		this.comments = comments;
	}

	
}
