/*
  * Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 24, 2016

*

*  @author :: Chirag Bansal

* ***************************************************************************
 */
package com.accolite.soaprest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;


@Path("queries")
public class Queries {
	public static String readFile(String filename) {
	    String result = "";
	    try {
	        BufferedReader br = new BufferedReader(new FileReader(filename));
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        while (line != null) {
	            sb.append(line);
	            line = br.readLine();
	        }
	        result = sb.toString();
	        br.close();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	    
	    return result;
	}
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	//@Produces(MediaType.APPLICATION_JSON)
	@Path("addMessage")
	public void addMessage(@QueryParam("message_id")int message_id_1,@QueryParam("name")String owner_1,@QueryParam("message")String description_1, 
			@QueryParam("time")int time_1)
	{
		ArrayList<Comment> comments_1=new ArrayList<Comment>();
		ArrayList<Like> likes_1=new ArrayList<Like>();
		Message new_msg=new Message(message_id_1, 0, owner_1, description_1, time_1,comments_1, likes_1);
		System.out.println(new_msg.getComments().size());
		if(new_msg.getComments()!=null)
			System.out.println("hsdbhdvbhi");
		if(new_msg.getLikes()!=null)
			System.out.println("likessss");
		
		//System.out.println("lol");
	
		String jsonData = readFile("D:/work_space/FaceBook/data.json");
		try{
		JSONObject obj= new JSONObject(jsonData);
		JSONArray message_list=obj.getJSONArray("messageList");
		String arr[]={"message_id","owner_id","owner","description","time","comments","likes"};
		JSONObject temp=new JSONObject(new_msg);
		System.out.println(temp);
		message_list.put(temp);
		try (FileWriter file = new FileWriter("D:/work_space/FaceBook/data.json")) {
			file.write(obj.toString(0));
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + obj);
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		//return new_msg;
		
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("sortedmessages")
	public MessageList getsortedMessages()
	{
		
			
		ArrayList<String> sorted_messages=new ArrayList<String>();
		List<JSONObject> jsonValues=null;
		try{
		String jsonData = readFile("D:/work_space/FaceBook/data.json");
		JSONObject obj= new JSONObject(jsonData);
		JSONArray message_list=obj.getJSONArray("messageList");
		
		  jsonValues= new ArrayList<JSONObject>();
		  
		    for (int i = 0; i < message_list.length(); i++){
		        jsonValues.add(message_list.getJSONObject(i));
		    }
		    
		    
		    Collections.sort( jsonValues, new Comparator<JSONObject>() {
		        //You can change "Name" with "ID" if you want to sort by ID
		        private static final String KEY_NAME = "time";

		        @Override
		        public int compare(JSONObject a, JSONObject b) {
		            String valA = new String();
		            String valB = new String();
		            int vala=0,valb=0;
		            try {
		                valA = (String) a.get(KEY_NAME);
		                valB = (String) b.get(KEY_NAME);
		                 vala=Integer.parseInt(valA);
		                valb=Integer.parseInt(valB);
		            } 
		            catch (Exception e) {
		                //do something
		            }
		            if(vala<valb)return -1;
		            else return 1;
		           
		            //if you want to change the sort order, simply use the following:
		            //return -valA.compareTo(valB);
		        }
		    });
		
		   
//		    for(i=0;i<jsonValues.size();i++)
//		    {
//		    	System.out.println(jsonValues.get(i).get("description"));
//		    }
		    for(JSONObject jobj:jsonValues)
		    {
		    	System.out.println(jobj.get("description").toString());
		    	sorted_messages.add(jobj.get("description").toString());
		    }
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		//System.out.println(sorted_messages.size());
		//return sorted_messages;
		MessageList ret_obj=new MessageList(sorted_messages);
		    return ret_obj;
		
		
		
	}
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	//@Produces(MediaType.APPLICATION_JSON)
	@Path("addComment")
	public void addComment(@QueryParam("message_id")int message_id_1,@QueryParam("content")String content_1,@QueryParam("name")String name_1)
	{
		Comment new_comment=new Comment(message_id_1, content_1, 0, name_1);
	//	System.out.println(new_comment.getMessage_id());
		Integer message_id=(Integer)new_comment.getMessage_id();
		System.out.println("lol");
		
		String jsonData = readFile("D:/work_space/FaceBook/data.json");
		try{
		JSONObject obj= new JSONObject(jsonData);
		JSONArray message_list=obj.getJSONArray("messageList");
		int i;
		System.out.println(message_list.length());
		for(i=0;i<message_list.length();i++)
		{
			JSONObject message=message_list.getJSONObject(i);
			System.out.println((message.get("message_id")));
			if((message.get("message_id").toString()).equals(message_id.toString())==true)
			{
				System.out.println("phaunch gya");
				JSONObject temp=new JSONObject(new_comment);
				JSONArray comments=message.getJSONArray("comments");
				System.out.println(comments.length());
			
				comments.put(temp);
				
				
			}
		}
		
		
		try (FileWriter file = new FileWriter("D:/work_space/FaceBook/data.json")) {
			file.write(obj.toString(0));
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + obj);
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
		
	}
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	//@Produces(MediaType.APPLICATION_JSON)
	@Path("addLike")
	public void addLike(@QueryParam("name")String name_1,@QueryParam("message_id")int message_id_1)
	{
		
		Like new_like=new Like(name_1, 0, message_id_1);
		Integer message_id=(Integer)new_like.getMessage_id();
		
		String jsonData = readFile("D:/work_space/FaceBook/data.json");
		try{
		JSONObject obj= new JSONObject(jsonData);
		JSONArray message_list=obj.getJSONArray("messageList");
		int i;
		//System.out.println(message_list.length());
		for(i=0;i<message_list.length();i++)
		{
			JSONObject message=message_list.getJSONObject(i);
			//System.out.println((message.get("message_id")));
			if((message.get("message_id").toString()).equals(message_id.toString())==true)
			{
				System.out.println("phaunch gya");
				JSONObject temp=new JSONObject(new_like);
				JSONArray likes=message.getJSONArray("likes");
			//	System.out.println(comments.length());
			
				likes.put(temp);
				
				
			}
		}
		
		
		try (FileWriter file = new FileWriter("D:/work_space/FaceBook/data.json")) {
			file.write(obj.toString(0));
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + obj);
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
		
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("viewcommentsonmessage")
	public MessageList viewComments(@QueryParam("message")String mes) {

		ArrayList<String> comment_list = new ArrayList<String>();
		String jsonData = readFile("D:/work_space/FaceBook/data.json");
		try {
			JSONObject obj = new JSONObject(jsonData);
			JSONArray message_list = obj.getJSONArray("messageList");
			int i;
			// System.out.println(message_list.length());
			for (i = 0; i < message_list.length(); i++) {
				JSONObject message = message_list.getJSONObject(i);
				// System.out.println((message.get("message_id")));
				if ((message.get("description").toString()).equals(mes) == true) {
					System.out.println("phaunch gya");

					JSONArray comments = message.getJSONArray("comments");
					// System.out.println(comments.length());
					int j;
					for (j = 0; j < comments.length(); j++) {
						comment_list.add(comments.getJSONObject(j).getString("content"));
					}

				}
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		MessageList ret_obj = new MessageList(comment_list);
		return ret_obj;
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("viewlikesonmessage")
	public MessageList viewLikes(@QueryParam("message")String mes) {

		ArrayList<String> like_list = new ArrayList<String>();
		String jsonData = readFile("D:/work_space/FaceBook/data.json");
		try {
			JSONObject obj = new JSONObject(jsonData);
			JSONArray message_list = obj.getJSONArray("messageList");
			int i;
			// System.out.println(message_list.length());
			for (i = 0; i < message_list.length(); i++) {
				JSONObject message = message_list.getJSONObject(i);
				// System.out.println((message.get("message_id")));
				if ((message.get("description").toString()).equals(mes) == true) {
					System.out.println("phaunch gya");

					JSONArray likes = message.getJSONArray("likes");
					// System.out.println(comments.length());
					int j;
					for (j = 0; j < likes.length(); j++) {
						like_list.add(likes.getJSONObject(j).getString("name"));
					}

				}
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		MessageList ret_obj = new MessageList(like_list);
		return ret_obj;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
JSONObject jik=new JSONObject(object, names)
	}

}
