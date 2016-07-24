package com.accolite.Messanger.messanger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * Login resource (exposed at "login" path)
 */

@Path("login")
public class Login {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    
	@POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String postLogin(String username) {
    	String userId = "invalid";
    	System.out.println(username+"Hello world"+userId);
    	try {
    		if(username.equals("")){
				userId = "emptyNotAccepted";
    		}else{
    			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
				Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USERNAME, Constants.PASSWORD);
				Statement statement = connection.createStatement();
				String select = "SELECT user_id FROM users where name='"+username+"'" ;
	
		    	System.out.println(select);
				ResultSet rs = statement.executeQuery(select);
				
				if(rs.next()){
					userId = rs.getString(1);
				}
		    	rs.close();
		    	statement.close();
		    	connection.close();
    		}
    	} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
		return userId;
    }
}
