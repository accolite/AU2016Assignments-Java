package com.au.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.au.messenger.database.DatabaseClass;
import com.au.messenger.model.Message;

public class MessageService {
	
	private Map<Integer,Message> messages = DatabaseClass.getMessages();
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());	
	}
	
	public Message getMessage(int id){
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		DatabaseClass.store();
		return message;
		
	}

}
