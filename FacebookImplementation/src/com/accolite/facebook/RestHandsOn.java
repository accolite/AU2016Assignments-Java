/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 24, 2016

*

*  @author :: Sachin Gupta

* ***************************************************************************

*/
package com.accolite.facebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.Scanner;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// TODO: Auto-generated Javadoc
/**
 * The Class RestHandsOn.
 */
@Path("messages")
public class RestHandsOn {



	/**
	 * Adds the message.
	 *
	 * @param name the name
	 * @param Id the id
	 * @param messageContent the message content
	 * @param personName the person name
	 * @param personId the person id
	 * @throws ParseException the parse exception
	 * @throws JSONException the JSON exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void AddMessage(String name, int Id, String messageContent, String personName,String personId) throws ParseException, JSONException, IOException {

		int j;
		String content = new Scanner(new File(name)).useDelimiter("\\Z").next();
		JSONObject rootObject = new JSONObject(content);
		JSONArray listOfmessages = rootObject.getJSONArray("messageList");

		JSONObject messageObject = new JSONObject();
		messageObject.put("messageid",Id);
		messageObject.put("ownerid", personId);
		messageObject.put("description", messageContent);
		messageObject.put("owner",personName);
		messageObject.put("likes",new JSONArray());
		messageObject.put("commments",new JSONArray());
		listOfmessages.put(messageObject);
		FileWriter file;
		file = new FileWriter(name);
		file.write(rootObject.toString());
		file.flush();
		file.close();

	}




	/**
	 * Gets the message.
	 *
	 * @return the message
	 * @throws FileNotFoundException the file not found exception
	 * @throws JSONException the JSON exception
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String getMessage() throws FileNotFoundException, JSONException
	{
		int j,i;
		String output="";
		String content = new Scanner(new File("D:/Projects On Eclipse/FacebookImplementation/WebContent/WEB-INF/messages.json")).useDelimiter("\\Z").next();
		JSONObject rootObject = new JSONObject(content);
		JSONArray listOfmessages = rootObject.getJSONArray("messageList");

		for(j=listOfmessages.length()-1;j>=0;j--)
		{
			JSONObject getMessageObject=listOfmessages.getJSONObject(j);

			//String ownerid=getMessageObject.getString("ownerid");
			String owner=getMessageObject.getString("owner");
			String description=getMessageObject.getString("description");
			output+="Owner:"+owner+"\nMessage:"+description+"\nLikedBy:";
			JSONArray likes = getMessageObject.getJSONArray("likes");
			JSONArray comments = getMessageObject.getJSONArray("comments");



			for(i=0; i < likes.length(); i++) 
			{ 
				JSONObject like = likes.getJSONObject(i);
				String name = like.getString("name"); 
				output+=name+"\n";

			}
			output+="Comments:\n";
			for(i=0; i < comments.length(); i++) 
			{ // Loop over each each row
				JSONObject comment = comments.getJSONObject(i); 
				//System.out.println(like);
				String name = comment.getString("name"); 
				String descr = comment.getString("content"); 
				//System.out.println(name+" "+id);
				output+=name+":"+descr+"\n";
			}
		}
		return output;
	}

	/**
	 * View likes.
	 *
	 * @param Id the id
	 * @return the string
	 * @throws FileNotFoundException the file not found exception
	 * @throws JSONException the JSON exception
	 */
	@GET
	@Path("likes")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String viewLikes(@QueryParam("id")String Id) throws FileNotFoundException, JSONException
	{
		int j,i;
		String output="";
		String content = new Scanner(new File("D:/Projects On Eclipse/FacebookImplementation/WebContent/WEB-INF/messages.json")).useDelimiter("\\Z").next();
		JSONObject rootObject = new JSONObject(content);
		JSONArray listOfmessages = rootObject.getJSONArray("messageList");

		for(j=0;j<listOfmessages.length();j++)
		{
			JSONObject getMessageObject=listOfmessages.getJSONObject(j);

			String messageId=getMessageObject.getString("messageid");
			output+=getMessageObject.getString("description");

			output+="\nLiked By:";
			if(messageId.equals(Id))
			{


				JSONArray likes = getMessageObject.getJSONArray("likes");


				for(i=0; i < likes.length(); i++) 
				{
					JSONObject like = likes.getJSONObject(i); 
					String name = like.getString("name"); 
					output+=name+"\n";

				}
			}

		}
		return output;
	}


