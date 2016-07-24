/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
* Created date :: Jul 24, 2016
*  @author :: Lokesh K
* ***************************************************************************
*/
package com.accolite.service;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

// TODO: Auto-generated Javadoc
/**
 * The Class FB.
 */
@Path("facebook")
public class FB {
	
	/**
	 * Gets the message.
	 *
	 * @param user the user
	 * @return the message
	 */
	@GET
	@Path("getMessage")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage(@DefaultValue("") @QueryParam("user_name") String user) {
		JSONHandler jhandle=new JSONHandler(user);
		if(jhandle.user!=null)
			return jhandle.getMessage();
		return "{\"error\":\"user not found\"}";
	}

	/**
	 * Gets the all message.
	 *
	 * @param user the user
	 * @return the all message
	 */
	@GET
	@Path("getAllMessage")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAllMessage(@DefaultValue("") @QueryParam("user_name") String user) {
		JSONHandler jhandle=new JSONHandler(user);
		if(jhandle.user!=null)
			return jhandle.getAllMessage();
		return "{\"error\":\"user not found\"}";
	}

	/**
	 * Gets the comment.
	 *
	 * @param user the user
	 * @param messageID the message ID
	 * @param commentID the comment ID
	 * @return the comment
	 */
	@GET
	@Path("getComment")
	@Produces(MediaType.TEXT_PLAIN)
	public String getComment(@DefaultValue("") @QueryParam("user_name") String user,
			@DefaultValue("-1") @QueryParam("message_id") int messageID,
			@DefaultValue("-1") @QueryParam("comment_id") int commentID) {
		JSONHandler jhandle=new JSONHandler(user);
		if(jhandle.user!=null)
			return jhandle.getComment(messageID, commentID);
		return "{\"error\":\"user not found\"}";
	}

	/**
	 * Gets the all comment.
	 *
	 * @param user the user
	 * @param messageID the message ID
	 * @return the all comment
	 */
	@GET
	@Path("getAllComment")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAllComment(@DefaultValue("") @QueryParam("user_name") String user,
			@DefaultValue("-1") @QueryParam("message_id") int messageID) {
		JSONHandler jhandle=new JSONHandler(user);
		if(jhandle.user!=null)
			return jhandle.getAllComment(messageID);
		return "{\"error\":\"user not found\"}";
	}

	/**
	 * Gets the likes.
	 *
	 * @param user the user
	 * @param messageID the message ID
	 * @return the likes
	 */
	@GET
	@Path("getLikes")
	@Produces(MediaType.TEXT_PLAIN)
	public String getLikes(@DefaultValue("") @QueryParam("user_name") String user,
			@DefaultValue("-1") @QueryParam("message_id") int messageID) {
		JSONHandler jhandle=new JSONHandler(user);
		if(jhandle.user!=null)
			return jhandle.getLikers(messageID);
		return "{\"error\":\"user not found\"}";
	}

	/**
	 * Adds the message.
	 *
	 * @param user the user
	 * @param message the message
	 * @return the string
	 */
	@POST
	@Path("addMessage")
	@Produces(MediaType.TEXT_PLAIN)
	public String addMessage(@DefaultValue("") @QueryParam("user_name") String user,
			@DefaultValue("") @QueryParam("message") String message) {
		JSONHandler jhandle=new JSONHandler(user);
		if(jhandle.user!=null){
			jhandle.addMessage(message);
			return getAllMessage(user);
		}
		return "{\"error\":\"user not found\"}";
	}

	/**
	 * Adds the comment.
	 *
	 * @param user the user
	 * @param comment the comment
	 * @param messageID the message ID
	 * @param whoCommented the who commented
	 * @return the string
	 */
	@POST
	@Path("addComment")
	@Produces(MediaType.TEXT_PLAIN)
	public String addComment(@DefaultValue("") @QueryParam("user_name") String user,
			@DefaultValue("") @QueryParam("comment") String comment,
			@DefaultValue("-1") @QueryParam("message_id") int messageID,
			@DefaultValue("") @QueryParam("who_commented") String whoCommented) {
		JSONHandler jhandle=new JSONHandler(user);
		if(jhandle.user!=null){
			jhandle.addComment(messageID, comment, whoCommented);
			return getAllMessage(user);
		}
		return "{\"error\":\"user not found\"}";
	}

	/**
	 * Adds the like.
	 *
	 * @param user the user
	 * @param messageID the message ID
	 * @param whoLiked the who liked
	 * @return the string
	 */
	@POST
	@Path("addLike")
	@Produces(MediaType.TEXT_PLAIN)
	public String addLike(@DefaultValue("") @QueryParam("user_name") String user,
			@DefaultValue("-1") @QueryParam("message_id") int messageID,
			@DefaultValue("") @QueryParam("who_liked") String whoLiked) {
		JSONHandler jhandle=new JSONHandler(user);
		if(jhandle.user!=null){
			jhandle.addLike(messageID,whoLiked);
			return getAllMessage(user);
		}
		return "{\"error\":\"user not found\"}";
	}
}