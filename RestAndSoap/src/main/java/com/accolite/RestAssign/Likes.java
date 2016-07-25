package com.accolite.RestAssign;

import java.io.File;
import java.io.InputStream;

import org.json.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/UserService")
public class Likes {
	
	@PUT
	@Path("/like")
	@Consumes(MediaType.TEXT_PLAIN)
	public void likeMessage(InputStream incomingData){
		File file = new File("C:/Users/SUKO-HYD-01/Desktop/Likes.txt");
		Helper helper = new Helper();
		String JSONString = helper.readFile(file);
		String incomingJSON = helper.readIncomingStream(incomingData);
		JSONObject js = helper.extractJSONObject(JSONString);
		js.getJSONArray("likes").put(helper.extractJSONObject(incomingJSON));
		new Helper().saveFile(js, file);
	}
	
	@GET
	@Path("/getLikes")
	@Produces(MediaType.TEXT_PLAIN)
	public String getLikesOnMessage(@DefaultValue("-1") @QueryParam("id") int id,
			@DefaultValue("-1") @QueryParam("messageId") int messageId,
			@DefaultValue("-1") @QueryParam("userId") int userId){
		LikeDao likeDao = new LikeDao();
		String JSONObject;
		if(id != -1)
			JSONObject = likeDao.getLikeById(id);
		else if(messageId != -1)
			JSONObject = likeDao.getLikeOnMessage(messageId);
		else if(userId != -1)
			JSONObject = likeDao.getLikeByUser(userId);
		else
			JSONObject = likeDao.getAllLikes();
		
		return JSONObject;
	}
}
