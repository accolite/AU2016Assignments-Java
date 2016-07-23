package com.accolite.Assignment;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDetails {

	private Map<String, Users> users;

	public UserDetails() {
		super();
		users = new HashMap<String, Users>();
		users.put("Jegan", new Users(1,"Jegan",new Date()));
		users.put("Loki", new Users(2,"Log10",new Date()));
	}
	
	public List<Users> getAllUsers()
	{
		return new ArrayList<Users>(users.values());
	}

}
