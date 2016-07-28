package com.au.jndi;

public class employee {

private String name;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getProfile() {
	return profile;
}
public void setProfile(String profile) {
	this.profile = profile;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
private String profile;
private String email;
private int salary;
private int empid;
public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public int getMngid() {
	return mngid;
}
public void setMngid(int mngid) {
	this.mngid = mngid;
}
private int mngid;

public employee()
{
	name=null;
	profile=null;
	email=null;
	salary=0;
	empid=0;
	mngid=0;
}

}
