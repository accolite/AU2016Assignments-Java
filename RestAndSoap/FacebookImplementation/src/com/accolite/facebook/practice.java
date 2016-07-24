package com.accolite.facebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.ws.rs.QueryParam;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class practice {

	public static void main(String[] args) throws JSONException, IOException {
	

		int j,i;
		String output="";
		String content = new Scanner(new File("D:/Projects On Eclipse/FacebookImplementation/WebContent/WEB-INF/messages.json")).useDelimiter("\\Z").next();
		JSONObject rootObject = new JSONObject(content);
		JSONArray listOfmessages = rootObject.getJSONArray("messageList");

		for(j=0;j<listOfmessages.length();j++)
		{
			JSONObject getMessageObject=listOfmessages.getJSONObject(j);

			String messageId=getMessageObject.getString("messageid");
			if(messageId.equals("1")){
					
				output+=getMessageObject.getString("description")+"\n";
				output+="\nComments:\n";
				

				JSONArray comments = getMessageObject.getJSONArray("comments");


				for(i=0; i < comments.length(); i++) 
				{ 
					JSONObject comm = comments.getJSONObject(i); 
					String name = comm.getString("name"); 
					String desc = comm.getString("content");
					output+=name+":"+desc+'\n';


				}
				System.out.println(output);
			}

		}

	}
}
	
