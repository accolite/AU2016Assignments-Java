package com.accolite.assignment;

import java.awt.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jettison.json.*;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("ChatBox")
public class application 
{
	ArrayList<Message> msg=new ArrayList<Message>(10);
	
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	@Path("get")
	public ArrayList<Message> getMessage() throws JsonParseException, JsonMappingException, IOException
	{
	 	
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayList<Message> messages = null;
		messages = objectMapper.readValue(new File("C://Users/Anshika Agarwal/Desktop/MessageJSON.json"), new TypeReference<ArrayList<Message>>(){});
		//return messages;
		
		Iterator itr=messages.iterator();
		while(itr.hasNext())
		{
			Message m = (Message)itr.next();
			System.out.println(m.message_id);
			
		}
		return messages;
	}
	
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	@Path("ViewComments")
	public ArrayList<Comment> ViewComments() throws JsonParseException, JsonMappingException, IOException
	{
		System.out.println("Enter the message id:");
		Scanner scan = new Scanner(System.in);
		int message_id = scan.nextInt();
		
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayList<Message> messages = null;
		messages = objectMapper.readValue(new File("C://Users/Anshika Agarwal/Desktop/MessageJSON.json"), new TypeReference<ArrayList<Message>>(){});
		//return messages;
		
		Iterator itr=messages.iterator();
		while(itr.hasNext())
		{
			Message m = (Message)itr.next();
			if(m.message_id == message_id)
			{
				return m.comment;
			}
			
			System.out.println(m.message_id);
			
		}
		return null;
		
	}
	
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	@Path("ViewLikes")
	public ArrayList<Likes> ViewLikes() throws JsonParseException, JsonMappingException, IOException
	{
		System.out.println("Enter the message id:");
		Scanner scan = new Scanner(System.in);
		int message_id = scan.nextInt();
		
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayList<Message> messages = null;
		messages = objectMapper.readValue(new File("C://Users/Anshika Agarwal/Desktop/MessageJSON.json"), new TypeReference<ArrayList<Message>>(){});
		//return messages;
		
		Iterator itr=messages.iterator();
		while(itr.hasNext())
		{
			Message m = (Message)itr.next();
			if(m.message_id == message_id)
			{
				return m.like;
			}
			
		}
		return null;
		
	}
	
	public String toString(Message m)
	{
		System.out.println("ghgh");
		return "Message m has"+m.message_id+"m has "+m.person_id;
		
	}
	
	public Message getValues()
	{
		Message m1=new Message();
		
		System.out.println("Enter the details");
		Scanner scan = new Scanner(System.in);
		int message_id =scan.nextInt();
		int person_id=scan.nextInt();
		String date=scan.next();
		String message=scan.next();
		
		
		m1.setDate(date);
		m1.setMessage_id(message_id);
		m1.setMessage(message);
		m1.setPerson_id(person_id);
		
		
		return m1;
	}
	
	@POST
	@Consumes (MediaType.APPLICATION_JSON)
	@Produces (MediaType.APPLICATION_JSON)
	@Path("put")
	public void putMessage() throws JSONException, IOException
	{
		Message m = new Message();
		m=getValues();
		ObjectMapper objectMapper = new ObjectMapper();
		msg = objectMapper.readValue(new File("C://Users/Anshika Agarwal/Desktop/MessageJSON.json"), new TypeReference<ArrayList<Message>>(){});
		msg.add(m);
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("C://Users/Anshika Agarwal/Desktop/MessageJSON.json"),msg);
		
	}
	
	@POST
	@Consumes (MediaType.APPLICATION_JSON)
	@Produces (MediaType.APPLICATION_JSON)
	@Path("putComment")
	public void putCommentToMessage() throws JSONException, IOException
	{
		System.out.println("Enter the message id:");
		Scanner scan = new Scanner(System.in);
		int message_id = scan.nextInt();
		System.out.println("Enter the person id:");
		int person_id = scan.nextInt();
		System.out.println("Enter the comment");
		String com = scan.next();
		Comment commm=new Comment();
		commm.setComment(com);commm.setPerson_id(person_id);
		ObjectMapper objectMapper = new ObjectMapper();
		msg = objectMapper.readValue(new File("C://Users/Anshika Agarwal/Desktop/MessageJSON.json"), new TypeReference<ArrayList<Message>>(){});
		Iterator itr=msg.iterator();
		while(itr.hasNext())
		{
			System.out.println("hiefgfg");
			Message m = (Message)itr.next();
			if(m.message_id==message_id)
			{
			m.comment.add(commm);
			
			}
			
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("C://Users/Anshika Agarwal/Desktop/MessageJSON.json"),msg);
		
	}
	
	@POST
	@Consumes (MediaType.APPLICATION_JSON)
	@Produces (MediaType.APPLICATION_JSON)
	@Path("addLikes")
	public void AddLikeToMessage() throws JSONException, IOException
	{
		System.out.println("Enter the message id:");
		Scanner scan = new Scanner(System.in);
		int message_id = scan.nextInt();
		System.out.println("Enter the person id:");
		int person_id = scan.nextInt();
		ObjectMapper objectMapper = new ObjectMapper();
		msg = objectMapper.readValue(new File("C://Users/Anshika Agarwal/Desktop/MessageJSON.json"), new TypeReference<ArrayList<Message>>(){});
		Likes like=new Likes();
		like.setMessage_id(message_id);
		like.setPerson_id(person_id);
		Iterator itr=msg.iterator();
		while(itr.hasNext())
		{
			Message m = (Message)itr.next();
			if(m.message_id==message_id)
			{
			m.likes++;
			m.like.add(like);
			}
			
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("C://Users/Anshika Agarwal/Desktop/MessageJSON.json"),msg);
		
	}
	
	
	
	public static void main(String args[]) throws JSONException, IOException
	{
		application app = new application();
		app.putMessage();
		app.getMessage();
		//app.putCommentToMessage(1, 1732, "Nice", 1);
		//app.putCommentToMessage(1, 1734, "Thanks", 2);
		
		
	}
	

}
