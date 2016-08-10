package com.springdemo.tutorial.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.tutorial.controller.SendTraineeMails;
import com.springdemo.tutorial.jdbctemplate.JDBCTemplateDao;
import com.springdemo.tutorial.model.*;

// TODO: Auto-generated Javadoc
/**
 * The Class MeetingManagerService.
 */
@Service
public class MeetingManagerService {
	
	/** The jdbc. */
	@Autowired
	private JDBCTemplateDao jdbc;

	/**
	 * Creates the session.
	 *
	 * @param SessionName the session name
	 * @param TrainerID the trainer ID
	 * @param date the date
	 * @param StartTime the start time
	 * @param EndTime the end time
	 */
	public void CreateSession(String SessionName, int TrainerID, Date date, String StartTime, String EndTime) {
		Session session = new Session();
		session.setSessionName(SessionName);
		session.setTrainerID(TrainerID);
		session.setDate(date);
		session.setStartTime(StartTime);
		session.setEndTime(EndTime);
		jdbc.createSession(session);
	}

	/**
	 * Gets the feedback.
	 *
	 * @param sessionID the session ID
	 * @return the feedback
	 */
	public Feedback getFeedback(int sessionID) {
		Session s = new Session();
		s.setSessionID(sessionID);
		Feedback feedback = new Feedback(s.getSessionID()); // New Session( int
		jdbc.setFeedback(feedback); // SessionID, 0 0 0
		return feedback; // Instead of passing int, pass the session.
	}

	/**
	 * Fetch feedback.
	 *
	 * @param sessionID the session ID
	 * @return the feedback
	 */
	public Feedback fetchFeedback(int sessionID) {
		Session s = new Session();
		s.setSessionID(sessionID);
		Feedback feedback = jdbc.fetchFeedback(s); // Instead of passing int,
		return feedback;
	}

	/**
	 * Avg feedback.
	 *
	 * @param sessionID the session ID
	 * @param f1 the f 1
	 * @param f2 the f 2
	 * @param f3 the f 3
	 * @param f4 the f 4
	 * @param userID the user ID
	 * @return the feedback
	 */
	public Feedback avgFeedback(int sessionID, int f1, int f2, int f3, int f4, int userID) {
		Session s = new Session();
		s.setSessionID(sessionID);
		User user = new User();
		user.setUserID(userID);
		Feedback feedback = new Feedback(s.getSessionID(), f1, f2, f3, f4);
		jdbc.updateFeedback(feedback, user);
		return feedback;
	}

	/**
	 * Adds the trainee.
	 *
	 * @param SessionID the session ID
	 * @param UserID the user ID
	 * @return the string
	 */
	public String addTrainee(int SessionID, int UserID) {
		Session session = new Session();
		session.setSessionID(SessionID);
		User trainee = new User();
		trainee.setUserID(UserID);
		jdbc.addTrainee(trainee, session);
		return "Trainee added";
	}

	/**
	 * Gets the waiting sessions.
	 *
	 * @param TraineeID the trainee ID
	 * @return the waiting sessions
	 */
	public ArrayList<Session> getWaitingSessions(int TraineeID) {
		User Trainee = new User();
		Trainee.setUserID(TraineeID);
		return jdbc.getWaitingSessions(Trainee);
	}

	/**
	 * Gets the joined sessions.
	 *
	 * @param TraineeID the trainee ID
	 * @return the joined sessions
	 */
	public ArrayList<Session> getJoinedSessions(int TraineeID) {
		User Trainee = new User();
		Trainee.setUserID(TraineeID);
		System.out.println(TraineeID);
		return jdbc.getJoinedSessions(Trainee);
	}

	/**
	 * Give poll.
	 *
	 * @param PollID the poll ID
	 * @param UserID the user ID
	 * @param choice the choice
	 * @return the int
	 */
	public int givePoll(int PollID, int UserID, int choice) {
		Poll p = new Poll();
		p.setPollID(PollID);
		User u = new User();
		u.setUserID(UserID);
		return jdbc.givePoll(u, p, choice);
	}

