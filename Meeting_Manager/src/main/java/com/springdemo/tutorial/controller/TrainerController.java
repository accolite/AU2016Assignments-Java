package com.springdemo.tutorial.controller;

import java.util.ArrayList;
import java.util.Iterator;

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
public class TrainerController {
	@Autowired
	private JDBCTemplateDao jdbc;

	@RequestMapping(value = "/sendInvite", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public int[] sendInvite(@RequestParam("SessionID") int sessionID, @RequestParam("TrainerID") int trainerID,
			@RequestParam("Emails") String Emails) {
		String[] emails = Emails.split(",");
		Session session = new Session();
		session.setSessionID(sessionID);
		session.setTrainerID(trainerID);
		// session.setStartTime(((Time)'09:00:00.00'));
		ArrayList<User> users = jdbc.getUserIDs(emails, session);
		int[] userID = new int[users.size()];
		for (int i = 0; i < users.size(); i++) {
			userID[i] = users.get(i).getUserID();
		}
		return userID;
	}

	@RequestMapping(value = "/sendEmail", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<User> SendEmail(@RequestParam("SessionID") int SessionID, @RequestParam("Subject") String Subject,
			@RequestParam("Message") String Message) {
		Session session = new Session();
		session.setSessionID(SessionID);
		String subject = Subject;
		String message = Message;
		ArrayList<User> u = jdbc.SendEmail(session, subject, message);
		Iterator itr = u.iterator();
		while (itr.hasNext()) {
			User t = (User) itr.next();
			SendTraineeMails stm = new SendTraineeMails(t.getUserEmail(), Subject, Message);
			stm.mailsend();
		}
		return u;

	}

	@RequestMapping(value = "/getSessions", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<Session> getSessions(@RequestParam("TrainerID") int TrainerID) {
		User Trainer = new User();
		Trainer.setUserID(TrainerID);
		// jdbc.CheckSessionAvailabilityTrainer(Trainer);
		return jdbc.getSessions(Trainer);
	}

	/* EXPIREMENTAL POLLING CODE FOLLOWS */

	@RequestMapping(value = "/addPoll", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public int addPoll(@RequestParam("q") String q, @RequestParam("o1") String o1, @RequestParam("o2") String o2,
			@RequestParam("o3") String o3, @RequestParam("o4") String o4) {
		Poll p = new Poll(0, q, o1, o2, o3, o4);
		return jdbc.addPoll(p);
	}

	@RequestMapping(value = "/fetchPoll", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public int[] fetchPoll(@RequestParam("PollID") int PollID) {
		Poll p = new Poll();
		p.setPollID(PollID);
		return jdbc.fetchPoll(p);
	}

}
