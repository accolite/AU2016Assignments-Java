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
 * AllComments of a post resource (exposed at "allComments/post_id" path)
 */

@Path("allComments")
public class AllComments {

    
	/**
	 * All comments.
	 *
	 * @param id the id of post
	 * @return the list of posts
	 */
	@GET
	@Path("{post_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> allComments(@PathParam("post_id") String id) {
		List<Comment> returner = new ArrayList<>();
    	try {
    		/**
    		 * DB Connection
    		 */
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USERNAME, Constants.PASSWORD);
			Statement statement = connection.createStatement();
			
			/**
			 * Order by commented time - oldest first
			 */
			String select = "select * from comments where post_id="+id+" ORDER by time_commented ASC;";

	    	System.out.println(select);
	    	
			ResultSet rs = statement.executeQuery(select);
			int count = 0;
			
			/**
			 * Set comments details
			 */
			while(rs.next()){
					count+=1;
					Comment comment = new Comment();
					comment.setPost_id(rs.getInt("post_id"));
					comment.setComment(rs.getString("comment"));
					comment.setTime_commented(rs.getString("time_commented"));
					comment.setUser_id(rs.getInt("user_id"));
					returner.add(comment);
				}
			/**
			 * No comments to show
			 */
			if(count==0){
				Comment comment = new Comment();
				comment.setComment("No Comments to show");
				returner.add(comment);
			}
			rs.close();
	    	statement.close();
	    	connection.close();
    	} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
    		Comment comment = new Comment();
    		comment.setComment("Invalid request");
    		returner.add(comment);
			e.printStackTrace();
		}
    	/**
    	 * Return status via Comment
    	 */
		return returner;
    }
}
