package com.springdemo.tutorial.jdbctemplate;

import java.sql.Date;
import java.sql.PreparedStatement;
import com.springdemo.tutorial.model.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class JDBCTemplateDao.
 */
@Repository
public class JDBCTemplateDao {
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Gets the waiting sessions.
	 *
	 * @param trainee the trainee
	 * @return the waiting sessions
	 */
	public ArrayList<Session> getWaitingSessions(User trainee) {
		String query = "SELECT * FROM session INNER JOIN trainee on session.SessionID = trainee.SessionID WHERE accepted = 0 AND trainee.UserID = "
				+ trainee.getUserID();
		return jdbcTemplate.query(query, new ResultSetExtractor<ArrayList<Session>>() {

			public ArrayList<Session> extractData(ResultSet rs) throws SQLException, DataAccessException {
				ArrayList<Session> Sessions = new ArrayList<Session>();
				while (rs.next()) {
					Session s = new Session();
					s.setTrainerID(rs.getInt(3));
					s.setSessionID(rs.getInt("SessionID"));
					s.setSessionName(rs.getString("SessionName"));
					s.setDate(rs.getDate("Date"));
					Float f = new Float(0);
					f = (float) (rs.getTime("StartTime").getHours() * 1.0 + rs.getTime("StartTime").getMinutes() / 60);
					s.setStartTime(f.toString());
					f = (float) (rs.getTime("EndTime").getHours() * 1.0 + rs.getTime("EndTime").getMinutes() / 60);
					s.setEndTime(f.toString());
					Sessions.add(s);
				}
				return Sessions;
			}
		});
	}

	/**
	 * Sets the feedback.
	 *
	 * @param feedback the feedback
	 * @return the int
	 */
	public int setFeedback(Feedback feedback) {
		String query = "insert into feedback values(" + feedback.getSessionID() + "," + feedback.getFeedback1() + ","
				+ feedback.getFeedback2() + "," + feedback.getFeedback3() + "," + feedback.getFeedback4() + ","
				+ feedback.getTotal() + ")";
		return jdbcTemplate.update(query);
	}

	/**
	 * Adds the trainee.
	 *
	 * @param trainee the trainee
	 * @param session the session
	 * @return the int
	 */
	public int addTrainee(User trainee, Session session) {
		String query = "Update trainee set accepted= 1, givenfeedback=0 where trainee.SessionID ="
				+ session.getSessionID() + " and trainee.UserID=" + trainee.getUserID() + ";";
		return jdbcTemplate.update(query);
	}

	/**
	 * Given feedback.
	 *
	 * @param user the user
	 * @param sessionID the session ID
	 * @return the boolean
	 */
	public Boolean givenFeedback(User user, int sessionID) {
		String query1 = "Select * from trainee where UserID=" + user.getUserID() + " and SessionID=" + sessionID + "";
		return jdbcTemplate.query(query1, new ResultSetExtractor<Boolean>() {

			public Boolean extractData(ResultSet rs) throws SQLException, DataAccessException {
				Boolean boolean1 = false;
				if (rs.next()) {
					if ((rs.getInt("givenFeedback") == 0))
						boolean1 = false;
					else
						boolean1 = true;
				}
				return boolean1;
			}
		});

	}

