package com.au.restandsoap.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comment {
	private int personID;
	private int messageID;
	private String comment;
	private int commentID;
	public Comment(){
		super();
	}
	public Comment(int commentID,String comment){
		this.commentID=commentID;
		this.comment=comment;
	}
	public int getPersonID() {
		return personID;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	public int getMessageID() {
		return messageID;
	}
	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getCommentID() {
		return commentID;
	}
	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}
	
}
