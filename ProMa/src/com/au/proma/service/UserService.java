package com.au.proma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.proma.dao.UserDao;
import com.au.proma.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public Boolean addUser(User user) {
		// TODO Auto-generated method stub
		int no_of_records_updated = userDao.addUser(user);
		if(no_of_records_updated > 0)
			return true;
		else {
			return false;
		}
	}

	public List<User> getAllUsers(){
		return userDao.getAllUsers();
	}
}
