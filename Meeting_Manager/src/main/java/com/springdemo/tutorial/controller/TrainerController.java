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
import com.springdemo.tutorial.model.Session;
import com.springdemo.tutorial.model.User;
@Controller
public class TrainerController {
	@Autowired
	private JDBCTemplateDao jdbc;

	@RequestMapping(value = "/SendEmail", method = RequestMethod.GET, produces = "application/json")
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
		//jdbc.CheckSessionAvailabilityTrainer(Trainer);
		return jdbc.getSessions(Trainer);
	}


}
