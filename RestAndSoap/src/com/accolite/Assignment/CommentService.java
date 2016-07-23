package com.accolite.Assignment;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("comment")
public class CommentService {

	CommentDetails commentDetails=new CommentDetails();
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comment> getAllComments(@PathParam("messageId") int messageId)
	{
		return commentDetails.getAllComments(messageId);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Comment addComment(@PathParam("messageId") int messageId, Comment comment)
	{
		return commentDetails.addComment(messageId, comment);
	}
	
	@GET
	@Path("/{commentId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Comment getCommentById(@PathParam("messageId") int messageId,@PathParam("commentId") int commentId)
	{
		return commentDetails.getComment(messageId, commentId);
	}
	
}
