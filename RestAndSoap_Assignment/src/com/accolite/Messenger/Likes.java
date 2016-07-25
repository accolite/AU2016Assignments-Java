package com.accolite.Messenger;

import java.util.Date;

public class Likes {

	/** The id. */
	private long id;
	
	/** The created. */
	private Date created;
	
	/** The author. */
	private String author;
	
	
	public Likes() {
		super();
	}


	public Likes(long id, String author) {
		super();
		this.id = id;
		this.created = new Date();;
		this.author = author;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
	
	
	
}
