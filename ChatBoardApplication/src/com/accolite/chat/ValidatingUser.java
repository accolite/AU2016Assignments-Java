package com.accolite.chat;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.jws.soap.InitParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Path("allusers")
public class ValidatingUser {

	
	
	@GET
	@Path("users")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String validateUser(@QueryParam("id")String Id,@QueryParam("password")String userPassword) throws FileNotFoundException, JSONException
	{
		int j;
		String content = new Scanner(new File("D:/Projects On Eclipse/ChatBoardApplication/WebContent/messages.json")).useDelimiter("\\Z").next();
		JSONObject rootObject = new JSONObject(content);
		System.out.println(rootObject);
		JSONObject registeredUsers = rootObject.getJSONObject("registeredUsers");
		JSONArray users=registeredUsers.getJSONArray("users");
		for(j=0;j<users.length();j++)
		{
			JSONObject getUserObject=users.getJSONObject(j);
			String pass=getUserObject.getString("password");
			String loginid=getUserObject.getString("userid");
			if(loginid.equals(Id)&&pass.equals(userPassword))
				return "true";
			
					
		}
		return "false";
	}
}
