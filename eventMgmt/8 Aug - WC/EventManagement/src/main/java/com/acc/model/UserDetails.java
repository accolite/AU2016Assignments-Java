package com.acc.model;

import java.util.List;

public class UserDetails {
	private User user;
	private List<Role> roles;
	
	public UserDetails() {
		super();
	}
	public UserDetails(User user, List<Role> roles) {
		super();
		this.user = user;
		this.roles = roles;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	@Override
	public String toString() {
		return "UserDetails [user=" + user + ", roles=" + roles + "]";
	}
	
	
	
}
