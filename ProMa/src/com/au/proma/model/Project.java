package com.au.proma.model;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement
@Component
public class Project{
	private int projectid;
	private Client client;
	private String projectname;
	private User projectmanager;
	private int resourceworking;
	private Date startdate;
	private Date enddate;
	private int status;
	private BU bu;
	public int getProjectid() {
		return projectid;
	}
	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public User getProjectmanager() {
		return projectmanager;
	}
	public void setProjectmanager(User projectmanager) {
		this.projectmanager = projectmanager;
	}
	public int getResourceworking() {
		return resourceworking;
	}
	public void setResourceworking(int resourceworking) {
		this.resourceworking = resourceworking;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public BU getBu() {
		return bu;
	}
	public void setBu(BU bu) {
		this.bu = bu;
	}
	public Project(int projectid, Client client, String projectname, User projectmanager, int resourceworking,
			Date startdate, Date enddate, int status, BU bu) {
		super();
		this.projectid = projectid;
		this.client = client;
		this.projectname = projectname;
		this.projectmanager = projectmanager;
		this.resourceworking = resourceworking;
		this.startdate = startdate;
		this.enddate = enddate;
		this.status = status;
		this.bu = bu;
	}
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}