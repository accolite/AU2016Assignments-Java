package com.au;

import java.util.ArrayList;
import java.util.HashMap;

public class tempstuffs {
	
	private static String admin[]={"admin","admin"};
	private static HashMap<String,String> users=new HashMap<>();
	private static String chat="";
	public static String[] getAdmin() {
		return admin;
	}
	public static String getChat() {
		return chat;
	}
	public static void setChat(String chat) {
		tempstuffs.chat = chat;
	}
	public static HashMap<String, String> getUsers() {
		return users;
	}
	public static void setUsers(HashMap<String, String> users) {
		tempstuffs.users = users;
	}
}
