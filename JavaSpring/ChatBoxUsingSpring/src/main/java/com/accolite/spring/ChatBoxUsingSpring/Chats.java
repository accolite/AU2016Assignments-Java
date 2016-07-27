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

// TODO: Auto-generated Javadoc
/**
 * The Class Chats.
 */
@Component
public class Chats {

	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	/**
	 * Gets the jdbc template.
	 *
	 * @return the jdbc template
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	/**
	 * Sets the jdbc template.
	 *
	 * @param jdbcTemplate the new jdbc template
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Gets the chats.
	 *
	 * @return the chats
	 */
	String getChats()
	{
		String query = "SELECT username,messages FROM dbo.chats";
		return jdbcTemplate.query(query, new ResultSetExtractor<String>() {

			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				String output="";
				while (rs.next()){
				
					String a=rs.getString("UserName");
					String b=rs.getString("Messages");
					output+=a+":"+b+"<br>";
					
				}
				return output;
			}
		});

		
	
		
	}
}
