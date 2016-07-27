package com.spring.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.spring.Dao.UserDao;
import com.spring.Model.User;

public class UserService {
	private UserDao userDao=null;

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
		ApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext.xml");
		userDao= (UserDao)ac.getBean("udao");
		// TODO Auto-generated constructor stub
	}
	public Boolean registerUser(User user)
	{
		return userDao.registerUser(user);
	}
	public List<User> LoggedInUsers(){
		return userDao.LoggedInUsers();
	}
	public boolean LoginUser(User user){
		  String pass = userDao.getpassword(user);
		  if(user.getPassword().equals(pass)){
		   userDao.setActive(user);
		   return true;
		  }
		  return false;
		 }
}
