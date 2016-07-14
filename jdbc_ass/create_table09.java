package pckg;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class create_table09 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.uname,Constants.pwd);
			stmt = conn.createStatement();
			String createDbIfNotExists = "IF  NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'jdbc_db1') CREATE DATABASE jdbc_db1 ";
			stmt.executeUpdate(createDbIfNotExists);
			//president
			System.out.println("Dropping table if exits");
			String dropTable = "USE jdbc_db1 IF OBJECT_ID('dbo.President', 'U') IS NOT NULL DROP TABLE dbo.President; " ;
			stmt.executeUpdate(dropTable);

			System.out.println("Creating table if not exists");
			String createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.President' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE President(id int not null,first varchar (255),last varchar (255)) "
					+ "END";

			stmt.executeUpdate(createTable);
			//states
			System.out.println("Dropping table if exits");
			dropTable = "IF OBJECT_ID('dbo.State', 'U') IS NOT NULL DROP TABLE dbo.State; " ;
			stmt.executeUpdate(dropTable);

			System.out.println("Creating table if not exists");
			createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.State' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE State(id int not null,name varchar (255),dis_id int not null,p_id int not null) "
					+ "END";

			stmt.executeUpdate(createTable);
			//districts
			System.out.println("Dropping table if exits");
			dropTable = "IF OBJECT_ID('dbo.District', 'U') IS NOT NULL DROP TABLE dbo.District; " ;
			stmt.executeUpdate(dropTable);

			System.out.println("Creating table if not exists");
			createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.District' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE District(id int not null,name varchar (255),head_id int not null,state_id int not null) "
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
