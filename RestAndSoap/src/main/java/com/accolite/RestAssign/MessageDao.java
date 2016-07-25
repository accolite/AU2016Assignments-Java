package com.accolite.RestAssign;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import org.json.*;

public class MessageDao {
	File file = new File("C:/Users/SUKO-HYD-01/Desktop/Messages.txt");

	public JSONObject getAllMessages() {
		// TODO Auto-generated method stub
		JSONObject JSONObject = new Helper().getJSONObjectFromFile(file);
		return JSONObject;
	}

	public JSONObject getAllMessages(int userId) {
		// TODO Auto-generated method stub
		JSONObject jsonObject = new Helper().getJSONObjectFromFile(file);
		JSONArray JSONArr = jsonObject.getJSONArray("messages");
		for(int i=0; i<JSONArr.length(); i++)
		{
			JSONObject u = (JSONObject) JSONArr.get(i);
			if(u.getInt("userId") == userId)
				JSONArr.put(u);
		
		}
		return jsonObject;
	}

	public JSONObject getMessage(int messageId) {
		// TODO Auto-generated method stub
		JSONObject JSONObject = new Helper().getJSONObjectFromFile(file);
		JSONArray JSONArr = JSONObject.getJSONArray("messages");
		for(int i=0; i<JSONArr.length(); i++)
		{
			JSONObject u = (JSONObject) JSONArr.get(i);
			if(u.getInt("id") == messageId)
				return u;
		}
		
		return null;
	}
	
	public JSONObject getMessagesOfParentMessage(int messageId) {
		// TODO Auto-generated method stub
		JSONObject jsonObject = new Helper().getJSONObjectFromFile(file);
		JSONArray JSONArr = jsonObject.getJSONArray("messages");
		JSONArray newArr = new JSONArray();
		for(int i=0; i<JSONArr.length(); i++)
		{
			JSONObject u = (JSONObject) JSONArr.get(i);
			if(u.getInt("parentId") == messageId)
				newArr.put(u);
				
		}
		
		jsonObject = new JSONObject().put("messages", newArr);
		return jsonObject;
	}

}
