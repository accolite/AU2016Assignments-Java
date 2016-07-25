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

import com.accolite.Messenger.classfiles.Comment;
import com.accolite.Messenger.classfiles.Message;
import com.accolite.Messenger.database.DatabaseClass;

// TODO: Auto-generated Javadoc
/**
 * The Class CommentService.
 */
public class CommentService
{


//	/** The Constant COMMENT. */
//	private final static String COMMENT = "Nerupu da";
//	
//	/** The Constant AUTHOR. */
//	private final static String AUTHOR = "Log10";
//	
//	/** The id. */
//	private long id = 1L;
//

//	/**
//	 * Instantiates a new comment service.
//	 */
//	public CommentService()
//	{
//
//		//comments.put(1L, new Comment(id, COMMENT, AUTHOR));
//		
//		//messages.get(1L).setComments(comments);
//		
//	}

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
