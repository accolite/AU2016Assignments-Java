/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 27, 2016

*

*  @author :: Udit Mehata

* ***************************************************************************

*/
package com.au.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.au.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Class UserDao.
 */
@Repository
public class UserDao {
	
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
	 * Gets the specific user.
	 *
	 * @param user the user
	 * @return the specific user
	 */
	public User getSpecificUser(String user) {
		String query = "SELECT usern,active FROM users where" + " usern = '" + user + "'";
		// System.out.println(query);
		return jdbcTemplate.query(query, new ResultSetExtractor<User>() {

			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				User u = new User("", 0);
				while (rs.next()) {
					u.setUsern(rs.getString(1));
					u.setActive(rs.getInt(2));
				}
				return u;
			}
		});
	}


	/**
	 * Gets the registered users.
	 *
	 * @return the registered users
	 */
	public List<User> getRegisteredUsers() {
		String query = "SELECT usern,active FROM users";
		// System.out.println(query);
		return jdbcTemplate.query(query, new ResultSetExtractor<List<User>>() {

			public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<User> ul = new ArrayList<User>();
				User u = new User("", 0);
				while (rs.next()) {
					u.setUsern(rs.getString(1));
					u.setActive(rs.getInt(2));
					ul.add(u);
				}
				return ul;
			}
		});
	}

	/**
	 * Gets the active users.
	 *
	 * @return the active users
	 */
	public List<User> getActiveUsers() {
		String query = "SELECT usern,active FROM users WHERE active = 1";
		// System.out.println(query);
		return jdbcTemplate.query(query, new ResultSetExtractor<List<User>>() {

			public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<User> ul = new ArrayList<User>();
				User u = new User("", 0);
				while (rs.next()) {
					u.setUsern(rs.getString(1));
					u.setActive(rs.getInt(2));
					ul.add(u);
				}
				return ul;
			}
		});
	}

	/**
	 * Register user.
	 *
	 * @param u the u
	 * @return the int
	 */
	public int registerUser(User u) {
		String query = "insert into users values " + "('" + u.getUsern() + "'," + u.getActive() + ")";
		// System.out.println(query);
		return jdbcTemplate.update(query);
	}
	
	public int activateUser(String u) {
		String query = "UPDATE users SET active = 1 WHERE usern = '"+ u + "')";
		// System.out.println(query);
		return jdbcTemplate.update(query);
	}
}
