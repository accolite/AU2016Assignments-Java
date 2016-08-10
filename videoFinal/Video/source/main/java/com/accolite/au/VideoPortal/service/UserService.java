package com.accolite.au.VideoPortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.au.VideoPortal.DAO.UserDAO;
import com.accolite.au.VideoPortal.model.User;

@Service
public class UserService {
	@Autowired
	private UserDAO jdbc;

	public boolean AddUser(String firstname, String lastname, String email_id) {
		if (jdbc.RetrieveUser(email_id) == null) {
			User user = new User();
			user.setEmail_id(email_id);
			user.setFirstname(firstname);
			user.setLastname(lastname);

			int result = jdbc.AddNewUser(user);
			System.out.println(result);

			if (result == 1)
				return true;
			else
				return false;
		}
		return false;
	}
	public User detectUser(String email) {
		  // TODO Auto-generated method stub
		  User user=jdbc.RetrieveUser(email);
		  return user;
		 }
	
	public boolean RemoveUser(int user_id) {
		if (jdbc.RetrieveUser(user_id) != null) {
			User user = new User();
			user.setUser_id(user_id);
			int result = jdbc.DeleteUser(user);
			if (result == 1)
				return true;
			else
				return false;
		}
		return false;
	}

	public User RetrieveUser(String email) {

		return jdbc.RetrieveUser(email);
	}
	public List<User> listAllExceptSiteAdmin() {
		// TODO Auto-generated method stub
		return jdbc.listAllUsersExceptSiteAdmin();
	}
}
