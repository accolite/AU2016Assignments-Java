package com.accolite.chat;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class practice {

		
		public static void main(String[] args) throws FileNotFoundException, JSONException {
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
				if(loginid.equals("sachin")&&pass.equals("hey"))
				{
					System.out.println(loginid);
				}
						
			}
	}
	}

