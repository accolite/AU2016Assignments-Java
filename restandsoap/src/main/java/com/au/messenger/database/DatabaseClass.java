package com.au.messenger.database;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.au.messenger.model.Message;
import com.au.messenger.model.User;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DatabaseClass {

	private static Map<Integer, Message> messages = new HashMap<>();
	private static Map<Integer, User> users = new HashMap<>();

	public static Map<Integer, Message> getMessages() {
		ObjectMapper mapper = new ObjectMapper();
		List<Message> messagesList = null;
		try {
			//messagesList = mapper.readValue(new File("D:\\db1.json"), new TypeReference<List<Message>>(){});
			messagesList = Arrays.asList(mapper.readValue(new File("D:\\db.json"), Message[].class));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Message message : messagesList) {
			messages.put(message.getId(),message);
		}
		return messages;
	}

	public static Map<Integer, User> getUsers() {
		ObjectMapper mapper = new ObjectMapper();
		List<User> UsersList = null;
		try {
			//UsersList = mapper.readValue(new File("D:\\dbuser.json"), new TypeReference<List<User>>(){});
			UsersList = Arrays.asList(mapper.readValue(new File("D:\\dbuser.json"), User[].class));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (User User : UsersList) {
			users.put(User.getId(),User);
		}
		return users;
	}
	
	public static void store(){
		  ObjectMapper mapper = new ObjectMapper();
		  try {
		   mapper.writeValue(new File("D:\\db.json"), messages.values());
		  } catch (JsonGenerationException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } catch (JsonMappingException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
		 }
}
