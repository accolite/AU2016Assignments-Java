/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 24, 2016

*

*  @author :: Mohit Devda

* ***************************************************************************

*/
package com.accolite.rest;
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

// TODO: Auto-generated Javadoc
/**
 * The Class Test.
 */
@Path("/")
public class Test
{
 
 /** The messages. */
 ArrayList<MessageClass> messages=new ArrayList<MessageClass>(10);
 
 /**
  * Extract message.
  *
  * @return the array list
  * @throws JsonParseException the json parse exception
  * @throws JsonMappingException the json mapping exception
  * @throws IOException Signals that an I/O exception has occurred.
  */
 @GET
 @Produces (MediaType.APPLICATION_JSON)
 @Path("allMessage")
 public ArrayList<MessageClass> extractMessage() throws JsonParseException, JsonMappingException, IOException
 {
   
  ObjectMapper objectMapper1 = new ObjectMapper();
  ArrayList<MessageClass> messages = null;
  messages = objectMapper1.readValue(new File("D://workspace/restandsoap/Message.json"), new TypeReference<ArrayList<MessageClass>>(){});  
  Iterator itr=messages.iterator();
  while(itr.hasNext())
  {
   MessageClass mess = (MessageClass)itr.next();
   System.out.println(mess.messageId);
   
  }
  return messages;
 }
 
 /**
  * View comments.
  *
  * @return the array list
  * @throws JsonParseException the json parse exception
  * @throws JsonMappingException the json mapping exception
  * @throws IOException Signals that an I/O exception has occurred.
  */
 @GET
 @Produces (MediaType.APPLICATION_JSON)
 @Path("viewComments")
 public ArrayList<Comment> ViewComments() throws JsonParseException, JsonMappingException, IOException
 {
  System.out.println("Enter the message id:");
  Scanner scan = new Scanner(System.in);
  int message_id = scan.nextInt();
  
  ObjectMapper objectMapper1 = new ObjectMapper();
  ArrayList<MessageClass> messages = null;
  messages = objectMapper1.readValue(new File("D://workspace/restandsoap/Message.json"), new TypeReference<ArrayList<MessageClass>>(){});
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
 
 /**
  * View likes.
  *
  * @return the array list
  * @throws JsonParseException the json parse exception
  * @throws JsonMappingException the json mapping exception
  * @throws IOException Signals that an I/O exception has occurred.
  */
 @GET
 @Produces (MediaType.APPLICATION_JSON)
 @Path("viewLikes")
 public ArrayList<Likes> ViewLikes() throws JsonParseException, JsonMappingException, IOException
 {
  System.out.println("Enter the message id");
  Scanner scan = new Scanner(System.in);
  int message_id = scan.nextInt();
  
  ObjectMapper objectMapper = new ObjectMapper();
  ArrayList<MessageClass> messages = null;
  messages = objectMapper.readValue(new File("D://workspace/restandsoap/Message.json"), new TypeReference<ArrayList<MessageClass>>(){});
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
 
 /**
  * To string.
  *
  * @param m the m
  * @return the string
  */
 public String toString(MessageClass m)
 {
  return "Message m has"+m.messageId+"m has "+m.personId;
  
 }
 
 /**
  * Gets the values.
  *
  * @return the values
  */
 public MessageClass getValues(){
  MessageClass message1=new MessageClass();
  
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
 
 /**
  * Put message.
  *
  * @throws JSONException the JSON exception
  * @throws IOException Signals that an I/O exception has occurred.
  */
 @POST
 @Consumes (MediaType.APPLICATION_JSON)
 @Produces (MediaType.APPLICATION_JSON)
 @Path("addMessage")
 public void putMessage() throws JSONException, IOException
 {
  MessageClass m = new MessageClass();
  m=getValues();
  ObjectMapper objectMapper = new ObjectMapper();
  messages = objectMapper.readValue(new File("D://workspace/restandsoap/Message.json"), new TypeReference<ArrayList<MessageClass>>(){});
  messages.add(m);
  ObjectMapper mapper = new ObjectMapper();
  mapper.writeValue(new File("D://workspace/restandsoap/Message.json"),messages);
  
 }
 
 /**
  * Put comment to message.
  *
  * @throws JSONException the JSON exception
  * @throws IOException Signals that an I/O exception has occurred.
  */
 @POST
 @Consumes (MediaType.APPLICATION_JSON)
 @Produces (MediaType.APPLICATION_JSON)
 @Path("addComment")
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
  messages = objectMapper.readValue(new File("D://workspace/restandsoap/Message.json"), new TypeReference<ArrayList<MessageClass>>(){});
  Iterator itr=messages.iterator();
  while(itr.hasNext())
  {
   MessageClass m = (MessageClass)itr.next();
   if(m.messageId==message_id)
   {
   m.comment.add(commm);
   
   }
   
  }
  ObjectMapper mapper = new ObjectMapper();
  mapper.writeValue(new File("D://workspace/restandsoap/Message.json"),messages);
  
 }
 
 /**
  * Adds the like to message.
  *
  * @throws JSONException the JSON exception
  * @throws IOException Signals that an I/O exception has occurred.
  */
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
  messages = objectMapper.readValue(new File("D://workspace/restandsoap/Message.json"), new TypeReference<ArrayList<MessageClass>>(){});
  Likes like=new Likes();
  like.setMessageId(message_id);
  like.setPersonId(person_id);
  Iterator itr=messages.iterator();
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
  mapper.writeValue(new File("D://workspace/restandsoap/Message.json"),messages);
 }
 
 
 
 
 /**
  * The main method.
  *
  * @param args the arguments
  * @throws JSONException the JSON exception
  * @throws IOException Signals that an I/O exception has occurred.
  */
 public static void main(String args[]) throws JSONException, IOException
 {
Test obj=new Test();
 
  
 }
 

}
