package com.accolite.au.VideoPortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.au.VideoPortal.DAO.GroupAdminDAO;
import com.accolite.au.VideoPortal.DAO.UserDAO;

import com.accolite.au.VideoPortal.model.User;
import com.accolite.au.VideoPortal.model.Video;
import com.accolite.au.VideoPortal.model.Group;

@Service
public class GroupAdminService {
	@Autowired
	private GroupAdminDAO jdbc;
	@Autowired
	private UserDAO jdbc1;
	@Autowired
	private SiteAdminService service;
	// The failure part is not handled.
	/*public boolean addMembers(String email, List<String> member, String group_name) {

		  String firstname = null;
		  User user = new User();
		  // user.setEmail_id(email);
		  // Based on session fetches the id of the admin.
		  user = jdbc1.RetrieveUser(email);
		  int admin_id = user.getUser_id();
		  System.out.println("admin_id"+admin_id);
		  // Now based on admin_id getting the Group_id.
		  int group_id = jdbc.getGroupIdByName(group_name);
		  
		  // Passing this group object to AddUser.
		  System.out.println("group_id"+group_id);
		  Group group = new Group();
		  group.setGroup_id(group_id);
		  jdbc.AddUser(group, user);
		  User user1 = new User();
		  for (String name : member) {
			   firstname=name;
		   if (name.contains(" ")) {
		    firstname = name.substring(0, name.indexOf(" "));
		    System.out.println("first name:"+firstname);
		   }
		   user1.setFirstname(firstname);
		   // now i need to get the user_id for this user
		   int id = jdbc.getUserId(user1);
		   System.out.println("user_id="+id);
		   System.out.println("group_id"+group_id);
		   user1.setUser_id(id);
		   int success = jdbc.AddUser(group, user1);
		   System.out.println("success:"+success);
		   if (success == 0) {
		    System.out.println("Failed to add :" + name);// Prints the names
		                // who could not
		                // be added.
		   }
		  }
		  return true;
		 }*/
	
	
	/*public boolean addMembers(String email, List<String> member, String group_name) {

		  //String firstname = null;
		  User user = new User();
		  // user.setEmail_id(email);
		  // Based on session fetches the id of the admin.
//		  /*user = jdbc1.RetrieveUser(email);
//		  int admin_id = user.getUser_id();
//		  System.out.println("admin_id"+admin_id);
//		  // Now based on admin_id getting the Group_id.
		  int group_id = jdbc.getGroupIdByName(group_name);
		  
		  // Passing this group object to AddUser.
		  System.out.println("group_id"+group_id);
		  Group group = new Group();
		  group.setGroup_id(group_id);
		 // jdbc.AddUser(group, user);*///for making group admin as user of that group
//		  User user1 = new User();
//		  for (String name : member) {
//		   if (name.contains(" ")) {
//		    firstname = name.substring(0, name.indexOf(" "));
//		    System.out.println("first name:"+firstname);
//		   }
//		   user1.setFirstname(firstname);
//			  user1.setEmail_id(name);
//		   // now i need to get the user_id for this user
//			  
//		   int id = jdbc.getUserIdBasedOnEmail(user1);
//		   System.out.println("user_id="+id);
//		   System.out.println("group_id"+group_id);
//		   user1.setUser_id(id);
//		   User users=new User();
//		   users=service.isSiteAdmin(user1);
//		  System.out.println("usrers"+users.getFirstname());
//		   if(service.isSiteAdmin(user1)==null)
//		   {
//		   int success = jdbc.AddUser(group, user1);
//		   System.out.println("success:"+success);
//		   if (success == 0) {
//		    System.out.println("Failed to add :" + name);// Prints the names
//		                // who could not
//		                // be added.
//		   }
//		  }
//		   else
//			   System.out.println("Site Admin cannot be added");
//		  }
//		  return true;
//		 }*/
	
	public boolean addingMembers(String email, List<String> member, String group_name) {
		 System.out.println("here in admin");
		     //String firstname = null;
		     User user = new User();
		     // user.setEmail_id(email);
		     // Based on session fetches the id of the admin.
		     user = jdbc1.RetrieveUser(email);
		     int admin_id = user.getUser_id();
		     System.out.println("admin_id"+admin_id);
		     // Now based on admin_id getting the Group_id.
		     int group_id = jdbc.getGroupIdByName(group_name);
		     
		     // Passing this group object to AddUser.
		     System.out.println("group_id"+group_id);
		     Group group = new Group();
		     group.setGroup_id(group_id);
		     jdbc.AddUser(group, user);//for making group admin as user of that group
		     User user1 = new User();
		     for (String name : member) {
		      /*if (name.contains(" ")) {
		       firstname = name.substring(0, name.indexOf(" "));
		       System.out.println("first name:"+firstname);
		      }
		      user1.setFirstname(firstname);*/
		      user1.setEmail_id(name);
		      // now i need to get the user_id for this user
		      int id = jdbc.getUserIdBasedOnEmail(user1);
		      System.out.println("user_id="+id);
		      System.out.println("group_id"+group_id);
		      user1.setUser_id(id);
		      int success = jdbc.AddUser(group, user1);
		      System.out.println("success:"+success);
		      if (success == 0) {
		       System.out.println("Failed to add :" + name);// Prints the names
		                   // who could not
		                   // be added.
		      }
		     }
		     return true;
		    }
	public boolean approveVideo(String email,int video_id)
	 {
	  Video video = new Video();
	  video.setVideo_id(video_id);
	  User user = new User();
	  user = jdbc1.RetrieveUser(email);
	  System.out.println("ID:" + user.getUser_id());
	  jdbc.ApproveVideo(video,user);
	  return true;
	 }
	
	public User isGroupAdmin(User user) {
		
		return jdbc.isGroupAdmin(user);
		
	}

	public List<Group> listAllGroups(String email) {
		  User user = new User();
		  user = jdbc1.RetrieveUser(email);
		  return(jdbc.listGroups(user));
		
	}

	public List<Group> listAllGroupsOfUser(String email) {
		User user = new User();
		  user = jdbc1.RetrieveUser(email);
		  return(jdbc.listGroupsOfUser(user));
	}


	public Group checkGroupName(String groupname) {
		// TODO Auto-generated method stub
		Group group=new Group();
		 group=jdbc.FindGroupWithName(groupname);
		 return group;
	}
}
