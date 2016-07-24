package com.accolite.Messanger.messanger;

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
public class NewPost {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Post newPost(Post newPost) {
		Post returner = newPost;
    	System.out.println(newPost.getUser_id()+newPost.getPost_content());
    	try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USERNAME, Constants.PASSWORD);
			Statement statement = connection.createStatement();
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
    
		return returner;
    }
}
