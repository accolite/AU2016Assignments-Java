/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 27, 2016

*

*  @author :: Udit Mehata

* ***************************************************************************

*/
package com.au.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.au.model.Message;
import com.au.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageDao.
 */
@Repository
public class MessageDao {
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Gets the jdbc template.
	 *
	 * @return the jdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * Sets the jdbc template.
	 *
	 * @param jdbcTemplate            the jdbcTemplate to set
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Gets the messages per user.
	 *
	 * @param user the user
	 * @return the messages per user
	 */
	public List<Message> getMessagesPerUser(String user) {
		String query = "SELECT usern, message, time FROM chat WHERE usern = '" + user + "'";
		// System.out.println(query);
		return jdbcTemplate.query(query, new ResultSetExtractor<List<Message>>() {

			public List<Message> extractData(ResultSet rs) throws SQLException, DataAccessException {
				Message m = new Message("", "", null);
				List<Message> l = new ArrayList<Message>();
				while (rs.next()) {
					m = new Message("", "", null);
					m.setMessage(rs.getString(2));
					m.setUser(rs.getString(1));
					m.setTime(rs.getDate(3));
					l.add(m);
				}
				return l;
			}
		});
	}

	/**
	 * Gets the full chat.
	 *
	 * @return the full chat
	 */
	public List<Message> getFullChat() {
		String query = "SELECT usern, message, time FROM chat";
		// System.out.println(query);
		return jdbcTemplate.query(query, new ResultSetExtractor<List<Message>>() {

			public List<Message> extractData(ResultSet rs) throws SQLException, DataAccessException {
				Message m = new Message("", "", null);
				List<Message> l = new ArrayList<Message>();
				while (rs.next()) {
					m = new Message("", "", null);
					m.setMessage(rs.getString(2));
					m.setUser(rs.getString(1));
					m.setTime(rs.getDate(3));
					l.add(m);
				}
				return l;
			}
		});
	}

	/**
	 * Post message.
	 *
	 * @param m the m
	 * @return the int
	 */
	public int postMessage(Message m) {
		Date d = new Date(0);
		String query = "insert into chat values " + "('" + m.getUser() + "','" + m.getMessage() + "','" + d.toString()
				+ "')";
		// System.out.println(query);
		return jdbcTemplate.update(query);
	}
}
