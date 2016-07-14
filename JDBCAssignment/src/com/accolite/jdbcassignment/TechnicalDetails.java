package com.accolite.jdbcassignment;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TechnicalDetails 
{
 
 void listTechnicalData()
 {
 DatabaseMetaData dbmd = null;
 try {
   Connection conn = null;
  Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
  conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB,Constants.username,Constants.password);
  
  
  
  dbmd = conn.getMetaData();
  
  System.out.println("Driver Name: "+dbmd.getDriverName());  
  System.out.println("Driver Version: "+dbmd.getDriverVersion());  
  System.out.println("UserName: "+dbmd.getUserName());  
  System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
  System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  

 } 
 catch (Exception e) {

 }
 }
}