package com.springdemo.tutorial.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springdemo.tutorial.jdbctemplate.JDBCTemplateDao;
import com.springdemo.tutorial.model.Session;
import com.springdemo.tutorial.model.User;

@Controller
public class TraineeController {

	@Autowired
	private JDBCTemplateDao jdbc;

	@RequestMapping(value = "/addTrainee", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String addTrainee(@RequestParam("SessionID") int SessionID, @RequestParam("UserID") int UserID) {
		Session session = new Session();
		session.setSessionID(SessionID);
		User trainee = new User();
		trainee.setUserID(UserID);
		jdbc.addTrainee(trainee, session);
		return "Trainee added";
	}
	
	@RequestMapping(value = "/getJoinedSessions", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<Session> getSessions(@RequestParam("TraineeID") int TraineeID) {
		User Trainee = new User();
		Trainee.setUserID(TraineeID);
		return jdbc.getJoinedSessions(Trainee);
	}
}
