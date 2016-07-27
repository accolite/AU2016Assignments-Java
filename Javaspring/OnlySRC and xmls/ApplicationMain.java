package com.springdemo.tutorial;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdemo.tutorial.jdbctemplate.JDBCTemplateDao;
import com.springdemo.tutorial.jdbctemplate.Student;

public class ApplicationMain {
	
	
	public static void main(String[] args) {
		System.out.println("Before Spring....");
		HelloWorld helloWorld = new HelloWorld("AU 2016");
		helloWorld.setName("AU 2016 prop");
		helloWorld.printHello();
		
		/*System.out.println("After Spring.....");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld helloWorld1 = (HelloWorld)applicationContext.getBean("helloworld");
		helloWorld1.printHello();*/
		
/*		System.out.println("After Spring.....Constructor Injection");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld helloWorld1 = (HelloWorld)applicationContext.getBean("helloworld");
		helloWorld1.printHello();*/
		
		System.out.println("Spring Reference...");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
/*		A a = (A) applicationContext.getBean("a1");
		B b = a.getB();
		System.out.println("P : "+b.getP()+" Q: "+b.getQ()+" R: "+b.getR());*/
		
/*		B b1 = (B) applicationContext.getBean("b");
		System.out.println("B1:  P : "+b1.getP()+" Q: "+b1.getQ()+" R: "+b1.getR());
		b1.setP(25);
		
		B b2 = (B) applicationContext.getBean("b");
		System.out.println("B2: P : "+b2.getP()+" Q: "+b2.getQ()+" R: "+b2.getR());*/
		
		
/*		Question question = (Question)applicationContext.getBean("question");
		List<String> name = question.getValues();
		for(String na : name){
			System.out.println(na);
		}*/
		
		JDBCTemplateDao jdbcTemplateDao = applicationContext.getBean(JDBCTemplateDao.class);
		Student student = new Student();
		student.setStudentId(2);
		student.setStudentName("AU Prepared 2016");
		jdbcTemplateDao.saveStudent(student);
		//jdbcTemplateDao.saveStudentUsingPreparedStatement(student);
		Student student2 = jdbcTemplateDao.getStudent(2);
		System.out.println(student2.getStudentId()+" "+student2.getStudentName());
		
	}

}
