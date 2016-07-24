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
 * AddLikes resource (exposed at "addLikes" path)
 */

@Path("addLikes")

public class AddLike {

	

	/**
	 * Adds the like.
	 *
	 * @param newLike the new like
	 * @param request the httprequest associated
	 * @return the like
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Like addLike(Like newLike, @Context HttpServletRequest request) {
		Like returner = newLike;
		System.out.println(newLike.getUser_id());
		try {
			/**
			 * Session handling
			 */
			HttpSession session = request.getSession();
			String user_id = (String) session.getAttribute("id");
			
			/**
			 * DB connection
			 */
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USERNAME,
					Constants.PASSWORD);
			Statement statement = connection.createStatement();
			
			/**
			 * Check for friendship
			 */
			String select = "select 1 from friendship where friend1_id="+user_id+" and friend2_id in ("
					+ "select user_id from posts where post_id="+returner.getPost_id()+");";


			System.out.println(select);

			ResultSet rs = statement.executeQuery(select);
			/**
			 * If a friend, go ahead and like
			 */
			if (rs.next()) {
				
				/**
				 * If already liked
				 */
				select = "select 1 from likes where user_id="+newLike.getUser_id()
				+" and post_id="+newLike.getPost_id()+";";
				rs = statement.executeQuery(select);
				if(rs.next()){
					returner.setLike_id(-1);
				}
				
				/**
				 * Like now
				 */
				else{
					System.out.println("I am likeable");
					select = "insert into Likes(user_id,post_id) values('" + returner.getUser_id()  
					+ "','" + returner.getPost_id() + "');";
					statement.executeUpdate(select);
				}
			} else {
				/**
				 * Not a friend
				 */
				returner = new Like();
				returner.setPost_id(-2);
			}

			rs.close();
			statement.close();
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			returner = new Like();
			returner.setLike_id(-3);
			e.printStackTrace();
		}
		/**
		 * Return status via like_id
		 */
		return returner;
	}
}
