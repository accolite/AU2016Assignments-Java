/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 24, 2016
*
*  @author :: Sharukh Mohamed
* ***************************************************************************
*/
package com.accolite.servletassignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * NewPost resource (exposed at "newPost" path)
 */

@Path("newPost")
public class NewPostOld {

    
	/**
	 * New post.
	 *
	 * @param newPost the new post
	 * @return the post
	 */
    public Post newPost(Post newPost) {
		Post returner = newPost;
    	System.out.println(newPost.getUser_id()+newPost.getPost_content());
    	try {
    		/**
    		 * DB Connection
    		 */
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USERNAME, Constants.PASSWORD);
			Statement statement = connection.createStatement();
			
			/**
			 * Insert
			 */
			String select = "insert into posts(user_id,post_content) values("+newPost.getUser_id()+",'"+newPost.getPost_content()+"');";

	    	System.out.println(select);
	    	
			statement.executeUpdate(select);
			
	    	statement.close();
	    	connection.close();
    	} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
    		returner = new Post();
    		returner.setPost_content("Invalid");
			e.printStackTrace();
		}
    	/**
    	 * Return status via Post_content
    	 */
		return returner;
    }
}
