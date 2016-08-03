package com.au.adportal.dao;

import java.util.ArrayList;

import com.au.adportal.model.Category;
import com.au.adportal.model.Location;
import com.au.adportal.model.Post;
import com.au.adportal.model.User;

public interface DaoInterface {
	public boolean makeAdmin(String email);

	public boolean blackList(String email);

	public boolean deletePost(int postId);

	public boolean createLocation(String location);

	public boolean createCategory(String category);

	public int addPost(Post post);

	public int editPost(Post post);

	public ArrayList<Post> getPosts(int locationId, String title, int minPrice, int maxPrice, int categoryID);

	public boolean contact(int postId);

	public ArrayList<Category> getCategories();

	public ArrayList<Location> getLocations();

	public Post getPost(int id);
	
	public String getCategoryName(int categoryid);
	
	public String getLocationName(int locationid);
	
	public User getUser(String userid);
	
	public boolean addUser(User user);

}