	/**
	 * View comments.
	 *
	 * @param Id the id
	 * @return the string
	 * @throws FileNotFoundException the file not found exception
	 * @throws JSONException the JSON exception
	 */
	@GET
	@Path("comments")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String viewComments(@QueryParam("id")String Id) throws FileNotFoundException, JSONException
	{
		int j,i;
		String output="";
		String content = new Scanner(new File("D:/Projects On Eclipse/FacebookImplementation/WebContent/WEB-INF/messages.json")).useDelimiter("\\Z").next();
		JSONObject rootObject = new JSONObject(content);
		JSONArray listOfmessages = rootObject.getJSONArray("messageList");

		for(j=0;j<listOfmessages.length();j++)
		{
			JSONObject getMessageObject=listOfmessages.getJSONObject(j);

			String messageId=getMessageObject.getString("messageid");
			output+=getMessageObject.getString("description");

			output+="\nComments:\n";
			if(messageId.equals(Id)){


				JSONArray comments = getMessageObject.getJSONArray("comments");


				for(i=0; i < comments.length(); i++) 
				{ 
					JSONObject comm = comments.getJSONObject(i); 
					String name = comm.getString("name"); 
					String desc = comm.getString("content");
					output+=name+":"+desc+'\n';


				}
			}

		}
		return output;
	}

	/**
	 * Adds the like.
	 *
	 * @param Id the id
	 * @param Name the name
	 * @param messageId the message id
	 * @throws JSONException the JSON exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@GET
	@Path("addlike")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public void addLike(@QueryParam("id")String Id,@QueryParam("name")String Name,@QueryParam("messId")String messageId) throws JSONException, IOException
	{
		int j;
		//String output="";
		String content = new Scanner(new File("D:/Projects On Eclipse/FacebookImplementation/WebContent/WEB-INF/messages.json")).useDelimiter("\\Z").next();
		JSONObject rootObject = new JSONObject(content);
		JSONArray listOfmessages = rootObject.getJSONArray("messageList");

		for(j=0;j<listOfmessages.length();j++)
		{
			JSONObject getMessageObject=listOfmessages.getJSONObject(j);

			String messId=getMessageObject.getString("messageid");
			if(messId.equals(Id)){


				JSONArray likes = getMessageObject.getJSONArray("likes");

				JSONObject newLike = new JSONObject();
				newLike.put("name",Name );
				newLike.put("id", Id);

				likes.put(newLike);
				FileWriter file;
				file = new FileWriter("D:/Projects On Eclipse/FacebookImplementation/WebContent/WEB-INF/messages.json");
				file.write(rootObject.toString());
				file.flush();
				file.close();
				return;
			}
		}
	}


	/**
	 * New comment.
	 *
	 * @param name the name
	 * @param Id the id
	 * @param commentContent the comment content
	 * @param personName the person name
	 * @param personId the person id
	 * @throws ParseException the parse exception
	 * @throws JSONException the JSON exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void newComment(String name, int Id, String commentContent, String personName,String personId) throws ParseException, JSONException, IOException {
		int j;
		String content = new Scanner(new File(name)).useDelimiter("\\Z").next();
		JSONObject rootObject = new JSONObject(content);
		JSONArray listOfmessages = rootObject.getJSONArray("messageList");

		for(j=0;j<listOfmessages.length();j++)
		{
			JSONObject getMessageObject=listOfmessages.getJSONObject(j);

			String messId=getMessageObject.getString("messageid");
			if(messId.equals(Id)){


				JSONArray comments = getMessageObject.getJSONArray("comments");

				JSONObject comment = new JSONObject();
				comment.put("content",commentContent);
				comment.put("name", personName);
				comment.put("userid", personId);
				comments.put(comment);
				FileWriter file;
				file = new FileWriter(name);
				file.write(rootObject.toString());
				file.flush();
				file.close();
				return;
			}
		}
	}

	/**
	 * Adds the comments.
	 *
	 * @param messageID the message ID
	 * @param comment the comment
	 * @param Name the name
	 * @param personId the person id
	 * @return the string
	 * @throws JSONException the JSON exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@POST
	@Path("addComment")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String addComments(@QueryParam(value = "messageid") int messageID, @QueryParam(value = "comment") String comment,
			@QueryParam(value = "name") String Name,@QueryParam(value = "id") String personId) throws JSONException, IOException {
		try {
			newComment("D:/Projects On Eclipse/FacebookImplementation/WebContent/WEB-INF/messages.json", messageID, comment, Name,personId);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Successfully Added Comment";
	}

	/**
	 * Addmsg.
	 *
	 * @param messageID the message ID
	 * @param contentMessage the content message
	 * @param Name the name
	 * @param personId the person id
	 * @return the string
	 * @throws JSONException the JSON exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@POST
	@Path("addmessage")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String addmsg(@QueryParam(value = "messageid") int messageID, @QueryParam(value = "addmess") String contentMessage,
			@QueryParam(value = "name") String Name,@QueryParam(value = "id") String personId) throws JSONException, IOException {
		try {
			AddMessage("D:/Projects On Eclipse/FacebookImplementation/WebContent/WEB-INF/messages.json", messageID, contentMessage, Name,personId);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Successfully Message Added";

	}








}
