package com.acc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.dao.AdminDAO;
import com.acc.model.Admin;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDAO adminDAO;
	
	public Integer addAdmin(Admin admin){
		return adminDAO.insertAdmin(admin);
	}
	
}
