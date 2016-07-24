package com.rest.demo;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("messages")
public class Messanger {
@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("thisIsget")
public Message getMessageContent()
{
	Message m=new Message();
	m.setValue("hi");
	m.setId(1);
	return m;
	//return "hello,world!";
}
@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Message saveMessage(Message message)
{
	message.setValue("You message"+message.getValue()+"with id"+message.getId()+"");
	return message;
	
}
}