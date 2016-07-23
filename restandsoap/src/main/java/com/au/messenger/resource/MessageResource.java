package com.au.messenger.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.au.messenger.model.Like;
import com.au.messenger.model.Message;
import com.au.messenger.service.LikeService;
import com.au.messenger.service.MessageService;

@Path("messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService messageService = new MessageService();
	private LikeService likeService = new LikeService();
	
	@GET
	public List<Message> getAllMessages(){
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{msgId}")
	public Message getMessage(@PathParam("msgId") int msgId){
		return messageService.getMessage(msgId);
		
	}
	
	@POST
	public Message addMessage(Message message){
		Message addedMessage = messageService.addMessage(message);
		return addedMessage;
	}
	
	@Path("/{msgId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}
	
	@GET
	@Path("/{msgId}/likes")
	public List<Like> bleh(@PathParam("msgId") int msgId){		
		return likeService.getAllLikes(msgId);
	}
	
	@POST
	@Path("/{msgId}/likes")
	public Like addComment(@PathParam("msgId") int msgId , Like like){
		likeService.addLike(msgId, like);
		return like;
	}
}
