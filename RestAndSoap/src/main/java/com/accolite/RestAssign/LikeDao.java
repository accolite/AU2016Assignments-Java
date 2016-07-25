package com.accolite.RestAssign;

import java.io.File;

import org.json.*;

public class LikeDao {
	File file = new File("C:/Users/SUKO-HYD-01/Desktop/Likes.txt");
	public String getLikeById(int id) {
		// TODO Auto-generated method stub
		JSONObject JSONObject = new Helper().getJSONObjectFromFile(file);
		JSONArray JSONArr = JSONObject.getJSONArray("likes");
		for(int i=0; i<JSONArr.length(); i++)
		{
			JSONObject u = (JSONObject) JSONArr.get(i);
			if(u.getInt("id") == id)
				return u.toString();
		}
		
		return null;
	}

	public String getLikeOnMessage(int messageId) {
		// TODO Auto-generated method stub
		JSONObject jsonObject = new Helper().getJSONObjectFromFile(file);
		JSONArray JSONArr = jsonObject.getJSONArray("likes");
		JSONArray newArr = new JSONArray();
		for(int i=0; i<JSONArr.length(); i++)
		{
			JSONObject u = (JSONObject) JSONArr.get(i);
			if(u.getInt("messageId") == messageId)
				newArr.put(u);
		
		}
		
		jsonObject = new JSONObject().put("likes", newArr);
		return jsonObject.toString();
	}

	public String getAllLikes() {
		// TODO Auto-generated method stub
		return new Helper().getJSONObjectFromFile(file).toString();
	}

	public String getLikeByUser(int userId) {
		// TODO Auto-generated method stub
		JSONObject jsonObject = new Helper().getJSONObjectFromFile(file);
		JSONArray JSONArr = jsonObject.getJSONArray("likes");
		JSONArray newArr = new JSONArray();
		for(int i=0; i<JSONArr.length(); i++)
		{
			JSONObject u = (JSONObject) JSONArr.get(i);
			if(u.getInt("userId") == userId)
				newArr.put(u);		
		}
		
	    jsonObject = new JSONObject().put("likes", newArr);
		return jsonObject.toString();
	}

}
