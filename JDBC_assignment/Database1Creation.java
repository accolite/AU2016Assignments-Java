package Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database1Creation {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME, Constants.username,
					Constants.password);
			stmt = conn.createStatement();
			String createDbIfNotExists = "IF  NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'DATABASE1') CREATE DATABASE DATABASE1";
			stmt.executeUpdate(createDbIfNotExists);

			// president table
			System.out.println("Dropping table if exists");
			String dropTable = "USE  DATABASE1 "
					+ "IF OBJECT_ID('dbo.president', 'U') IS NOT NULL DROP TABLE dbo.president; ";
			stmt.executeUpdate(dropTable);

			System.out.println("Creating table if not exists");
			String createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.president' AND type = 'U') "
					+ "BEGIN " + "CREATE TABLE president(userid int not null,name varchar (255),age int not null) "
					+ "END";

			stmt.executeUpdate(createTable);

			// state table
			System.out.println("Dropping table if exists");
			String dropTable1 = "USE  DATABASE1 " + "IF OBJECT_ID('dbo.state', 'U') IS NOT NULL DROP TABLE dbo.state; ";
			stmt.executeUpdate(dropTable1);

			System.out.println("Creating table if not exists");
			String createTable1 = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.state' AND type = 'U') "
					+ "BEGIN " + "CREATE TABLE state(stateid int not null,name varchar (255),headuserid int not null) "
					+ "END";

			stmt.executeUpdate(createTable1);

			// District table
			System.out.println("Dropping table if exists");
			String dropTable2 = "USE  DATABASE1 "
					+ "IF OBJECT_ID('dbo.district', 'U') IS NOT NULL DROP TABLE dbo.district; ";
			stmt.executeUpdate(dropTable2);

			System.out.println("Creating table if not exists");
			String createTable3 = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.district' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE district(districtid int not null,name varchar (255),headuserid int not null,stateid int not null) "
					+ "END";

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
