package com.au.adportal.service;

import java.util.ArrayList;
import java.util.List;

import com.au.adportal.model.Category;
import com.au.adportal.model.CurrentUser;
import com.au.adportal.model.Location;
import com.au.adportal.model.Post;
import com.au.adportal.model.User;
import com.au.adportal.viewmodel.ViewPost;

public interface ServiceInterface {
	
	public boolean makeAdmin(CurrentUser user, String email);
	
	public boolean blacklist(CurrentUser user, String email);
	
	public boolean createLocation(CurrentUser user, String location);
	
	public boolean createCategory(CurrentUser user, String category);
	
	public int addPost(CurrentUser user, Post post);
	
	public boolean deletePost(CurrentUser user, Integer postid);
	
	public ArrayList<ViewPost> getAllPosts(CurrentUser user, String title, Integer location, Integer minPrice, Integer maxPrice, Integer category);
	
	public int editPost(CurrentUser user, Post post);
	
	public String[] getContactInfo(CurrentUser user, Integer postid);
	
	public boolean contact(CurrentUser user, Integer postid, String message);
	
	public ArrayList<Category> getCategories();
	
	public ArrayList<Location> getLocations();
	
	public Post getPost(CurrentUser user, Integer postid);
	
	public User getUser(String userid); 
	
	public boolean addUser(User user); 
	
	public boolean changeMobile(CurrentUser user, String mobile);
	
	public boolean addCategory(CurrentUser user, String categoryName);

	public boolean addLocation(CurrentUser user, String locationName);
	
	public boolean subscribe(CurrentUser user, Integer categoryid);
	
	public boolean unsubscribe(CurrentUser user, Integer categoryid);

	public List<Category> getSubscribedCategories(CurrentUser current_user);

	public List<User> getBlacklistedUsers(CurrentUser current_user);

	public List<User> getAdminUsers(CurrentUser current_user);

	public List<User> getAllUsers(CurrentUser current_user);

	public boolean unblacklist(CurrentUser current_user, String userId);

	
}
