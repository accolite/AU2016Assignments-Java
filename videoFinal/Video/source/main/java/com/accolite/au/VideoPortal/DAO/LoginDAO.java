package com.accolite.au.VideoPortal.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.accolite.au.VideoPortal.Templates.LoginInterface;

@Repository
public class LoginDAO implements LoginInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int emailInDB(String email) {

		String query = "select * from UserTable where email_id like " + "'" + email + "'";

		return jdbcTemplate.query(query, new ResultSetExtractor<Integer>() {

			public Integer extractData(ResultSet rs) {

				try {
					if(rs.next()) {
						return 1;
					}else{
						return 0;
					}
				} catch (SQLException e) {
					return -1;
				}
				

			}
		});

	}

	@Override
	public int retrieveUserId(String email) {
		String query = "select user_id from UserTable where user_id=" + email;

		return jdbcTemplate.query(query, new ResultSetExtractor<Integer>() {

			public Integer extractData(ResultSet rs) {

				try {
					while (rs.next()) {
						return rs.getInt("user_id");
					}
				} catch (SQLException e) {
					return -1;
				}
				return 0;

			}
		});

	}

}
