package com.au.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.au.model.User;

public class UserDao {

	public List<User> getAllUsers (){
		
		Context initialContext = null;
		try {
			initialContext = new InitialContext();
			Context envContext = (Context) initialContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbcBlue");
			Connection con = ds.getConnection();
			Statement stmt = con.createStatement();
			
			String sql = "use jndi select * from dbo.employees";
			ResultSet rs = stmt.executeQuery(sql);
			List<User> l = new ArrayList<User>();
			while(rs.next()){
				l.add(new User(rs.getString("name"),rs.getString("email"),rs.getInt("ismanager")));
			}
			return l;
			
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void addUser (User user){
		
		Context initialContext = null;
		try {
			initialContext = new InitialContext();
			Context envContext = (Context) initialContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbcBlue");
			Connection con = ds.getConnection();
			Statement stmt = con.createStatement();
			
			String sql = "use jndi insert into dbo.employees values('" +user.getName()+ "','" + user.getEmail() + "'," + user.getIsmanager() + ")";
			stmt.execute(sql);	
		
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getEmail(User user){
		Context initialContext = null;
		String ans = null;
		try {
			initialContext = new InitialContext();
			Context envContext = (Context) initialContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbcBlue");
			Connection con = ds.getConnection();
			Statement stmt = con.createStatement();
			
			String sql = "use jndi select email from dbo.employees where name='" +user.getName() +  "'";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				ans = rs.getString("email");
			}
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}
}
