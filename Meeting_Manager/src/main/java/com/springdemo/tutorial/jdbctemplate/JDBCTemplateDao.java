package com.springdemo.tutorial.jdbctemplate;

import java.sql.Date;
import java.sql.PreparedStatement;
import com.springdemo.tutorial.model.*;
import java.sql.ResultSet;
import java.sql.SQLException;
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

@Repository
public class JDBCTemplateDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int setFeedback(Feedback feedback) {
		String query = "insert into feedback values(" + feedback.getSessionID() + "," + feedback.getFeedback1() + ","
				+ feedback.getFeedback2() + "," + feedback.getFeedback3() + "," + feedback.getFeedback4() + ","
				+ feedback.getTotal() + ")";
		return jdbcTemplate.update(query);
	}

	public int addTrainee(User trainee, Session session) {
		String query = "Update trainee set accepted= 1 where trainee.SessionID =" + session.getSessionID()
				+ " and trainee.UserID=" + trainee.getUserID() + ";";
		return jdbcTemplate.update(query);
	}

	public int updateFeedback(Feedback feedback) {

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
		return jdbcTemplate.update(query2);

	}

	private double getAvg(double feedback1, double feedback2, double total) {
		if (total == 0)
			return feedback2;
		double value = feedback1 * total + feedback2;
		return (value / (total + 1));
	}

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

	private int isSession(Session session) {
		String query = "Select * from session where Date='" + session.getDate() + "' and StartTime='"
				+ session.getStartTime() + "' and EndTime='" + session.getEndTime() + "'";
		RowCountCallbackHandler countCallback = new RowCountCallbackHandler();
		jdbcTemplate.query(query, countCallback);
		return countCallback.getRowCount();
	}

	public int addTrainer(User trainer, Session session) {
		String query = "insert into trainer values " + "(" + session.getSessionID() + "," + trainer.getUserID() + ")";
		return jdbcTemplate.update(query);
	}

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

	public int CheckSessionAvailabilityTrainer(User u) {
		ArrayList<Session> sessions = getSessions(u);
		Float currTime = new Float(0);
		currTime = (float) (Calendar.getInstance().getTime().getHours() * 1.0 % 12
				+ Calendar.getInstance().getTime().getMinutes() * 1.0 / 60);
		for (Session session : sessions) {
			if (Calendar.getInstance().getTime().compareTo(session.getDate()) == 0) {
				if (new Float(session.getStartTime()) > currTime && new Float(session.getEndTime()) < currTime)
					return session.getSessionID();
			}
		}
		return -1;
	}

	public int CheckSessionAvailabilityTrainee(User u) {
		ArrayList<Session> sessions = getJoinedSessions(u);
		Float currTime = new Float(0);
		currTime = (float) (Calendar.getInstance().getTime().getHours() * 1.0 % 12
				+ Calendar.getInstance().getTime().getMinutes() * 1.0 / 60);
		for (Session session : sessions) {
			if (Calendar.getInstance().getTime().compareTo(session.getDate()) == 0) {
				if (new Float(session.getStartTime()) > currTime && new Float(session.getEndTime()) < currTime)
					return session.getSessionID();
			}
		}
		return -1;
	}

	/* EXPIREMENTAL POLLING CODE FOLLOWS */
	public int addPoll(Poll p) {
		String query = "INSERT into poll VALUES ('" + p.getQ() + "','" + p.getO1() + "','" + p.getO2() + "','"
				+ p.getO3() + "','" + p.getO4() + "');";
		return jdbcTemplate.update(query);
	}

	public int givePoll(User u, Poll p, int choice) {
		String query = "INSERT INTO pollresponse VALUES ( " + p.getPollID() + ", " + u.getUserID() + ", " + choice
				+ " );";
		return jdbcTemplate.update(query);
	}

	public int[] fetchPoll(Poll p) {
		String query = "SELECT PollID, Choice, count(*) AS CNT FROM pollresponse GROUP BY PollID, Choice HAVING PollID = "
				+ p.getPollID();
		return jdbcTemplate.query(query, new ResultSetExtractor<int[]>() {

			public int[] extractData(ResultSet rs) throws SQLException, DataAccessException {
				int[] choices = new int[4];
				int optionNo = 0;
				while (rs.next()) {
					choices[optionNo++] = rs.getInt("CNT");
				}
				return choices;
			}
		});
	}

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

	private int addTrainees(ArrayList<User> users, Session session) {
		int i;
		String query;
		for (i = 0; i < users.size(); i++) {
			if (users.get(i).getUserID() != 0) {
				query = "insert into trainee values(" + session.getSessionID() + "," + users.get(i).getUserID()
						+ ",'09:00:00.00'," + "0)";
				System.out.println("Query :" + query);
				jdbcTemplate.update(query);
			}
		}
		return 1;
	}

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

}
