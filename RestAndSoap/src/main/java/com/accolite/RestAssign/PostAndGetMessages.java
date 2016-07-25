package com.accolite.RestAssign;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
import javax.ws.rs.core.Response;

@Path("/UserService")
public class PostAndGetMessages {
	
	@PUT
	@Path("/PostMessage")
	@Consumes(MediaType.TEXT_PLAIN)
	public void postMessage(String incomingData){
		File file = new File("C:/Users/SUKO-HYD-01/Desktop/Messages.txt");
		Helper helper = new Helper();
		String JSONString = helper.readFile(file);
		JSONObject js = helper.extractJSONObject(JSONString);
		js.getJSONArray("messages").put(helper.extractJSONObject(incomingData));
		new Helper().saveFile(js, file);
	}
	
	
	@GET
	@Path("/GetMessages")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessages(@DefaultValue("-1") @QueryParam("userId") int userId,
			@DefaultValue("-1") @QueryParam("messageId") int messageId,
			@DefaultValue("-1") @QueryParam("parentId") int parentId){
		MessageDao msDao = new MessageDao();
		JSONObject messageObject = null ;
		if(messageId != -1)
			messageObject = msDao.getMessage(messageId);
		else if(userId != -1)
			messageObject = msDao.getAllMessages(userId);
		else if(parentId != -1)
			messageObject = msDao.getMessagesOfParentMessage(parentId);
		else
			messageObject = msDao.getAllMessages();
		
		return messageObject.toString();
	}
	
}
