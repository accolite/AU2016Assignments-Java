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

	
	public void notifyEachAdmin(String role,Project p, String msg) {
		// TODO Auto-generated method stub
		int roleId = roleDao.getRoleId(role);
		List<String>emails = userDao.getUsersEmailWithRoleId(roleId);
		SendMailTLS sendMail = new SendMailTLS();
		int i;
		for(i=0; i<emails.size(); i++){
			System.out.println(emails.get(i));
			sendMail.sendMail(emails.get(i),p,msg);
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
		return userDao.convertVisitorToAdmin(user);
		
	}
	public List<User> getAllVisitors(){
		return userDao.getAllVisitors();
	}
	public List<User> getAllAdmins(){
		return userDao.getAllAdmins();
	}

	public Boolean convertAdminToVisitor(User user){
		return userDao.convertAdminToVisitor(user);
	}
}
