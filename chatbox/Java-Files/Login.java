package com.accolite.servletassignment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
 * Servlet implementation class Login
 */

@WebServlet(name="Login", urlPatterns={"/Login"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Create new logged_in users map to use for UI
		 */
		if(getServletContext().getAttribute("logged_in")==null){
        	getServletContext().setAttribute("logged_in", new HashMap<String, String>());
        }
		
		/**
		 * Assume user not available and get parameters 
		 */
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	Map<String, String> map = new HashMap<>();
    	map.put("status", "0");
    	try {
    		/**
    		 * preventDefault at server
    		 */
    		if(username.equals("") || password.equals("")){
    			map.put("status", "false");
    	    	map.put("content", "User name or password can't be empty");
    		}else{
    			/**
    			 * DB connection
    			 */
    			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
				Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USERNAME, Constants.PASSWORD);
				Statement statement = connection.createStatement();
				
				/**
				 * Authentication with username and password
				 */
				String select = "SELECT user_id FROM users where name='"+username
						+"' and password='"+password+"'" ;
	
		    	System.out.println(select);
				ResultSet rs = statement.executeQuery(select);
				
				/**
				 * if user available
				 */
				if(rs.next()){
					map.put("status", "true");
					/**
					 * If user is admin
					 */
					if(username.equals("admin")){
						map.put("status", "admin");
						
						HttpSession session = request.getSession();
						
						session.setAttribute("id", "admin");

				    //  request.getRequestDispatcher("/admin.jsp").forward(request, response);
						
					}
					else{
						String userId = rs.getString(1);
						
						/**
						 * Setting session vars
						 */
						HttpSession session = request.getSession();
					
						session.setAttribute("id", userId);
						session.setAttribute("username", username);	
						
						/**
						 * Add logged in user as notification
						 */
						Map<String, Map<String, String>> all_posts = (LinkedHashMap<String, Map<String, String>>) getServletContext().getAttribute("all_posts");
						Map<String, String> user = new HashMap<>();
						user.put("added", "<h1>User "+ username + " joined</h1>");
						all_posts.put(new Integer(all_posts.size()+1).toString(), user);
						
					}
					
				}
		    	rs.close();
		    	statement.close();
		    	connection.close();

    		}
    	} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("status", "false");
			map.put("content", e.getMessage());
		}
    	
    	String json = new Gson().toJson(map);
    	/**
    	 * Return JSON of status using GSON
    	 */
    	response.setContentType("application/json");
    	response.setCharacterEncoding("UTF-8");
    	response.getWriter().write(json);
    }

}
