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

public class Query4{
	
	/**
	 * The main method.
	 *
	 * @param a the arguments
	 * @throws SQLException 
	 */
	public static void main(String a[]) throws SQLException{
		Statement stmt = null;
		Connection conn = null;
		String sql = null;
		String name = null;
		int id;
		
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL, "sa", "accolite");
			
			stmt = conn.createStatement();
			
			String sql1 = "delete from db1.dbo.Districts where db1.dbo.Districts.DistrictName = 'Chennai'";
			stmt.addBatch(sql1);
			String sql2 = "alter table db2.dbo.Citizen set db2.dbo.Citizen.DistrictID = 0 where db2.dbo.Citizen.DistrictID=db2.dbo.Citizen.DistrictID";
			stmt.addBatch(sql2);
			stmt.executeBatch();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		finally{
			stmt.close();
			conn.close();
			
		}
		
	}
}
