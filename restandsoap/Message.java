package com.accolite.assignment;

import java.util.List;

public class Message {
	
	String messageID;
	String messageContent;
	String messageLikes;
	List<Comments> messageComments;

	public String getMessageID() {
		return messageID;
	}
	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public String getMessageLikes() {
		return messageLikes;
	}
	public void setMessageLikes(String messageLikes) {
		this.messageLikes = messageLikes;
	}
	public List<Comments> getMessageComments() {
		return messageComments;
	}
	public void setMessageComments(List<Comments> messageComments) {
		this.messageComments = messageComments;
	}
	
}
