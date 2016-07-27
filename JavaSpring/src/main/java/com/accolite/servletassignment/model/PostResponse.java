package com.accolite.servletassignment.model;

public class PostResponse {
	private Post post;
	private String name;
	
	public PostResponse() {
		
	}
	
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String getUsername() {
		return name;
	}

	public void setUsername(String username) {
		this.name = username;
	}

	public PostResponse(Post post, String username) {
		super();
		this.post = post;
		this.name = username;
	}
	
	@Override
	public String toString(){
		return "<b>"+getPost().toString()+" <br/></b> "+getUsername();
	}
	
}
