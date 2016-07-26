package com.accolite.Servlets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class mainClass {
	
	private static Map<String, String> Users = new HashMap<String, String>();
	
	private static List<String> Messages = new ArrayList<String>();
	
	private static Set<String> ActiveUsers = new HashSet<String>();
	
	private static List<String> Filters = new ArrayList<String>();
	
	public static List<String> getFilters() {
		return Filters;
	}

	public static void setFilters(List<String> filters) {
		Filters = filters;
	}

	
	public static Map<String, String> getUsers() {
		return Users;
	}

	public static void setUsers(Map<String, String> users) {
		Users = users;
	}

	
	public static Set<String> getActiveUsers() {
		return ActiveUsers;
	}

	public static void setActiveUsers(Set<String> activeUsers) {
		ActiveUsers = activeUsers;
	}

	public static List<String> getMessages() {
		return Messages;
	}

	public static void setMessages(List<String> messages) {
		Messages = messages;
	}
	
	
	
}
