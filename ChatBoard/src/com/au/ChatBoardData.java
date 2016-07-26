package com.au;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ChatBoardData {
	private static volatile ChatBoardData chatboard;

	private Set<String> activeUsers;
	private ArrayList<String> filter;
	private String chatHistory;
	private ChatBoardData() {
		activeUsers=new HashSet<String>();
		filter=new ArrayList<String>();
		chatHistory="";
	}

	public static ChatBoardData getDataInstance() {
		if (chatboard == null) {
			chatboard = new ChatBoardData();
		}
		return chatboard;
	}
	
	public void addFilter(String words) {
		//System.out.println(words);
		String[] word = words.split(",");
		for (String w : word) {
			filter.add(w);
			//System.out.println(w);
		}
	}
	
	public String[] getFilters() {
		String[]filters=new String[this.filter.size()];
		this.filter.toArray(filters);
		return filters;
	}
	
	public String[] getActiveUsers() {
		String[]Activeusers=new String[this.activeUsers.size()];
		this.activeUsers.toArray(Activeusers);
		return Activeusers;
	}
	
	public void addMessage(String User,String message){
		chatHistory=chatHistory+"<br>"+User+" : "+message;
	}
	
	public String getChatHistory(){
		return chatHistory;
	}
	
	public void makeUserActive(String User){
		activeUsers.add(User);
	}
	
	public void removeActiveUser(String User){
		activeUsers.remove(User);
	}
	
}
