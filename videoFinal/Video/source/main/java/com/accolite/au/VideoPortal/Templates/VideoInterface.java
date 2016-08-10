package com.accolite.au.VideoPortal.Templates;

import java.sql.Date;
import java.util.List;

import com.accolite.au.VideoPortal.model.Comment;
import com.accolite.au.VideoPortal.model.Group;
import com.accolite.au.VideoPortal.model.User;
import com.accolite.au.VideoPortal.model.Video;

public interface VideoInterface {

//	public int AddVideo(Video video, Group group, User user);

	public int AddVideo(Video video, User user);

	public int CreateGroupVideoTableEntry(Video video, Group group, User user);

	public int DeleteVideo(Video video);

	
	public Video PlayVideo(Video video);
	
	public List<Video> PublicVideos();

	public int AddComment(Video video, Comment comment, User user);

	public List<Comment> ViewComments(Video video);

	public List<Video> UserSearchVideoByTitle(String title, User user);

	public List<Video> UserSearchVideoByTopic(String topic, User user);

	public List<Video> UserSearchVideoByEvent(String event_name, User user);

	public List<Video> UserSearchVideoByDateOfAddition(Date date, User user);

	public List<Video> UserSearchVideoByDateOfEvent(Date date, User user);

	public List<Video> AdminSearchVideoByTitle(String title, User user);

	public List<Video> AdminSearchVideoByTopic(String topic, User user);

	public List<Video> AdminSearchVideoByEvent(String event_name, User user);

	public List<Video> AdminSearchVideoByDateOfAddition(Date date);

	public List<Video> AdminSearchVideoByDateOfEvent(Date date);

}
