package com.accolite.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accolite.dao.Userdao;


public class Main {
	public static void main(String a[]){
		System.out.println("Before Spring");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		User u1 = (User)context.getBean("user");
		System.out.println("After Spring");
		System.out.println("Name:"+u1.getName()+" Id:"+u1.getId());
		
		Userdao jdbcTemplateDao = context.getBean(Userdao.class);
		//User user = new User();
		/*user.setStudentId(2);
		student.setStudentName("AU Prepared 2016");*/
		//jdbcTemplateDao.saveStudent(student);
		//jdbcTemplateDao.saveStudentUsingPreparedStatement(student);
		User user = jdbcTemplateDao.getUser(1);
		System.out.println(user.getName());
	}
}
