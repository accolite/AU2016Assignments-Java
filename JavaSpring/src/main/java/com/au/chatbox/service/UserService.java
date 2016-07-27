package com.au.chatbox.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.au.chatbox.dao.UserDao;
import com.au.chatbox.model.User;

@Service
public class UserService {

	public boolean checkUserDetails(User pageUser) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao) context.getBean("userDAO");
		User dbUser=userDao.getUserDetails(pageUser);
		boolean flag=true;
		if(dbUser.getUsername().equals(pageUser.getUsername()))
		{
			if(dbUser.getPassword().equals(pageUser.getPassword())){
				System.out.println("Successful Login");
				userDao.setUserToActive(dbUser);
				dbUser.setStatus("active");
			}
			else{
				System.out.println("Invalid password");
				flag=false;
			}
		}
		else {
			
			System.out.println("Not a registered user");
			flag=false;
		}
		return flag;
	
}
}
