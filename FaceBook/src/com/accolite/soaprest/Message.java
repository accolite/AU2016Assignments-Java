package com.accolite.soaprest;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Message {
	private int message_id;
	private int owner_id;
	private String owner;
	private String description;
	private int time;
	private ArrayList<Comment> comments=new ArrayList<Comment>();
	private ArrayList<Like> likes=new ArrayList<Like>();
	
	public Message() {
		super();
	}
	public Message(int message_id,int owner_id, String owner, String description, int time,ArrayList<Comment> comments,
			ArrayList<Like> likes) {
		super();
		this.message_id=message_id;
		this.owner_id = owner_id;
		this.owner = owner;
		this.description = description;
		this.time=time;
		this.comments = comments;
		this.likes = likes;
	} 
	
	ArrayList<Comment> getComments() {
		return comments;
	}
	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}
	
	public ArrayList<Like> getLikes() {
		return likes;
	}
	public void setLikes(ArrayList<Like> likes) {
		this.likes = likes;
	}
	
	public int getMessage_id() {
		return message_id;
	}
	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
