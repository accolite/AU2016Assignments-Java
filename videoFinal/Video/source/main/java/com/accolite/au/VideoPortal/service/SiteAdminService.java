package com.accolite.au.VideoPortal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.au.VideoPortal.DAO.GroupAdminDAO;
import com.accolite.au.VideoPortal.DAO.SiteAdminDAO;
import com.accolite.au.VideoPortal.DAO.UserDAO;
import com.accolite.au.VideoPortal.model.Group;
import com.accolite.au.VideoPortal.model.User;

@Service
public class SiteAdminService {
	@Autowired
	private SiteAdminDAO jdbc;
	@Autowired
	private GroupAdminDAO group_jdbc;
	@Autowired
	private UserDAO jdbc1;
	@Autowired
	 private UserDAO user_jdbc;
	
	/*public boolean makeSiteAdmin(int user_id) {
		if (jdbc.RetrieveSiteAdmin(user_id) == null) {
			User user = new User();
			user.setUser_id(user_id);
			int result = jdbc.AddAdmin(user);
			if (result == 1)
				return true;
			else
				return false;
		}
		return false;

	}*/
	
	public List<Group> listGroupsForUser(String email) {
		  // TODO Auto-generated method stub
		  User user=user_jdbc.RetrieveUser(email);
		  List<Group> groups=new ArrayList<>();
		  groups=user_jdbc.listGroups(user);
		  return groups;
		 }
	
	public List<Group> listGroups() {
		  // TODO Auto-generated method stub
		  List<Group>groups=new ArrayList<>();
		  groups=jdbc.listAllGroups();
		  return groups;
		 }
	
/*	public boolean makeSiteAdmin(String name) {
		  if (jdbc.RetrieveSiteAdminExistsAsUser(name) != null) {
		   System.out.println(name);
		   User user = new User();
		   user.setFirstname(name);
		   user.setUser_id(jdbc.getUserId(user));
		   int result = jdbc.AddAdmin(user);
		   if (result == 1)
		    return true;
		   else
		    return false;
		  }
		  return false;

		 }

	
	
	public boolean deleteSiteAdmin(String name) {
		  if (jdbc.RetrieveSiteAdmin(name) != null) {
		   User user = new User();
		   user.setFirstname(name);
		   //user.setUser_id(user_id);
		   user.setUser_id(jdbc.getUserId(user));
		   int result = jdbc.DeleteAdmin(user);
		   if (result == 1)
		    return true;
		   else
		    return false;
		  }
		  return false;

		 }
	*/
	
	
	public boolean makeSiteAdmin(String email) {
		//  if (jdbc.RetrieveSiteAdminExistsAsUser(email) != null) {
		   System.out.println(email);
		   User user = new User();
		   //user.setFirstname(name);
		   user.setUser_id(jdbc.getUserIdBasedOnEmail(email));
		   System.out.println("user for settting site admin is"+user.getEmail_id());
		   int result = jdbc.AddAdmin(user);
		   System.out.println("result is"+result);
		   if (result == 1)
		    return true;
		   else
		    return false;
		//  }
		//  return false;

		 }
	
	
	public boolean deleteSiteAdmin(String email) {
		  if (jdbc.RetrieveSiteAdminBasedOnEmail(email) != null) {
		   User user = new User();
		   //user.setFirstname(name);
		   //user.setUser_id(user_id);
		   user.setEmail_id(email);
		   user.setUser_id(jdbc.getUserIdBasedOnEmail(email));
		   int result = jdbc.DeleteAdmin(user);
		   if (result == 1)
		   {
			   System.out.println("Site Admin with email_id " + email + "is deleted");
			   return true;
		   }
		   else
		    return false;
		  }
		  return false;

		 }
	
	
	 public boolean isGroupAdmin(User user)
	  {
	   if(jdbc.isGroupAdmin(user)!=null)
		   return true;
	   else 
		   return false;
	  }
	
	//called by SiteAdminController to create Group
	 //Checks whether group name already exists and returns true or false.
	/* public boolean createGroup(String group_name,String admin_name)
	 {
	  if(!jdbc.groupAlreadyExists(group_name)){
	   //Now to create Group and also the Admin
	   Group group = new Group();
	   User user = new User();
	   group.setName(group_name);
	   //Through the name try to get user_ID FROM DB & assign this id to the group admin column.
	   //user.setUser_id(1);
	   int test1 = jdbc.CreateGroup(group);//If test1 is 1 then group is created.
	   //Now get the group id of newly created group and admin id from user table
	   user.setFirstname(admin_name);
	   user.setUser_id(jdbc.getUserId(user));
	   group.setGroup_id(jdbc.getGroupId(group));
	   int test2 = jdbc.CreateGroupAdmin(group,user);
	   if(test1 ==1 && test2 == 1)
	   {
	    return true;//Group Created and Admin Added.
	   }
	    
	   return false;//Group NOT created
	  }
	  
	  return false;//Group Not created.
	 }*/
	 
	 public boolean createGroup(String group_name,String email)
	 {
	  if(!jdbc.groupAlreadyExists(group_name)){
	   //Now to create Group and also the Admin
	   Group group = new Group();
	   User user = new User();
	   group.setName(group_name);
	   //Through the name try to get user_ID FROM DB & assign this id to the group admin column.
	   //user.setUser_id(1);
	   int test1 = jdbc.CreateGroup(group);//If test1 is 1 then group is created.
	   //Now get the group id of newly created group and admin id from user table
	   //user.setFirstname(admin_name);COMMENT
	   user.setEmail_id(email);
	   user.setUser_id(jdbc.getUserIdBasedOnEmail(email));
	   group.setGroup_id(jdbc.getGroupId(group));
	   int test2 = jdbc.CreateGroupAdmin(group,user);
	   user = jdbc1.RetrieveUser(email);
		  int admin_id = user.getUser_id();
		  System.out.println("admin_id"+admin_id);
		  // Now based on admin_id getting the Group_id.
		  int group_id = group_jdbc.getGroupIdByName(group_name);
		  
		  // Passing this group object to AddUser.
		  System.out.println("group_id"+group_id);
		  Group group1 = new Group();
		  group1.setGroup_id(group_id);
		  group_jdbc.AddUser(group1, user);
	   if(test1 ==1 && test2 == 1)
	   {
	    return true;//Group Created and Admin Added.
	   }
	    
	   return false;//Group NOT created
	  }
	  
	  return false;//Group Already Exists.
	 }
	 
	 
	 public User isSiteAdmin(User user) {
		 
		 return jdbc.isSiteAdmin(user);
	 }

}
