/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 24, 2016
*
*  @author :: Sharukh Mohamed
* ***************************************************************************
*/
package com.accolite.Messanger.messanger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


/**
 * Login resource (exposed at "login" path)
 */

@Path("login")
public class Login {

    
	/**
	 * login.
	 *
	 * @param username the username logging in
	 * @return the string
	 */
	@POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String postLogin(String username, @Context HttpServletRequest request) {
		/**
		 * Assume user not available
		 */
    	String userId = "invalid";
    	System.out.println(username+"Hello world"+userId);
    	try {
    		/**
    		 * preventDefault at server
    		 */
    		if(username.equals("")){
				userId = "emptyNotAccepted";
    		}else{
    			/**
    			 * DB connection
    			 */
    			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
				Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USERNAME, Constants.PASSWORD);
				Statement statement = connection.createStatement();
				
				/**
				 * Authentication with username
				 */
				String select = "SELECT user_id FROM users where name='"+username+"'" ;
	
		    	System.out.println(select);
				ResultSet rs = statement.executeQuery(select);
				
				/**
				 * if user available
				 */
				if(rs.next()){
					userId = rs.getString(1);
					
					/**
					 * Setting session vars
					 */
					HttpSession session = request.getSession();
					session.setAttribute("id", userId);
					session.setAttribute("username", username);
				}
		    	rs.close();
		    	statement.close();
		    	connection.close();
    		}
    	} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	/**
    	 * Return plain string
    	 */
		return userId;
    }
}
