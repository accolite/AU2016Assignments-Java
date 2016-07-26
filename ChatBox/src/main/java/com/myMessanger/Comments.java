package com.myMessanger;


import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


@Path("Comments")

public class Comments  {
	
	void populateJson(CommentsPojo commentsPojo,String msg_id) {
		Object obj;
		try {
			File file = new File("D:\\Files\\Comment.json");

			JSONObject jsonObj = new JSONObject();
			jsonObj.put("comment", commentsPojo.getComment());
			jsonObj.put("comment_id", commentsPojo.getComment_id());
			jsonObj.put("user_id", commentsPojo.getUser_id());
			jsonObj.put("time", commentsPojo.getTime());
			
			JSONParser jsonParser=new JSONParser();
			Object obj1 = jsonParser.parse(new FileReader(file));
			JSONObject jsonObject = (JSONObject) obj1;
			if(jsonObject.containsKey(msg_id))
			{
				JSONArray comments = (JSONArray) jsonObject.get(msg_id);
				comments.add(jsonObj);
				System.out.println(comments);
			}
			else
			{
				JSONArray comments = new JSONArray();
				comments.add(jsonObj);
				jsonObject.put(msg_id, comments);
				System.out.println(jsonObject);

			}

			PrintWriter out=new PrintWriter(file);
			out.write( jsonObject.toJSONString());
			out.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@GET
	@Path("{msg_id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessageById(@PathParam("msg_id") String msg_id) {

		JSONParser parser = new JSONParser();
		String all_comments = "";
		try {
			File file = new File("D:\\Files\\Comment.json");
			Object obj = parser.parse(new FileReader(file));
			ArrayList<CommentsPojo> sortit = new ArrayList<CommentsPojo>();
			JSONObject jsonObject = (JSONObject) obj;
			
			JSONArray comments = (JSONArray) jsonObject.get(msg_id);
			for (Object object : comments) {
				JSONObject m = (JSONObject) object;
				String comment_json = (String) m.get("comment");
				String time = (String) m.get("time");
				String user_id=(String)m.get("user_id");
				String comment_id=(String)m.get("comment_id");
				CommentsPojo commentsPojo=new CommentsPojo(comment_id, time, user_id, comment_json);
				sortit.add(commentsPojo);
			}
			Collections.sort(sortit, new CommentsPojo());
			for (CommentsPojo s : sortit) {
				System.out.println(s.comment + " " + s.time);
				all_comments += s.comment + " at  " + s.time + " by user "+s.user_id+"<br> ";
			}
			return all_comments;

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "hello world";
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{msg_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public CommentsPojo saveComment( CommentsPojo commentsPojo, @PathParam("msg_id") String msg_id) {
		commentsPojo.setComment(commentsPojo.getComment());
		
		this.populateJson(commentsPojo,msg_id);
		return commentsPojo;

	}
}

