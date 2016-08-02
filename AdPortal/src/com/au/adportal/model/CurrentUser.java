package com.au.adportal.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS )
@Component
public class CurrentUser {
	private String id, name, email, role;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public CurrentUser(String id, String name, String email, String role) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
	}

	public CurrentUser() {
	}
	
	public CurrentUser(User user){
		this.id = user.getUserid();
		this.name = user.getUsername();
		this.email = user.getEmail();
	}
	
}
