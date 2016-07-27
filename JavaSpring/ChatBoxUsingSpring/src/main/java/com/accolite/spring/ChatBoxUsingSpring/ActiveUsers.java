/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 27, 2016

*

*  @author :: Sachin Gupta

* ***************************************************************************

*/
package com.accolite.spring.ChatBoxUsingSpring;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class ActiveUsers {

	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public String activeUsers(){
		String query = "SELECT UserName FROM dbo.LoggedInUsers  where"
				+ " online = true'";
		return jdbcTemplate.query(query, new ResultSetExtractor<String>() {

			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				String output="";
				while (rs.next()){
				
					output+="<br>"+rs.getString("UserName");
					
				}
				return output;
			}
		});
	}

}
