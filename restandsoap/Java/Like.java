package com.accolite.Messanger.messanger;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Like {

	private int like_id;
	private int user_id;
	private int post_id;
	private String time_liked;
	
	public Like(){
		
	}
	

	public Like(int like_id, int user_id, int post_id, String time_liked) {
		this.like_id = like_id;
		this.user_id = user_id;
		this.post_id = post_id;
		this.time_liked = time_liked;
	}
	
	public int getLike_id() {
		return like_id;
	}
	public void setLike_id(int like_id) {
		this.like_id = like_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getTime_liked() {
		return time_liked;
	}
	public void setTime_liked(String time_liked) {
		this.time_liked = time_liked;
	}
}
