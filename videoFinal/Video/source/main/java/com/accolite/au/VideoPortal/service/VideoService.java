package com.accolite.au.VideoPortal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.au.VideoPortal.DAO.UserDAO;
import com.accolite.au.VideoPortal.DAO.VideoDAO;
import com.accolite.au.VideoPortal.model.Event;
import com.accolite.au.VideoPortal.model.Group;
import com.accolite.au.VideoPortal.model.User;
import com.accolite.au.VideoPortal.model.Video;


@Service
public class VideoService {

	@Autowired
	private VideoDAO video_jdbc;
	
	@Autowired
	private UserDAO user_jdbc;
	
	public boolean addVideo(String title,String topic,String event,String url,String privacy,String email)
	{
		Group group = new Group();
		Video video = new Video();
		User user = new User();
		user = user_jdbc.RetrieveUser(email);//Gives the user object filtered on input email.
		//This user will now have its Id obtained from database.This user will let us know more about
		//what kind of videos he has Store 
		System.out.println("user_id"+user.getUser_id());
		video.setTitle(title);
		video.setTopic(topic);
		video.setEvent_id(1);//Rite now not going through the event name->db(fetching auto event_id)->setting it here
		video.setUrl(url.replace("watch?v=", "embed/"));
		video.setPrivacy(privacy);
		video.setStatusFlag(0);//APPROVAL PENDING
		System.out.println("title"+video.getTitle());
		System.out.println("getTopic "+video.getTopic());
		System.out.println("getEvent_id "+video.getEvent_id());
		System.out.println("getUrl "+video.getUrl());
		System.out.println("getPrivacy "+video.getPrivacy());
		System.out.println("getStatusFlag "+video.getStatusFlag());
		System.out.println("getApproval_id "+video.getApproval_id());
		int result = video_jdbc.AddVideo(video,user);
		if((result == 1))
		{
			System.out.println("result "+result);
			System.out.println("privacy "+privacy);
			//Write code to make entry into the GroupVideoTable
			//First to get the group id of the uploader.
			if((privacy.equals("Private")))
					{
			int group_id = user_jdbc.getGroupId(user.getUser_id());
			group.setGroup_id(group_id);
			//Now to get the video id of the newly added video
			video.setVideo_id(video_jdbc.getVideoId(video));
				System.out.println("HERE");
			if(video_jdbc.AddVideoToGroup(group,video))
				System.out.println("Private Video added successfully");
					}
			else
				System.out.println("Public Video added successfully");

		}
		else
			System.out.println("Failed to add the video");
		
		return true;
	}
	
	public List<Video> retrieveVideoOfAGroup(int group_id) {
		  List<Video>videos=new ArrayList<Video>();
		  Group group=new Group();
		  group.setGroup_id(group_id);
		  videos=video_jdbc.SearchByGroup(group);
		  return videos;
		 }
	
	public List<Video> PublicVideos(){
		return video_jdbc.PublicVideos();
	}

	public List<Event> fetchEvents() {
		List<Event>events=new ArrayList<Event>();
		events=video_jdbc.fetchingEvents();
		  return events;
	}
	public Video searchfordupPrivate(String url,String groupname)
	 {
	  url.replace("watch?v=", "embed/");
	  System.out.println("url is "+url);
	  return(video_jdbc.SearchForDuplicatePrivate(url, groupname));
	 }
	 public Video searchfordupPublic(String url)
	 {
	  url.replace("watch?v=", "embed/");
	  System.out.println("url is "+url);
	  return(video_jdbc.SearchForDuplicatePublic(url));
	 }
}
