package com.au.proma.model;

import java.sql.Date;

import com.au.proma.util.Colour;

public class Sprint {
	private int sprint_id;
	private Date startdate;
	private Date enddate;
	private String milestone;
	private Colour colour;
	private int completed;
	public Colour getColour() {
		return colour;
	}
	public void setColour(Colour colour) {
		this.colour = colour;
	}
	
	public int getCompleted() {
		return completed;
	}
	public void setCompleted(int completed) {
		this.completed = completed;
	}
	public int getSprint_id() {
		return sprint_id;
	}
	public void setSprint_id(int sprint_id) {
		this.sprint_id = sprint_id;
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
	public String getMilestone() {
		return milestone;
	}
	public void setMilestone(String milestone) {
		this.milestone = milestone;
	}
	public Sprint(int sprint_id, Date startdate, Date enddate, String milestone, int completed) {
		super();
		this.sprint_id = sprint_id;
		this.startdate = startdate;
		this.enddate = enddate;
		this.milestone = milestone;
		this.completed = completed;
	}
	public Sprint() {
		// TODO Auto-generated constructor stub
	}
	
	
}
