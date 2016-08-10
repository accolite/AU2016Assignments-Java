package com.accolite.au.VideoPortal.model;

import java.sql.Date;
import java.util.List;

public class Video {
	private int video_id;
	private int user_id;
	private int approval_id;
	private String privacy;
	private String title;
	private String topic;
	private int event_id;
	private int statusFlag;
	private List<Comment> comment;
	private String url;
	private String groupname;
	private String eventname;
	private Date DateOfUpload;
	private Date DateOfEvent;
//	private Time time;
//
//	public Time getTime() {
//		return time;
//	}
//
//	public void setTime(Time time) {
//		this.time = time;
//	}

	public int getVideo_id() {
		return video_id;
	}

	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getApproval_id() {
		return approval_id;
	}

	public void setApproval_id(int approval_id) {
		this.approval_id = approval_id;
	}

	public String getPrivacy() {
		return privacy;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public int getStatusFlag() {
		return statusFlag;
	}

	public void setStatusFlag(int statusFlag) {
		this.statusFlag = statusFlag;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public void setUrl(String url) {
		// TODO Auto-generated method stub
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public Date getDateOfUpload() {
		return DateOfUpload;
	}

	public void setDateOfUpload(Date dateOfUpload) {
		DateOfUpload = dateOfUpload;
	}

	public Date getDateOfEvent() {
		return DateOfEvent;
	}

	public void setDateOfEvent(Date dateOfEvent) {
		DateOfEvent = dateOfEvent;
	}
}
