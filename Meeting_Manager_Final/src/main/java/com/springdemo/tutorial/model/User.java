package com.springdemo.tutorial.model;

import org.springframework.jdbc.core.JdbcTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
public class User {
	
	/** The User ID. */
	private int UserID;
	
	/** The User name. */
	private String UserName;
	
	/** The User email. */
	private String UserEmail;

	/**
	 * Gets the user ID.
	 *
	 * @return the userID
	 */
	public int getUserID() {
		return UserID;
	}

	/**
	 * Sets the user ID.
	 *
	 * @param userID            the userID to set
	 */
	public void setUserID(int userID) {
		UserID = userID;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the userName
	 */
	public String getUserName() {
		return UserName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName            the userName to set
	 */
	public void setUserName(String userName) {
		UserName = userName;
	}

	/**
	 * Gets the user email.
	 *
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return UserEmail;
	}

	/**
	 * Sets the user email.
	 *
	 * @param userEmail            the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}

}
