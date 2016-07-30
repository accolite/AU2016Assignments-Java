package com.springdemo.tutorial.jdbctemplate;

import java.sql.PreparedStatement;
import com.springdemo.tutorial.model.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class JDBCTemplateDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int addTrainer(User trainer, Session session){
		String query = "insert into trainer values "
				+ "("+ session.getSessionID() +","+ trainer.getUserID()+")";		
		return jdbcTemplate.update(query);
	}
	
	public ArrayList<Session> getSessions(User Trainer){
		String query = "SELECT * FROM session INNER JOIN trainer on session.SessionID = trainer.SessionID WHERE trainer.UserID = " + Trainer.getUserID();
		return jdbcTemplate.query(query, new ResultSetExtractor<ArrayList<Session>>() {

			public ArrayList<Session> extractData(ResultSet rs) throws SQLException, DataAccessException {
				ArrayList<Session> Sessions = new ArrayList<Session>();
				while (rs.next()){
				Session s = new Session();
				s.setSessionID(rs.getInt("SessionID"));
				s.setSessionName(rs.getString("SessionName"));
				s.setDate( rs.getDate("Date"));
				s.setStartTime( rs.getTime("StartTime").toGMTString());
				s.setEndTime( (String) rs.getTime("EndTime").toGMTString());
				Sessions.add(s);
				}
				return Sessions;
			}
		});
		
	}
	
}
