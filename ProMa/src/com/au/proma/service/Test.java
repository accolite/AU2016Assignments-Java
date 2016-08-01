package com.au.proma.service;

import java.sql.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.au.proma.dao.ProjectDao;
import com.au.proma.model.BU;
import com.au.proma.model.Client;
import com.au.proma.model.Project;
import com.au.proma.model.User;

public class Test {
	
public static void main(String[] args) {
	Date sd=new Date(26, 7, 4);
	Date ed=new Date(26,7,27);
	Project pr=new Project();
	pr.setStartdate(sd);
	pr.setEnddate(ed);
	pr.setClient(new Client());
	pr.setBu(new BU());
	pr.setProjectmanager(new User());
	
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	ProjectDao pd = (ProjectDao) applicationContext.getBean("pdao");
	BU bu=new BU();
	bu.setBuid(1);
	System.out.println("go");
	//System.out.println(pd.insertProject(pr));
	System.out.println("go");
	for(Project p: pd.extractProjectsUnderBU(bu)){
		System.out.println(p.getProjectname());
	}
	
	
}
}
