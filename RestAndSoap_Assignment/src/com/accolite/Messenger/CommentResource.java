/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 24, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************/

package com.accolite.Messenger;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


// TODO: Auto-generated Javadoc
/**
 * The Class CommentResource.
 */
@Path("/")
public class CommentResource
{

	/** The comment service. */
	CommentService commentService = new CommentService();

	/**
	 * Gets the all comments.
	 *
	 * @param messageId the message id
	 * @return the all comments
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comment> getAllComments(@PathParam("messageId") long messageId)
	{

		return commentService.getAllComments(messageId);
	}


	/**
	 * Gets the comment.
	 *
	 * @param messageId the message id
	 * @param commentId the comment id
	 * @return the comment
	 */
	@GET
	@Path("/{commentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Comment getComment(@PathParam("messageId") long messageId,
		@PathParam("commentId") long commentId)
	{
		return commentService.getComment(messageId, commentId);
	}

	/**
	 * Adds the comment.
	 *
	 * @param messageId the message id
	 * @param comment the comment
	 * @return the comment
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Comment addComment(@PathParam("messageId") long messageId, Comment comment)
	{
		return commentService.addComment(messageId, comment);
	}

}
