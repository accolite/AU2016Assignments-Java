package com.springchat.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.springchat.dao.User;
import com.springchat.dao.Message;

//import com.springdemo.tutorial.jdbctemplate.Student;

//import com.springdemo.tutorial.jdbctemplate.Student;

@Repository
public class JDBCTemplateDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean validUser(String uname) {
		String query = "SELECT username from dbo.User where username = " + uname;
		return jdbcTemplate.query(query, new ResultSetExtractor<Boolean>() {

			public Boolean extractData(ResultSet rs) throws SQLException, DataAccessException {

				if (rs.next() == false) {
					return false;
				} else
					return true;// user doesn't exist
			}
		});
	}

	public Boolean registerUserUsingPreparedStatement(final User user) {
		String query = "insert into dbo.User(username,password) values (?,?)";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPassword());
				return ps.execute();
			}
		});
	}

	public boolean validateUser(String uname, String pass) {
		String query = "SELECT username,password FROM dbo.User where" + " username = " + uname + " and  password = "
				+ pass;
		return jdbcTemplate.query(query, new ResultSetExtractor<Boolean>() {

			public Boolean extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next() == true) {
					return true;// user doesn't exist
				} else
					return false;
			}
		});
	}

	public int addMessage(String username, String message) {
		String query = "Insert into dbo.Message(username,message) Values ('" + username + "','" + message + "')";
		return jdbcTemplate.update(query);
	}

	public List<Message> getAllMessages() {

		return jdbcTemplate.query("select * from dbo.Message", new ResultSetExtractor<List<Message>>() {

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
