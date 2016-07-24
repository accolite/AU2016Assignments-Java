package com.au;

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

@Path("chatapp")
public class ChatApp {

	List<Message> messages = new ArrayList<>();
	
	ObjectMapper mapper;
	
	public void store(List<Message> messages){
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File("msg.json"), messages);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Message> retrieve(){
		ObjectMapper mapper = new ObjectMapper();
		List<Message> messages = null;
		try {
			messages = mapper.readValue(new File("msg.json"), new TypeReference<List<Message>>(){});
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(messages==null)
			return new ArrayList<Message>();
		return messages;
	}
	
	@GET
	@Path("getallmsg")
	@Produces(MediaType.APPLICATION_JSON)
	public Message[] getMessages(){
		messages = retrieve();
		return messages.toArray(new Message[messages.size()]);
	}
	
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
	
	@Path("postlike/{msgid}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void addLike(@PathParam("msgid") String msgid, Like like){
		messages = this.retrieve();
		for(Message message: messages){
			if(message.getMsgid().equals(msgid)){
				List<Like> likes = message.getLikes();
				if(likes == null){
					likes = new ArrayList<>();
				}
				likes.add(like);
				message.setLikes(likes);
				message.setNoLikes(message.getNoLikes()+1);
				break;
			}
		}
		store(messages);
		
	}
	
	@Path("postmsg")
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
		store(messages);
		return Response.ok().build();
	}
	
	@Path("postcomment/{msgid}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addComment(@PathParam("msgid") String msgid, Comment comment){
		messages = this.retrieve();
		for(Message message: messages){
			if(message.getMsgid().equals(msgid)){
				List<Comment> comments = message.getComments();
				if(comments == null){
					comments = new ArrayList<>();
				}
				comments.add(comment);
				message.setComments(comments);
				break;
			}
		}
		store(messages);
		return Response.ok().build();
	}
	
}