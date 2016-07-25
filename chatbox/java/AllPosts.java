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
 * Servlet implementation class AllPosts
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
		
		if(getServletContext().getAttribute("all_posts")==null){
        	getServletContext().setAttribute("all_posts", new LinkedHashMap<String, Map<String,String>>());
        }
		
		Map<String, Map<String,String>> all_posts = (LinkedHashMap<String, Map<String, String>>) getServletContext().getAttribute("all_posts");
		
		HttpSession session = request.getSession(false);
		Map<String, Map<String, String>> map = new LinkedHashMap<>();
		Map<String, String> submap = new HashMap<>();
		if(session!=null){
			try{
			/**
			 * DB Connection
			 */
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USERNAME, Constants.PASSWORD);
			Statement statement = connection.createStatement();

			/**
			 * Get posts
			 */
			String select = "select * from posts";

			System.out.println(select);

			ResultSet rs = statement.executeQuery(select);
			System.out.println("I came here");
			/**
			 * If any posts available
			 */
			//ResultSet rs2 = null;
			int count = 0;
			while(rs.next()){
				count+=1;
				submap = new HashMap<>();
				submap.put("post_content",rs.getString("post_content"));
				Integer user = rs.getInt("user_id");
				submap.put("user_id", user.toString());

				System.out.println(select);

				Integer a = rs.getInt("post_id");
				map.put(a.toString(),submap);
				System.out.println("Closed here");
			}
			
			for(String i: map.keySet()){
				select = "select name from users where user_id="+map.get(i).get("user_id")+";";
				rs = statement.executeQuery(select);
				if(rs.next()){
					map.get(i).put("user_name", rs.getString("name"));
				}
			}
			
			if()

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
		
	String json = new Gson().toJson(map);
	/**
	 * Return JSON of posts using GSON
	 */
	
	
	response.setContentType("application/json");
	response.setCharacterEncoding("UTF-8");
    response.getWriter().write(json);
}

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */


}
