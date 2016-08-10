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

import com.accolite.au.VideoPortal.model.Event;
import com.accolite.au.VideoPortal.model.Video;
import com.accolite.au.VideoPortal.service.VideoService;

@Controller
public class VideoController {

		@Autowired 
		VideoService vservice;
		
		
		
		@RequestMapping(value = "/addVideo",method=RequestMethod.GET,produces="application/json")
		@ResponseBody
		public void addVideo(@RequestParam("video_url")String video_url,@RequestParam("title")String title,
				@RequestParam("topic")String topic,@RequestParam("event")String event,
				@RequestParam("group_name")String group_name,	HttpServletRequest servletRequest)
		{
			String email = (String) servletRequest.getSession().getAttribute("email");
			String privacy;
			System.out.println("group_name"+group_name);
			if(group_name.equals(""))
				{System.out.println("empty"); privacy="Public";System.out.println("Privacy="+privacy);}
			else
			{
				System.out.println(" not empty"+group_name); privacy="Private";
				System.out.println("Privacy="+privacy);
			}
			if(vservice.addVideo(title,topic,event,video_url,privacy,email))
				System.out.println("Video got added");
			else
				System.out.println("Failed to add the video");
		}
		@RequestMapping(value = "/fetchEvents",method=RequestMethod.GET,produces="application/json")
		@ResponseBody
		public List<Event> fetchEvent(HttpServletRequest servletRequest)
		{
			return vservice.fetchEvents();
		}
		
		@RequestMapping(value = "/listGrpVideo",method=RequestMethod.GET,produces="application/json")
		  @ResponseBody
		  public List<Video> searchVideosOfAGroup(@RequestParam("group_id")int group_id,HttpServletRequest servletRequest)
		  {
		 String email = (String) servletRequest.getSession().getAttribute("email");
		 //  String email = "jayesh76@gmail.com";//this is from the session.
		   System.out.println("group_id"+group_id);
		   List<Video>videos=new ArrayList<Video>();
		   videos=vservice.retrieveVideoOfAGroup(group_id);
		   return videos;
		   
		  }
		
