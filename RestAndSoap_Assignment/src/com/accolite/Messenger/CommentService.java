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
 * The Class CommentService.
 */
public class CommentService
{


	/** The messages. */
	private Map<Long, Message> messages = new DatabaseClass().getMessages();
	
	/** The comments. */
	private Map<Long, Comment> comments = new DatabaseClass().getComments();

	/**
	 * Gets the all comments.
	 *
	 * @param messageId the message id
	 * @return the all comments
	 */
	public List<Comment> getAllComments(long messageId)
	{
		Map<Long, Comment> comments = messages.get(messageId).getComments();

		return new ArrayList<Comment>(comments.values());

	}

	/**
	 * Gets the comment.
	 *
	 * @param messageId the message id
	 * @param commentId the comment id
	 * @return the comment
	 */
	public Comment getComment(long messageId, long commentId)
	{
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.get(commentId);
	}


	/**
	 * Adds the comment.
	 *
	 * @param messageId the message id
	 * @param comment the comment
	 * @return the comment
	 */
	public Comment addComment(long messageId, Comment comment)
	{
		Map<Long, Comment> comments = messages.get(messageId).getComments();

		comment.setId(comments.size() + 1);
		comment.setCreated(new Date());
		comments.put(comment.getId(), comment);
		return comment;

	}


}
