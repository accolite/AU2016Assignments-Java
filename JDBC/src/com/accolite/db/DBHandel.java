package com.accolite.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.accolite.util.Constants;

public class DBHandel {
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	DBHandel(){
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 		
	}
	public void closeResources(){
		try{
			if(stmt!=null)
				stmt.close();
			if(pstmt!=null)
				pstmt.close();
			if(conn!=null)
				conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void establishConnection(){
		try {
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//	public static void main(String[]args){
//		DBHandel dbh=new DBHandel();
//		dbh.establishConnection();
//		dbh.closeResources();
//	}
	public void reEstablish() {
		closeResources();
		establishConnection();
	}
}