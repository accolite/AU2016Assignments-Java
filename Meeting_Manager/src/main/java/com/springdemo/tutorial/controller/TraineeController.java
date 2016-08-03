package com.springdemo.tutorial.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springdemo.tutorial.jdbctemplate.JDBCTemplateDao;
import com.springdemo.tutorial.model.Poll;
import com.springdemo.tutorial.model.Session;
import com.springdemo.tutorial.model.User;

@Controller
public class TraineeController {

	@Autowired
	private JDBCTemplateDao jdbc;

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

	@RequestMapping(value = "/addTrainee", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String addTrainee(@RequestParam("SessionID") int SessionID, @RequestParam("UserID") int UserID, HttpServletRequest request) {
		if( checkuser(request) <= 0)
			return null;
		Session session = new Session();
		session.setSessionID(SessionID);
		User trainee = new User();
		trainee.setUserID(UserID);
		jdbc.addTrainee(trainee, session);
		return "Trainee added";
	}

	@RequestMapping(value = "/getJoinedSessions", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<Session> getSessions(@RequestParam("TraineeID") int TraineeID, HttpServletRequest request) {
		if( checkuser(request) <= 0)
			return null;
		User Trainee = new User();
		Trainee.setUserID(TraineeID);
		return jdbc.getJoinedSessions(Trainee);
	}

	@RequestMapping(value = "/givePoll", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public int givePoll(@RequestParam("PollID") int PollID, @RequestParam("UserID") int UserID,
			@RequestParam("choice") int choice, HttpServletRequest request) {
		if( checkuser(request) <= 0)
			return -1;
		Poll p = new Poll();
		p.setPollID(PollID);
		User u = new User();
		u.setUserID(UserID);
		return jdbc.givePoll(u, p, choice);
	}

}
