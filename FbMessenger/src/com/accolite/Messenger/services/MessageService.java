/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 24, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************/

package com.accolite.Messenger.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.accolite.Messenger.classfiles.Message;
import com.accolite.Messenger.database.DatabaseClass;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageService.
 */
public class MessageService
{

	/** The Constant MESSAGE. */
	private final static String MESSAGE = "Kabali Movie";
	
	/** The Constant AUTHOR. */
	private final static String AUTHOR = "Jegan";
	
	/** The id. */
	private long id = 1L;

	/**
	 * Instantiates a new message service.
	 */
	public MessageService()
	{
		messages.put(1L, new Message(id, MESSAGE, AUTHOR));		
		messages.put(2L, new Message(id = id + 1,"Thalivar Rocks" , AUTHOR));
	}

	/** The messages. */
	private Map<Long, Message> messages = new DatabaseClass().getMessages();


	/**
	 * Gets the all messages.
	 *
	 * @return the all messages
	 */
	public List<Message> getAllMessages()
	{

		return new ArrayList<Message>(messages.values());

	}

	/**
	 * Gets the message.
	 *
	 * @param id the id
	 * @return the message
	 */
	public Message getMessage(Long id)
	{
		return messages.get(id);
	}


	/**
	 * Adds the message.
	 *
	 * @param message the message
	 * @return the message
	 */
	public Message addMessage(Message message)
	{
		message.setId(messages.size() + 1);
		message.setCreated(new Date());
		messages.put(message.getId(), message);
		return message;

	}

}
