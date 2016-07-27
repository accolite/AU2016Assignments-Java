package com.accolite.au.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

@Repository
public class JDBCTemplateDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean addUser(User user) {

		String username = user.getUsername();
		String password = user.getPassword();

		String query = "insert into dbo.users values " + "('" + username + "','" + password + "')";
		if( jdbcTemplate.update(query) > 0)
			return true;
		else
			return false;
		
	}

	public boolean validateUser(String username) {

		String query = "SELECT username from dbo.users where" + " username = " + username;

		return jdbcTemplate.query(query, new ResultSetExtractor<Boolean>() {

			@Override
			public Boolean extractData(ResultSet rs) throws SQLException, DataAccessException {

				if (rs.next() == false)
					return true;
				else
					return false;
			}
		});

	}
	
	public User loginValidation(User user){
		String username = user.getUsername();
		
		String query = "SELECT username,password from dbo.users where" + " username = " + username;
		
		return jdbcTemplate.query(query, new ResultSetExtractor<User>() {

			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {

				User userdb = new User();

				while (rs.next()) {
					userdb.setUsername(rs.getString(1));
					userdb.setPassword(rs.getString(2));
				}

				return userdb;
			}
		});
	}

	public int addMessage(Message messageobj) {
		String message = messageobj.getMessage();
		String username = messageobj.getUsername();

		String query = "insert into dbo.messages values " + "('" + username + "','" + message + "')";
		return jdbcTemplate.update(query);

	}

	public List<Message> retrieveMessages() {

		return jdbcTemplate.query("select * from dbo.messages", new ResultSetExtractor<List<Message>>() {

			@Override
			public List<Message> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<Message> list = new ArrayList<Message>();

				while (rs.next()) {
					Message m = new Message();
					m.setUsername(rs.getString(1));
					m.setMessage(rs.getString(2));
					list.add(m);
				}

				return list;
			}
		});

	}

}
