package com.au.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.au.dao.UserDao;
import com.au.model.User;

public class UserService {

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserService(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	public UserService() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

		userDao = (UserDao) ac.getBean("udao");
	}


	public Boolean registerUser(User user){
		return userDao.registerUser(user);
	}

	public List<User> getListofLoggedInUsers(){
		return  userDao.getListofLoggedInUsers();
	}
	
	public boolean doLoginUser(User user){
		String pass = userDao.getPassword(user);
		if(user.getPassword().equals(pass)){
			userDao.setActive(user);
			return true;
		}
		return false;
	}
	
}
