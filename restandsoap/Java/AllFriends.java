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
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * AllFriends resource (exposed at "allPosts" path)
 */

@Path("allFriends")
public class AllFriends {

	/**
	 * All friends of a friend.
	 *
	 * @param user_id the id of user requesting
	 * @param friend_name the friend name
	 * @return the list of friends of friends
	 */
	@GET
	@Path("{user_id}/{friend_name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> allFriendsOfFriend(@PathParam("user_id") String user_id, @PathParam("friend_name") String friend_name) {
		List<User> returner = new ArrayList<>();
    	try {
    		/**
    		 * DB Connection
    		 */
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USERNAME, Constants.PASSWORD);
			Statement statement = connection.createStatement();
			
			/**
			 * If a friend
			 */
			String select = "select * from friendship where friend1_id="+user_id+" and friend2_id in ("
					+ "select user_id from users where name = '"+ friend_name +"');";
			
			System.out.println(select);
			
			ResultSet rs = statement.executeQuery(select);
			if(rs.next()){
				/**
				 * Get all id of friend's friends
				 */
				select = "select friend1_id from friendship where friend2_id in ("
						+ "select user_id from users where name = '"+friend_name+"') ORDER by friendship_id DESC;";
	
		    	System.out.println(select);
		    	rs = statement.executeQuery(select);
		    	
		    	int count = 0;
				
				while(rs.next()){
					count+=1;
					User user = new User();
					user.setUser_id(rs.getInt("friend1_id"));
					returner.add(user);
				}
				
				/**
				 * No friends of friends - never hit as I am always his friend, if i'm here
				 */
				if(count == 0){
					User user = new User();
					user.setName("No friends for "+friend_name);
					returner.add(user);
				}
				else{
					/**
					 * If there are some users, get their names
					 */
					for(User user: returner){
						select = "select name from users where user_id="+user.getUser_id()+";";
						rs = statement.executeQuery(select);
						if(rs.next())
							user.setName(rs.getString("name"));
					}
					
				}
			}else{
				/**
				 * Not a friend
				 */
				User user = new User();
				user.setName("Not a friend");
				returner.add(user);
			}
			
			rs.close();
	    	statement.close();
	    	connection.close();
    	} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block

			User user = new User();
			user.setName("Invalid Request");
			returner.add(user);
			e.printStackTrace();
		}
    	
    	/**
    	 * Return status via name
    	 */
		return returner;
    }
	
}