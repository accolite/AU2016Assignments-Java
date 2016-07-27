package com.au.chatboxspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.chatboxspring.dao.ChatBoxDAO;
import com.au.chatboxspring.model.User;

@Service
public class ChatBoxService {

	@Autowired
	ChatBoxDAO chatBoxDAO;
	
	public int  loginService(User user) {		
			User userDao= chatBoxDAO.loginDAOImplementation(user);
			if(user.getPassword().equals(userDao.getPassword()))
					{
							return 1;
					}
			else
			{
				return 0;
			}
	}

	public void registerService(User user) {
		
		chatBoxDAO.registerDAOImplementation(user);
	}

}
