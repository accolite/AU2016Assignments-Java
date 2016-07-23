package com.accolite.facebookdemo;

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

@Path("messages")
public class RestPractice {

	@GET
	@Path("Likes")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String viewLikes(@QueryParam("id")String Id) throws FileNotFoundException, JSONException
	{
		int i,j;
		String Result_String="";
		String content = new Scanner(new File("D:/Projects On Eclipse/FacebookImplementation/WebContent/WEB-INF/messages.json")).useDelimiter("\\Z").next();
		JSONObject MainObject = new JSONObject(content);
		JSONArray list = MainObject.getJSONArray("List_Of_Messages");

		for(j=0;j<list.length();j++)
		{
			JSONObject Message_GetObject=list.getJSONObject(j);

			String message_id=Message_GetObject.getString("message_id");
			Result_String+=Message_GetObject.getString("Detail");

			Result_String+="\nLiked By:";
			if(message_id.equals(Id))
			{


				JSONArray Likes = Message_GetObject.getJSONArray("Likes");


				for(i=0; i < Likes.length(); i++) 
				{
					JSONObject like = Likes.getJSONObject(i); 
					String name = like.getString("name"); 
					Result_String+=name+"\n";

				}
			}

		}
		return Result_String;
	}

	@GET
	@Path("Comments")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String viewComments(@QueryParam("id")String Id) throws FileNotFoundException, JSONException
	{
		int j,i;
		String Result_String="";
		String content = new Scanner(new File("D:/Projects On Eclipse/FacebookImplementation/WebContent/WEB-INF/messages.json")).useDelimiter("\\Z").next();
		JSONObject MainObject = new JSONObject(content);
		JSONArray list = MainObject.getJSONArray("List_Of_Messages");

		for(j=0;j<list.length();j++)
		{
			JSONObject Message_GetObject=list.getJSONObject(j);

			String message_id=Message_GetObject.getString("message_id");
			Result_String+=Message_GetObject.getString("Detail");

			Result_String+="\nComments:\n";
			if(message_id.equals(Id)){


				JSONArray Comments = Message_GetObject.getJSONArray("Comments");


				for(i=0; i < Comments.length(); i++) 
				{ 
					JSONObject comm = Comments.getJSONObject(i); 
					String name = comm.getString("name"); 
					String desc = comm.getString("content");
					Result_String+=name+":"+desc+'\n';


				}
			}

		}
		return Result_String;
	}

	
	

	public static void Message_Adding(String name, int Id, String messageContent, String personName,String personId) throws ParseException, JSONException, IOException {

		int j;
		String content = new Scanner(new File(name)).useDelimiter("\\Z").next();
		JSONObject MainObject = new JSONObject(content);
		JSONArray list = MainObject.getJSONArray("List_Of_Messages");

		JSONObject messageObject = new JSONObject();
		messageObject.put("message_id",Id);
		messageObject.put("owner_id", personId);
		messageObject.put("Detail", messageContent);
		messageObject.put("owner",personName);
		messageObject.put("Likes",new JSONArray());
		messageObject.put("commments",new JSONArray());
		list.put(messageObject);
		FileWriter file;
		file = new FileWriter(name);
		file.write(MainObject.toString());
		file.flush();
		file.close();

	}

