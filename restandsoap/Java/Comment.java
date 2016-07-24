package com.accolite.Messanger.messanger;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comment {
	

	public Comment(int comment_id, int post_id, int user_id, String comment, String time_commented) {
		this.comment_id = comment_id;
		this.post_id = post_id;
		this.user_id = user_id;
		this.comment = comment;
		this.time_commented = time_commented;
	}
	
	public Comment(){
		
	}
	
	private int comment_id;
	private int post_id;
	private int user_id;
	private String comment;
	private String time_commented;
	
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getTime_commented() {
		return time_commented;
	}
	public void setTime_commented(String time_commented) {
		this.time_commented = time_commented;
	}
}
