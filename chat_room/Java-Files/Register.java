package com.accolite.servletassignment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

/**
 * Servlet implementation class Register
 */
@WebServlet(name="Register", urlPatterns= {"/Register"})
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * If logged_in users are null, initialize
		 */
		if(getServletContext().getAttribute("logged_in")==null){
        	getServletContext().setAttribute("logged_in", new HashMap<String, String>());
        }
		/**
		 * Get username and password
		 */
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Map<String, String> map = new HashMap<>();
    	map.put("status", "0");
    	Integer user_id = 0;
    	try {
    		/**
    		 * PreventDefault at server
    		 */
    		if(username.equals("") || password.equals("")){
    			map.put("status", "false");
    	    	map.put("content", "User name or password can't be empty");
    		}else{
    			/**
    			 * DB Connection
    			 */
				Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
				Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USERNAME, Constants.PASSWORD);
				Statement statement = connection.createStatement();
				
				/**
				 * Check if already existing user
				 */
				String select = "SELECT user_id FROM users where name='"+username+"'" ;
	
		    	System.out.println(select);
				ResultSet rs = statement.executeQuery(select);
				
				/**
				 * If existing don't add
				 */
				if(rs.next()){
					map.put("status", "false");
					map.put("content", "alreadyRegistered");
				}
				else{
					/**
					 * Go ahead and insert
					 */
					select = "INSERT INTO users(name,password) values('"+username+"','"+password+"');" ;
					System.out.println(select);
					statement.executeUpdate(select);
					select = "SELECT user_id FROM users WHERE name='"+username+"';" ;
					System.out.println(select);
					rs = statement.executeQuery(select);
					if(rs.next()){
						user_id=rs.getInt("user_id");
						
						/**
						 * setting Session vars
						 */
						HttpSession session = request.getSession();
						session.setAttribute("id", user_id.toString());
						session.setAttribute("username", username);
						map.put("status", "true");
						
						/**
						 * Registering as event
						 */
						Map<String, Map<String, String>> all_posts = (LinkedHashMap<String, Map<String, String>>) getServletContext().getAttribute("all_posts");
						Map<String, String> user = new HashMap<>();
						user.put("added", "<h1>User "+ username + " joined</h1>");
						Integer toInsert = new Integer(all_posts.size());
						if(all_posts.get(toInsert.toString())!=null)
							toInsert+=all_posts.size();
						all_posts.put("1111-"+new Date().toString()+"-"+toInsert.toString(), user);
					}
					
				}
		    	rs.close();
		    	statement.close();
		    	connection.close();
    		}
    	} catch (ClassNotFoundException | NullPointerException | SQLException e) {
			// TODO Auto-generated catch block
    		if(request.getSession(false)==null)
    		map.put("status", "false");
			e.printStackTrace();
			map.put("content", e.getMessage());
		}
    	/**
    	 * Return status via JSON status
    	 */
    	
    	
    	String json = new Gson().toJson(map);
    	/**
    	 * Return JSON of status using GSON
    	 */
    	response.setContentType("application/json");
    	response.setCharacterEncoding("UTF-8");
    	response.getWriter().write(json);    
    	}

}