	/**
	 * Update feedback.
	 *
	 * @param feedback the feedback
	 * @param user the user
	 * @return the int
	 */
	public int updateFeedback(Feedback feedback, User user) {

		if (!givenFeedback(user, feedback.getSessionID())) {
			JDBCTemplateDao obj = new JDBCTemplateDao();
			String query1 = "select SessionID, Feedback1, Feedback2, Feedback3, Feedback4, Total from feedback where SessionID = "
					+ feedback.getSessionID() + "";

			Feedback f = jdbcTemplate.query(query1, new ResultSetExtractor<Feedback>() {
				public Feedback extractData(ResultSet rs) throws SQLException, DataAccessException {
					Feedback old = new Feedback();
					while (rs.next()) {
						old.setSessionID(rs.getInt("SessionID"));
						old.setFeedback1(rs.getDouble("Feedback1"));
						old.setFeedback2(rs.getDouble("Feedback2"));
						old.setFeedback3(rs.getDouble("Feedback3"));
						old.setFeedback4(rs.getDouble("Feedback4"));
						old.setTotal(rs.getInt("Total"));
					}
					return old;
				}
			});

			Feedback updated = new Feedback();
			int total = f.getTotal();
			updated.setSessionID(f.getSessionID());
			updated.setFeedback1(obj.getAvg(f.getFeedback1(), feedback.getFeedback1(), total));
			updated.setFeedback2(obj.getAvg(f.getFeedback2(), feedback.getFeedback2(), total));
			updated.setFeedback3(obj.getAvg(f.getFeedback3(), feedback.getFeedback3(), total));
			updated.setFeedback4(obj.getAvg(f.getFeedback4(), feedback.getFeedback4(), total));
			updated.setTotal(total + 1);
			System.out.println("Feedback2 : " + updated.getFeedback2());

			String query2 = "update feedback set Feedback1=" + updated.getFeedback1() + ", Feedback2="
					+ updated.getFeedback2() + ", Feedback3=" + updated.getFeedback3() + ", Feedback4="
					+ updated.getFeedback4() + ", Total=" + updated.getTotal() + " where SessionID="
					+ updated.getSessionID() + " ";
			String query3 = "Update trainee set givenFeedback=1 where UserID=" + user.getUserID() + " and SessionID="
					+ feedback.getSessionID() + "";
			jdbcTemplate.update(query3);
			return jdbcTemplate.update(query2);

		} else {
			return 0;
		}

	}

	/**
	 * Gets the avg.
	 *
	 * @param feedback1 the feedback 1
	 * @param feedback2 the feedback 2
	 * @param total the total
	 * @return the avg
	 */
	private double getAvg(double feedback1, double feedback2, double total) {
		if (total == 0)
			return feedback2;
		double value = feedback1 * total + feedback2;
		return (value / (total + 1));
	}

	/**
	 * Creates the session.
	 *
	 * @param session the session
	 * @return the int
	 */
	public int createSession(Session session) {
		String query = null;
		if (isSession(session) > 0) {
			query = "update session set SessionName='" + session.getSessionName() + "',UserID=" + session.getTrainerID()
					+ " " + " where Date='" + session.getDate() + "' and StartTime='" + session.getStartTime()
					+ "' and EndTime='" + session.getEndTime() + "'";

		} else {
			query = "insert into session(SessionName,UserID,Date,StartTime,EndTime) values ('"
					+ session.getSessionName() + "'," + session.getTrainerID() + ",'" + session.getDate() + "','"
					+ session.getStartTime() + "','" + session.getEndTime() + "')";

		}

		return jdbcTemplate.update(query);
	}

	/**
	 * Checks if is session.
	 *
	 * @param session the session
	 * @return the int
	 */
	private int isSession(Session session) {
		String query = "Select * from session where Date='" + session.getDate() + "' and StartTime='"
				+ session.getStartTime() + "' and EndTime='" + session.getEndTime() + "'";
		RowCountCallbackHandler countCallback = new RowCountCallbackHandler();
		jdbcTemplate.query(query, countCallback);
		return countCallback.getRowCount();
	}

	/**
	 * Adds the trainer.
	 *
	 * @param trainer the trainer
	 * @param session the session
	 * @return the int
	 */
	public int addTrainer(User trainer, Session session) {
		String query = "insert into trainer values " + "(" + session.getSessionID() + "," + trainer.getUserID() + ")";
		return jdbcTemplate.update(query);
	}

