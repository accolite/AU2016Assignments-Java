package com.springdemo.tutorial.servlets;

import java.util.ArrayList;
import java.util.HashMap;

public class tempstuffs {
	
	private static String admin[]={"admin","admin"};
	private static HashMap<String,String> users=new HashMap<>();
	private static ArrayList<String> activeusers=new ArrayList<>();
	private static ArrayList<String> banwords=new ArrayList<String>() {{
	    add("ban");
	    add("fuck");
	    add("blah");
	}};
	private static String chats="";
	public static String[] getAdmin() {
		return admin;
	}
	public static ArrayList<String> getActiveusers() {
		return activeusers;
	}
	public static void setActiveusers(ArrayList<String> activeusers) {
		tempstuffs.activeusers = activeusers;
	}
	public static String getChat() {
		return chats;
	}
	public static void setChat(String chats) {
		tempstuffs.chats = chats;
	}
	public static HashMap<String, String> getUsers() {
		return users;
	}
	public static void setUsers(HashMap<String, String> users) {
		tempstuffs.users = users;
	}
	public static ArrayList<String> getBanwords() {
		return banwords;
	}
	public static void setBanwords(ArrayList<String> banwords) {
		tempstuffs.banwords = banwords;
	}
}
