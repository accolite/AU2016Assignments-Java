/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Aug 10, 2016

*

*  @author :: Udit Mehata

* ***************************************************************************

*/
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

// TODO: Auto-generated Javadoc
/**
 * The Class AdminController.
 */
@Controller
public class AdminController {
	
	/** The serv. */
	@Autowired
	private MeetingManagerService serv;

	/**
	 * Checkuser.
	 *
	 * @param request the request
	 * @return the int
	 */
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

	/**
	 * Gets the all users.
	 *
	 * @param request the request
	 * @return the all users
	 */
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<User> getAllUsers(HttpServletRequest request) { // Take //
																		// int
		if (checkuser(request) <= 0)
			return null;
		return serv.getAllUsers();
	}

	/**
	 * Gets the session attribute.
	 *
	 * @param attribute the attribute
	 * @param request the request
	 * @return the session attribute
	 */
	@RequestMapping(value = "/getSessionAttribute", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String getSessionAttribute(@RequestParam("attribute") String attribute, HttpServletRequest request) { // Take
																													// //
																													// int

		String resp = (String) request.getSession().getAttribute(attribute);
		return resp;
	}

	/**
	 * Gets the sessionid.
	 *
	 * @param request the request
	 * @return the sessionid
	 */
	@RequestMapping(value = "/getSessionid", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String getSessionid(HttpServletRequest request) { // Take // int
		Integer resp = (Integer) request.getSession().getAttribute("SessionID");
		return resp.toString();
	}

	/**
	 * Creates the session.
	 *
	 * @param SessionName the session name
	 * @param TrainerID the trainer ID
	 * @param date the date
	 * @param StartTime the start time
	 * @param EndTime the end time
	 * @param request the request
	 * @return the string
	 */
	@RequestMapping(value = "/createSession", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String createSession(@RequestParam("SessionName") String SessionName,
			@RequestParam("TrainerID") int TrainerID, @RequestParam("Date") Date date,
			@RequestParam("StartTime") String StartTime, @RequestParam("EndTime") String EndTime,
			HttpServletRequest request) {
		if (checkuser(request) <= 0)
			return null;
		serv.CreateSession(SessionName, TrainerID, date, StartTime, EndTime);
		return "Session is created";
	}

	/**
	 * Gets the feedback.
	 *
	 * @param sessionID the session ID
	 * @param request the request
	 * @return the feedback
	 */
	@RequestMapping(value = "feedback", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Feedback getFeedback(@RequestParam("SessionID") int sessionID, HttpServletRequest request) { // Take
		if (checkuser(request) <= 0)
			return null;
		return serv.getFeedback(sessionID);
	}

	/**
	 * Fetch feedback.
	 *
	 * @param sessionID the session ID
	 * @param request the request
	 * @return the feedback
	 */
	@RequestMapping(value = "fetchFeedback", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Feedback fetchFeedback(@RequestParam("SessionID") int sessionID, HttpServletRequest request) { // Take
		// int
		if (checkuser(request) <= 0)
			return null; // SessionID
		return serv.fetchFeedback(sessionID);
	}

	/**
	 * Fetch sessions admin.
	 *
	 * @param TraineeID the trainee ID
	 * @param request the request
	 * @return the array list
	 */
	@RequestMapping(value = "/fetchSessionsAdmin", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<Session> fetchSessionsAdmin(@RequestParam("TraineeID") int TraineeID, HttpServletRequest request) {
		if (checkuser(request) <= 0)
			return null;
		return serv.fetchSessionsAdmin(TraineeID);
	}

	/**
	 * Update feedback.
	 *
	 * @param sessionID the session ID
	 * @param f1 the f 1
	 * @param f2 the f 2
	 * @param f3 the f 3
	 * @param f4 the f 4
	 * @param request the request
	 * @return the feedback
	 */
	@RequestMapping(value = "/avgFeedback", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Feedback updateFeedback(@RequestParam("SessionID") int sessionID, @RequestParam("f1") int f1,
			@RequestParam("f2") int f2, @RequestParam("f3") int f3, @RequestParam("f4") int f4,
			HttpServletRequest request) { // Take
		// int
		// SessionID
		if (checkuser(request) <= 0)
			return null;
		int userID = (Integer) request.getSession().getAttribute("SessionID");
		return serv.avgFeedback(sessionID, f1, f2, f3, f4, userID);
	}
}
