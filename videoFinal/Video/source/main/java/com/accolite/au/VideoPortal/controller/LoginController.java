package com.accolite.au.VideoPortal.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accolite.au.VideoPortal.model.User;
import com.accolite.au.VideoPortal.model.Video;
import com.accolite.au.VideoPortal.service.GroupAdminService;
import com.accolite.au.VideoPortal.service.LoginService;
import com.accolite.au.VideoPortal.service.SiteAdminService;
import com.accolite.au.VideoPortal.service.UserService;
import com.accolite.au.VideoPortal.service.VideoService;

import Constants.Constants;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private UserService userService;

	@Autowired
	private SiteAdminService siteAdminService;

	@Autowired
	private GroupAdminService groupAdminService;

	@Autowired
	private VideoService videoService;

	@RequestMapping(value = "/SignIn", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public void addUser(@RequestParam("emailId") String email_id, @RequestParam("name") String name,
			HttpServletRequest servletRequest ,HttpServletResponse servletResponse) {

		servletRequest.getSession().setAttribute("email", email_id);
		servletRequest.getSession().setAttribute("name", name);

		String[] splitName = name.split("\\s+");
		String firstname = splitName[0];
		String lastname = splitName[1];

		int status = loginService.emailInDB(email_id);
		System.out.println(status);
		if (status == 0) {
			userService.AddUser(firstname, lastname, email_id);
		
		} else if (status == 1) {	
/*
			for (Video video : publicVideos) {
				System.out.println(video.getPrivacy());
			}*/
			try {
				servletResponse.sendRedirect(Constants.rootPath+"adminscreen.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {

			System.out.println("exception (-1)");
		}
	}
	@RequestMapping(value =  "/detectUser", method = RequestMethod.GET, produces = "application/json")
	 @ResponseBody
	 public User DetectUser(
	   HttpServletRequest servletRequest,HttpServletResponse httpServletResponse) throws ServletException, IOException {
	    String email = (String) servletRequest.getSession().getAttribute("email");
	    User x=userService.detectUser(email);
	    System.out.println("x= "+x.getFirstname());
	    return(x);
	 }
	@RequestMapping(value =  "/listAllUsers", method = RequestMethod.GET, produces = "application/json")
	 @ResponseBody
	 public List<User> listAllUsers(
	   HttpServletRequest servletRequest,HttpServletResponse httpServletResponse) throws ServletException, IOException {
	    String email = (String) servletRequest.getSession().getAttribute("email");
	    List<User> users=new ArrayList<User>();
	    users=userService.listAllExceptSiteAdmin();
	    return(users);
	 }
}
