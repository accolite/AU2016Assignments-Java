package com.accolite.Servlets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataClass {
	
	private static Map<String, String> Users = new HashMap<String, String>();
	
	private static List<String> Messages = new ArrayList<String>();

//	public static Map<String, String> getUsers() {
//		return Users;
//	}

	public static void setUsers(Map<String, String> users) {
		Users = users;
	}

//	public static List<String> getMessages() {
//		return Messages;
//	}

	public static void setMessages(List<String> messages) {
		Messages = messages;
	}
	
}
