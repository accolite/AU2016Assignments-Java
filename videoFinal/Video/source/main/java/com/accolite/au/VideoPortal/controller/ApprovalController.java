package com.accolite.au.VideoPortal.controller;

import java.util.List;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accolite.au.VideoPortal.DAO.ApprovalDAO;
import com.accolite.au.VideoPortal.DAO.SiteAdminDAO;
import com.accolite.au.VideoPortal.DAO.UserDAO;
import com.accolite.au.VideoPortal.model.Video;
import com.accolite.au.VideoPortal.service.ApprovalService;
import com.accolite.au.VideoPortal.service.SiteAdminService;

@Controller
public class ApprovalController {
 @Autowired
 private ApprovalDAO jdbc;
 @Autowired
 private SiteAdminService site_service;
 @Autowired
 private SiteAdminDAO site_DAO;
 @Autowired
 private ApprovalDAO app_DAO;
 @Autowired
 private UserDAO user_dao;
 @Autowired
 private ApprovalService service;
 @RequestMapping(value = "/FetchVideosForApproval", method = RequestMethod.GET, produces = "application/json")
 @ResponseBody
 public List<Video> FetchVideo(HttpServletRequest servletRequest) {
  String email = (String) servletRequest.getSession().getAttribute("email");
  return service.fetchVideoForRoles(email);
  
 }
 @RequestMapping(value = "/ApproveVideo", method = RequestMethod.GET, produces = "application/json")
 @ResponseBody
 public void ApproveVideo(@RequestParam("video_id") int video_id,HttpServletRequest servletRequest) throws NamingException {
  String email = (String) servletRequest.getSession().getAttribute("email");
  
   service.approveThisVideo(video_id,email);
  
 }
 @RequestMapping(value = "/RejectVideo", method = RequestMethod.GET, produces = "application/json")
 @ResponseBody
 public void RejectVideo(@RequestParam("video_id") int video_id,HttpServletRequest servletRequest) throws NamingException {
  String email = (String) servletRequest.getSession().getAttribute("email");
  System.out.println("here");
   service.rejectThisVideo(video_id,email);
  
 }
}