/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 24, 2016

*

*  @author :: Ravi Kalmodia

* ***************************************************************************

*/
package com.au.chat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
@Path("/")
public class Main {

	/** The messages. */
	List<Message> messages = new ArrayList<>();
	
	/** The mapper. */
	ObjectMapper mapper;
	
	/**
	 * Addtodb.
	 *
	 * @param messages the messages
	 */
	public void addtodb(List<Message> messages){
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File("jasonfile.json"), messages);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Retrieve.
	 *
	 * @return the list
	 */
	public List<Message> retrieve(){
		ObjectMapper mapper = new ObjectMapper();
		List<Message> messages = null;
		try {
			messages = mapper.readValue(new File("jasonfile.json"), new TypeReference<List<Message>>(){});
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(messages==null)
			return new ArrayList<Message>();
		return messages;
	}
	
	/**
	 * Gets the messages.
	 *
	 * @return the messages
	 */
	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public Message[] getMessages(){
		messages = retrieve();
		return messages.toArray(new Message[messages.size()]);
	}
	
	/**
	 * Gets the comments.
	 *
	 * @param msgid the msgid
	 * @return the comments
	 */
	@Path("getcomments/{msgid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Comment[] getComments(@PathParam("msgid") String msgid){
		messages = this.retrieve();
		for(Message message: messages){
			if(message.getMsgid().equals(msgid))
				return message.getComments().toArray(new Comment[message.getComments().size()]);
		}
		return new Comment[1];
	}
	
	/**
	 * Gets the likes.
	 *
	 * @param msgid the msgid
	 * @return the likes
	 */
	@Path("getlikes/{msgid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Like[] getLikes(@PathParam("msgid") String msgid){
		messages = this.retrieve();
		for(Message message: messages){
			if(message.getMsgid().equals(msgid))
				return message.getLikes().toArray(new Like[message.getLikes().size()]);
		}
		return new Like[1];
		
	}
	
	/**
	 * Adds the like.
	 *
	 * @param msgid the msgid
	 * @param l the l
	 */
	@Path("addlike/{msgid}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void addLike(@PathParam("msgid") String msgid, Like l){
		messages = this.retrieve();
		for(Message message: messages){
			if(message.getMsgid().equals(msgid)){
				List<Like> likes = message.getLikes();
				if(likes == null){
					likes = new ArrayList<>();
				}
				likes.add(l);
				message.setLikes(likes);
				message.setNoLikes(message.getNoLikes()+1);
				break;
			}
		}
		addtodb(messages);
		
	}

	
	/**
	 * Adds the message.
	 *
	 * @param messageS the message S
	 * @return the response
	 * @throws JsonParseException the json parse exception
	 * @throws JsonMappingException the json mapping exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Path("addmessage")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMessage(String messageS) throws JsonParseException, JsonMappingException, IOException{
		mapper = new ObjectMapper();
		Message message = mapper.readValue(messageS, Message.class);
		messages = retrieve();
		if(messages==null)
			message.setMsgid("0");
		else	
			message.setMsgid(""+messages.size());
		message.setNoLikes(0);
		message.setLikes(new ArrayList<Like>());
		message.setComments(new ArrayList<Comment>());
		messages.add(message);
		addtodb(messages);
		return Response.ok().build();
	}
	
	/**
	 * Adds the comment.
	 *
	 * @param msgid the msgid
	 * @param com the com
	 * @return the response
	 */
	@Path("addcomment/{msgid}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addComment(@PathParam("msgid") String msgid, Comment com){
		messages = this.retrieve();
		for(Message message: messages){
			if(message.getMsgid().equals(msgid)){
				List<Comment> comments = message.getComments();
				if(comments == null){
					comments = new ArrayList<>();
				}
				comments.add(com);
				message.setComments(comments);
				break;
			}
		}
		addtodb(messages);
		return Response.ok().build();
	}
	
}