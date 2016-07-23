package com.accolite.Assignment;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageDetails {

	public Map<Integer, Messsage> messages;

	public MessageDetails() {
		super();
		messages=new HashMap<Integer,Messsage>();
		Messsage msg=new Messsage(1,"Kabali","Jegan");
		messages.put(1,msg);
		Comment comment=new Comment(1,"Nerupu da","Log10");
		Map<Integer, Comment> comments=new HashMap<Integer, Comment>();
		comments.put(1, comment);
		msg.setComments(comments);		
	}
	
	public Messsage getMessage(int id)
	{
		return messages.get(id);
	}
	
	public Messsage addMessage(Messsage message)
	{
		//message.setId(messages.size() + 1);
		message.setCreated(new Date());
		messages.put(message.getId(), message);
		return message;

	}
	
	public List<Messsage> getAllMessages()
	{
		return new ArrayList<Messsage>(messages.values());

	}
}
