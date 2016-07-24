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
 * AllLikes resource (exposed at "allLikes" path)
 */

@Path("allLikes")
public class AllLikes {

    
	/**
	 * All likes.
	 *
	 * @param id the id of post
	 * @return the list of likes
	 */
	@GET
	@Path("{post_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Like> allLikes(@PathParam("post_id") String id) {
		List<Like> returner = new ArrayList<>();
    	try {
    		/**
    		 * DB Connection
    		 */
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USERNAME, Constants.PASSWORD);
			Statement statement = connection.createStatement();
			
			/**
			 * get all associated likes
			 */
			String select = "select * from likes where post_id="+id+" ORDER by time_liked ASC;";

	    	System.out.println(select);
	    	
			ResultSet rs = statement.executeQuery(select);
			int count = 0;
			/**
			 * If there are any likes
			 */
			while(rs.next()){
				count+=1;
				Like like = new Like();
				like.setPost_id(rs.getInt("post_id"));
				like.setTime_liked(rs.getString("time_liked"));
				like.setUser_id(rs.getInt("user_id"));
				returner.add(like);
			}
			/**
			 * No likes for that post or there is no such post
			 */
			if(count==0){
				Like like = new Like();
				like.setLike_id(-1);
				returner.add(like);
			}
			
			rs.close();
	    	statement.close();
	    	connection.close();
    	} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
    		/**
    		 * Invalid request
    		 */
    		Like like = new Like();
    		like.setLike_id(-2);
    		returner.add(like);
			e.printStackTrace();
		}
    	/**
    	 * Return status via Like_id
    	 */
		return returner;
    }
}
