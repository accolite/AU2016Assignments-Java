package com.accolite.au.VideoPortal.Templates;

import com.accolite.au.VideoPortal.model.Group;
import com.accolite.au.VideoPortal.model.User;

public interface SiteAdminInterface {

	public int AddAdmin(User user);

	public int DeleteAdmin(User user);

//	public int CreateGroup(Group group, User groupAdmin);

	public int CreateGroup(Group group);

	
	public int DeleteGroup(Group group);

	public int RemoveEntriesInGroupAdmin(Group group);

	public int RemoveEntriesInGroupUserTable(Group group);

	public int RemoveEntriesInGroupVideoTable(Group group);

	public int CreateGroupAdmin(Group group, User groupAdmin);

	public User isSiteAdmin(User user);

	/*public User RetrieveSiteAdmin(int id);*/
	public User RetrieveSiteAdminExistsAsUser(String name);
}
