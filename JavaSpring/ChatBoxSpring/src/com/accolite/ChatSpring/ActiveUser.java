package com.accolite.ChatSpring;

import java.util.ArrayList;
import java.util.List;

public class ActiveUser {
	List<String> active_user=new ArrayList<String>();

	
	public List<String> getActive_user() {
		
		return active_user;
	}
	

	public void setActive_user(String username) {
		active_user.add(username);
		
	}
	

}
