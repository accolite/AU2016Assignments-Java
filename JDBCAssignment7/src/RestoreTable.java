import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.Statement;

public class RestoreTable{

	void restore()
	{
		Connection conn = null;
		Statement stmt = null;
		DatabaseMetaData dbmd = null;
		String tmp;
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.user_name,Constants.password);
			stmt = conn.createStatement();
			String createDbIfNotExists = "IF  NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'SANTOSH') CREATE DATABASE JDBCAssignment";
			stmt.executeUpdate(createDbIfNotExists);

			System.out.println("Dropping table if exits");
		String dropTable ="USE  SANTOSH "+ "IF OBJECT_ID('dbo.employees', 'U') IS NOT NULL DROP TABLE dbo.employees; " ;
			stmt.executeUpdate(dropTable);
		System.out.println("Creating table if not exists");
			String createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.employees' AND type = 'U') "
					+ "BEGIN "
					+ "Use JDBCASsignment CREATE TABLE CITIZEN" +
	                   "(CITIZENID INT PRIMARY KEY, " +
	                   " NAME VARCHAR(40)  NOT NULL, " + 
	                   " sTATEID  INT NOT NULL, " + 
	                   " DISTRICTiD  INT NOT NULL,AGE INT NOT NULL,"+
	                   "Flag Int null)"
				+"CREATE TABLE District" +
	                   "(DistrictId INT PRIMARY KEY, " +
	                   " NAME VARCHAR(40)  NOT NULL, " + 
	                   " sTATEID  INT NOT NULL)"
	 
	+"CREATE TABLE State" +
	                   "(STATEID INT PRIMARY KEY, " +
	                   " NAME VARCHAR(40)  NOT NULL)"
	+"CREATE TABLE President"+
	                   "(CitizenId INT PRIMARY KEY, " +
	                   " NAME VARCHAR(40)  NOT NULL) "+
	                   "Insert into dbo.CITIZEN(CitizenId,NAME,sTATEID,DISTRICTiD,Age,Flag,inactive) "
	                   +"VAlues(7,'Ram',1,102,30,0,0) "
	                   +" INSERT INTO dbo.District(DistrictID,NAme,STATEID,StatusD) "+
	                   "values(1100,'ABC',100,1) "+"INSERT INTO dbo.State(StateId,NAme,StatusS) "
	                   	+" values('Maharahstra',100,1) "
	                   	+" INSERT INTO dbo.President(CitizenID,Name) "
	                   	+" VAlues(1,'sachin')";
			
			stmt.executeUpdate(createTable);
		}
		catch (Exception e)
		{
			
		}
	}
}
		

