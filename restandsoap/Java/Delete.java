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
 * AddLikes resource (exposed at "addLikes" path)
 */

@Path("delete")

public class Delete {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */

	@Path("deletePost/{user_id}/{post_id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Post deletePost(@PathParam("post_id") String post_id,@PathParam("user_id") String user_id, @Context HttpServletRequest request) {
		HttpSession session = request.getSession();
		String session_user = (String) session.getAttribute("id");
		Post returner = new Post();
		returner.setPost_id(Integer.parseInt(post_id));
		if(session_user.equals(user_id)){
			try {
				Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
				Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USERNAME,
						Constants.PASSWORD);
				Statement statement = connection.createStatement();
				
				String select = "select 1 from posts where post_id="+post_id+" and user_id="+user_id+";";
				ResultSet rs = statement.executeQuery(select);
				
				if(rs.next()){
				
					select = "delete from comments where post_id="+post_id+";";
					System.out.println(select);
					statement.executeUpdate(select);
					
					select = "delete from likes where post_id="+post_id+";";
					System.out.println(select);
					statement.executeUpdate(select);
				
					select = "delete from posts where post_id="+post_id+";";
					returner.setPost_content(post_id + " was deleted");
					System.out.println(select); 
					statement.executeUpdate(select);
				}
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
			returner.setPost_content("Invalid session");
		}
		return returner;
	}
	
	@Path("deleteComment/{user_id}/{comment_id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Comment deleteComment(@PathParam("comment_id") String comment_id,@PathParam("user_id") String user_id, @Context HttpServletRequest request) {
		HttpSession session = request.getSession();
		String session_user = (String) session.getAttribute("id");
		Comment returner = new Comment();
		returner.setComment_id(Integer.parseInt(comment_id));
		if(session_user.equals(user_id)){
			try {
				Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
				Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USERNAME,
						Constants.PASSWORD);
				Statement statement = connection.createStatement();
				
				String select = "select 1 from comments where comment_id="+comment_id+" and user_id="+user_id+";";
				ResultSet rs = statement.executeQuery(select);
				
				if(rs.next()){
				
					select = "delete from comments where comment_id="+comment_id+";";
					System.out.println(select);
					statement.executeUpdate(select);
					returner.setComment("Comment "+comment_id+" was deleted");
				}
				else{
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
			returner.setComment("Invalid session");
		}
		return returner;
	}
	
	@Path("deleteLike/{user_id}/{like_id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Like deleteLike(@PathParam("like_id") String like_id,@PathParam("user_id") String user_id, @Context HttpServletRequest request) {
		HttpSession session = request.getSession();
		String session_user = (String) session.getAttribute("id");
		Like returner = new Like();
		returner.setLike_id(Integer.parseInt(like_id));
		if(session_user.equals(user_id)){
			try {
				Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
				Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USERNAME,
						Constants.PASSWORD);
				Statement statement = connection.createStatement();
				
				String select = "select 1 from likes where like_id="+like_id+" and user_id="+user_id+";";
				ResultSet rs = statement.executeQuery(select);
				
				if(rs.next()){
				
					select = "delete from likes where like_id="+like_id+";";
					System.out.println(select);
					statement.executeUpdate(select);
					returner.setLike_id(Integer.parseInt(like_id));
				}
				else{
					returner.setLike_id(-1);
				}
				
				statement.close();
				connection.close();
			} catch (ClassNotFoundException | SQLException e ) {
				// TODO Auto-generated catch block
				returner.setLike_id(-3);
				e.printStackTrace();
			}
		}
		else{
			returner.setLike_id(-2);
		}
		return returner;
	}
	
	@Path("deleteFriend/{user_id}/{friend_name}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public User deleteFriend(@PathParam("friend_name") String friend_name,@PathParam("user_id") String user_id, @Context HttpServletRequest request) {
		HttpSession session = request.getSession();
		String session_user = (String) session.getAttribute("id");
		User returner = new User();
		if(session_user.equals(user_id)){
			try {
				Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
				Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USERNAME,
						Constants.PASSWORD);
				Statement statement = connection.createStatement();
				
				String select = "select * from friendship where friend1_id="+user_id+" and friend2_id in ("
						+ "select user_id from users where name = '"+ friend_name +"');";
				
				ResultSet rs = statement.executeQuery(select);
				
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
			returner.setName("Invalid session");
		}
		return returner;
	}
}
