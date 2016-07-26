package com.accolite.chat;

import java.util.ArrayList;
import java.util.HashMap;

public class MapGlobal {

	public static HashMap<String, String> registeredUsers = new HashMap<String, String>();//List of registered Users
	public static HashMap<String, String> activeUsers = new HashMap<String, String>();//List of active Users
	public static ArrayList<String> chatsRecord=new ArrayList<String>(); 
	public static ArrayList<String> prohibitedWords=new ArrayList<String>(); 
	
}
