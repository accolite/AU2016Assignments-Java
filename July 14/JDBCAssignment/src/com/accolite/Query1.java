/*
 * /****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 14, 2016

*

*  @author :: Loghithavani

* ***************************************************************************

 */
package com.accolite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.accolite.*;
import com.accolite.util.Constants;

public class Query1{
	
	/**
	 * The main method.
	 *
	 * @param a the arguments
	 * @throws SQLException 
	 */
	public static void main(String a[]) throws SQLException{
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		String sql = null;
		String name = null;
		int id;
		
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL, "sa", "accolite");
			
			String sql1 = "select DB1.dbo.States.StateName from DB1.dbo.States;";
			stmt = conn.prepareStatement(sql1);
			rs = stmt.executeQuery();
			while (rs.next()) {
				name = rs.getString("StateName");
				System.out.println("Name:"+name);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			rs.close();
			stmt.close();
			conn.close();
			
		}
		
	}
}
