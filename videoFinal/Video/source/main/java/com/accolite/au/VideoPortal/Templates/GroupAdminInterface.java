package com.accolite.au.VideoPortal.Templates;

import com.accolite.au.VideoPortal.model.Group;
import com.accolite.au.VideoPortal.model.User;
import com.accolite.au.VideoPortal.model.Video;

public interface GroupAdminInterface {
 
	public int AddUser(Group group,User user);
	public int RemoveUser(Group group,User user);
	//public int ApproveVideo(Group group,Video video,User user);
	public int ApproveVideo(Video video,User user);
	public Video RetrieveVideo(Video video);
	public User isGroupAdmin(User user);
}
