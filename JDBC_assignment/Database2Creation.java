package Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database2Creation {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME, Constants.username,
					Constants.password);
			stmt = conn.createStatement();
			String createDbIfNotExists = "IF  NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'DATABASE2') CREATE DATABASE DATABASE2";
			stmt.executeUpdate(createDbIfNotExists);

			// citizen table
			System.out.println("Dropping table if exists");
			String dropTable = "USE  DATABASE2 "
					+ "IF OBJECT_ID('dbo.citizen', 'U') IS NOT NULL DROP TABLE dbo.citizen; ";
			stmt.executeUpdate(dropTable);

			System.out.println("Creating table if not exists");
			String createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.citizen' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE citizen(userid int not null,name varchar (255),age int not null,districtid int not null,designation varchar (255),relativeid int not null ) "
					+ "END";

			stmt.executeUpdate(createTable);

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