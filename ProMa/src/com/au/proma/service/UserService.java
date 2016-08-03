package com.au.proma.service;

import java.util.List;

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

	public Boolean addUser(User user) {
		// TODO Auto-generated method stub
		int no_of_records_updated = userDao.addUser(user);
		if(no_of_records_updated > 0)
			return true;
		else {
			return false;
		}
	}

	public void notifyEachAdmin(String role,Project p) {
		// TODO Auto-generated method stub
		int roleId = roleDao.getRoleId(role);
		List<String>emails = userDao.getUsersEmailWithRoleId(roleId);
		SendMailTLS sendMail = new SendMailTLS();
		int i;
		for(i=0; i<emails.size(); i++){
			System.out.println(emails.get(i));
			sendMail.sendMail(emails.get(i),p);
		}
	}

}
