package com.accolite.assignment;

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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/messages")
public class Messenger {

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages() {
		ObjectMapper objectMapper = new ObjectMapper();
		File file = new File("D:\\Workspace\\Messenger\\data\\messenger.json");
		List<Message> messages = null;
		try {
			messages = objectMapper.readValue(file, new TypeReference<List<Message>>() {
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
		return messages;
	}

	@POST
	//@Consumes(MediaType.APPLICATION_JSON)
	public void setMessages(Message message) throws JsonParseException, JsonMappingException {
		ObjectMapper myObjectMapper = new ObjectMapper();
		File file = new File("D:\\Workspace\\Messenger\\data\\messenger.json");
		try {
			List<Message> messages = new ArrayList<Message>();
			messages.add(message);
			List<Message> messagePast = null;
			messagePast = myObjectMapper.readValue(file, new TypeReference<List<Message>>() {
			});
			if (messagePast != null) {
				messages.addAll(messagePast);
			}
			myObjectMapper.writeValue(file, messages);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@GET
	@Path("/{id}/comments")
	public List<Comments> getComments(@PathParam("id") String id) {
		ObjectMapper myObjectMapper = new ObjectMapper();
		File file = new File("D:\\Workspace\\Messenger\\data\\messenger.json");
		List<Comments> comments = null;
		try {
			List<Message> messages = null;
			messages = myObjectMapper.readValue(file, new TypeReference<List<Message>>() {
			});
			for (Message currentMessage : messages) {
				if (currentMessage.messageID.equals(id)) {
					comments = currentMessage.getMessageComments();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comments;
	}

	@POST
	@Path("/{msgID}/addComments")
	public void addComments(@PathParam("userID") String userID, @PathParam("msgID") String msgID, Comments comments) {
		ObjectMapper myObjectMapper = new ObjectMapper();
		File file = new File("D:\\Workspace\\Messenger\\data\\messenger.json");
		List<Message> messages = null;
		try {
			messages = myObjectMapper.readValue(file, new TypeReference<List<Message>>() {
			});
			for (Message currentMessage : messages) {
				if (currentMessage.messageID.equals(msgID)) {
					List<Comments> pastComments = currentMessage.getMessageComments();
					pastComments.add(comments);
					currentMessage.setMessageComments(pastComments);
					myObjectMapper.writeValue(file, messages);
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GET
	@Path("/{msgID}/likes")
	public String getLikes(@PathParam("msgID") String msgID) {
		ObjectMapper myObjectMapper = new ObjectMapper();
		File file = new File("D:\\Workspace\\Messenger\\data\\messenger.json");
		Message message = null;
		String likes = null;
		try {
			List<Message> messages = null;
			messages = myObjectMapper.readValue(file, new TypeReference<List<Message>>() {
			});
			for (Message currentMessage : messages) {
				if (currentMessage.messageID.equals(msgID)) {
					likes = currentMessage.getMessageLikes();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return likes;
	}

	@POST
	@Path("/{msgID}/like")
	public void addLike(@PathParam("msgID") String msgID) {
		ObjectMapper myObjectMapper = new ObjectMapper();
		File file = new File("D:\\Workspace\\Messenger\\data\\messenger.json");
		String likes = null;
		try {
			List<Message> messages = null;
			messages = myObjectMapper.readValue(file, new TypeReference<List<Message>>() {
			});
			for (Message currentMessage : messages) {
				if (currentMessage.messageID.equals(msgID)) {
					likes = currentMessage.getMessageLikes();
					likes = Integer.toString(Integer.parseInt(likes) + 1);
					currentMessage.setMessageLikes(likes);
					myObjectMapper.writeValue(file, messages);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
