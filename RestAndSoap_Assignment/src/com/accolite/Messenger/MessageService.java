/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 24, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************/

package com.accolite.Messenger;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageService.
 */
public class MessageService
{

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
		message.setCreated(new Date());
		messages.put(message.getId(), message);
		return message;

	}

}
