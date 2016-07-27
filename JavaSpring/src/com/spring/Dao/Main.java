package com.spring.Dao;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.Model.User;

public class Main {
	//private static final String List=null;
	public static void main(String[] args)
	{
		ApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao u= (UserDao)ac.getBean("udao");
	//	u.registerUser(new User("Ar",1,"arka"));
		//u.registerUser(new User("Anshika",1,"anshika"));
		System.out.println(u.getpassword(new User("Arnika",0,"a")));
		List<User> l = u.LoggedInUsers();
		  for (User user : l) {
		   System.out.println(user.getUsername());
		  }
		MessageDao m=(MessageDao)ac.getBean("msgdao");
		
	}
}
