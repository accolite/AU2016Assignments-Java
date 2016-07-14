package com.accolite.JDBCassignment;
import java.sql.*;

import com.accolite.util.Constants;


public class Home {
	
	public void letsStart() {
		CreateDatabase cd = new CreateDatabase();
		
	}
	
	public static void main(String args[]) {
		
		Home m = new Home();
		//m.letsStart();
        CreateTables ct = new CreateTables();
        
		
	}
}
