package com.accolite.au.VideoPortal.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accolite.au.VideoPortal.DAO.SiteAdminDAO;
import com.accolite.au.VideoPortal.DAO.UserDAO;
import com.accolite.au.VideoPortal.model.Group;
import com.accolite.au.VideoPortal.model.User;
import com.accolite.au.VideoPortal.service.SiteAdminService;
import com.accolite.au.VideoPortal.service.UserService;

@Controller
public class SiteAdminController {
	@Autowired
	private SiteAdminDAO jdbc;
	@Autowired
	private SiteAdminService service;
	@Autowired
	private UserService user_service;
	/*@RequestMapping(value = "/makeAdmin", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void addAdmin(@RequestParam("user_id") int user_id, HttpServletRequest servletRequest) {
		System.out.println("userId" + user_id);

		if (service.makeSiteAdmin(user_id))
			System.out.println("Site admin added");
		else
			System.out.println("Site Admin cannot be added");

	}*/

	@RequestMapping(value = "/listGroup", method = RequestMethod.GET, produces = "application/json")
	 @ResponseBody
	 public List<Group> ListGroup( HttpServletRequest servletRequest) {
	  System.out.println("groups");
	  List<Group>groups=new ArrayList<>();
	  groups=service.listGroups();
	  if (groups!= null)
	   {System.out.println("List displayed");return groups;}
	  else
	   {System.out.println("List cannot be displayed");return null;}

	 }
	
	@RequestMapping(value = "/listGroupForUser", method = RequestMethod.GET, produces = "application/json")
	 @ResponseBody
	 public List<Group> ListGroupForUser(HttpServletRequest servletRequest) {
	  System.out.println("groupsList");
	  String email = (String) servletRequest.getSession().getAttribute("email");
	  List<Group> groups=new ArrayList<>();
	  groups=service.listGroupsForUser(email);
	  if (groups!= null)
	   {System.out.println("List displayed");return groups;}
	  else
	   {System.out.println("List cannot be displayed");return null;}

	 }
	
	/*@RequestMapping(value = "/makeAdmin", method = RequestMethod.GET, produces = "application/json")
	 @ResponseBody
	 public void addAdmin(@RequestParam("name") String name, HttpServletRequest servletRequest) {
	  System.out.println("name:" + name);String firstname=name;
	  if (name.contains(" ")) {
		    firstname = name.substring(0, name.indexOf(" "));
		    System.out.println("first name:"+firstname);
		   }
	  if (service.makeSiteAdmin(firstname))
	   System.out.println("Site admin added");
	  else
	   System.out.println("Site Admin cannot be added because user doesn't exist");

	 }*/
	@RequestMapping(value = "/makeAdmin", method = RequestMethod.GET, produces = "application/json")
	 @ResponseBody
	 public void addAdmin(@RequestParam("email_id") String email, HttpServletRequest servletRequest) {
	  System.out.println("Add Admin----email_id:" + email);

	  if (service.makeSiteAdmin(email))
	   System.out.println("Site admin added");
	  else
	   System.out.println("Site Admin cannot be added because user doesn't exist");

	 }
	/*@RequestMapping(value = "/removeAdmin", method = RequestMethod.POST, produces = "application/json")
	 @ResponseBody
	 public void removeAdmin(@RequestParam("name") String name, HttpServletRequest servletRequest) {
	  System.out.println("name :" + name);
	  String firstname=name;
	  if (name.contains(" ")) {
		    firstname = name.substring(0, name.indexOf(" "));
		    System.out.println("first name:"+firstname);
		   }
	  if (service.deleteSiteAdmin(name))
	   System.out.println("Site admin deleted");
	  else
	   System.out.println("Site Admin cannot be added");
	 }
	*/
	@RequestMapping(value = "/removeAdmin", method = RequestMethod.POST, produces = "application/json")
	 @ResponseBody
	 public void removeAdmin(@RequestParam("email_id") String email, HttpServletRequest servletRequest) {
	  System.out.println("email_d :" + email);

	  if (service.deleteSiteAdmin(email))
	   System.out.println("Site admin deleted");
	  else
	   System.out.println("Site Admin cannot be added");
	 }
	//This to be called from the Group page when site admin enters new Group details and hits Create Group
/*	 @RequestMapping(value="/createGroup",method=RequestMethod.GET,produces="application/json")
	 @ResponseBody
	 public void createGroup(@RequestParam("group_name")String group_name,@RequestParam("group_admin")String admin_name,
	   HttpServletRequest servletRequest,HttpServletResponse httpServletResponse) throws ServletException, IOException
	 {
	  System.out.println("GroupName " + group_name + "\n" + "Admin " + admin_name );
	  String firstname=admin_name;
	  if (admin_name.contains(" ")) {
		    firstname = admin_name.substring(0, admin_name.indexOf(" "));
		    System.out.println("first name:"+firstname);
		   }
	  if(service.createGroup(group_name,firstname))
	  {
		  
		  servletRequest.setAttribute("group_name", group_name);
		  RequestDispatcher rd=servletRequest.getRequestDispatcher("/AddMembers.jsp");  
		 // httpServletResponse.setHeader("Location", "http://localhost:8081/VideoPO/AddMembers.html");
		  rd.forward(servletRequest, httpServletResponse); 
	   System.out.println("Group created successfully");
	  }
	  else
	   System.out.println("failed to create the Group");
	 }
	 */
	
	@RequestMapping(value="/createGroup",method=RequestMethod.GET,produces="application/json")
	 @ResponseBody
	 public void createGroup(@RequestParam("group_name")String group_name,@RequestParam("email_id")String email,
	   HttpServletRequest servletRequest,HttpServletResponse httpServletResponse) throws ServletException, IOException
	 {
	  System.out.println("GroupName " + group_name + "\n" + "Admin email_id " + email );
	  if(service.createGroup(group_name,email))
	  {
		  /*
		  servletRequest.setAttribute("group_name", group_name);
		  RequestDispatcher rd=servletRequest.getRequestDispatcher("/AddMembers.jsp");  
		 // httpServletResponse.setHeader("Location", "http://localhost:8081/VideoPO/AddMembers.html");
		  rd.forward(servletRequest, httpServletResponse); */
	   System.out.println("Group created successfully");
	  }
	  else
	   System.out.println("failed to create the Group");
	 }
	
	
	 @RequestMapping(value="/isSiteAdmin",method=RequestMethod.GET,produces="application/json")
	 @ResponseBody
	 public int isSiteAdmin(
			   HttpServletRequest servletRequest,HttpServletResponse httpServletResponse) throws ServletException, IOException
			 {
		 String email = (String) servletRequest.getSession().getAttribute("email");
			 // System.out.println("GroupName " + group_name + "\n" + "Admin " + admin_name );
		 User user=user_service.RetrieveUser(email);
			  if(service.isSiteAdmin(user)!=null)
				  {System.out.println("siteAdmin ");return 1;}
			  else if(service.isGroupAdmin(user))
			  { System.out.println("groupAdmin ");return 2;}
			  else
			  {
				  System.out.println("user ");
				  return 0;
			  }
			 }  
}
