package com.au.adportal.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.au.adportal.dao.DaoInterface;
import com.au.adportal.model.Category;
import com.au.adportal.model.CurrentUser;
import com.au.adportal.model.Location;
import com.au.adportal.model.Post;
import com.au.adportal.model.Subscription;
import com.au.adportal.model.User;
import com.au.adportal.util.Role;
import com.au.adportal.util.Status;
import com.au.adportal.viewmodel.ViewPost;

@Repository
public class Dao implements DaoInterface{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public boolean makeAdmin(String userId) {
		boolean result = false;
		try{
			
			String hquery = "FROM User u WHERE u.userid='"+userId+"'";
			User user = (User) entityManager.createQuery(hquery).getSingleResult();
			user.setRole(Role.ADMIN);
			result = true;
		}
		catch(Exception e){
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	@Override
	@Transactional
	public boolean blackList(String userId) {
		boolean result = false;
		try{
			String hquery = "FROM User u WHERE u.userid='"+userId+"'";
			User user = (User) entityManager.createQuery(hquery).getSingleResult();
			user.setRole(Role.BLACKLISTED);
			result = true;
		}
		catch(Exception e){
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	@Transactional
	public boolean unblackList(String userId) {
		boolean result = false;
		try{
			String hquery = "FROM User u WHERE u.userid='"+userId+"'";
			User user = (User) entityManager.createQuery(hquery).getSingleResult();
			user.setRole(Role.USER);
			result = true;
		}
		catch(Exception e){
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	@Transactional
	public boolean deletePost(int postId) {
		boolean result = false;
		try{
			Post p = entityManager.find(Post.class, postId);
			p.setStatus(Status.DELETED);
		}
		catch(Exception e){
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	@Transactional
	public boolean createLocation(String location) {
		boolean result = false;
		Location l = new Location();
		l.setLocationname(location);
		try{
			entityManager.persist(l);
			result = true;
		}
		catch(Exception e){
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	@Transactional
	public int addPost(Post post) {
		int returnval = -1;
		try{
			entityManager.persist(post);
			returnval = post.getPostid();
		}
		catch(Exception e){
			returnval = -1;
			e.printStackTrace();
		}
		return returnval;
	}

	@Override
	@Transactional
	public int editPost(Post post) {
		int returnval = -1;
		try{
			Post post1 = entityManager.find(Post.class, post.getPostid());
			post1.setPrice(post.getPrice());
			System.out.println(post.toString()+"\n"+post1.toString());
			post1.setDescription(post.getDescription());
			post1.setLocation(post.getLocation());
			post1.setCategory(post.getCategory());
			post1.setStatus(post.getStatus());
			post1.setTitle(post.getTitle());
			returnval = post1.getPostid();
		}
		catch(Exception e){
			returnval = -1;
			e.printStackTrace();
		}
		return returnval;
	}
	
	@Override
	@Transactional
	public ArrayList<Post> getPosts(int locationId, String title, int minPrice, int maxPrice, int categoryID) {
		
		String hquery = "FROM Post p WHERE 1=1";
		
		if(locationId != 0)
			hquery += " AND p.location = "+locationId;
		if(minPrice != 0)
			hquery += " AND p.price >= "+minPrice;
		if(maxPrice != 0)
			hquery += " AND p.price <= "+maxPrice;
		if(categoryID != 0)
			hquery += " AND p.category = "+categoryID;
		
		hquery+=" AND p.title LIKE :titleStr";
		
		hquery += " AND p.status != "+Status.DELETED;
		hquery += " AND p.status != "+Status.SOLD;
		
		hquery+=" order by p.postid desc";
		
		System.out.println("Query to execute: "+hquery);
		
		ArrayList<Post> posts = (ArrayList<Post>)entityManager.createQuery(hquery).setParameter("titleStr", "%"+title+"%").getResultList();
		
		return posts;
	}

	@Override
	public boolean contact(int postId) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	@Transactional
	public ArrayList<Category> getCategories() {
		String hquery = "FROM Category c";
		
		ArrayList<Category> categories = (ArrayList<Category>)entityManager.createQuery(hquery).getResultList();
		
		return categories;
	}

	@Override
	@Transactional
	public ArrayList<Location> getLocations() {
		String hquery = "FROM Location l";
		
		ArrayList<Location> locations = (ArrayList<Location>)entityManager.createQuery(hquery).getResultList();
		
		return locations;
	}

	@Override
	@Transactional
	public Post getPost(int postId) {
		Post post = entityManager.find(Post.class, postId);
		if(post.getStatus()==Status.NEW)
			return post;
		return null;
	}
	
	@Override
	@Transactional
	public boolean createCategory(String category) {
		boolean result = false;
		Category c = new Category();
		c.setCategoryname(category);
		try{
			entityManager.persist(c);
			result = true;
		}
		catch(Exception e){
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	@Transactional
	public String getCategoryName(int categoryid) {
		String categoryName = null;
		try{
			Category category = entityManager.find(Category.class, categoryid);
			categoryName = category.getCategoryname();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return categoryName;
	}
	
	
	
	@Override
	@Transactional
	public String getLocationName(int locationid) {
		String locationName = null;
		try{
			Location location = entityManager.find(Location.class, locationid);
			locationName = location.getLocationname();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return locationName;
	}
	@Override
	@Transactional
	public User getUser(String userid) {
		User user = entityManager.find(User.class, userid);
		return user;
	}

	@Override
	@Transactional
	public boolean addUser(User user) {
		boolean result = false;
		try{
			entityManager.persist(user);
			result = true;
		}
		catch(Exception e){
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	@Override
	@Transactional
	public boolean addCategory(Category category){
		
		try{
			entityManager.persist(category);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	@Override
	@Transactional
	public boolean addLocation(Location location){
		try{
			entityManager.persist(location);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	@Override
	@Transactional
	public boolean changeMobile(String userid, String mobile) {
		boolean result = false;
		try{
			User user = entityManager.find(User.class, userid);
			user.setMobile(mobile);
			result = true;
		}
		catch(Exception e){
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	@Transactional
	public boolean subscribe(String userid, Integer categoryid) {
		boolean result = false;
		try{
			Subscription s = new Subscription(userid, categoryid);
			entityManager.persist(s);
			result = true;

		}
		catch(Exception e){
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	@Transactional
	public boolean unsubscribe(String userid, Integer categoryid) {
		boolean result = false;
		try{
			System.out.println("dao");
			String hquery = "FROM Subscription s WHERE s.userid='"+userid+"' AND s.categoryid="+categoryid;
			Subscription s = (Subscription) entityManager.createQuery(hquery).getSingleResult();
			entityManager.remove(s);
			System.out.println("removed");
			result = true;
		}
		catch(Exception e){
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean isSubscribed(String userid, Integer categoryid) {
		boolean result = false;
		try{
			String hquery = "FROM Subscription s WHERE s.userid='"+userid+"' AND s.categoryid="+categoryid;
			Subscription s = (Subscription) entityManager.createQuery(hquery).getSingleResult();
			if(s!=null){
				result = true;
			}
		}
		catch(Exception e){
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Category getCategoryById(Integer categoryid) {
		Category category = entityManager.find(Category.class, categoryid);
		return category;
	}

	@Override
	public Location getLocationById(Integer locationid) {
		Location location = entityManager.find(Location.class, locationid);
		return location;
	}
	
	@Override
	public List<String> getMailsForSubscription(Integer categoryid) {
		String hquery = "SELECT u.email FROM User u, Subscription s WHERE u.userid = s.userid AND s.categoryid="+categoryid;
		List<String> locations = (ArrayList<String>)entityManager.createQuery(hquery).getResultList();		
		return locations;
	}
	@Override
	public List<Category> getSubscribedCategory(CurrentUser current_user) {
		// TODO Auto-generated method stub
		String hquery = "SELECT c FROM Category c,Subscription s WHERE s.userid = '"+current_user.getId()+"' AND c.categoryid=s.categoryid";
		List<Category> categories = (ArrayList<Category>)entityManager.createQuery(hquery).getResultList();
		for(Category c: categories)
			System.out.println(":::"+c.getCategoryname());
		return categories;
	}
	@Override
	 public List<User> getBlacklistedUsers() {
	  String hquery = "FROM User u where u.role="+Role.BLACKLISTED; 
	  List<User> blacklistedUsers = (ArrayList<User>)entityManager.createQuery(hquery).getResultList();
	  return blacklistedUsers;
	 }

	 @Override
	 public List<User> getAdminUsers() {
	  String hquery = "FROM User u where u.role="+Role.ADMIN; 
	  List<User> adminUsers = (ArrayList<User>)entityManager.createQuery(hquery).getResultList();
	  return adminUsers;
	 }

	 @Override
	 public List<User> getAllUsers() {
	  String hquery = "FROM User u where u.role="+Role.USER; 
	  List<User> allUsers = (ArrayList<User>)entityManager.createQuery(hquery).getResultList();
	  return allUsers;
	 }
	@Override
	public ArrayList<Post> getUserPosts(String id) {
		// TODO Auto-generated method stub
		String hquery = "FROM Post p where p.userid='"+id+"' order by p.postid desc"; 
		 ArrayList<Post> userPosts = (ArrayList<Post>)entityManager.createQuery(hquery).getResultList();
		return userPosts;
		//return null;
	}
	
	@Override
	public boolean setStatusSold(Integer postId) {
		// TODO Auto-generated method stub
		try{
			Post p = entityManager.find(Post.class, postId);
			p.setStatus(Status.SOLD);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	

}
