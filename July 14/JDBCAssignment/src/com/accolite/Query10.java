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
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.accolite.*;
import com.accolite.util.Constants;

// TODO: Auto-generated Javadoc
/**
 * The Class Query10.
 */
public class Query10{
	
	/**
	 * The main method.
	 *
	 * @param a the arguments
	 * @throws SQLException 
	 */
	public static void main(String a[]) throws SQLException{
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = null;
		DatabaseMetaData dbmd = null;
		ResultSetMetaData rsmd = null;
		ResultSet rs = null;
		
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL, "sa", "accolite");
			
            dbmd = conn.getMetaData();
			
            System.out.println("          DATABASE METADATA");
			System.out.println("Driver Name: "+dbmd.getDriverName());  
			System.out.println("Driver Version: "+dbmd.getDriverVersion());  
			System.out.println("UserName: "+dbmd.getUserName());  
			System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
			System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  
			
			System.out.println("");
			System.out.println("");
			System.out.println("          RESULTSET METADATA");
			pstmt = conn.prepareStatement("select DB1.dbo.States.StateName from DB1.dbo.States;");
			rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.println("Name:"+rs.getString(1));
			}
			rsmd=rs.getMetaData();
			
			System.out.println("Total columns: "+rsmd.getColumnCount());  
			System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));  
			System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1));  
			

			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		finally{
			rs.close();
			conn.close();
			
		}
		
	}
}
