package com.accolite.servletassignment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
 * Servlet implementation class NewPost
 */
@WebServlet("/NewPost")
public class NewPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * Get post entered and user_id
		 */
		String post = request.getParameter("post_content");
		if(request.getServletContext().getAttribute("blocked")!=null){
			if(((ArrayList<String>)request.getServletContext().getAttribute("blocked")).size()>0)
				post = (String) request.getServletContext().getAttribute("filtered");
		}
		//System.out.println("Filtered post :"+post);
		String user_id = request.getParameter("user_id");
		HttpSession session = request.getSession(false);
		Map<String, String> map = new HashMap<>();
		/**
		 * Server side preventDefault
		 */
		if(post.equals("")){
			map.put("-1","post Cannot be empty");
		}
		else{
			/**
			 * Session is valid?
			 */
			if(session!=null){
		    	try {
		    		/**
		    		 * DB Connection
		    		 */
					Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
					Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USERNAME, Constants.PASSWORD);
					Statement statement = connection.createStatement();
					
					/**
					 * Insert
					 */
					String select = "insert into posts(user_id,post_content) values("+user_id+",'"+post+"');";
		
			    	map.put("status", "true");
			    	
					statement.executeUpdate(select);
					map.put("post_content", post);
					map.put("user_id", user_id);
					
					
					/**
					 * Selecting time posted of current post
					 */
					select = "select time_posted from posts where user_id = "+user_id+" and post_content = '"+post+"';";
					
					ResultSet rs = statement.executeQuery(select);
					
					if(rs.next()){
						System.out.println("Reverse mapped");
						map.put("time_posted", rs.getString("time_posted"));
					}
					
					/**
					 * Closing ResultSet, Statement and Connection
					 */
					rs.close();
			    	statement.close();
			    	connection.close();
		    	} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
		    		map.put("-3", e.getMessage());
					e.printStackTrace();
				}
			}else{
				map.put("-2", "Invalid session");
			}
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
