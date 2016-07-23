package com.au.messenger.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.au.messenger.model.Comment;
import com.au.messenger.service.CommentService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

	private CommentService commentService = new CommentService();
	@GET
	public List<Comment> bleh(@PathParam("msgId") int msgId){		
		return commentService.getAllComments(msgId);
	}
	
	@POST
	public Comment addComment(@PathParam("msgId") int msgId , Comment comment){
		commentService.addComment(msgId, comment);
		return comment;
	}
	
}
