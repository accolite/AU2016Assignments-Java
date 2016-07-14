package com.accolite.jdbcAssignment.jdbcJuhi;

import com.accolite.jdbcAssignment.utils.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class create_table {
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(Constants.JTDS_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.username,Constants.Password);
			stmt = conn.createStatement();
	

			//System.out.println("Creating table if not exists");
			//String createTable = "USe database1 "
				//	+ "CREATE TABLE citizen(C_Id int not null primary key,D_Id int not null,Name varchar (255),Age int,Type varchar(255) ) "
					//;

			//stmt.executeUpdate(createTable);
			
			//String createTable1 = "USe database2 "
				//	+ "CREATE TABLE district(D_Id int not null primary key,Head_Id int not null,Name varchar (255),State_id int ) "
					//;

			//stmt.executeUpdate(createTable1);
			
			
			//String createTable2 = "USe database2 "
				//	+ "CREATE TABLE state(state_Id int not null primary key,Name varchar (255),president_id int ) "
					//;

			//stmt.executeUpdate(createTable2);
			
			String createTable3 = "USe database2 "
					+ "CREATE TABLE president(president_Id int not null primary key,Name varchar (255) ) "
					;

			stmt.executeUpdate(createTable3);


		} catch (SQLException se) {
			System.out.println(se.getErrorCode());
			if (se.getErrorCode() == 1801) {
				// Database already exists error
				System.out.println(se.getMessage());
			} else {
				// Some other problems, e.g. Server down, no permission, etc
				se.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


