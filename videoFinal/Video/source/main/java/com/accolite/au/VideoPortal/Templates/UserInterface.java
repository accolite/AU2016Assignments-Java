package com.accolite.au.VideoPortal.Templates;

import com.accolite.au.VideoPortal.model.User;

public interface UserInterface {

	public int AddNewUser(User user);

	public int DeleteUser(User user);

	public User RetrieveUser(int id);

	public User RetrieveUser(String email);

}
