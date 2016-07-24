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

@Path("allLikes")
public class AllLikes {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    
	@GET
	@Path("{post_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Like> allLikes(@PathParam("post_id") String id) {
		List<Like> returner = new ArrayList<>();
    	try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USERNAME, Constants.PASSWORD);
			Statement statement = connection.createStatement();
			String select = "select * from likes where post_id="+id+" ORDER by time_liked ASC;";

	    	System.out.println(select);
	    	
			ResultSet rs = statement.executeQuery(select);
			int count = 0;
			while(rs.next()){
				count+=1;
				Like like = new Like();
				like.setPost_id(rs.getInt("post_id"));
				like.setTime_liked(rs.getString("time_liked"));
				like.setUser_id(rs.getInt("user_id"));
				returner.add(like);
			}
			
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
    		Like like = new Like();
    		like.setPost_id(-2);
    		returner.add(like);
			e.printStackTrace();
		}
    
		return returner;
    }
}