	/**
	 * Send email.
	 *
	 * @param session the session
	 * @param subject the subject
	 * @param message the message
	 * @return the array list
	 */
	public ArrayList<User> SendEmail(Session session, String subject, String message) {
		String query = "SELECT * FROM userdata inner join trainee on userdata.UserID = trainee.UserID inner join session on trainee.SessionID = session.SessionID WHERE session.SessionID  ="
				+ session.getSessionID();
		System.out.println(query);
		return jdbcTemplate.query(query, new ResultSetExtractor<ArrayList<User>>() {

			public ArrayList<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
				ArrayList<User> Users = new ArrayList<User>();
				while (rs.next()) {
					User u = new User();
					// u.setUserID(rs.getInt("UserID"));
					// u.setUserName(rs.getString("UserName"));
					u.setUserEmail(rs.getString("UserEmail"));
					Users.add(u);
				}
				return Users;
			}
		});
	}

	/**
	 * Gets the sessions.
	 *
	 * @param Trainer the trainer
	 * @return the sessions
	 */
	public ArrayList<Session> getSessions(User Trainer) {
		String query = "SELECT * FROM session WHERE UserID = " + Trainer.getUserID();
		return jdbcTemplate.query(query, new ResultSetExtractor<ArrayList<Session>>() {

			public ArrayList<Session> extractData(ResultSet rs) throws SQLException, DataAccessException {
				ArrayList<Session> Sessions = new ArrayList<Session>();
				while (rs.next()) {
					Session s = new Session();
					s.setTrainerID(rs.getInt("UserID"));
					s.setSessionID(rs.getInt("SessionID"));
					s.setSessionName(rs.getString("SessionName"));
					s.setDate(rs.getDate("Date"));
					Float f = new Float(0);
					f = (float) (rs.getTime("StartTime").getHours() * 1.0 + rs.getTime("StartTime").getMinutes() / 60);
					s.setStartTime(f.toString());
					f = (float) (rs.getTime("EndTime").getHours() * 1.0 + rs.getTime("EndTime").getMinutes() / 60);
					s.setEndTime(f.toString());
					Sessions.add(s);
				}
				return Sessions;
			}
		});

	}

	/**
	 * Gets the joined sessions.
	 *
	 * @param Trainee the trainee
	 * @return the joined sessions
	 */
	public ArrayList<Session> getJoinedSessions(User Trainee) {
		String query = "SELECT * FROM session INNER JOIN trainee on session.SessionID = trainee.SessionID WHERE accepted = 1 AND trainee.UserID = "
				+ Trainee.getUserID();
		return jdbcTemplate.query(query, new ResultSetExtractor<ArrayList<Session>>() {

			public ArrayList<Session> extractData(ResultSet rs) throws SQLException, DataAccessException {
				ArrayList<Session> Sessions = new ArrayList<Session>();
				while (rs.next()) {
					Session s = new Session();
					s.setTrainerID(rs.getInt(3));
					s.setSessionID(rs.getInt("SessionID"));
					s.setSessionName(rs.getString("SessionName"));
					s.setDate(rs.getDate("Date"));
					Float f = new Float(0);
					f = (float) (rs.getTime("StartTime").getHours() * 1.0 + rs.getTime("StartTime").getMinutes() / 60);
					s.setStartTime(f.toString());
					f = (float) (rs.getTime("EndTime").getHours() * 1.0 + rs.getTime("EndTime").getMinutes() / 60);
					s.setEndTime(f.toString());
					Sessions.add(s);
				}
				return Sessions;
			}
		});

	}

	/**
	 * Check session availability trainer.
	 *
	 * @param u the u
	 * @return the session
	 */
	public Session CheckSessionAvailabilityTrainer(User u) {
		ArrayList<Session> sessions = getSessions(u);
		Float currTime;
		currTime = new Float((Calendar.getInstance().getTime().getHours() * 1.0
				+ Calendar.getInstance().getTime().getMinutes() * 1.0 / 60));
		/*
		 * System.out.println("CURRENT TIME : " + currTime); System.out.println(
		 * "CURRENT DATE : " + Calendar.getInstance().getTime());
		 */

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String text = df.format(Calendar.getInstance()
				.getTime());/*
							 * System.out.println("CHANGED DATE : " + text);
							 */

		for (Session session : sessions) {
			/*
			 * System.out.println("SESSION NAME : " + session.getSessionName());
			 * System.out.println("SESSION DATE : " +
			 * session.getDate().toString() + "Compared to " + text);
			 * System.out.println("SESSION STARTTIME : " +
			 * session.getStartTime()); System.out.println("SESSION ENDTIME : "
			 * + session.getEndTime());
			 */
			if (text.contains(session.getDate().toString())) {
				Float StartTime = new Float(session.getStartTime());
				Float EndTime = new Float(session.getEndTime());

				/*
				 * System.out.println("DATE MATCHED \n CALCULATED StartTime : "
				 * + StartTime + " CALCULATED EndTime " + EndTime);
				 */
				if (StartTime < currTime && currTime < EndTime) {
					/* System.out.println("Time Matched"); */
					return session;
				}
			}
		}
		return null;
	}

	/**
	 * Check session availability trainee.
	 *
	 * @param u the u
	 * @return the session
	 */
	public Session CheckSessionAvailabilityTrainee(User u) {
		ArrayList<Session> sessions = getJoinedSessions(u);
		Float currTime;
		currTime = new Float((Calendar.getInstance().getTime().getHours() * 1.0
				+ Calendar.getInstance().getTime().getMinutes() * 1.0 / 60));
		/*
		 * System.out.println("CURRENT TIME : " + currTime); System.out.println(
		 * "CURRENT DATE : " + Calendar.getInstance().getTime());
		 */

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String text = df.format(Calendar.getInstance()
				.getTime());/*
							 * System.out.println("CHANGED DATE : " + text);
							 */

		for (Session session : sessions) {
			/*
			 * System.out.println("SESSION NAME : " + session.getSessionName());
			 * System.out.println("SESSION DATE : " +
			 * session.getDate().toString() + "Compared to " + text);
			 * System.out.println("SESSION STARTTIME : " +
			 * session.getStartTime()); System.out.println("SESSION ENDTIME : "
			 * + session.getEndTime());
			 */
			if (text.contains(session.getDate().toString())) {
				Float StartTime = new Float(session.getStartTime());
				Float EndTime = new Float(session.getEndTime());

				/*
				 * System.out.println("DATE MATCHED \n CALCULATED StartTime : "
				 * + StartTime + " CALCULATED EndTime " + EndTime);
				 */
				if (StartTime < currTime && currTime < EndTime) {
					/* System.out.println("Time Matched"); */
					return session;
				}
			}
		}
		return null;
	}

	/**
	 * Adds the poll.
	 *
	 * @param p the p
	 * @return the int
	 */
	/* EXPIREMENTAL POLLING CODE FOLLOWS */
	public int addPoll(Poll p) {
		String query = "INSERT into poll VALUES ('" + p.getQ() + "','" + p.getO1() + "','" + p.getO2() + "','"
				+ p.getO3() + "','" + p.getO4() + "'," + p.getSessionID() + ",1);";
		return jdbcTemplate.update(query);
	}

	/**
	 * Close poll.
	 *
	 * @param p the p
	 * @return the int
	 */
	public int closePoll(Poll p) {
		String query = "Update poll set isAlive=0 where PollID=" + p.getPollID();
		return jdbcTemplate.update(query);
	}

	/**
	 * List active poll trainer.
	 *
	 * @param user the user
	 * @return the array list
	 */
	public ArrayList<Poll> listActivePollTrainer(User user) {
		String query = "Select PollID, SessionName, Question, Option1, Option2, Option3, Option4 FROM poll INNER "
				+ "JOIN session ON poll.SessionID = session.SessionID WHERE session.UserID =" + user.getUserID()
				+ " and poll.isAlive = 1";
		System.out.println(query);
		return jdbcTemplate.query(query, new ResultSetExtractor<ArrayList<Poll>>() {

			public ArrayList<Poll> extractData(ResultSet rs) throws SQLException, DataAccessException {
				ArrayList<Poll> polls = new ArrayList<Poll>();
				while (rs.next()) {
					Poll p = new Poll();
					p.setPollID(rs.getInt("PollID"));
					p.setQ(rs.getString("Question"));
					p.setO1(rs.getString("Option1"));
					p.setO2(rs.getString("Option2"));
					p.setO3(rs.getString("Option3"));
					p.setO4(rs.getString("Option4"));
					p.setSessionName(rs.getString("SessionName"));
					polls.add(p);
				}
				return polls;
			}
		});
	}

	/**
	 * List active poll trainee.
	 *
	 * @param user the user
	 * @return the array list
	 */
	public ArrayList<Poll> listActivePollTrainee(User user) {
		String query = "SELECT PollID, Question, Option1, Option2, Option3, Option4 FROM Trainee INNER "
				+ " JOIN Poll ON Trainee.SessionID = Poll.SessionID WHERE UserID=" + user.getUserID()
				+ " and poll.isAlive = 1 and trainee.accepted = 1";
		System.out.println(query);
		return jdbcTemplate.query(query, new ResultSetExtractor<ArrayList<Poll>>() {

			public ArrayList<Poll> extractData(ResultSet rs) throws SQLException, DataAccessException {
				ArrayList<Poll> polls = new ArrayList<Poll>();
				while (rs.next()) {
					Poll p = new Poll();
					p.setPollID(rs.getInt("PollID"));
					p.setQ(rs.getString("Question"));
					p.setO1(rs.getString("Option1"));
					p.setO2(rs.getString("Option2"));
					p.setO3(rs.getString("Option3"));
					p.setO4(rs.getString("Option4"));
					polls.add(p);
				}
				return polls;
			}
		});

	}

	/**
	 * Give poll.
	 *
	 * @param u the u
	 * @param p the p
	 * @param choice the choice
	 * @return the int
	 */
	public int givePoll(User u, Poll p, int choice) {
		String query = "INSERT INTO pollresponse VALUES ( " + p.getPollID() + ", " + u.getUserID() + ", " + choice
				+ " );";
		return jdbcTemplate.update(query);
	}

	/**
	 * Fetch poll.
	 *
	 * @param p the p
	 * @return the string[]
	 */
	public String[] fetchPoll(Poll p) {
		String query = "SELECT poll.Option1, poll.Option2, poll.Option3, poll.Option4, poll.PollID, Choice, count(*) AS CNT FROM pollresponse INNER JOIN poll ON pollresponse.PollID = poll.PollID GROUP BY poll.PollID, Choice, poll.Option1, poll.Option2, poll.Option3, poll.Option4 HAVING poll.PollID = "
				+ p.getPollID();
		return jdbcTemplate.query(query, new ResultSetExtractor<String[]>() {

			public String[] extractData(ResultSet rs) throws SQLException, DataAccessException {
				String[] choices = new String[8];
				int optionNo = 0;
				int labelNo = 4;
				String[] o = { "Option1", "Option2", "Option3", "Option4" };
				while (rs.next()) {
					choices[optionNo++] = Integer.toString(rs.getInt("CNT"));
					choices[labelNo++] = rs.getString(o[rs.getInt("Choice") - 1]);
				}
				return choices;
			}
		});
	}

	/**
	 * Fetch feedback.
	 *
	 * @param s the s
	 * @return the feedback
	 */
	public Feedback fetchFeedback(Session s) {
		String query = "SELECT * FROM feedback WHERE SessionID = " + s.getSessionID();
		return jdbcTemplate.query(query, new ResultSetExtractor<Feedback>() {

			public Feedback extractData(ResultSet rs) throws SQLException, DataAccessException {
				Feedback f = new Feedback();
				while (rs.next()) {
					f.setFeedback1(rs.getFloat("Feedback1"));
					f.setFeedback2(rs.getFloat("Feedback2"));
					f.setFeedback3(rs.getFloat("Feedback3"));
					f.setFeedback4(rs.getFloat("Feedback4"));
				}
				return f;
			}
		});
	}

	/**
	 * Adds the trainees.
	 *
	 * @param users the users
	 * @param session the session
	 * @return the int
	 */
	private int addTrainees(ArrayList<User> users, Session session) {
		int i;
		String query;
		for (i = 0; i < users.size(); i++) {
			if (users.get(i).getUserID() != 0) {
				query = "insert into trainee values(" + session.getSessionID() + "," + users.get(i).getUserID()
						+ ",'09:00:00.00'," + "0, 0)";
				System.out.println("Query :" + query);
				jdbcTemplate.update(query);
			}
		}
		return 1;
	}

	/**
	 * Gets the user I ds.
	 *
	 * @param email the email
	 * @param session the session
	 * @return the user I ds
	 */
	public ArrayList<User> getUserIDs(String[] email, Session session) {
		int i;
		String query;
		ArrayList<User> users = new ArrayList<User>();
		User newUser = new User();

		for (i = 0; i < email.length; i++) {
			query = "Select UserID FROM userdata WHERE UserEmail = '" + email[i] + "'";
			newUser = jdbcTemplate.query(query, new ResultSetExtractor<User>() {

				public User extractData(ResultSet rs) throws SQLException, DataAccessException {
					User u = new User();
					while (rs.next()) {
						u.setUserID(rs.getInt("UserID"));
					}
					return u;
				}
			});
			if (newUser.getUserID() != session.getTrainerID())
				users.add(newUser);
		}
		addTrainees(users, session);
		return users;
	}

	/**
	 * Fetch sessions admin.
	 *
	 * @param u the u
	 * @return the array list
	 */
	public ArrayList<Session> fetchSessionsAdmin(User u) {
		String query = "SELECT * FROM session";
		return jdbcTemplate.query(query, new ResultSetExtractor<ArrayList<Session>>() {

			public ArrayList<Session> extractData(ResultSet rs) throws SQLException, DataAccessException {
				ArrayList<Session> Sessions = new ArrayList<Session>();
				while (rs.next()) {
					Session s = new Session();
					s.setTrainerID(rs.getInt(3));
					s.setSessionID(rs.getInt("SessionID"));
					s.setSessionName(rs.getString("SessionName"));
					s.setDate(rs.getDate("Date"));
					Float f = new Float(0);
					f = (float) (rs.getTime("StartTime").getHours() * 1.0 + rs.getTime("StartTime").getMinutes() / 60);
					s.setStartTime(f.toString());
					f = (float) (rs.getTime("EndTime").getHours() * 1.0 + rs.getTime("EndTime").getMinutes() / 60);
					s.setEndTime(f.toString());
					Sessions.add(s);
				}
				return Sessions;
			}
		});

	}

	/**
	 * Fetch feedback sessions trainee.
	 *
	 * @param u the u
	 * @return the array list
	 */
	public ArrayList<Session> fetchFeedbackSessionsTrainee(User u) {
		String query = "SELECT SessionName, session.SessionID FROM session INNER JOIN trainee ON session.SessionID = trainee.SessionID WHERE trainee.givenFeedback = 0 AND trainee.accepted = 1 AND trainee.UserID = "
				+ u.getUserID();
		return jdbcTemplate.query(query, new ResultSetExtractor<ArrayList<Session>>() {

			public ArrayList<Session> extractData(ResultSet rs) throws SQLException, DataAccessException {
				ArrayList<Session> Sessions = new ArrayList<Session>();
				while (rs.next()) {
					Session s = new Session();
					s.setSessionID(rs.getInt("SessionID"));
					s.setSessionName(rs.getString("SessionName"));
					Sessions.add(s);
				}
				return Sessions;
			}
		});

	}

	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 */
	public ArrayList<User> getAllUsers() {
		String query = "SELECT * FROM userdata";
		System.out.println(query);
		return jdbcTemplate.query(query, new ResultSetExtractor<ArrayList<User>>() {

			public ArrayList<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
				ArrayList<User> Users = new ArrayList<User>();
				while (rs.next()) {
					User u = new User();
					u.setUserID(rs.getInt("UserID"));
					u.setUserName(rs.getString("UserName"));
					u.setUserEmail(rs.getString("UserEmail"));
					Users.add(u);
				}
				return Users;
			}
		});
	}

	/**
	 * List files.
	 *
	 * @param session the session
	 * @return the array list
	 */
	public ArrayList<String> listFiles(Session session) {
		String query = "SELECT * FROM uploadedFiles WHERE SessionID=" + session.getSessionID();
		return jdbcTemplate.query(query, new ResultSetExtractor<ArrayList<String>>() {

			public ArrayList<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
				ArrayList<String> lists = new ArrayList<String>();
				while (rs.next()) {
					String s = rs.getString("FileName");
					lists.add(s);
				}
				return lists;
			}
		});

	}

	/**
	 * Upload files.
	 *
	 * @param session the session
	 * @param fileName the file name
	 * @return the int
	 */
	public int uploadFiles(Session session, String fileName) {
		String query = "insert into uploadedFiles(SessionID,FileName) values (" + session.getSessionID() + ",'"
				+ fileName + "')";
		return jdbcTemplate.update(query);
	}

}
