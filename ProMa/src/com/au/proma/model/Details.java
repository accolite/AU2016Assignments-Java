package com.au.proma.model;

public class Details {
String role;
Boolean loggedin;

public Details() {
	super();
}
public Details(String role, Boolean loggedin) {
	super();
	this.role = role;
	this.loggedin = loggedin;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public Boolean getLoggedin() {
	return loggedin;
}
public void setLoggedin(Boolean loggedin) {
	this.loggedin = loggedin;
}

}
