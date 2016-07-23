
package com.au.messenger.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Messages {
	private List<Message> messages;

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Messages(List<Message> messages) {
		super();
		this.messages = messages;
	}

	public Messages() {
		super();
	}
	
}
