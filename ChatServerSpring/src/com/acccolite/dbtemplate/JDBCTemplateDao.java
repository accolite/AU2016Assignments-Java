package com.acccolite.dbtemplate;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;



@Repository
public class JDBCTemplateDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int addRegisterUser(String name,String password)
	{
		String query="insert into dbo.registeredusers(name,password) values "
				+ "("+name+",'"+password+"')";
		return jdbcTemplate.update(query);
	}
	public int addMessage(String name,String message)
	{
		String query="insert into dbo.messages(name,message) values "
				+ "("+name+",'"+message+"')";
		return jdbcTemplate.update(query);
	}
	public String getUserPassword(String name){
		String query = "SELECT password FROM dbo.registeredusers where"
				+ " name = "+name;
		return jdbcTemplate.query(query, new ResultSetExtractor<String>() {

			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				String pass=new String();
				while (rs.next()){
				pass=rs.getString("password");
				}
				return pass;
			}
		});
		
	}
	public ArrayList<String> getMessages(){
		String query = "SELECT * FROM  dbo.messages";
		return jdbcTemplate.query(query, new ResultSetExtractor< ArrayList<String> >() {

			public ArrayList<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
				ArrayList<String> temp=new ArrayList<String>();
				while (rs.next()){
				temp.add(rs.getString("name")+" : "+ rs.getString("message"));
				}
				return temp;
			}
		});
		
	}
	public int addActiveUser(String name)
	{
		String query="insert into dbo.activeusers(name) values " + "('" + name+ "')" ;
		return jdbcTemplate.update(query);
	}
	public int removeActiveUser(String name)
	{
		String query="delete from dbo.activeusers where " + "name=" + name ;
		return jdbcTemplate.update(query);
	}
	public int addRestrictedWord(String word)
	{
		String query="insert into dbo.restrictedwords(name) values " + "('" + word+ "')" ;
		return jdbcTemplate.update(query);
	}
	public ArrayList<String> getRestrictedWords(){
		String query = "SELECT * FROM  dbo.restrictedwords";
		return jdbcTemplate.query(query, new ResultSetExtractor< ArrayList<String> >() {

			public ArrayList<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
				ArrayList<String> temp=new ArrayList<String>();
				while (rs.next()){
				temp.add(rs.getString("word"));
				}
				return temp;
			}
		});
		
	}
	

}
