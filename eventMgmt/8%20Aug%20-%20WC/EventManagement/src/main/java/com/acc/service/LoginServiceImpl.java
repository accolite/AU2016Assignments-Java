package com.acc.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.dao.AdminDAO;
import com.acc.dao.UserDAO;
import com.acc.model.Admin;
import com.acc.model.Person;
import com.acc.model.User;
import com.acc.util.GooglePOJO;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	AdminDAO adminDAO;
	
	@Autowired
	UserDAO userDAO;
	
	public Person checkLogin(GooglePOJO googlePojo, HttpServletRequest request){
		
		Person person = new Person();
    	person.setEmail(googlePojo.getEmail());
    	person.setName(googlePojo.getName());
    	String userType = null;
		
    	if(isAdmin(person))
			userType = "admin";
		else if(isUser(person))
			userType = "user";
		
    	if(userType.equals("admin")){
    		request.setAttribute("admin", person);
    		HttpSession session = request.getSession();
    		session.setAttribute("type", userType);
    	}
    	else if(userType.equals("user")){
    		request.setAttribute("user", person);
    		HttpSession session = request.getSession();
    		session.setAttribute("type", userType);
    	}
    	else
    		return new Person(-1,"Failure","failed@failed.com");
    	return person;
	}
	
	private boolean isAdmin(Person person){
		Admin admin = adminDAO.getAdmin(person);
		if(admin!=null)
			return true;
		return false;
	}
	
	private boolean isUser(Person person){
		User user = userDAO.getUser(person);
		if(user!=null)
			return true;
		if(userDAO.insertUser(person)>-1)
			return true;
		else 
			return false;
	}
	
}
