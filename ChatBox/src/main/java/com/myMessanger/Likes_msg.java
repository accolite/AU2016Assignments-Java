package com.myMessanger;

import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@Path("Likes")

public class Likes_msg {

	void populateJson(Likes commentsPojo, String msg_id) {
		Object obj;
		try {
			File file = new File("D:\\Files\\likes.json");

			JSONObject jsonObj = new JSONObject();
			jsonObj.put("user_id", commentsPojo.getUser_id());

			JSONParser jsonParser = new JSONParser();
			Object obj1 = jsonParser.parse(new FileReader(file));
			JSONObject jsonObject = (JSONObject) obj1;
			if (jsonObject.containsKey(msg_id)) {
				JSONArray comments = (JSONArray) jsonObject.get(msg_id);
				comments.add(jsonObj);
				System.out.println(comments);
			} else {
				JSONArray comments = new JSONArray();
				comments.add(jsonObj);
				jsonObject.put(msg_id, comments);
				System.out.println(jsonObject);

			}

			PrintWriter out = new PrintWriter(file);
			out.write(jsonObject.toJSONString());
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
		int i = 0;

		try {
			File file = new File("D:\\Files\\likes.json");
			Object obj = parser.parse(new FileReader(file));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray likes = (JSONArray) jsonObject.get(msg_id);
			for (Object object : likes) {
				JSONObject m = (JSONObject) object;
				String comment_json = (String) m.get("user_id");
				i++;
				all_comments += " liked by " + comment_json;
			}
			all_comments +=" "+ i + " is the like count ";

			return all_comments;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "hello world";
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{msg_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Likes saveComment( Likes likes, @PathParam("msg_id") String msg_id) {
		likes.setUser_id(likes.getUser_id());
		this.populateJson(likes, msg_id);
		return likes;

	}
}
