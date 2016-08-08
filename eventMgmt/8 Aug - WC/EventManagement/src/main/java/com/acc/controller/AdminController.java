package com.acc.controller;

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
	
	
	
	 @RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
	 @ResponseBody
	 public Integer addEventController(@RequestBody Admin admin, Model model){
		 return adminService.addAdmin(admin);
	 }
	
	  
}