		@RequestMapping(value = "/getPublicVideo",method=RequestMethod.GET,produces="application/json")
		 @ResponseBody
		 public List<Video> getPublicVideos(HttpServletRequest servletRequest){
			List<Video> publicVideos = vservice.PublicVideos();
		    return publicVideos;
		 }
		@RequestMapping(value = "/checkdupVideo",method=RequestMethod.GET,produces="application/json")
	    @ResponseBody
	    public Video checkDupVideo(@RequestParam("url")String url,@RequestParam("groupname")String groupname,HttpServletRequest servletRequest)
	    {
	   String email = (String) servletRequest.getSession().getAttribute("email");
	   //  String email = "jayesh76@gmail.com";//this is from the session.
	     System.out.println("url "+url);
	     System.out.println("groupname "+groupname);
	     if(groupname.equals(""))
	     return(vservice.searchfordupPublic(url));
	     else
	      return(vservice.searchfordupPrivate(url, groupname));
	     
	    }
	
//		@RequestMapping(value = "/deleteVideo",method=RequestMethod.GET,produces="application/json")
//		 @ResponseBody
//		 public void DeleteVideo(@RequestParam("video_id")int video_id,
//		            HttpServletRequest servletRequest){
//		  System.out.println("userId"+video_id); 
//		  if(service.DeleteVideo(video_id)){
//		   System.out.println("Video deleted");
//		   }
//		  else
//		    System.out.println("Video cannot be deleted");
//		   
//		 }
//		 @RequestMapping(value = "/SearchTitle",method=RequestMethod.GET,produces="application/json")
//		 @ResponseBody
//		 public List<Video> UserSearchVideoByTitle(@RequestParam("id") Integer user_id, @RequestParam("title") String Title,HttpServletRequest servletRequest)
//		 {
//		  System.out.println("user_id"+user_id);
//		  List<Video>videos=new ArrayList<Video>();
//		  videos=service.UserSearchVideoByTitleGiven(Title, user_id);
//		  return videos;
//		 }
//		 @RequestMapping(value = "/SearchTopic",method=RequestMethod.GET,produces="application/json")
//		 @ResponseBody
//		 public List<Video> UserSearchVideoByTopic(@RequestParam("id") Integer user_id, @RequestParam("topic")String Topic,HttpServletRequest servletRequest)
//		 {
//		  List<Video>videos=new ArrayList<Video>();
//		  videos=service.UserSearchVideoByTopicGiven(Topic, user_id);
//		  return videos;
//		 }
//		 @RequestMapping(value = "/SearchEvent",method=RequestMethod.GET,produces="application/json")
//		 @ResponseBody
//		 public List<Video> UserSearchVideoByEvent(@RequestParam("id")int user_id,@RequestParam("event")String event_name,HttpServletRequest servletRequest)
//		 {
//		  List<Video>videos=new ArrayList<Video>();
//		  System.out.println("dfgf");
//		  videos=service.UserSearchVideoByEventGiven(event_name, user_id);
//		  return videos;
//		 }
//		 @RequestMapping(value = "/SearchDateOfAddition",method=RequestMethod.GET,produces="application/json")
//		 @ResponseBody
//		 public List<Video> UserSearchVideoByDateOfAddition(@RequestParam("user_id")int user_id,@RequestParam("date")Date date,HttpServletRequest servletRequest)
//		 {
//		  List<Video>videos=new ArrayList<Video>();
//		  videos=service.UserSearchVideoByDateOfAdditionGiven(date, user_id);
//		  return videos;
//		 }
//		 @RequestMapping(value = "/SearchDateOfEvent",method=RequestMethod.GET,produces="application/json")
//		 @ResponseBody
//		 public List<Video> UserSearchVideoByDateOfEvent(@RequestParam("user_id")int user_id,@RequestParam("date")Date date,HttpServletRequest servletRequest)
//		 {
//		  List<Video>videos=new ArrayList<Video>();
//		  videos=service.UserSearchVideoByDateOfEventGiven(date, user_id);
//		  return videos;
//		 }
//		 @RequestMapping(value = "/AdminSearchTitle",method=RequestMethod.GET,produces="application/json")
//		 @ResponseBody
//		 public List<Video> AdminSearchVideoByTitle(@RequestParam("user_id")int user_id,@RequestParam("Title")String Title,HttpServletRequest servletRequest)
//		 {
//		  List<Video>videos=new ArrayList<Video>();
//		  videos=service.AdminSearchVideoByTitleGiven(Title, user_id);
//		  return videos;
//		 }
//		 @RequestMapping(value = "/AdminSearchTopic",method=RequestMethod.GET,produces="application/json")
//		 @ResponseBody
//		 public List<Video> AdminSearchVideoByTopic(@RequestParam("user_id")int user_id,@RequestParam("Topic")String Topic,HttpServletRequest servletRequest)
//		 {
//		  List<Video>videos=new ArrayList<Video>();
//		  videos=service.AdminSearchVideoByTopicGiven(Topic, user_id);
//		  return videos;
//		 }
//		 @RequestMapping(value = "/AdminSearchEvent",method=RequestMethod.GET,produces="application/json")
//		 @ResponseBody
//		 public List<Video> AdminSearchVideoByEvent(@RequestParam("user_id")int user_id,@RequestParam("event")String event_name,HttpServletRequest servletRequest)
//		 {
//		  List<Video>videos=new ArrayList<Video>();
//		  videos=service.AdminSearchVideoByEventGiven(event_name, user_id);
//		  return videos;
//		 }
//		 @RequestMapping(value = "/AdminSearchDateOfAddition",method=RequestMethod.GET,produces="application/json")
//		 @ResponseBody
//		 public List<Video> AdminSearchVideoByDateOfAddition(@RequestParam("user_id")int user_id,@RequestParam("date")Date date,HttpServletRequest servletRequest)
//		 {
//		  List<Video>videos=new ArrayList<Video>();
//		  videos=service.AdminSearchVideoByDateOfAdditionGiven(date, user_id);
//		  return videos;
//		 }
//		 @RequestMapping(value = "/AdminSearchDateOfEvent",method=RequestMethod.GET,produces="application/json")
//		 @ResponseBody
//		 public List<Video> AdminSearchVideoByDateOfEvent(@RequestParam("user_id")int user_id,@RequestParam("date")Date date,HttpServletRequest servletRequest)
//		 {
//		  List<Video>videos=new ArrayList<Video>();
//		  videos=service.AdminSearchVideoByDateOfEventGiven(date, user_id);
//		  return videos;
//		 }
//
//		}
}
