package com.accolite.RestAssign;


import java.io.File;

import org.json.*;

public class UserDao {
	File file = new File("C:/Users/Vishal Goyal/Desktop/Users.txt");

	public String getAllUsers(){
		return new Helper().getJSONObjectFromFile(file).toString();
	}

	public String getUserById(int id) {
		// TODO Auto-generated method stub
		JSONObject JSONObject = new Helper().getJSONObjectFromFile(file);
		JSONArray JSONArr = JSONObject.getJSONArray("users");
		for(int i=0; i<JSONArr.length(); i++)
		{
			JSONObject u = (JSONObject) JSONArr.get(i);
			if(u.getInt("id") == id)
				return u.toString();
		}
		
		return null;
	}
}
