package com.accolite.servletassignment.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.accolite.servletassignment.model.Post;
import com.accolite.servletassignment.model.PostResponse;
import com.accolite.servletassignment.model.User;

@Repository
public class PostDAO {
	private JdbcTemplate jdbcTemplate;  

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
		this.jdbcTemplate = jdbcTemplate;  
	}  

	public List<PostResponse> getPosts(){
		String query = "SELECT p.post_content,p.time_posted,u.name FROM posts p,users u where p.user_id=u.user_id;";
		return jdbcTemplate.query(query, new ResultSetExtractor<List<PostResponse>>(){
			
			public List<PostResponse> extractData(ResultSet rs) throws SQLException, DataAccessException{
				List<PostResponse> posts=new ArrayList<PostResponse>();
				while(rs.next()){
					PostResponse postResponse = new PostResponse();
					Post post = new Post();
					post.setPost_content(rs.getString("post_content"));
					post.setTime_posted(rs.getString("time_posted"));
					postResponse.setPost(post);
					postResponse.setUsername(rs.getString("name"));
					posts.add(postResponse);
				}
				return posts;
			}
		});
	}
	
	public Integer putNewPost(PostResponse postResponse){
		
		String query = "SELECT u.user_id FROM users u where u.name='"+postResponse.getUsername()+"';";
		User u = jdbcTemplate.query(query, new ResultSetExtractor<User>(){
			
			public User extractData(ResultSet rs) throws SQLException, DataAccessException{
				User user = new User();
				while(rs.next()){
					user.setUser_id(rs.getInt("user_id"));
				}
				return user;
			}
		});
			query = "insert into posts(post_content,user_id) values "
					+ "('"+postResponse.getPost().getPost_content()+"',"+u.getUser_id()+")";		
			return jdbcTemplate.update(query);
		}
}
