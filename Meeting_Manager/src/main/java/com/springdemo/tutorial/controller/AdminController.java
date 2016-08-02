package com.springdemo.tutorial.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springdemo.tutorial.jdbctemplate.JDBCTemplateDao;
import com.springdemo.tutorial.model.*;

@Controller
public class AdminController {
	@Autowired
	private JDBCTemplateDao jdbc;

	@RequestMapping(value = "/createSession", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String createSession(@RequestParam("SessionName") String SessionName,
			@RequestParam("TrainerID") int TrainerID, @RequestParam("Date") Date date,
			@RequestParam("StartTime") String StartTime, @RequestParam("EndTime") String EndTime) {
		Session session = new Session();
		session.setSessionName(SessionName);
		session.setTrainerID(TrainerID);
		session.setDate(date);
		session.setStartTime(StartTime);
		session.setEndTime(EndTime);
		jdbc.createSession(session);

		return "Session is created";
	}

	@RequestMapping(value = "/feedback", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Feedback getFeedback(@RequestParam("SessionID") int sessionID) { // Take
																			// int
																			// SessionID
		Session s = new Session();
		s.setSessionID(sessionID);
		Feedback feedback = new Feedback(s.getSessionID()); // New Session( int
															// SessionID, 0 0 0
															// 0 )
		jdbc.setFeedback(feedback); // Instead of passing int, pass the session.
		return feedback;
	}

	@RequestMapping(value = "/avgFeedback", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Feedback updateFeedback(@RequestParam("SessionID") int sessionID, @RequestParam("f1") int f1,
			@RequestParam("f2") int f2, @RequestParam("f3") int f3, @RequestParam("f4") int f4) { // Take
																									// int
																									// SessionID
		Session s = new Session();
		s.setSessionID(sessionID);
		Feedback feedback = new Feedback(s.getSessionID(), f1, f2, f3, f4); // New
																			// Session(
																			// int
																			// SessionID,
																			// 0
																			// 0
																			// 0
																			// 0
																			// )
		jdbc.updateFeedback(feedback); // Instead of passing int, pass the
										// session.
		return feedback;
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
