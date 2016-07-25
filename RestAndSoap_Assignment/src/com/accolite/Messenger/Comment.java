/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 24, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************/



package com.accolite.Messenger;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Comment.
 */
public class Comment
{
	
	/** The id. */
	private long id;
	
	/** The comment. */
	private String comment;
	
	/** The created. */
	private Date created;
	
	/** The author. */
	private String author;
	
	/**
	 * Instantiates a new comment.
	 */
	public Comment()
	{
		// TODO Auto-generated constructor stub
	}
	


	/**
	 * Instantiates a new comment.
	 *
	 * @param id the id
	 * @param comment the comment
	 * @param author the author
	 */
	public Comment(long id, String comment, String author)
	{
		super();
		this.id = id;
		this.comment = comment;
		this.created = new Date();
		this.author = author;
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
	 * Gets the comment.
	 *
	 * @return the comment
	 */
	public String getComment()
	{
		return comment;
	}

	/**
	 * Sets the comment.
	 *
	 * @param comment the new comment
	 */
	public void setComment(String comment)
	{
		this.comment = comment;
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
