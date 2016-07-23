package com.accolite.Messanger.messanger;

import java.io.FileReader;

import javax.json.JsonObject;
import javax.json.stream.JsonParser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParserc {
	
	JSONArray dojson(){
		JSONParser parser = new JSONParser();
		//String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
	      try{
	         //Object obj = parser.parse(s);
	         Object obj = parser.parse(new FileReader("d:\\db.json"));
	         JSONObject jsonObject = (JSONObject) obj;
	         JSONArray ja = (JSONArray)jsonObject.get("messagelist");
	         //JSONArray ja=(JSONArray)jobj;
	         return(ja);
	         
	         //System.out.println();
	         
	      }catch(Exception pe){
			return null;
	      }
	}
}
