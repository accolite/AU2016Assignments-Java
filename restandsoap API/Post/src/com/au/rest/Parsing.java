package com.au.rest;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public  class Parsing {
	
	JSONArray forParse(){
		JSONParser parser = new JSONParser();
		try{
	      Object obj = parser.parse(new FileReader("C:/Users/Shailendra Kumar/Desktop/data.json"));
	         JSONObject jsonObject = (JSONObject) obj;
	         JSONArray jArray = (JSONArray)jsonObject.get("messagelist");
	         return(jArray);
	         
	         
	      }catch(Exception pe){
			return null;
	      }
	}
}