	@GET
	@Path("Like_Add")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public void Like_Add(@QueryParam("id")String Id,@QueryParam("name")String Name,@QueryParam("messId")String message_id) throws JSONException, IOException
	{
		int j;
		
		String content = new Scanner(new File("D:/Projects On Eclipse/FacebookImplementation/WebContent/WEB-INF/messages.json")).useDelimiter("\\Z").next();
		JSONObject MainObject = new JSONObject(content);
		JSONArray list = MainObject.getJSONArray("List_Of_Messages");

		for(j=0;j<list.length();j++)
		{
			JSONObject Message_GetObject=list.getJSONObject(j);

			String messId=Message_GetObject.getString("message_id");
			if(messId.equals(Id)){


				JSONArray Likes = Message_GetObject.getJSONArray("Likes");

				JSONObject newLike = new JSONObject();
				newLike.put("name",Name );
				newLike.put("id", Id);

				Likes.put(newLike);
				FileWriter file;
				file = new FileWriter("D:/Projects On Eclipse/FacebookImplementation/WebContent/WEB-INF/messages.json");
				file.write(MainObject.toString());
				file.flush();
				file.close();
				return;
			}
		}
	}

	
	


	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String Message_Get() throws FileNotFoundException, JSONException
	{
		int j,i;
		String Result_String="";
		String content = new Scanner(new File("D:/Projects On Eclipse/FacebookImplementation/WebContent/WEB-INF/messages.json")).useDelimiter("\\Z").next();
		JSONObject MainObject = new JSONObject(content);
		JSONArray list = MainObject.getJSONArray("List_Of_Messages");

		for(j=list.length()-1;j>=0;j--)
		{
			JSONObject Message_GetObject=list.getJSONObject(j);

			//String owner_id=Message_GetObject.getString("owner_id");
			String owner=Message_GetObject.getString("owner");
			String Detail=Message_GetObject.getString("Detail");
			Result_String+="Owner:"+owner+"\nMessage:"+Detail+"\nLikedBy:";
			JSONArray Likes = Message_GetObject.getJSONArray("Likes");
			JSONArray Comments = Message_GetObject.getJSONArray("Comments");



			for(i=0; i < Likes.length(); i++) 
			{ 
				JSONObject like = Likes.getJSONObject(i);
				String name = like.getString("name"); 
				Result_String+=name+"\n";

			}
			Result_String+="Comments:\n";
			for(i=0; i < Comments.length(); i++) 
			{ // Loop over each each row
				JSONObject comment = Comments.getJSONObject(i); 
				//System.out.println(like);
				String name = comment.getString("name"); 
				String descr = comment.getString("content"); 
				//System.out.println(name+" "+id);
				Result_String+=name+":"+descr+"\n";
			}
		}
		return Result_String;
	}

	
	
	

	public static void newComment(String name, int Id, String commentContent, String personName,String personId) throws ParseException, JSONException, IOException {
		int j;
		String content = new Scanner(new File(name)).useDelimiter("\\Z").next();
		JSONObject MainObject = new JSONObject(content);
		JSONArray list = MainObject.getJSONArray("List_Of_Messages");

		for(j=0;j<list.length();j++)
		{
			JSONObject Message_GetObject=list.getJSONObject(j);

			String messId=Message_GetObject.getString("message_id");
			if(messId.equals(Id)){


				JSONArray Comments = Message_GetObject.getJSONArray("Comments");

				JSONObject comment = new JSONObject();
				comment.put("content",commentContent);
				comment.put("name", personName);
				comment.put("userid", personId);
				Comments.put(comment);
				FileWriter file;
				file = new FileWriter(name);
				file.write(MainObject.toString());
				file.flush();
				file.close();
				return;
			}
		}
	}

	@POST
	@Path("Comment_Adding")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String Comment_Addings(@QueryParam(value = "message_id") int message_id, @QueryParam(value = "comment") String comment,
			@QueryParam(value = "name") String Name,@QueryParam(value = "id") String personId) throws JSONException, IOException {
		try {
			newComment("D:/Projects On Eclipse/FacebookImplementation/WebContent/WEB-INF/messages.json", message_id, comment, Name,personId);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Comment  Added Successfully ";
	}

	@POST
	@Path("Message_Adding")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String AddMessage(@QueryParam(value = "message_id") int message_id, @QueryParam(value = "addmess") String contentMessage,
			@QueryParam(value = "name") String Name,@QueryParam(value = "id") String personId) throws JSONException, IOException {
		try {
			Message_Adding("D:/Projects On Eclipse/FacebookImplementation/WebContent/WEB-INF/messages.json", message_id, contentMessage, Name,personId);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return " Message Added  Successfully";

	}








}
