package com.accolite.chat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/registerusers")
public class AddingUser {

	public static void newUser(String name,String loginId, String passwordUser) throws ParseException, JSONException, IOException {
		int j;
		String content = new Scanner(new File(name)).useDelimiter("\\Z").next();
		JSONObject rootObject = new JSONObject(content);
		JSONObject registeredUsers = rootObject.getJSONObject("registeredUsers");
		JSONArray users=registeredUsers.getJSONArray("users");



		JSONObject registerUser = new JSONObject();
		registerUser.put("userid",loginId);
		registerUser.put("password", passwordUser);
		users.put(registerUser);
		FileWriter file;
		file = new FileWriter(name);
		file.write(rootObject.toString());
		file.flush();
		file.close();
		return;
	}



@POST
@Path("adduser")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public String addComments(@QueryParam(value = "id") String ID, @QueryParam(value = "password") String userPassword) throws JSONException, IOException {
	try {
		newUser("D:/Projects On Eclipse/ChatBoardApplication/WebContent/messages.json",ID,userPassword);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "Successfully Added User";
}
}
