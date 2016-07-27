package com.accolite.servletassignment.model;


public class Post {
	
	private int post_id;
	private String post_content;
	private int user_id;
	private String time_posted;
	
public Post(){
	
}
	
public Post(int post_id, String post_content, int user_id, String time_posted) {
		this.post_id = post_id;
		this.post_content = post_content;
		this.user_id = user_id;
		this.time_posted = time_posted;
	}


public int getPost_id() {
	return post_id;
}
public void setPost_id(int post_id) {
	this.post_id = post_id;
}
public String getPost_content() {
	return post_content;
}
public void setPost_content(String post_content) {
	this.post_content = post_content;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getTime_posted() {
	return time_posted;
}
public void setTime_posted(String time_posted) {
	this.time_posted = time_posted;
}

@Override
public String toString(){
	return getPost_content()+" "+getTime_posted();
}

}
