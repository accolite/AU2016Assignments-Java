package com.accolite.Messanger.messanger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.accolite.Messanger.messanger.Post;

@Path("messages")

public class Messanger {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage() {
		return "hello, world!";
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Post saveMessage(Post message) {
		
	   return message;
		
	}

	@GET
	@Path("{id}")
	public Response getMessageById(@PathParam("id") String id) {
		
		return Response.status(200).entity("You need the message with id : " + id).build();
	}

	

}
