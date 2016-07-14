package com.accolite.jdbcassignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class ChangeHead {

	public ChangeHead() {
		// TODO Auto-generated constructor stub
	}

public void ChangingHead(){
Connection conn = null;
Statement stmt = null;
try {
 //register driver
	conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB,Constants.username,Constants.password);
 stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
 //stmt = conn.createStatement();

 String sql, sql2;
 Scanner sc = new Scanner(System.in);
 System.out.println("enter the district ID: ");
 int val = sc.nextInt();
 

 System.out.println("enter the citizen id of new head: ");
 int val2 = sc.nextInt();
 int age = 0;
 sql2 = " Select age from database2.dbo.Citizen where database2.dbo.Citizen.citizenID="+ val2;
 ResultSet rs = stmt.executeQuery(sql2);
 while (rs.next()) {
   age = rs.getInt("age");
 }
 
 if (age <= 60) {
  
  sql = " update database1.dbo.District set headID = "+val2+" where districtID="+ val;
  stmt.execute(sql);
  
  String sql3;
  sql3 = "update database2.dbo.citizen set type = 'VIP' where citizenID="+ val2;
  stmt.execute(sql3);
  System.out.println("updated successfully");
  // STEP 6: Clean-up environment
  rs.close();
  stmt.close();
  conn.close();
 }       
 else {
  System.out.println("sorry! His age is greater than 60 ");
 }
  
 
}
 catch (Exception e) {
  e.printStackTrace();
 }
}
}