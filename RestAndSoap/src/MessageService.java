import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/messages")
public class MessageService {

	MessageDetails messageDetails=new MessageDetails();
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages()
	{
		return messageDetails.getAllMessages();
	}

	@GET
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessageById(@PathParam("messageId") int messageId)
	{
		return messageDetails.getMessage(messageId);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(Message input_message, @Context UriInfo uriInfo  )
	{
		//String path = uriInfo.getAbsolutePath().toString();		
		Message message = messageDetails.addMessage(input_message);
		String Id = String.valueOf(message.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(Id).build();
		return Response.created(uri).entity(message).build();
	}
	
	
	
	
}