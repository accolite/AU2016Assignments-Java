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

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * Register resource (exposed at "register" path)
 */

@Path("register")
public class Register {

    
	/**
	 * Post register.
	 *
	 * @param username the username registering
	 * @return the string
	 */
	@POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String postRegister(String username) {
		/**
		 * Assume invalid user
		 */
    	String userId = "invalid";
    	Integer user_id = 0;
    	System.out.println(username+"Hello world"+userId);
    	try {
    		/**
    		 * PreventDefault at server
    		 */
    		if(username.equals(""))
					userId = "emptyNotAccepted";
    		else{
    			/**
    			 * DB Connection
    			 */
				Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
				Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USERNAME, Constants.PASSWORD);
				Statement statement = connection.createStatement();
				
				/**
				 * Check if already existing user
				 */
				String select = "SELECT user_id FROM users where name='"+username+"'" ;
	
		    	System.out.println(select);
				ResultSet rs = statement.executeQuery(select);
				
				/**
				 * If existing don't add
				 */
				if(rs.next())
					userId = "alreadyRegistered";
				else{
					/**
					 * Go ahead and insert
					 */
					select = "INSERT INTO users(name) values('"+username+"');" ;
					System.out.println(select);
					statement.executeUpdate(select);
					select = "SELECT user_id FROM users WHERE name='"+username+"';" ;
					System.out.println(select);
					rs = statement.executeQuery(select);
					if(rs.next()){
						user_id=rs.getInt("user_id");
						userId = user_id.toString();
					}
					
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
    	 * Return status via string
    	 */
		return userId;
    }
}