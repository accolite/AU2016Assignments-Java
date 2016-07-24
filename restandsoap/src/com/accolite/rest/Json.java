package com.accolite.rest;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import org.codehaus.jettison.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Path("Friendsbook")
public class Json {
 @GET
 @Produces(MediaType.APPLICATION_JSON)
 @Path("getMsg")
 public ArrayList<Message> getMessage()
 {
	 JSONParser parser = new JSONParser();
	 ArrayList<Message> list = new ArrayList<Message>();
	 try {
		FileReader file=new FileReader("D://restandassignment/MessageJSON.txt");
	} catch (FileNotFoundException e1) {
		
		e1.printStackTrace();
	}
	 try {
		Object obj = parser.parse(new FileReader("D://restandassignment/MessageJSON.txt"));
		JSONObject jsonObject = (JSONObject) obj;
		JSONArray jsonArray = (JSONArray) jsonObject.get("messages");
		for(int i=0; i<jsonArray.size(); i++){
		JSONObject newObj = (JSONObject) jsonArray.get(i);
		int pid = ((Long) newObj.get("pid")).intValue();
		System.out.println(pid);
		 Message m=new Message();
		int id = ((Long) newObj.get("mid")).intValue();
		System.out.println(id);
		int cid = ((Long) newObj.get("cid")).intValue();
		System.out.println(cid);
		
		String n=(String) newObj.get("Msg");
		m.setPid(pid);
		m.setMid(id);
		m.setMsg(n);
		m.setCid(cid);
		list.add(m);
		}
   return list;		
		
		
	 
	 } catch (FileNotFoundException e) {
		
		e.printStackTrace();
	} catch (IOException e) {
		
		e.printStackTrace();
	} catch (ParseException e) {
		
		e.printStackTrace();
	}
	 return list;
 }


 @POST
 @Consumes(MediaType.TEXT_PLAIN)
 //@Produces(MediaType.APPLICATION_JSON)
 @Path("posting")
 @SuppressWarnings("unchecked")
 public JSONObject putMessage(String mess) throws JSONException, IOException
  {
   JSONObject obj = new JSONObject();
   JSONParser parser = new JSONParser();
   //Message message = new Message();
   try {
	obj = (JSONObject) parser.parse(mess);
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
   
   BufferedReader reader = new BufferedReader(new FileReader("D://restandassignment/MessageJSON.txt"));
   String jsonString = reader.readLine();
   JSONParser parser1 = new JSONParser();
   JSONObject object = null;
   try {
	   object = (JSONObject) parser1.parse(jsonString);
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
   ((JSONArray)object.get("messages")).add(obj);
   FileWriter file = new FileWriter("D://restandassignment/MessageJSON.txt",false);
   file.write (object.toString());
   System.out.println("Successfully Copied JSON Object to File...");
   System.out.println("\nJSON Object: " + obj);
   file.close();
    return obj;
   
  }
 @SuppressWarnings("unchecked")
 @POST
 @Consumes(MediaType.APPLICATION_JSON)
// @Produces(MediaType.APPLICATION_JSON)
 @Path("commenting")
  public JSONObject putCommentToMessage(String mess) throws JSONException, IOException
  {

	 JSONObject obj = new JSONObject();
	   JSONParser parser = new JSONParser();
	   //Message message = new Message();
	   try {
		obj = (JSONObject) parser.parse(mess);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	   BufferedReader reader = new BufferedReader(new FileReader("D://restandassignment/MessageJSON.txt"));
	   String jsonString = reader.readLine();
	   JSONParser parser1 = new JSONParser();
	   JSONObject object = null;
	   try {
		   object = (JSONObject) parser1.parse(jsonString);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   ((JSONArray)object.get("messages")).add(obj);
	   int cid = ((Long) obj.get("cid")).intValue();
	   if(cid ==1)
	   {
	   FileWriter file = new FileWriter("D://restandassignment/MessageJSON.txt",false);
	   file.write (object.toString());
	   System.out.println("Successfully Copied JSON Object to File...");
	   System.out.println("\nJSON Object: " + obj);
	   file.close();
	   }
	   else
	   {
	   }
	    return obj;
  }
}