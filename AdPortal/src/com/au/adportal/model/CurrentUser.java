package com.au.adportal.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS )
@Component
public class CurrentUser {
	private String id, name, email, mobile;
	private int role;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public CurrentUser(String id, String name, String email, int role) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
	}

	public CurrentUser() {
	}
	
	public void setUser(User user){
		this.id = user.getUserid();
		this.name = user.getUsername();
		this.email = user.getEmail();
		this.role = user.getRole();
		this.mobile = user.getMobile();
	}
	
}
