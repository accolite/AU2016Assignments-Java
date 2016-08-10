package com.acc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acc.model.Admin;
import com.acc.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
    private AdminService adminService;
	
	
	
	 public AdminService getAdminService() {
		return adminService;
	}



	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}



	@RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
	 @ResponseBody
	 public Integer addEventController(@RequestBody Admin admin, HttpServletRequest request, Model model){
		 if(request.getSession(false)!=null && request.getSession(false).getAttribute("type")=="admin")
			 return adminService.addAdmin(admin);
		 else
			 return null;
	 }
	
	  
}
