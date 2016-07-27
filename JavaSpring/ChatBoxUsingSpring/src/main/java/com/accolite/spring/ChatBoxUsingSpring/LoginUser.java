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
 * The Class LoginUser.
 */
//Component is to be done to make it a bean
@Component
public class LoginUser {

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
	 * Validate user.
	 *
	 * @param userName the user name
	 * @param userPassword the user password
	 * @return the user info
	 */
	public UserInfo validateUser(final String userName,final String userPassword){
		String query = "SELECT UserName,Password FROM dbo.LoggedInUsers  where"
				+ " UserName = '"+userName+"' ANd Password='"+userPassword+"'";
		return jdbcTemplate.query(query, new ResultSetExtractor<UserInfo>() {

			public UserInfo extractData(ResultSet rs) throws SQLException, DataAccessException {
				UserInfo userObject = new UserInfo();
				while (rs.next()){


					if(rs.getString("UserName").equals(userName)&&rs.getString("Password").equals(userPassword))
					{
						userObject.setUserName(userName);
						userObject.setUserPassword(userPassword);
						String username=userObject.getUserName();
						String passwordUser=userObject.getUserPassword();
						String query = "Update dbo.LoggedInUsers set online='true' where  userName= '"+username+"'";
						jdbcTemplate.update(query);
						return userObject;
					}
				}
				return userObject;
			}
		});
	}
}
