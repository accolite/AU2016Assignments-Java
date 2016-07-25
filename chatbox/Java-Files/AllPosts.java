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
 * Get all posts
 */
@WebServlet("/AllPosts")
public class AllPosts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AllPosts() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * Initialize all posts at very first request
		 */
		if(getServletContext().getAttribute("all_posts")==null){
        	getServletContext().setAttribute("all_posts", new LinkedHashMap<String, Map<String,String>>());
        }
		
		/**
		 * A linked hash map to get all attributes. Can be extended for order of insertion if needed.
		 */
		Map<String, Map<String,String>> all_posts = (LinkedHashMap<String, Map<String, String>>) getServletContext().getAttribute("all_posts");
		
		/**
		 * Handling session
		 */
		HttpSession session = request.getSession(false);
		
		/**
		 * map object to handle posts
		 */
		Map<String, Map<String, String>> map = new LinkedHashMap<>();
		/**
		 * internal sub map to handle post content and username
		 */
		Map<String, String> submap = new HashMap<>();
		if(session!=null){
			try{
				/**
				 * If any invalid session, remove
				 */
				all_posts.remove("-3");
				/**
				 * Connecting to DB
				 */
				Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
				Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USERNAME, Constants.PASSWORD);
				Statement statement = connection.createStatement();
	
				/**
				 * Get posts
				 */
				String select = "select * from posts";
	
	
				ResultSet rs = statement.executeQuery(select);
				/**
				 * If any posts available
				 */
				Integer count = 0;
				while(rs.next()){
					count+=1;
					submap = new HashMap<>();
					submap.put("post_content",rs.getString("post_content"));
					submap.put("time_posted", rs.getString("time_posted"));
					Integer user = rs.getInt("user_id");
					submap.put("user_id", user.toString());
	
					count+=1;
					map.put(count.toString(),submap);
				}
				/**
				 * Getting user names
				 */
				for(String i: map.keySet()){
					select = "select name from users where user_id="+map.get(i).get("user_id")+";";
					rs = statement.executeQuery(select);
					if(rs.next()){
						map.get(i).put("user_name", "<h3>"+rs.getString("name")+"</h3>");
					}
					
				}
	
				/**
				 * No posts to show
				 */
				if(count==0){
					submap.put("post_content","No posts to show");
					map.put("-1", submap);
				}
				rs.close();
				//rs2.close();
				statement.close();
				connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			submap.put("post_content",e.getMessage());
			map.put("-2", submap);
			e.printStackTrace();
		}
	}else{
		submap.put("post_content", "session invalid");
		map.put("-3", submap);
	}
		
	/**
	 * Return JSON of posts using GSON
	 */
	
	all_posts.putAll(map);

	String json = new Gson().toJson(all_posts);
	response.setContentType("application/json");
	response.setCharacterEncoding("UTF-8");
    response.getWriter().write(json);
}

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */


}
