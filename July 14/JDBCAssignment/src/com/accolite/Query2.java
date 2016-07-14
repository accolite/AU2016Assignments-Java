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

// TODO: Auto-generated Javadoc
/**
 * The Class Query2.
 */
public class Query2{
	
	/**
	 * The main method.
	 *
	 * @param a the arguments
	 * @throws SQLException 
	 */
	public static void main(String a[]) throws SQLException{
		PreparedStatement stmt = null;
		Connection conn = null;
		String sql = null;
		String name = null;
		int id;
		ResultSet rs = null;
		
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL, "sa", "accolite");
			
			String sql1 = "select DB1.dbo.Districts.DistrictName from DB1.dbo.Districts;";
			stmt = conn.prepareStatement(sql1);
			rs = stmt.executeQuery();
			while (rs.next()) {
				name = rs.getString("DistrictName");
				System.out.println("Name:"+name);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		finally{
			rs.close();
			stmt.close();
			conn.close();
			
		}
		
	}
}
