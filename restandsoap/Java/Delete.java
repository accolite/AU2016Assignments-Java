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
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


/**
 * Delete resource (exposed at "delete" path)
 */

@Path("delete")

public class Delete {

	

	/**
	 * Delete post.
	 *
	 * @param post_id the post id
	 * @param user_id the user id of user requesting
	 * @param request the httprequest associated
	 * @return the post
	 */
	@Path("deletePost/{user_id}/{post_id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Post deletePost(@PathParam("post_id") String post_id,@PathParam("user_id") String user_id, @Context HttpServletRequest request) {
		/**
		 * Session handling
		 */
		HttpSession session = request.getSession();
		String session_user = (String) session.getAttribute("id");
		Post returner = new Post();
		returner.setPost_id(Integer.parseInt(post_id));
		if(session_user.equals(user_id)){
			try {
				/**
				 * DB Connection
				 */
				Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
				Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USERNAME,
						Constants.PASSWORD);
				Statement statement = connection.createStatement();
				
				/**
				 * See if post is available and belongs to him
				 */
				String select = "select 1 from posts where post_id="+post_id+" and user_id="+user_id+";";
				ResultSet rs = statement.executeQuery(select);
				
				if(rs.next()){
					/**
					 * Delete comments relevant
					 */
					select = "delete from comments where post_id="+post_id+";";
					System.out.println(select);
					statement.executeUpdate(select);
					
					/**
					 * Delete likes associated
					 */
					select = "delete from likes where post_id="+post_id+";";
					System.out.println(select);
					statement.executeUpdate(select);
				
					/**
					 * Finally delete from posts
					 */
					select = "delete from posts where post_id="+post_id+";";
					returner.setPost_content(post_id + " was deleted");
					System.out.println(select); 
					statement.executeUpdate(select);
				}
				/**
				 * Post not available for deletion
				 */
				else{
					returner.setPost_content("Post not available for you");
				}
				
				statement.close();
				connection.close();
			} catch (ClassNotFoundException | SQLException e ) {
				// TODO Auto-generated catch block
				returner.setPost_content("Invalid request");
				e.printStackTrace();
			}
		}
		else{
			/**
			 * Invalid session
			 */
			returner.setPost_content("Invalid session");
		}
		/**
		 * Return status via post_content
		 */
		return returner;
	}
	
	/**
	 * Delete comment.
	 *
	 * @param comment_id the comment id
	 * @param user_id the user id requesting
	 * @param request the httprequest associated
	 * @return the comment
	 */
	@Path("deleteComment/{user_id}/{comment_id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Comment deleteComment(@PathParam("comment_id") String comment_id,@PathParam("user_id") String user_id, @Context HttpServletRequest request) {
		/**
		 * Session handling
		 */
		HttpSession session = request.getSession();
		String session_user = (String) session.getAttribute("id");
		Comment returner = new Comment();
		returner.setComment_id(Integer.parseInt(comment_id));
		if(session_user.equals(user_id)){
			try {
				/**
				 * DB Connection
				 */
				Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
				Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USERNAME,
						Constants.PASSWORD);
				Statement statement = connection.createStatement();
				
				/**
				 * See if comment is available and belongs to user
				 */
				String select = "select 1 from comments where comment_id="+comment_id+" and user_id="+user_id+";";
				ResultSet rs = statement.executeQuery(select);
				
				/**
				 * If yes go ahead and delete
				 */
				if(rs.next()){
				
					select = "delete from comments where comment_id="+comment_id+";";
					System.out.println(select);
					statement.executeUpdate(select);
					returner.setComment("Comment "+comment_id+" was deleted");
				}
				else{
					/**
					 * Not available for deletion
					 */
					returner.setComment("Comment not available for you");
				}
				
				statement.close();
				connection.close();
			} catch (ClassNotFoundException | SQLException e ) {
				// TODO Auto-generated catch block
				returner.setComment("Invalid request");
				e.printStackTrace();
			}
		}
		else{
			/**
			 * Invalid session
			 */
			returner.setComment("Invalid session");
		}
		/**
		 * Return status via comment
		 */
		return returner;
	}
	
	/**
	 * Delete like.
	 *
	 * @param like_id the like id
	 * @param user_id the user id requesting
	 * @param request the httprequest associated
	 * @return the like
	 */
	@Path("deleteLike/{user_id}/{like_id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Like deleteLike(@PathParam("like_id") String like_id,@PathParam("user_id") String user_id, @Context HttpServletRequest request) {
		/**
		 * Session handling
		 */
		HttpSession session = request.getSession();
		String session_user = (String) session.getAttribute("id");
		Like returner = new Like();
		returner.setLike_id(Integer.parseInt(like_id));
		if(session_user.equals(user_id)){
			try {
				/**
				 * DB Connection
				 */
				Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
				Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USERNAME,
						Constants.PASSWORD);
				Statement statement = connection.createStatement();
				
				/**
				 * Select if like is available and belongs to him
				 */
				String select = "select 1 from likes where like_id="+like_id+" and user_id="+user_id+";";
				ResultSet rs = statement.executeQuery(select);
				
				/*
				 * If yes, go ahead and delete
				 */
				if(rs.next()){
				
					select = "delete from likes where like_id="+like_id+";";
					System.out.println(select);
					statement.executeUpdate(select);
					returner.setLike_id(Integer.parseInt(like_id));
				}
				/**
				 * Like is not available for deletion
				 */
				else{
					returner.setLike_id(-1);
				}
				
				statement.close();
				connection.close();
			} catch (ClassNotFoundException | SQLException e ) {
				// TODO Auto-generated catch block
				/**
				 * Invalid request
				 */
				returner.setLike_id(-3);
				e.printStackTrace();
			}
		}
		else{
			/**
			 * Invalid session
			 */
			returner.setLike_id(-2);
		}
		/**
		 * Return status via like_id
		 */
		return returner;
	}
	
	/**
	 * Delete friend.
	 *
	 * @param friend_name the friend name
	 * @param user_id the user id of requesting user
	 * @param request the httprequest associated
	 * @return the user
	 */
	@Path("deleteFriend/{user_id}/{friend_name}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public User deleteFriend(@PathParam("friend_name") String friend_name,@PathParam("user_id") String user_id, @Context HttpServletRequest request) {
		/**
		 * Session handling
		 */
		HttpSession session = request.getSession();
		String session_user = (String) session.getAttribute("id");
		User returner = new User();
		if(session_user.equals(user_id)){
			try {
				/**
				 * DB Connection
				 */
				Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
				Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USERNAME,
						Constants.PASSWORD);
				Statement statement = connection.createStatement();
				
				/**
				 * See if friend
				 */
				String select = "select * from friendship where friend1_id="+user_id+" and friend2_id in ("
						+ "select user_id from users where name = '"+ friend_name +"');";
				
				ResultSet rs = statement.executeQuery(select);
				
				/**
				 * If friend, delete both way connection, friend1-friend2
				 */
				if(rs.next()){
				
					select = "delete from friendship where friend1_id="+user_id+" and friend2_id in ("
						+ "select user_id from users where name = '"+ friend_name +"');";
					System.out.println(select);
					statement.executeUpdate(select);
					
					select = "delete from friendship where friend2_id="+user_id+" and friend1_id in ("
							+ "select user_id from users where name = '"+ friend_name +"');";
					
					statement.executeUpdate(select);
					
					returner.setName("You and "+friend_name+ " are no longer friends");
				}
				/**
				 * Not a friend
				 */
				else{
					returner.setName("Not your Friend yet");
				}
				
				statement.close();
				connection.close();
			} catch (ClassNotFoundException | SQLException e ) {
				// TODO Auto-generated catch block
				returner.setName("Invalid request");;
				e.printStackTrace();
			}
		}
		else{
			/**
			 * Invalid session
			 */
			returner.setName("Invalid session");
		}
		/**
		 * Return status via name
		 */
		return returner;
	}
}
