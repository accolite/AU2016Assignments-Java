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
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Comment addComment(Comment newComment,@Context HttpServletRequest request) {
		Comment returner = newComment;
    	System.out.println(newComment.getUser_id()+newComment.getComment());
    	try {
    		HttpSession session = request.getSession();
    		String user_id = (String) session.getAttribute("id");
    		
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USERNAME, Constants.PASSWORD);
			Statement statement = connection.createStatement();
			
			String select = "select 1 from friendship where friend1_id="+user_id+" and friend2_id in ("
					+ "select user_id from posts where post_id="+returner.getPost_id()+");";

	    	System.out.println(select);
	    	
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
    
		return returner;
    }
}
