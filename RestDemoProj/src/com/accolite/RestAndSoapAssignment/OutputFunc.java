package com.accolite.RestAndSoapAssignment;
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

@Path("MessageApp")
public class OutputFunc
{
 ArrayList<MessageClass> messageStore=new ArrayList<MessageClass>(10);
 
 @GET
 @Produces (MediaType.APPLICATION_JSON)
 @Path("getMessage")
 public ArrayList<MessageClass> getMessage() throws JsonParseException, JsonMappingException, IOException
 {
   
  ObjectMapper objectMapper1 = new ObjectMapper();
  ArrayList<MessageClass> messages = null;
  messages = objectMapper1.readValue(new File("D://jsonrestassignment/MessageJSON.json"), new TypeReference<ArrayList<MessageClass>>(){});  
  Iterator itr=messages.iterator();
  while(itr.hasNext())
  {
   MessageClass mess = (MessageClass)itr.next();
   System.out.println(mess.messageId);
   
  }
  return messages;
 }
 
 @GET
 @Produces (MediaType.APPLICATION_JSON)
 @Path("ViewCommentsOnMessage")
 public ArrayList<Comment> ViewComments() throws JsonParseException, JsonMappingException, IOException
 {
  System.out.println("Enter the message id whose comments have to be shown:");
  Scanner scan = new Scanner(System.in);
  int message_id = scan.nextInt();
  
  ObjectMapper objectMapper1 = new ObjectMapper();
  ArrayList<MessageClass> messages = null;
  messages = objectMapper1.readValue(new File("D://jsonrestassignment/MessageJSON.json"), new TypeReference<ArrayList<MessageClass>>(){});
  //return messages;
  
  Iterator itr=messages.iterator();
  while(itr.hasNext())
  {
   MessageClass m = (MessageClass)itr.next();
   if(m.messageId == message_id)
   {
    return m.getComment();
   }
   
   System.out.println(m.messageId);
 
  }
  return null;
  
 }
 
 @GET
 @Produces (MediaType.APPLICATION_JSON)
 @Path("ViewLikesOnMessage")
 public ArrayList<Likes> ViewLikes() throws JsonParseException, JsonMappingException, IOException
 {
  System.out.println("Enter the message id whose likes have to be shown:");
  Scanner scan = new Scanner(System.in);
  int message_id = scan.nextInt();
  
  ObjectMapper objectMapper = new ObjectMapper();
  ArrayList<MessageClass> messages = null;
  messages = objectMapper.readValue(new File("D://jsonrestassignment/MessageJSON.json"), new TypeReference<ArrayList<MessageClass>>(){});
  //return messages;
  
  Iterator itr=messages.iterator();
  while(itr.hasNext())
  {
   MessageClass m = (MessageClass)itr.next();
   if(m.messageId == message_id)
   {
    return m.getLike();
   }
   
  }
  return null;
  
 }
 
 public String toString(MessageClass m)
 {
  return "Message m has"+m.messageId+"m has "+m.personId;
  
 }
 
 public MessageClass getValues()
 {
  MessageClass message1=new MessageClass();
  
  System.out.println("Enter the details");
  Scanner scan = new Scanner(System.in);
  System.out.println("Enter the messageId");
  int message_id =scan.nextInt();
  System.out.println("Enter the personId");
  int person_id=scan.nextInt();
  System.out.println("Enter the date");
  String date=scan.next();
  System.out.println("Enter the message");
  String message=scan.next();
  
  
  message1.setDate(date);
  message1.setMessageId(message_id);
  message1.setMessage(message);
  message1.setPersonId(person_id);
  return message1;
 }
 
 @POST
 @Consumes (MediaType.APPLICATION_JSON)
 @Produces (MediaType.APPLICATION_JSON)
 @Path("addMessage")
 public void putMessage() throws JSONException, IOException
 {
  MessageClass m = new MessageClass();
  m=getValues();
  ObjectMapper objectMapper = new ObjectMapper();
  messageStore = objectMapper.readValue(new File("D://jsonrestassignment/MessageJSON.json"), new TypeReference<ArrayList<MessageClass>>(){});
  messageStore.add(m);
  ObjectMapper mapper = new ObjectMapper();
  mapper.writeValue(new File("D://jsonrestassignment/MessageJSON.json"),messageStore);
  
 }
 
 @POST
 @Consumes (MediaType.APPLICATION_JSON)
 @Produces (MediaType.APPLICATION_JSON)
 @Path("addCommentOnMessage")
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
  commm.setComment(com);commm.setPersonId(person_id);
  ObjectMapper objectMapper = new ObjectMapper();
  messageStore = objectMapper.readValue(new File("D://jsonrestassignment/MessageJSON.json"), new TypeReference<ArrayList<MessageClass>>(){});
  Iterator itr=messageStore.iterator();
  while(itr.hasNext())
  {
   MessageClass m = (MessageClass)itr.next();
   if(m.messageId==message_id)
   {
   m.comment.add(commm);
   
   }
   
  }
  ObjectMapper mapper = new ObjectMapper();
  mapper.writeValue(new File("D://jsonrestassignment/MessageJSON.json"),messageStore);
  
 }
 
 @POST
 @Consumes (MediaType.APPLICATION_JSON)
 @Produces (MediaType.APPLICATION_JSON)
 @Path("addLikesOnMessage")
 public void AddLikeToMessage() throws JSONException, IOException
 {
  System.out.println("Enter the message id:");
  Scanner scan = new Scanner(System.in);
  int message_id = scan.nextInt();
  System.out.println("Enter the person id:");
  int person_id = scan.nextInt();
  ObjectMapper objectMapper = new ObjectMapper();
  messageStore = objectMapper.readValue(new File("D://jsonrestassignment/MessageJSON.json"), new TypeReference<ArrayList<MessageClass>>(){});
  Likes like=new Likes();
  like.setMessageId(message_id);
  like.setPersonId(person_id);
  Iterator itr=messageStore.iterator();
  while(itr.hasNext())
  {
   MessageClass m = (MessageClass)itr.next();
   if(m.messageId==message_id)
   {
   m.setLikes(m.getLikes() + 1);
   m.getLike().add(like);
   }
   
  }
  ObjectMapper mapper = new ObjectMapper();
  mapper.writeValue(new File("D://jsonrestassignment/MessageJSON.json"),messageStore);
 }
 
 
 
 
 public static void main(String args[]) throws JSONException, IOException
 {
OutputFunc obj=new OutputFunc();
 
  
 }
 

}
