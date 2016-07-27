package com.accolite.servletassignment.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.accolite.servletassignment.model.Blocked;

@Repository
public class BlockedDAO {
	private JdbcTemplate jdbcTemplate;  

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
		this.jdbcTemplate = jdbcTemplate;  
	}  

	public Integer setBlockedWords(List<Blocked> blocked){
		String query; Integer status=1;
		for(Blocked block: blocked){
			query = "insert into blocked(blocked_word) values "
					+ "('"+block.getBlocked_word()+"')";		
			status *= jdbcTemplate.update(query);
		}
		return status;
	}
	
	public List<Blocked> getBlockedWords(){
			String query = "SELECT blocked_words FROM blocked;";
			return jdbcTemplate.query(query, new ResultSetExtractor<List<Blocked>>(){
				
				public List<Blocked> extractData(ResultSet rs) throws SQLException, DataAccessException{
					List<Blocked> blocked_words=new ArrayList<Blocked>();
					while(rs.next()){
						Blocked blocked = new Blocked();
						blocked_words.add(blocked);
					}
					return blocked_words;
				}
			});
		
	}
}
