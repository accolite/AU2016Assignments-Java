package com.springdemo.tutorial.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.tutorial.controller.SendTraineeMails;
import com.springdemo.tutorial.jdbctemplate.JDBCTemplateDao;
import com.springdemo.tutorial.model.*;

@Service
public class MeetingManagerService {
	@Autowired
	private JDBCTemplateDao jdbc;

	public void CreateSession(String SessionName, int TrainerID, Date date, String StartTime, String EndTime) {
		Session session = new Session();
		session.setSessionName(SessionName);
		session.setTrainerID(TrainerID);
		session.setDate(date);
		session.setStartTime(StartTime);
		session.setEndTime(EndTime);
		jdbc.createSession(session);
	}

	public Feedback getFeedback(int sessionID) {
		Session s = new Session();
		s.setSessionID(sessionID);
		Feedback feedback = new Feedback(s.getSessionID()); // New Session( int
		jdbc.setFeedback(feedback); // SessionID, 0 0 0
		return feedback; // Instead of passing int, pass the session.
	}

	public Feedback fetchFeedback(int sessionID) {
		Session s = new Session();
		s.setSessionID(sessionID);
		Feedback feedback = jdbc.fetchFeedback(s); // Instead of passing int,
		return feedback;
	}

	public Feedback avgFeedback(int sessionID, int f1, int f2, int f3, int f4, int userID) {
		Session s = new Session();
		s.setSessionID(sessionID);
		User user = new User();
		user.setUserID(userID);
		Feedback feedback = new Feedback(s.getSessionID(), f1, f2, f3, f4);
		jdbc.updateFeedback(feedback, user);
		return feedback;
	}

	public String addTrainee(int SessionID, int UserID) {
		Session session = new Session();
		session.setSessionID(SessionID);
		User trainee = new User();
		trainee.setUserID(UserID);
		jdbc.addTrainee(trainee, session);
		return "Trainee added";
	}

	public ArrayList<Session> getWaitingSessions(int TraineeID) {
		User Trainee = new User();
		Trainee.setUserID(TraineeID);
		System.out.println(TraineeID);
		return jdbc.getWaitingSessions(Trainee);
	}

	public ArrayList<Session> getJoinedSessions(int TraineeID) {
		User Trainee = new User();
		Trainee.setUserID(TraineeID);
		System.out.println(TraineeID);
		return jdbc.getJoinedSessions(Trainee);
	}

	public int givePoll(int PollID, int UserID, int choice) {
		Poll p = new Poll();
		p.setPollID(PollID);
		User u = new User();
		u.setUserID(UserID);
		return jdbc.givePoll(u, p, choice);
	}

	public ArrayList<Session> getSessions(int TrainerID) {
		User Trainer = new User();
		Trainer.setUserID(TrainerID);
		return jdbc.getSessions(Trainer);
	}

	public ArrayList<User> SendEmail(int SessionID, String Subject, String Message) {
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

	public int[] sendInvite(String Emails, int sessionID, int trainerID) {
		String[] emails = Emails.split(",");
		Session session = new Session();
		session.setSessionID(sessionID);
		session.setTrainerID(trainerID);
		ArrayList<User> users = jdbc.getUserIDs(emails, session);
		int[] userID = new int[users.size()];
		for (int i = 0; i < users.size(); i++) {
			userID[i] = users.get(i).getUserID();
		}
		return userID;
	}

	public int addPoll(String q, String o1, String o2, String o3, String o4, int sessionID) {
		Poll p = new Poll(0, q, o1, o2, o3, o4);
		p.setSessionID(sessionID);
		return jdbc.addPoll(p);
	}

	public int[] fetchPoll(int PollID) {
		Poll p = new Poll();
		p.setPollID(PollID);
		return jdbc.fetchPoll(p);
	}

	public Session checkaval(int id) {
		User u = new User();
		u.setUserID(id);
		return jdbc.CheckSessionAvailabilityTrainer(u);
	}

	public Session checkavaltrainee(int id) {
		User u = new User();
		u.setUserID(id);
		return jdbc.CheckSessionAvailabilityTrainee(u);
	}

	public int closePoll(int PollID) {
		Poll p = new Poll();
		p.setPollID(PollID);
		return jdbc.closePoll(p);
	}

	public ArrayList<Poll> listActivePollTrainer(int trainerID) {
		User user = new User();
		user.setUserID(trainerID);
		return jdbc.listActivePollTrainer(user);
	}

	public ArrayList<Poll> listActivePollTrainee(int traineeID) {
		User user = new User();
		user.setUserID(traineeID);
		return jdbc.listActivePollTrainee(user);
	}
}
