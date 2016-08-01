package com.au.proma.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

//	Integer getRoleId(String rolename)
//	{
//		String query ="select roleid from dbo.role where rolename='"+rolename+"'";
//		return jdbcTemplate.query(query, new ResultSetExtractor< Integer>() {
//
//			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
//				
//				
//				Integer temp=0;
//				while (rs.next()){
//				temp=rs.getInt("roleid");
//				
//				}
//				return temp;
//			}
//		});
//	}
	
	
}
