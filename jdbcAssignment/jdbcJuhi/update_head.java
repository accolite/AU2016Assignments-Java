package com.accolite.jdbcAssignment.jdbcJuhi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.accolite.jdbcAssignment.utils.*;
import com.mysql.jdbc.Statement;

public class update_head{

Connection conn = null;
java.sql.Statement stmt = null;

public void update()
{
try {
 //register driver
 Class.forName(Constants.JTDS_DRIVER);
 
 conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME, Constants.username, Constants.Password);
 stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
 //stmt = conn.createStatement();

 String sql, sql2;
 Scanner sc = new Scanner(System.in);
 System.out.println("enter the district ID: ");
 int val = sc.nextInt();
 

 System.out.println("enter the citizen id of new head: ");
 int val2 = sc.nextInt();
 int age = 0;
 sql2 = " Select age from database1.dbo.citizen where database1.dbo.citizen.C_ID="+ val2;
 ResultSet rs = stmt.executeQuery(sql2);
 while (rs.next()) {
   age = rs.getInt("age");
 }
 
 if (age <= 60) {
  
  sql = " update database2.dbo.district set Head_ID = "+val2+" where D_ID="+ val;
  stmt.execute(sql);
  
  String sql3;
  sql3 = "update databa9se1.dbo.citizen set type = 'VIP' where C_ID="+ val2;
  stmt.execute(sql3);
  System.out.println("updated successfully");
  // STEP 6: Clean-up environment
  rs.close();
  stmt.close();
  conn.close();
 }       
 else {
  System.out.println("update not allowed ");
 }
  
 
}
 catch (Exception e) {
  e.printStackTrace();
 }
}
}