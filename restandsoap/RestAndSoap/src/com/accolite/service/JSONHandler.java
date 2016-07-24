package com.accolite.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONHandler {
	JSONParser parser;
	JSONArray userArray;
	JSONObject user;
	int userIndex;
	File f;
//	@SuppressWarnings("unchecked")
	public JSONHandler(String name) {
		parser = new JSONParser();
		f = new File("FBdata.json");
//		f.delete();
		if(f.exists()){
			try {
				userIndex=0;
				userArray=(JSONArray) parser.parse(new FileReader(f));
				for(Object u:userArray){
					JSONObject usr=(JSONObject)u;
					if(name.equals((String)usr.get("name"))){
						user=usr;
						break;
					}
					userIndex++;
				}
			}  catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				f.createNewFile();
				userArray = new JSONArray();
				user=new JSONObject();
				user.put("name", "log10");
				JSONArray userMessage=new JSONArray();
				JSONObject message=new JSONObject();
				message.put("id", 0);
				message.put("message","Happy Fun Friday");
				message.put("like", 0);
				JSONArray messageComment=new JSONArray();
				JSONObject comment=new JSONObject();
				comment.put("id", 0);
				comment.put("name", "jegan");
				comment.put("comment", "boring pa!");
				messageComment.add(comment);
				message.put("comment", messageComment);
				userMessage.add(message);
				user.put("message", userMessage);
				userArray.add(user);
				FileWriter fw=new FileWriter(f);
				userArray.writeJSONString(fw);
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void addMessage(String message){
		JSONObject msg=new JSONObject();
		JSONArray userMsg=(JSONArray)user.get("message");
		msg.put("id",""+userMsg.size()+1);
		msg.put("message", message);
		msg.put("like", 0);
		msg.put("comment",new JSONArray());
		userMsg.add(msg);
		user.put("message", userMsg);
		userArray.set(userIndex, user);
		try {
			FileWriter fw=new FileWriter(f);
			userArray.writeJSONString(fw);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getMessage(){
		JSONArray userMsg=(JSONArray)user.get("message");
//		System.out.println(userMsg+"\n"+userMsg.toJSONString());
		return userMsg.toJSONString();
	}
	public String getAllMessage(){
		return userArray.toJSONString();
	}
	public void addComment(int messageID, String comment, String name) {
		JSONArray userMsg = (JSONArray) user.get("message");
		JSONObject message = (JSONObject) userMsg.get(messageID);
		if(message==null)
			return;
		JSONArray comments = (JSONArray) message.get("comment");
		JSONObject cmnt = new JSONObject();
		cmnt.put("id", "" + comments.size() + 1);
		cmnt.put("name", name);
		cmnt.put("comment", comment);
		comments.add(cmnt);
		message.put("comment", comments);
		userMsg.set(messageID, message);
		user.put("message", userMsg);
		userArray.set(userIndex, user);
		try {
			FileWriter fw=new FileWriter(f);
			userArray.writeJSONString(fw);
			fw.close();
			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getComment(int messageID, int commentID){
		JSONArray userMsg=(JSONArray)user.get("message");
		JSONObject message=(JSONObject)userMsg.get(messageID);
		if(message==null)
			return "";
		JSONArray comments = (JSONArray)message.get("comment");
		JSONObject comment=(JSONObject)comments.get(commentID);
		if(comment!=null)
			return comment.toJSONString();
		return "";
	}
	public String getAllComment(int messageID){
		JSONArray userMsg=(JSONArray)user.get("message");
		JSONObject message=(JSONObject)userMsg.get(messageID);
		if(message==null)
			return "";
		JSONArray comments = (JSONArray)message.get("comment");
		return comments.toJSONString();
	}
	public void addLike(int messageID){
//		System.out.println(messageID+" "+user);
		JSONArray userMsg=(JSONArray)user.get("message");
		JSONObject message=(JSONObject)userMsg.get(messageID);
		if(message==null)
			return;
		int likes=-1;
		try{
			likes=((Integer)message.get("like")).intValue();
		}catch(ClassCastException e){
			likes=((Long)message.get("like")).intValue();
		}
//		System.out.println(likes+" "+message.get("like"));
		message.put("like", likes+1);
//		System.out.println(message.get("like"));
		userMsg.set(messageID, message);
		user.put("message", userMsg);
		userArray.set(userIndex, user);
		try {
			FileWriter fw=new FileWriter(f);
			userArray.writeJSONString(fw);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(new JSONHandler("log10").getLikes(messageID));
	}
	public int getLikes(int messageID){
		JSONArray userMsg=(JSONArray)user.get("message");
		JSONObject message=(JSONObject)userMsg.get(messageID);
		if(message==null)
			return -1;
		try{
			return ((Integer)message.get("like")).intValue();
		}catch(ClassCastException e){
			return ((Long)message.get("like")).intValue();
		}
	}
//	public static void main(String[]args){
//		JSONHandler jh=new JSONHandler("log10");
//		System.out.println(jh.getMessage());
//		jh.addMessage("Happy Week end");
//		System.out.println(jh.getMessage());
//		jh.addLike(1);
//		System.out.println(jh.getLikes(1));
//		jh.addComment(1, "week end sollave illa", "jegan");
//		System.out.println(jh.getAllComment(1));
//		System.out.println(jh.getComment(1, 0));
//	}
}
