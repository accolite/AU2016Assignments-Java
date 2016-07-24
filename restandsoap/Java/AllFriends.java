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
 * NewPost resource (exposed at "allPosts" path)
 */

@Path("allFriends")
public class AllFriends {

	@GET
	@Path("{user_id}/{friend_name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> allFriendsOfFriend(@PathParam("user_id") String user_id, @PathParam("friend_name") String friend_name) {
		List<User> returner = new ArrayList<>();
    	try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USERNAME, Constants.PASSWORD);
			Statement statement = connection.createStatement();
			
			String select = "select * from friendship where friend1_id="+user_id+" and friend2_id in ("
					+ "select user_id from users where name = '"+ friend_name +"');";
			
			System.out.println(select);
			
			ResultSet rs = statement.executeQuery(select);
			if(rs.next()){
				
				select = "select friend1_id from friendship where friend2_id in ("
						+ "select user_id from users where name = '"+friend_name+"') ORDER by friendship_id DESC;";
	
		    	System.out.println(select);
		    	rs = statement.executeQuery(select);
		    	
		    	int count = 0;
				
				while(rs.next()){
					count+=1;
					User user = new User();
					user.setUser_id(rs.getInt("user_id"));
					returner.add(user);
				}
				if(count == 0){
					User user = new User();
					user.setUser_id(-1);
					returner.add(user);
				}
			}else{
				User user = new User();
				user.setUser_id(-2);
				returner.add(user);
			}
			
			rs.close();
	    	statement.close();
	    	connection.close();
    	} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block

			User user = new User();
			user.setUser_id(-3);
			returner.add(user);
			e.printStackTrace();
		}
    
		return returner;
    }
	
}