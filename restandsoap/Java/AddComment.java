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
 * AddComments resource (exposed at "addComments" path)
 */

@Path("addComments")

public class AddComment {

    
    
	/**
	 * Adds the comment.
	 *
	 * @param newComment the new comment
	 * @param request the associated HttpRequest
	 * @return the comment
	 */
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Comment addComment(Comment newComment,@Context HttpServletRequest request) {
		Comment returner = newComment;
		
		
    	System.out.println(newComment.getUser_id()+newComment.getComment());
    	try {
    		/**
    		 * Handle sessions
    		 */
    		HttpSession session = request.getSession();
    		String user_id = (String) session.getAttribute("id");
    		
    		/**
    		 * Connect to database
    		 */
    		
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USERNAME, Constants.PASSWORD);
			Statement statement = connection.createStatement();
			
			
			/**
			 * Check if a friend
			 */
			String select = "select 1 from friendship where friend1_id="+user_id+" and friend2_id in ("
					+ "select user_id from posts where post_id="+returner.getPost_id()+");";

	    	System.out.println(select);
	    	
	    	/**
	    	 * If friend insert
	    	 */
			ResultSet rs = statement.executeQuery(select);
			if(rs.next()){
				select = "insert into comments(user_id,comment,post_id) values('"
						+returner.getUser_id()+"','"+returner.getComment()+"','"+returner.getPost_id()+"');";
				statement.executeUpdate(select);
			} else{
				returner = new Comment();
				returner.setComment("Not a friend");
			}
			
			rs.close();
	    	statement.close();
	    	connection.close();
    	} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
    		returner = new Comment();
    		returner.setComment("Invalid");
			e.printStackTrace();
		}
    	
    	/**
    	 * Return status of comment via comment
    	 */
		return returner;
    }
}
