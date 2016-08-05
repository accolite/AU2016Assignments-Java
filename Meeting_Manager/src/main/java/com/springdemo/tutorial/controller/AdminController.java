package com.springdemo.tutorial.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springdemo.tutorial.jdbctemplate.JDBCTemplateDao;
import com.springdemo.tutorial.model.*;
import com.springdemo.tutorial.service.MeetingManagerService;

@Controller
public class AdminController {
	@Autowired
	private MeetingManagerService serv;
	//private JDBCTemplateDao jdbc;

	public int checkuser(HttpServletRequest request) {
		String string = (String) request.getSession().getAttribute("role");
		if (string.equals("admin"))
			return 1;
		else if (string.equals("user")) {
			return 2;
		} else {
			return -1;
		}
	}
	
	
	@RequestMapping(value = "/getSessionAttribute", method = RequestMethod.GET, produces = "application/json")
	 @ResponseBody
	 public String getSessionAttribute(@RequestParam("attribute") String attribute, HttpServletRequest request) { // Take                   // int
	 
	  String resp = (String) request.getSession().getAttribute(attribute);
	  return resp;
	 }
	 
	 @RequestMapping(value = "/getSessionid", method = RequestMethod.GET, produces = "application/json")
	 @ResponseBody
	 public String getSessionid(HttpServletRequest request) { // Take                   // int
	  Integer resp = (Integer) request.getSession().getAttribute("SessionID");
	  return resp.toString();
	 }
	
	@RequestMapping(value = "/createSession", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String createSession(@RequestParam("SessionName") String SessionName,
			@RequestParam("TrainerID") int TrainerID, @RequestParam("Date") Date date,
			@RequestParam("StartTime") String StartTime, @RequestParam("EndTime") String EndTime, HttpServletRequest request) {
		if( checkuser(request) <= 0)
			return null;
		serv.CreateSession(SessionName, TrainerID, date, StartTime, EndTime);
		return "Session is created";
	}

	@RequestMapping(value = "feedback", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Feedback getFeedback(@RequestParam("SessionID") int sessionID, HttpServletRequest request) { // Take
		if( checkuser(request) <= 0)
			return null;
		return serv.getFeedback(sessionID);
	}

	@RequestMapping(value = "fetchFeedback", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Feedback fetchFeedback(@RequestParam("SessionID") int sessionID, HttpServletRequest request) { // Take
																				// int
		if( checkuser(request) <= 0)
			return null;																		// SessionID
		return serv.fetchFeedback(sessionID);
	}

	 @RequestMapping(value = "/avgFeedback", method = RequestMethod.GET, produces = "application/json")
	 @ResponseBody
	 public Feedback updateFeedback(@RequestParam("SessionID") int sessionID, @RequestParam("f1") int f1,
	   @RequestParam("f2") int f2, @RequestParam("f3") int f3, @RequestParam("f4") int f4, HttpServletRequest request) { // Take
	                         // int
	                         // SessionID
	  if( checkuser(request) <= 0)
	   return null;
	  int userID=(Integer) request.getSession().getAttribute("SessionID");
	  return serv.avgFeedback(sessionID, f1, f2, f3, f4,userID);
	 }
	


	/*
	 * @RequestMapping(value = "/addTrainer", method = RequestMethod.GET,
	 * produces = "application/json")
	 * 
	 * @ResponseBody public String addTrainer(@RequestParam("SessionID") int
	 * SessionID, @RequestParam("TrainerID") int TrainerID) { Session session =
	 * new Session(); session.setSessionID(SessionID); User trainer = new
	 * User(); trainer.setUserID(TrainerID); jdbc.addTrainer(trainer, session);
	 * return "Session alloted to Trainer"; }
	 */

}
