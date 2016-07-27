package com.au.chatboard.dao;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.au.chatboard.bean.Message;
import com.au.chatboard.bean.User;


public class Tester {
	public static void main(String[] args) {
		UserManager um = new ClassPathXmlApplicationContext("applicationContext.xml").getBean(UserManager.class);
		/*um.addUser(new User("ab","cd"));
		System.out.println(um.isExist("ab"));
		System.out.println(um.isExist("cd"));*/
		/*System.out.println(um.checkUser(new User("ab","cd")));
		System.out.println(um.checkUser(new User("ab1","cd")));
		System.out.println(um.checkUser(new User("ab","cd1")));
		*/
		
		
		MessageManager mm =  new ClassPathXmlApplicationContext("applicationContext.xml").getBean(MessageManager.class);
//		mm.addMessage(new Message("ab","message"));
		
		
		ActiveListManager alm =   new ClassPathXmlApplicationContext("applicationContext.xml").getBean(ActiveListManager.class);
//		System.out.println("A1"+alm.addUser("as"));
//		System.out.println("D1"+alm.getUsersList());
//		System.out.println("A2"+alm.addUser("ab"));
//		System.out.println("D2"+alm.getUsersList());
//		System.out.println("A3"+alm.addUser("as"));
//		System.out.println("D4"+alm.getUsersList());
	}	
}
