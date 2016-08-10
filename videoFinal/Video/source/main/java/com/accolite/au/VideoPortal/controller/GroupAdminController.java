package com.accolite.au.VideoPortal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accolite.au.VideoPortal.model.Group;
import com.accolite.au.VideoPortal.service.GroupAdminService;


@Controller
public class GroupAdminController {
	
	@Autowired
	private GroupAdminService gservice;
	
	/*@RequestMapping(value = "/addMembers",method=RequestMethod.GET)
	@ResponseBody
	public void addMembers(@RequestParam("x") String x,@RequestParam("group_name") String group_name,HttpServletRequest servletRequest)
	{
		//String group_name=(String) servletRequest.getAttribute("group_name");
		System.out.println("group_name"+group_name);
		String email = (String) servletRequest.getSession().getAttribute("email");
		String y=x.trim();
		String[] parts = y.split(",");
		String part1 = parts[0]; // 004
		String part2 = parts[1];
		List<String> a=users.getUsers();
		List<String> member = new ArrayList<String>();
		for (int i = 0; i < parts.length; i++) {
		  member.add(parts[i]);
		        System.out.print(parts[i]+"parts ");
		    
		}
		if(gservice.addMembers(email,member,group_name))
		System.out.println("Members added");
	}
	*/
	
	
	@RequestMapping(value = "/addMembers",method=RequestMethod.GET)
	@ResponseBody
	public void addMembers(@RequestParam("x") String x,@RequestParam("group_name") String group_name,HttpServletRequest servletRequest)
	{
		//String group_name=(String) servletRequest.getAttribute("group_name");
		System.out.println("group_name"+group_name);
		String email = (String) servletRequest.getSession().getAttribute("email");
		String y=x.trim();
		String[] parts = y.split(",");
		/*String part1 = parts[0]; // 004
		String part2 = parts[1];
		List<String> a=users.getUsers();*/
		List<String> member = new ArrayList<String>();
		for (int i = 0; i < parts.length; i++) {
		  member.add(parts[i]);
		        System.out.print(parts[i]+"parts ");
		    
		}
		if(gservice.addingMembers(email,member,group_name))
		System.out.println("Members added");
	}
	
	@RequestMapping(value = "/checkIfGroupAlreadyExists",method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public Group checkGroup(@RequestParam("groupname") String groupname,HttpServletRequest servletRequest)
	{
		return gservice.checkGroupName(groupname);
	}
	
	
	@RequestMapping(value = "/approveVideo",method=RequestMethod.GET,produces="application/json")
	 @ResponseBody
	 public void approveVideo(@RequestParam("video_id") int video_id,HttpServletRequest servletRequest)
	 {
	  //Approval admin id from the session to set the approval_id.
	  //Video id from video_id to make the statusflag as 1
	  //String email = "jayesh76@gmail.com";
		String email = (String) servletRequest.getSession().getAttribute("email");
	  if(gservice.approveVideo(email,video_id))
	   System.out.println("Video got approved video_id :" + video_id);
	  else
	   System.out.println("Approval Failed.");
	  
	 }
	@RequestMapping(value = "/listofGroupsForWhichHeIsAdmin",method=RequestMethod.GET,produces="application/json")
	 @ResponseBody
	 public List<Group> ListOfGroups(HttpServletRequest servletRequest)
	 {
		String email = (String) servletRequest.getSession().getAttribute("email");
		return(gservice.listAllGroups(email));
	 }
	@RequestMapping(value = "/listofGroupsForWhichHeIsMember",method=RequestMethod.GET,produces="application/json")
	 @ResponseBody
	 public List<Group> ListOfGroupsOfUser(HttpServletRequest servletRequest)
	 {
		String email = (String) servletRequest.getSession().getAttribute("email");
		return(gservice.listAllGroupsOfUser(email));
	 }
}
