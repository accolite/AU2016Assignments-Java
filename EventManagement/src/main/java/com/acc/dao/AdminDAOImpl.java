/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Aug 10, 2016
*
*  @author :: Sharukh Mohamed
* ***************************************************************************
*/
package com.acc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.acc.model.Admin;
import com.acc.model.Person;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminDAOImpl.
 */
@Repository
public class AdminDAOImpl implements AdminDAO{
	
	/** The jdbc. */
	@Autowired
	JdbcTemplate jdbc;

	public JdbcTemplate getJdbc() {
		return jdbc;
	}

	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	/* (non-Javadoc)
	 * @see com.acc.dao.AdminDAO#insertAdmin(com.acc.model.Person)
	 */
	public Integer insertAdmin(Person person){
		String query = "insert into admins(name,email_id) values('"+person.getName()+"','"+person.getEmail()+"')";		
		return jdbc.update(query);
	}

	/* (non-Javadoc)
	 * @see com.acc.dao.AdminDAO#getAdmin(com.acc.model.Person)
	 */
	public Admin getAdmin(Person person){
		String query = "SELECT * FROM admins where email_id='"+person.getEmail()+"';";
		
		/*
		 * Getting name of admin
		 */
		String name = jdbc.query(query, new ResultSetExtractor<String>() {

			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				String string = "";
				while (rs.next()){
					string = rs.getString("name");
				}
				return string;
			}
		});
		
		/*
		 * Update if name is null or not equal to Google name
		 */
		if(name==null || !name.equals(person.getName())){
			String query1 = "UPDATE admins set name='"+person.getName()+"' where email_id='"+person.getEmail()+"';";
			jdbc.update(query1);
		}
		
		/*
		 * return the admin
		 */
		return jdbc.query(query, new ResultSetExtractor<Admin>() {

			public Admin extractData(ResultSet rs) throws SQLException, DataAccessException {
				Admin admin = new Admin();
				while (rs.next()){
					admin.set_id(rs.getInt("_id"));
					admin.setName(rs.getString("name"));
					admin.setEmail(rs.getString("email_id"));
				}
				return admin.getEmail()==null?null:admin;
			}
		});

	}
}
