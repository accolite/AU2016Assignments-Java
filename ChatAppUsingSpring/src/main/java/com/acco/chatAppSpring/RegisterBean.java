package com.acco.chatAppSpring;

public class RegisterBean {

	String userName;
	String password;
	
	public RegisterBean(String userName,String password) {
		this.userName = userName;
		this.password = password;
	}
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

}
