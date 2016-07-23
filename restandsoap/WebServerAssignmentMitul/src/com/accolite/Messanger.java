package com.accolite;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("messages")
public class Messanger {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("thisIsget")
	public String getMessage(){
		return "hello,world";
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("savemessage")
	public Message saveMessage(Message message){
		message.setValue("you message" + message.getValue() + "with id " + message.getId() + "is saved");
		return message;
	}
	
}
