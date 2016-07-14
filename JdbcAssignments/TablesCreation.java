package org.au.workshop.domain;

import java.sql.*;

import org.au.workshop.util.Constants;

public class TablesCreation {
	public static final String CreatePresidentTable = "Use Database1 "+"Create Table President("
			+ "ssn int primary key, name nvarchar(50) not null, age int not null)";
	public static final String CreateState  = "Use Database1 "+"Create Table State("
			+ "id int primary key, name nvarchar(50) not null)";
	public static final String CreateDistrict  = "Use Database1 "+"Create Table District("
			+ "id int primary key, "
			+ "state_id int foreign key references State(id) on delete Cascade on update Cascade, "
			+ "head_ssn int, "
			+ "name nvarchar(50) not null)";
	
	public static final String CreateCitizen = "Use Database2 "+"Create Table Citizen("
			+ "ssn int primary key, "
			+ "district_id int, "
			+ "name nvarchar(50) not null, "
			+"age int, "
			+ "is_vip int )";
	public void createTables(){
		 Connection conn = null;
		 Statement stmt = null;
		 try{
		  Class.forName(Constants.JTDS_DRIVER);
		  conn = DriverManager.getConnection(Constants.DB_URL,Constants.userName,Constants.password);
		  stmt = conn.createStatement();
		  stmt.execute(CreatePresidentTable);
		  stmt.execute(CreateState);
		  stmt.execute(CreateDistrict);
		  stmt.execute(CreateCitizen);
		  stmt.executeBatch();
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally{
				try {
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
}
