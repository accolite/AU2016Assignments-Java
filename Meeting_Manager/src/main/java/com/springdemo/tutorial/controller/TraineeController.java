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
import com.springdemo.tutorial.service.MeetingManagerService;

@Controller
public class TraineeController {

	@Autowired
	private MeetingManagerService serv;

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
	public String addTrainee(@RequestParam("SessionID") int SessionID, @RequestParam("UserID") int UserID,
			HttpServletRequest request) {
		if (checkuser(request) <= 0)
			return null;
		return serv.addTrainee(SessionID, UserID);
	}

	@RequestMapping(value = "/getWaitingSessions", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<Session> getWaitingSessions(@RequestParam("TraineeID") int TraineeID, HttpServletRequest request) {
		if (checkuser(request) <= 0)
			return null;
		return serv.getWaitingSessions(TraineeID);
	}

	@RequestMapping(value = "/getJoinedSessions", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<Session> getSessions(@RequestParam("TraineeID") int TraineeID, HttpServletRequest request) {
		if (checkuser(request) <= 0)
			return null;
		return serv.getJoinedSessions(TraineeID);
	}

	@RequestMapping(value = "/givePoll", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public int givePoll(@RequestParam("PollID") int PollID, @RequestParam("UserID") int UserID,
			@RequestParam("choice") int choice, HttpServletRequest request) {
		if (checkuser(request) <= 0)
			return -1;
		return serv.givePoll(PollID, UserID, choice);
	}

	@RequestMapping(value = "/checkavaltrainee", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Session checkaval(@RequestParam("id") int id) { // Take
		return serv.checkavaltrainee(id);
	}

	@RequestMapping(value = "/listActivePollTrainee", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<Poll> listActivePollTrainee(HttpServletRequest request) {
		if (checkuser(request) <= 0)
			return null;
		int trainee = (Integer) request.getSession().getAttribute("SessionID");
		System.out.println(trainee + "ATTEMPT1");
		return serv.listActivePollTrainee(trainee);
	}

}
