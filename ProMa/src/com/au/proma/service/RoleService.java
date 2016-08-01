package com.au.proma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.proma.dao.RoleDao;

@Service
public class RoleService {

	@Autowired
	private RoleDao roleDao;
	
}
