package com.acc.model;

import java.sql.Timestamp;

public class Event {
	private int _id;
	private String name;
	private String description;
	private String type;
	private Timestamp start_time;
	private Timestamp end_time;	
	private String venue;
	
	
	public Event() {
		super();
	}


	public Event(int _id, String name, String description, String type, Timestamp start_time, Timestamp end_time, String venue) {
		super();
		this._id = _id;
		this.name = name;
		this.description = description;
		this.type = type;
		this.start_time = start_time;
		this.end_time = end_time;
		this.venue = venue;
	}


	public int get_id() {
		return _id;
	}


	public void set_id(int _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Timestamp getStart_time() {
		return start_time;
	}


	public void setStart_time(Timestamp start_time) {
		this.start_time = start_time;
	}


	public Timestamp getEnd_time() {
		return end_time;
	}


	public void setEnd_time(Timestamp end_time) {
		this.end_time = end_time;
	}


	public String getVenue() {
		return venue;
	}


	public void setVenue(String venue) {
		this.venue = venue;
	}


	@Override
	public String toString() {
		return "Event [_id=" + _id + ", name=" + name + ", description=" + description + ", type=" + type
				+ ", start_time=" + start_time + ", end_time=" + end_time + ", venue=" + venue + "]";
	}
	
	
	
	
}
