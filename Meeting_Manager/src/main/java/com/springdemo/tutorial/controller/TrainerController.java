package com.springdemo.tutorial.controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.api.client.http.HttpRequest;
import com.springdemo.tutorial.jdbctemplate.JDBCTemplateDao;
import com.springdemo.tutorial.model.Poll;
import com.springdemo.tutorial.model.Session;
import com.springdemo.tutorial.model.User;
import com.springdemo.tutorial.service.MeetingManagerService;

@Controller
public class TrainerController {

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

	@RequestMapping(value = "/sendInvite", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public int[] sendInvite(@RequestParam("SessionID") int sessionID, @RequestParam("TrainerID") int trainerID,
			@RequestParam("Emails") String Emails, HttpServletRequest request) {
		if (checkuser(request) <= 0)
			return null;
		return serv.sendInvite(Emails, sessionID, trainerID);
	}

	@RequestMapping(value = "/sendEmail", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<User> SendEmail(@RequestParam("SessionID") int SessionID, @RequestParam("Subject") String Subject,
			@RequestParam("Message") String Message, HttpServletRequest request) {
		if (checkuser(request) <= 0)
			return null;
		return serv.SendEmail(SessionID, Subject, Message);

	}

	@RequestMapping(value = "/getSessions", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<Session> getSessions(@RequestParam("TrainerID") int TrainerID, HttpServletRequest request) {
		if (checkuser(request) <= 0)
			return null;
		return serv.getSessions(TrainerID);
	}

	@RequestMapping(value = "/checkavaltrainer", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Session checkaval(@RequestParam("id") int id) { // Take
		return serv.checkaval(id);
	}

	/* EXPIREMENTAL POLLING CODE FOLLOWS */

	@RequestMapping(value = "/closePoll", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public int closePoll(@RequestParam("PollID") int PollID, HttpServletRequest request) {
		if (checkuser(request) <= 0)
			return 0;
		return serv.closePoll(PollID);
	}

	@RequestMapping(value = "/listActivePollTrainer", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<Poll> listActivePollTrainer(HttpServletRequest request) {
		if (checkuser(request) <= 0)
			return null;
		int trainer = (Integer) request.getSession().getAttribute("SessionID");
		System.out.println(trainer + "ATTEMPT1");
		return serv.listActivePollTrainer(trainer);
	}

	@RequestMapping(value = "/addPoll", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public int addPoll(@RequestParam("q") String q, @RequestParam("o1") String o1, @RequestParam("o2") String o2,
			@RequestParam("o3") String o3, @RequestParam("o4") String o4, @RequestParam("SessionID") int sessionID,
			HttpServletRequest request) {
		if (checkuser(request) <= 0)
			return 0;
		return serv.addPoll(q, o1, o2, o3, o4, sessionID);
	}

	@RequestMapping(value = "/fetchPoll", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public int[] fetchPoll(@RequestParam("PollID") int PollID, HttpServletRequest request) {
		if (checkuser(request) <= 0)
			return null;
		return serv.fetchPoll(PollID);
	}

}
