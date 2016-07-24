/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 24, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************/

package com.accolite.Messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.accolite.Messenger.classfiles.Comment;
import com.accolite.Messenger.classfiles.Message;
import com.accolite.Messenger.classfiles.Profile;


// TODO: Auto-generated Javadoc
/**
 * The Class DatabaseClass.
 */
public class DatabaseClass
{

	/** The messages. */
	private static Map<Long, Message> messages = new HashMap<Long, Message>();
	
	/** The profiles. */
	private static Map<String, Profile> profiles = new HashMap<String, Profile>();
	
	/** The comments. */
	private static Map<Long, Comment> comments = new HashMap<Long, Comment>();

	/**
	 * Gets the comments.
	 *
	 * @return the comments
	 */
	public static Map<Long, Comment> getComments()
	{
		return comments;
	}

	/**
	 * Gets the messages.
	 *
	 * @return the messages
	 */
	public static Map<Long, Message> getMessages()
	{
		return messages;
	}

	/**
	 * Gets the profiles.
	 *
	 * @return the profiles
	 */
	public static Map<String, Profile> getProfiles()
	{
		return profiles;
	}

}
