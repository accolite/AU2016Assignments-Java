package com.accolite.au.VideoPortal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.au.VideoPortal.DAO.LoginDAO;

@Service
public class LoginService {

	@Autowired
	private LoginDAO loginDAO;

	 public int emailInDB(String email) {
		  return loginDAO.emailInDB(email);
		 }
	
}
