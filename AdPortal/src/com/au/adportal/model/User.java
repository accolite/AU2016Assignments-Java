package com.au.adportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Column
	@Id
	private String userid;
	@Column
	private String username;
	@Column
	private String email;
	@Column
	private String mobile;
	@Column
	private int role;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public User(String userid, String username, String email, String mobile, int role) {
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.mobile = mobile;
		this.role = role;
	}
	public User() {
	}
	
}
