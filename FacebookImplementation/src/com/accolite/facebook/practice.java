package com.accolite.facebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class practice {

	public static void main(String[] args) throws FileNotFoundException, JSONException {
	
		int j,i;
		String output="";
		String content = new Scanner(new File("messages.json")).useDelimiter("\\Z").next();
		JSONObject rootObject = new JSONObject(content);
		JSONArray listOfmessages = rootObject.getJSONArray("messageList");
		
		for(j=0;j<listOfmessages.length();j++)
		{
			JSONObject getMessageObject=listOfmessages.getJSONObject(j);
			
			//String ownerid=getMessageObject.getString("ownerid");
			String owner=getMessageObject.getString("owner");
			String description=getMessageObject.getString("description");
			output+="Owner:"+owner+"\nMessage:"+description+"\nLikedBy:";
			JSONArray likes = getMessageObject.getJSONArray("likes");
			JSONArray comments = getMessageObject.getJSONArray("comments");
			
			
			
			for(i=0; i < likes.length(); i++) 
			{ // Loop over each each row
	            JSONObject like = likes.getJSONObject(i); // Get row object
	            //System.out.println(like);
	            String name = like.getString("name"); // Get duration sub object
	            //String id = like.getString("id"); 
	           // System.out.println(name+" "+id);
				output+=name+"\n";
				
			}
			output+="Comments:\n";
			for(i=0; i < comments.length(); i++) 
			{ // Loop over each each row
	            JSONObject comment = comments.getJSONObject(i); // Get row object
	            //System.out.println(like);
	            String name = comment.getString("name"); // Get duration sub object
	            String descr = comment.getString("content"); 
	            //System.out.println(name+" "+id);
	            output+=name+":"+descr+"\n";
			}
		}
		System.out.println(output);
		
		
	}
	
}
