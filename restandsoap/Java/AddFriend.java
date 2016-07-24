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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


/**
 * AddFriend resource (exposed at "addFriend/friendName" path)
 */

@Path("addFriend")

public class AddFriend {

    
    
	/**
	 * Adds the friend.
	 *
	 * @param user the user requesting for new friend
	 * @param friendName the friend name of new friend
	 * @param request the request associated
	 * @return the user - friend added
	 */
	@Path("{friendUser}")
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User addFriend(User user,@PathParam("friendUser") String friendName, @Context HttpServletRequest request) {
		User returner = new User();
    	try {
    		/**
    		 * PreventDefault at server side just in case
    		 */
    		if(friendName.equals(""))
    			returner.setName("username can't be empty");
    		else{
    			
    			/**
    			 * Session handling
    			 */
    			HttpSession session = request.getSession();
    			String user_id = (String) session.getAttribute("id");
    			
    			/**
    			 * Database connection
    			 */
				Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
				Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USERNAME, Constants.PASSWORD);
				Statement statement = connection.createStatement();
				
				/**
				 * Check if friend
				 */
				String select = "select * from friendship where friend1_id="+user_id+" and friend2_id in ("
						+ "select user_id from users where name = '"+ friendName +"');";
	
		    	System.out.println(select);
		    	
				ResultSet rs = statement.executeQuery(select);
				
				if(rs.next()){
					returner.setName("Already a friend");
				} else{
					
					/**
					 * Create new friendship, both ways friend1-friend2, friend2-friend1
					 */
					select = "select user_id from users where name='"+friendName+"';";
					rs=statement.executeQuery(select);
					if(rs.next()){
						int friend_id = rs.getInt("user_id");
						select = "insert into friendship(friend1_id,friend2_id) values("
								+user.getUser_id()+","+friend_id+");";
						statement.executeUpdate(select);

						select = "insert into friendship(friend1_id,friend2_id) values("
								+friend_id+","+user.getUser_id()+");";
						statement.executeUpdate(select);
						
						returner.setName(friendName+ " is now a friend");
					}else{
						returner.setName("Invalid friend");
					}
					
				}
				rs.close();
		    	statement.close();
		    	connection.close();
    		}
    	} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
    		returner.setName("Invalid request");
			e.printStackTrace();
		}
    	/**
    	 * return status via name
    	 */
		return returner;
    }
}
