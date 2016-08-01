package com.au.proma.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.au.proma.model.Role;

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
//		return jdbcTemplate.query(query, new ResultSetExtractor<Integer>() {
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
	
	public ArrayList<Role> getAllRoles()
	{
		String query="select * from dbo.role";
			
					return jdbcTemplate.query(query, new ResultSetExtractor< ArrayList<Role> >() {
			
						public ArrayList<Role> extractData(ResultSet rs) throws SQLException, DataAccessException {
							
							
							ArrayList<Role> temp=new ArrayList<Role>(); 
							while (rs.next()){
							Role role =new Role();
								
							role.setRoleid(rs.getInt("roleid"));
							
							role.setRolename(rs.getString("rolename"));
							temp.add(role);
							
														
							}
							return temp;
						}
					});
	}
}
				
	

