/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 24, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************/

package com.accolite.Messenger.webResources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.w3c.dom.Comment;

import com.accolite.Messenger.classfiles.Message;
import com.accolite.Messenger.services.MessageService;


// TODO: Auto-generated Javadoc
/**
 * The Class MessageResource.
 */
@Path("/messages")
public class MessageResource
{
	
	/** The message service. */
	MessageService messageService = new MessageService();

	/**
	 * Gets the messages.
	 *
	 * @return the messages
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages()
	{
		return messageService.getAllMessages();
	}


	/**
	 * Gets the message.
	 *
	 * @param messageId the message id
	 * @return the message
	 */
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long messageId)
	{
		return messageService.getMessage(messageId);
	}

	/**
	 * Adds the message.
	 *
	 * @param message the message
	 * @param uriInfo the uri info
	 * @return the response
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(Message message, @Context UriInfo uriInfo  )
	{
		//String path = uriInfo.getAbsolutePath().toString();		
		Message newMessage = messageService.addMessage(message);
		String newId = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)
			.entity(newMessage)
			.build();
		//return messageService.addMessage(message);
	}


	
	/**
 * Gets the comment resource.
 *
 * @return the comment resource
 */
@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}

}