	/**
	 * Gets the sessions.
	 *
	 * @param TrainerID the trainer ID
	 * @return the sessions
	 */
	public ArrayList<Session> getSessions(int TrainerID) {
		User Trainer = new User();
		Trainer.setUserID(TrainerID);
		return jdbc.getSessions(Trainer);
	}

	/**
	 * Send email.
	 *
	 * @param SessionID the session ID
	 * @param Subject the subject
	 * @param Message the message
	 * @return the array list
	 */
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

	/**
	 * Send invite.
	 *
	 * @param Emails the emails
	 * @param sessionID the session ID
	 * @param trainerID the trainer ID
	 * @return the int[]
	 */
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

	/**
	 * Adds the poll.
	 *
	 * @param q the q
	 * @param o1 the o 1
	 * @param o2 the o 2
	 * @param o3 the o 3
	 * @param o4 the o 4
	 * @param sessionID the session ID
	 * @return the int
	 */
	public int addPoll(String q, String o1, String o2, String o3, String o4, int sessionID) {
		Poll p = new Poll(0, q, o1, o2, o3, o4);
		p.setSessionID(sessionID);
		return jdbc.addPoll(p);
	}

	/**
	 * Fetch poll.
	 *
	 * @param PollID the poll ID
	 * @return the string[]
	 */
	public String[] fetchPoll(int PollID) {
		Poll p = new Poll();
		p.setPollID(PollID);
		return jdbc.fetchPoll(p);
	}

	/**
	 * Checkaval.
	 *
	 * @param id the id
	 * @return the session
	 */
	public Session checkaval(int id) {
		User u = new User();
		u.setUserID(id);
		return jdbc.CheckSessionAvailabilityTrainer(u);
	}

	/**
	 * Checkavaltrainee.
	 *
	 * @param id the id
	 * @return the session
	 */
	public Session checkavaltrainee(int id) {
		User u = new User();
		u.setUserID(id);
		return jdbc.CheckSessionAvailabilityTrainee(u);
	}

	/**
	 * Close poll.
	 *
	 * @param PollID the poll ID
	 * @return the int
	 */
	public int closePoll(int PollID) {
		Poll p = new Poll();
		p.setPollID(PollID);
		return jdbc.closePoll(p);
	}

	/**
	 * List active poll trainer.
	 *
	 * @param trainerID the trainer ID
	 * @return the array list
	 */
	public ArrayList<Poll> listActivePollTrainer(int trainerID) {
		User user = new User();
		user.setUserID(trainerID);
		return jdbc.listActivePollTrainer(user);
	}

	/**
	 * List active poll trainee.
	 *
	 * @param traineeID the trainee ID
	 * @return the array list
	 */
	public ArrayList<Poll> listActivePollTrainee(int traineeID) {
		User user = new User();
		user.setUserID(traineeID);
		return jdbc.listActivePollTrainee(user);
	}

	/**
	 * Fetch feedback sessions trainee.
	 *
	 * @param userID the user ID
	 * @return the array list
	 */
	public ArrayList<Session> fetchFeedbackSessionsTrainee(int userID) {
		User u = new User();
		u.setUserID(userID);
		return jdbc.fetchFeedbackSessionsTrainee(u);
	}

	/**
	 * Fetch sessions admin.
	 *
	 * @param traineeID the trainee ID
	 * @return the array list
	 */
	public ArrayList<Session> fetchSessionsAdmin(int traineeID) {
		return jdbc.fetchSessionsAdmin(new User());
	}

	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 */
	public ArrayList<User> getAllUsers() {
		// TODO Auto-generated method stub
		return jdbc.getAllUsers();
	}

	/**
	 * List files.
	 *
	 * @param sessionID the session ID
	 * @return the array list
	 */
	public ArrayList<String> listFiles(int sessionID) {
		Session session = new Session();
		session.setSessionID(sessionID);
		return jdbc.listFiles(session);
	}

	/**
	 * Upload files.
	 *
	 * @param sessionID the session ID
	 * @param fileName the file name
	 * @return the int
	 */
	public int uploadFiles(int sessionID, String fileName) {
		Session session = new Session();
		session.setSessionID(sessionID);
		return jdbc.uploadFiles(session, fileName);
	}

}
