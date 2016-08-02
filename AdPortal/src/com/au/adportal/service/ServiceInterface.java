package com.au.adportal.service;

import java.util.ArrayList;

import com.au.adportal.model.Category;
import com.au.adportal.model.CurrentUser;
import com.au.adportal.model.Location;
import com.au.adportal.model.Post;

public interface ServiceInterface {
	
	public boolean makeAdmin(CurrentUser user, String email);
	
	public boolean blacklist(CurrentUser user, String email);
	
	public boolean createLocation(CurrentUser user, String location);
	
	public boolean createCategory(CurrentUser user, String category);
	
	public int addPost(CurrentUser user, Post post);
	
	public boolean deletePost(CurrentUser user, Integer postid);
	
	public ArrayList<Post> getAllPosts(CurrentUser user, String title, Integer location, Integer minPrice, Integer maxPrice, Integer category);
	
	public int editPost(CurrentUser user, Post post);
	
	public String[] getContactInfo(CurrentUser user, Integer postid);
	
	public boolean contact(CurrentUser user, Integer postid, String message);
	
	public ArrayList<Category> getCategories();
	
	public ArrayList<Location> getLocations();
	
	public Post getPost(CurrentUser user, Integer postid);
	
}
