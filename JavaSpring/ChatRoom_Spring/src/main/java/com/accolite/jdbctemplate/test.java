package com.accolite.jdbctemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"+"integratedSecurity=true");
		Statement s=conn.createStatement();
		s.execute("use ChatBox");
		s.executeUpdate("insert into users values('log','log','loggedout')");
	}

}
