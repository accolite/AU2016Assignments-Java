package com.au.adportal.service.impl;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.au.adportal.dao.DaoInterface;
import com.au.adportal.dao.impl.Dao;
import com.au.adportal.model.Category;
import com.au.adportal.model.CurrentUser;
import com.au.adportal.model.Location;
import com.au.adportal.model.Post;
import com.au.adportal.model.User;
import com.au.adportal.service.ServiceInterface;
import com.au.adportal.util.Status;
import com.au.adportal.viewmodel.ViewPost;

@Service
@Component
public class ServiceImplementation implements ServiceInterface {

	@Autowired
	DaoInterface dao;
	
	@Override
	public boolean makeAdmin(CurrentUser user, String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean blacklist(CurrentUser user, String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createLocation(CurrentUser user, String location) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createCategory(CurrentUser user, String category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	 public int addPost(CurrentUser user, Post post) {
	  // TODO Auto-generated method stub
	  post.setUserid(user.getId());
	  post.setStatus(Status.NEW);
	  Calendar calendar = Calendar.getInstance();
	  Date now = calendar.getTime();
	  Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
	  post.setCreatedDate(currentTimestamp);
	  return dao.addPost(post);
	 }

	@Override
	public boolean deletePost(CurrentUser user, Integer postid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	 public ArrayList<ViewPost> getAllPosts(CurrentUser user, String title, Integer location, Integer minPrice,
	   Integer maxPrice, Integer category) {
	  // TODO Auto-generated method stub
	  if(location==null)
	  {
	   location=0;
	  }
	  if(minPrice==null)
	  {
	   minPrice=0;
	  }
	  if(maxPrice==null)
	  {
	   maxPrice=0;
	  }
	  if(category==null)
	  {
	   category=0;
	  }
	  if(title==null)
	  {
	   title="";
	  }
	  ArrayList<Post> list= dao.getPosts(location,title,minPrice,maxPrice,category);
	  ArrayList<ViewPost>arrayList=new ArrayList<>();
	  for (Post post : list) {
	   User user1;
	   user1=dao.getUser(post.getUserid());
	   System.out.println(user1.getEmail());
	   ViewPost viewpost=new ViewPost();
	   viewpost.setTitle(post.getTitle());
	   viewpost.setCategory(dao.getCategoryName(post.getCategory()));
	   viewpost.setDescription(post.getDescription());
	   viewpost.setStatus(post.getStatus());
	   viewpost.setPrice(post.getPrice());
	   viewpost.setLocation(dao.getLocationName(post.getLocation()));
	   viewpost.setCreatedDate(post.getCreatedDate());
	   viewpost.setUsername(user1.getUsername());
	   arrayList.add(viewpost);
	  }
	  return arrayList;
	 }

	@Override
	public int editPost(CurrentUser user, Post post) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String[] getContactInfo(CurrentUser user, Integer postid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contact(CurrentUser user, Integer postid, String message) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Category> getCategories() {
		// TODO Auto-generated method stub
		return dao.getCategories();
		//return null;
	}

	@Override
	public ArrayList<Location> getLocations() {
		// TODO Auto-generated method stub
		for(Location o: dao.getLocations()){
			System.out.println(o.getLocationname());
			System.out.println(o.getLocationid());
		}
		return dao.getLocations();
	//	return null;
	}

	@Override
	public Post getPost(CurrentUser user, Integer postid) {
		// TODO Auto-generated method stub
		
		return dao.getPost(postid);
		//return null;
	}

	@Override
	public User getUser(String userid) {
		return dao.getUser(userid);
	}

	@Override
	public boolean addUser(User user) {
		return dao.addUser(user);
	}

}
