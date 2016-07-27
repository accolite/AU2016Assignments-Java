package com.smruti.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.smruti.jdbctemplate.JDBCTemplateDao;
import com.smruti.jdbctemplate.User;

@Service
public class UserServices {

	public Boolean validity(User  pageUser) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		JDBCTemplateDao jdbcDao = (JDBCTemplateDao) context.getBean("jdbctemplateDAO");
		User dbUser=jdbcDao.getUser(pageUser);
		if(dbUser.getName().equals(pageUser.getName()))
		{
			if(dbUser.getPassword().equals(pageUser.getPassword())){
				dbUser.setStatus("Active");
				jdbcDao.setStatus(dbUser);
				return true;
			}
			else
				return false;
		}
		return false;
	}
	
}
