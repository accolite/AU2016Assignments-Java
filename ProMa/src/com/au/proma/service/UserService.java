package com.au.proma.service;

import java.util.List;
import java.security.MessageDigest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.proma.dao.RoleDao;
import com.au.proma.dao.UserDao;
import com.au.proma.model.Project;
import com.au.proma.model.User;
import com.au.proma.util.SendMailTLS;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;

	
	public void notifyEachAdmin(String role,Project p, String subject) {
		// TODO Auto-generated method stub
		int roleId = roleDao.getRoleId(role);
		List<String>emails = userDao.getUsersEmailWithRoleId(roleId);
		SendMailTLS sendMail = new SendMailTLS();
		String content = "Project Details : "+"\n" 
				+"Project name : "+p.getProjectname() + "\n"
				+"Project resource working : "+p.getResourceworking() + "\n"
				 + "\n";
		int i;
		for(i=0; i<emails.size(); i++){
			System.out.println(emails.get(i));
			sendMail.sendMail(emails.get(i),subject,content);
		}
	}

	public User getUser(int userId) {
		// TODO Auto-generated method stub
		return userDao.getUser(userId);
	}

	public List<User> getAllUsers(){
		return userDao.getAllUsers();
	}
	
	public Boolean convertVisitorToAdmin(User user){
		Boolean isSuccess =  userDao.convertVisitorToAdmin(user);
		if(isSuccess)
		{
			String email = user.getUseremail();
			String subject = "Congratulation!!";
			
			String content = "You have been made an admin on ProMa "+"\n" + "It's a manner of honour";
			SendMailTLS mailTLS = new SendMailTLS();
			mailTLS.sendMail(email, subject, content);
		}
		return isSuccess;
	}
}
