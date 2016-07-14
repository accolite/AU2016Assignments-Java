package org.au.workshop.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.au.workshop.util.Constants;

public class Databases {
	
	public void createDatabases(){
		Connection conn = null;
		PreparedStatement stmt1=null;
		try{
		  Class.forName(Constants.JTDS_DRIVER);
		  conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.userName,Constants.password);
		  System.out.println(conn.toString());
		  stmt1 = conn.prepareStatement("Create Database DATABASE1");
		  System.out.println(""+stmt1.execute());
		}catch(Exception e){
			e.printStackTrace();;
		}finally{
			try {
				if(stmt1 != null)
				  stmt1.close();
				if(conn != null)
				 conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
