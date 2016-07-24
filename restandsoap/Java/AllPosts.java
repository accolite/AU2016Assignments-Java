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
 * AllPosts resource (exposed at "allPosts" path)
 */

@Path("allPosts")
public class AllPosts {

    
	/**
	 * All posts of this user
	 *
	 * @param id the id of user
	 * @return the list of posts by the user
	 */
	@GET
	@Path("{user_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> allPosts(@PathParam("user_id") String id) {
		List<Post> returner = new ArrayList<>();
    	try {
    		/**
    		 * DB Connection
    		 */
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USERNAME, Constants.PASSWORD);
			Statement statement = connection.createStatement();
			
			/**
			 * Get posts
			 */
			String select = "select * from posts where user_id="+id+" ORDER by time_posted DESC;";

	    	System.out.println(select);
	    	
			ResultSet rs = statement.executeQuery(select);
			
			/**
			 * If any posts available
			 */
			int count = 0;
			while(rs.next()){
				count+=1;
				Post post = new Post();
				post.setPost_content(rs.getString("post_content"));
				post.setTime_posted(rs.getString("time_posted"));
				post.setUser_id(rs.getInt("user_id"));
				post.setPost_id(rs.getInt("post_id"));
				returner.add(post);
			}
			
			/**
			 * No posts to show
			 */
			if(count==0){
				Post post = new Post();
				post.setPost_content("No posts to show");
				returner.add(post);
			}
			
			rs.close();
	    	statement.close();
	    	connection.close();
    	} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
    		Post post = new Post();
    		post.setPost_content("Invalid");
    		returner.add(post);
			e.printStackTrace();
		}
    
		return returner;
    }
	
	/**
	 * All posts by friend.
	 *
	 * @param user_id the user id of requesting user
	 * @param friend_name the friend name
	 * @return the list of posts by friend
	 */
	@GET
	@Path("{user_id}/{friend_name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> allPostsByFriend(@PathParam("user_id") String user_id, @PathParam("friend_name") String friend_name) {
		List<Post> returner = new ArrayList<>();
    	try {
    		/**
    		 * DB Connection
    		 */
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USERNAME, Constants.PASSWORD);
			Statement statement = connection.createStatement();
			
			/**
			 * Check if friend
			 */
			String select = "select * from friendship where friend1_id="+user_id+" and friend2_id in ("
					+ "select user_id from users where name = '"+ friend_name +"');";
			
			System.out.println(select);
			
			ResultSet rs = statement.executeQuery(select);
			
			/**
			 * If friend
			 */
			if(rs.next()){
				
				/**
				 * select all posts from friend's id
				 */
				select = "select * from posts where user_id in ("
						+ "select user_id from users where name = '"+friend_name+"') ORDER by time_posted DESC;";
	
		    	System.out.println(select);
		    	rs = statement.executeQuery(select);
		    	
		    	int count = 0;
				
		    	/**
		    	 * If available posts
		    	 */
				while(rs.next()){
					count+=1;
					Post post = new Post();
					post.setPost_content(rs.getString("post_content"));
					post.setTime_posted(rs.getString("time_posted"));
					post.setUser_id(rs.getInt("user_id"));
					post.setPost_id(rs.getInt("post_id"));
					returner.add(post);
				}
				/**
				 * Else no posts
				 */
				if(count == 0){
					Post post = new Post();
					post.setPost_content("No posts to show");
					returner.add(post);
				}
			}else{
				/**
				 * Not a friend
				 */
				Post post = new Post();
				post.setPost_content("Not your friend");
				returner.add(post);
			}
			
			rs.close();
	    	statement.close();
	    	connection.close();
    	} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
    		Post post = new Post();
    		post.setPost_content("Invalid");
    		returner.add(post);
			e.printStackTrace();
		}
    	/**
    	 * Return status via post content
    	 */
		return returner;
    }
}
