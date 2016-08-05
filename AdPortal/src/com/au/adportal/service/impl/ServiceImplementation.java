package com.au.adportal.service.impl;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import com.au.adportal.util.MailSender;
import com.au.adportal.util.MailSenderImpl;
import com.au.adportal.util.Role;
import com.au.adportal.util.Status;
import com.au.adportal.viewmodel.ViewPost;

@Service
@Component
public class ServiceImplementation implements ServiceInterface {

	@Autowired
	DaoInterface dao;
	
	@Autowired
	MailSender mailSender;
	
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
		 Post postFromDB = dao.getPost(postid);
		    if(postFromDB!=null && (user.getRole()==Role.ADMIN|| user.getId().trim().equals(postFromDB.getUserid().trim())))
		       {
		     dao.deletePost(postid);
		         return true;
		       }
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
	   viewpost.setPostid(post.getPostid());
	   viewpost.setTitle(post.getTitle());
	   viewpost.setCategory(dao.getCategoryName(post.getCategory()));
	   viewpost.setDescription(post.getDescription());
	   viewpost.setStatus(post.getStatus());
	   viewpost.setPrice(post.getPrice());
	   viewpost.setLocation(dao.getLocationName(post.getLocation()));
	   viewpost.setCreatedDate(post.getCreatedDate());
	   viewpost.setUsername(user1.getUsername());
	   viewpost.setUserid(post.getUserid());
	   arrayList.add(viewpost);
	  }
	  return arrayList;
	 }

	@Override
	public int editPost(CurrentUser user, Post post) {
		Post postFromDB = dao.getPost(post.getPostid());
		if(postFromDB!=null && (user.getRole()==Role.ADMIN|| user.getId().trim().equals(postFromDB.getUserid().trim())))
	    {
			 dao.editPost(post);
		     return post.getPostid();
	    }
	   return -1;
	}

	@Override
	 public String[] getContactInfo(CurrentUser user, Integer postid) {
	  // TODO Auto-generated method stub
	  String[] contactinfo= new String[2];
	  Post post=dao.getPost(postid);
	  if(post!=null){
		  User user1=dao.getUser(post.getUserid());
		  String email=user1.getEmail();
		  String phoneNumber=user1.getMobile();
		  contactinfo[0]=email;
		  contactinfo[1]=phoneNumber;  
		  return contactinfo;
	  }
	  return null;
	 }

	@Override
	public boolean contact(CurrentUser user, Integer postid, String message) {
		Post post = dao.getPost(postid);
		if(message != null && post != null && user.getRole()!=Role.BLACKLISTED && !user.getId().equals(post.getUserid())){
			mailSender.sendContactMail(user, post, message);
		}
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
		Post post = dao.getPost(postid);
		if(post != null && (user.getRole() == Role.ADMIN || post.getUserid().trim().equals(user.getId().trim())) )
			return post;
		return null;
	}

	@Override
	public User getUser(String userid) {
		return dao.getUser(userid);
	}

	@Override
	public boolean addUser(User user) {
		return dao.addUser(user);
	}

	@Override
	public boolean changeMobile(CurrentUser user, String mobile) {
		mobile = mobile.trim();
		if(mobile.length()==10)
			return dao.changeMobile(user.getId(), mobile);
		return false;
	}

}
