/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Aug 10, 2016
*
*  @author :: Sharukh Mohamed
* ***************************************************************************
*/
package com.acc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.dao.AdminDAO;
import com.acc.model.Admin;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminServiceImpl.
 */
@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDAO adminDAO;
	
	public AdminDAO getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	/* (non-Javadoc)
	 * @see com.acc.service.AdminService#addAdmin(com.acc.model.Admin)
	 */
	public Integer addAdmin(Admin admin){
		return adminDAO.insertAdmin(admin);
	}
	
}
