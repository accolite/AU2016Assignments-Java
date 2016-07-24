package com.accolite.Messanger.messanger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.accolite.Messanger.messanger.Message;

@Path("messages")

public class Messanger {
	@GET
	/*@Produces(MediaType.APPLICATION_JSON)*/
	public String getMessage() {
		return "send the message id as param";
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message saveMessage(Message message) {
	    message.setValue("You message " + message.getValue()+" with id "+ message.getId()+" is saved");
	   return message;
		
	}
	/*@PathParam("id") String id*/
	@GET
	@Path("getMessages")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMessageById() {
		System.out.println("in get message by id");
		return Response.status(200).entity("D:/Eclipse-Acco/messanger/messanger.json").build();
	}
	
	@POST
	@Path("addMessage/{id}")
	public void addMessage(@PathParam("id") int id)
	{	System.out.println("in add message");
		// add a message with id in json file
	}
	
	@POST
	@Path("addComment/{id}/{comment}")
	public void addComment(@PathParam("id") int id,@PathParam("comment") String str)
	{
		// add a comment in json
	}
	
	@POST
	@Path("addLike/{id}/{byWho}")
	public void addLike(@PathParam("id") int id,@PathParam("byWho") String str)
	{
		// add a comment in json
	}
	
	@GET
	@Path("veiwLikes/{id}")
	public void veiwLikes(@PathParam("id") int id)
	{
		// view likes 
	}
	
	@GET
	@Path("veiwComments/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void veiwComments(@PathParam("id") int id)
	{
		// view Comments 
	}
	

}
