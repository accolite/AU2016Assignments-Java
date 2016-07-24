package com.accolite.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("facebook")
public class FB {
	@GET
	@Path("getMessage")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage(@DefaultValue("") @QueryParam("user_name")String user){
		return (new JSONHandler(user)).getMessage();
	}
	
	@GET
	@Path("getAllMessage")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAllMessage(@DefaultValue("") @QueryParam("user_name")String user){
		return new JSONHandler(user).getAllMessage();
	}
	
	@GET
	@Path("getComment")
	@Produces(MediaType.TEXT_PLAIN)
	public String getComment(@DefaultValue("") @QueryParam("user_name")String user,
			@DefaultValue("-1") @QueryParam("message_id")int messageID,
			@DefaultValue("-1") @QueryParam("comment_id")int commentID){
		return new JSONHandler(user).getComment(messageID, commentID);
	}
	
	@GET
	@Path("getAllComment")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAllComment(@DefaultValue("") @QueryParam("user_name")String user,
			@DefaultValue("-1") @QueryParam("message_id")int messageID){
		return new JSONHandler(user).getAllComment(messageID);
	}
	
	@GET
	@Path("getLikes")
	@Produces(MediaType.TEXT_PLAIN)
	public int getLikes(@DefaultValue("") @QueryParam("user_name")String user,
			@DefaultValue("-1") @QueryParam("message_id")int messageID){
		return new JSONHandler(user).getLikes(messageID);
	}
	
	@POST
	@Path("addMessage")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String addMessage(@DefaultValue("") @QueryParam("user_name")String user,
			@DefaultValue("") @QueryParam("message")String message){
//		System.out.println(user+" "+message);
		new JSONHandler(user).addMessage(message);
		return getAllMessage(user);
	}
	
	@POST
	@Path("addComment")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String addComment(@DefaultValue("") @QueryParam("user_name")String user,
			@DefaultValue("") @QueryParam("comment")String comment,
			@DefaultValue("-1") @QueryParam("message_id")int messageID,
			@DefaultValue("") @QueryParam("who_commented")String whoCommented){
		new JSONHandler(user).addComment(messageID, comment, whoCommented);
		return getAllMessage(user);
	}
	
	@POST
	@Path("addLike")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String addLike(@DefaultValue("") @QueryParam("user_name")String user,
			@DefaultValue("-1") @QueryParam("message_id")int messageID){
//		System.out.println(user+" "+messageID);
		new JSONHandler(user).addLike(messageID);
		return getAllMessage(user);
	}
}