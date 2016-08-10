package com.acc.model;

public class Group {
	private int _id;
	private int event_id;
	private String group_name;
	private Integer points;
	
	public Group() {
		super();
	}
	
	public Group(int _id, int event_id, String group_name, Integer points) {
		super();
		this._id = _id;
		this.event_id = event_id;
		this.group_name = group_name;
		this.points = points;
	}

	public int getGroup_id() {
		return _id;
	}

	public void setGroup_id(int _id) {
		this._id = _id;
	}

	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}
	
	@Override
	public String toString() {
		return "Group [group_id=" + _id + ", event_id=" + event_id + ", group_name=" + group_name + ", points="
				+ points + "]";
	}
	
	
}
