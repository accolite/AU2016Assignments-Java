package AU_JDBC.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.au.workshop.util.Constants;

public class Database {
	void createInitial(){
		 int pid = 555;
		  int[] stid = {123,124};
		  String[] staname = {"Texas","NY"};
		  int[] did = {12,15,18,23,25,29};
		  String[] disname = {"Dallas","Pens","Oval","Mars","Washington","DC"};
		  int[] disheadid = {31,33,35,37,38,39};
		  int[] dissid = {123,123,123,124,124,124};
		  
		  int[] ciid = {31,32,33,34,35,36,37,38,39,40};
		  String[] ciname = {"one","two","three","four","five","six","seven","eight","nine","ten"};
		  int[] cage = {32,36,43,10,23,25,35,67,36,11};
		  int[] citdis = {12,12,15,15,18,18,23,25,29,12};
		  int[] citspo = {32,31,0,0,36,35,0,0,0,0};
		  int[] citchild = {40,40,34,0,0,0,0,0,0,0};
		Connection conn = null;
		Statement stmt = null;
		Pstmts key = new Pstmts();
		try {
			Class.forName(Constants.JTDS_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);
			stmt = conn.createStatement();
			String createDb1IfNotExists = "IF  NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'DB1') CREATE DATABASE DB1";
			String createDb2IfNotExists = "IF  NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'DB2') CREATE DATABASE DB2";
			stmt.executeUpdate(createDb1IfNotExists);
			stmt.executeUpdate(createDb2IfNotExists);
			System.out.println("Dropping table if exits");
			String dropTable1 ="USE  DB1 "+ "IF OBJECT_ID('dbo.states', 'U') IS NOT NULL DROP TABLE dbo.states; " ;
			String dropTable2 ="USE  DB1 "+ "IF OBJECT_ID('dbo.district', 'U') IS NOT NULL DROP TABLE dbo.district; " ;
			String dropTable3 ="USE  DB1 "+ "IF OBJECT_ID('dbo.president', 'U') IS NOT NULL DROP TABLE dbo.president; " ;
			stmt.executeUpdate(dropTable1);
			stmt.executeUpdate(dropTable2);
			stmt.executeUpdate(dropTable3);
			String dropTable4 ="USE  DB2 "+ "IF OBJECT_ID('dbo.citizen', 'U') IS NOT NULL DROP TABLE dbo.citizen; " ;
			stmt.executeUpdate(dropTable4);
			
			System.out.println("Creating table if not exists");
			String createTable1 = "IF  NOT EXISTS (SELECT * FROM DB1.sys.tables WHERE name = N'dbo.states' AND type = 'U') "
					+ "BEGIN  use db1 "
					+ "CREATE TABLE states(State_id int not null,name nvarchar (255)) "
					+ "END";
			String createTable2 = "IF  NOT EXISTS (SELECT * FROM DB1.sys.tables WHERE name = N'dbo.district' AND type = 'U') "
					+ "BEGIN  use db1 "
					+ "CREATE TABLE district(District_id int not null,name nvarchar (255),Head_id int, State_id int) "
					+ "END";

			String createTable3 = "IF  NOT EXISTS (SELECT * FROM DB1.sys.tables WHERE name = N'dbo.president' AND type = 'U') "
					+ "BEGIN use db1 "
					+ "CREATE TABLE president(id int not null,name nvarchar (255)) "
					+ "END";

			String createTable4 = "IF  NOT EXISTS (SELECT * FROM DB2.sys.tables WHERE name = N'dbo.citizen' AND type = 'U') "
					+ "BEGIN  use db2 "
					+ "CREATE TABLE citizen(citizen_id int not null,name nvarchar (255),age int,District_id int,spouseID int,childID int) "
					+ "END";

			stmt.executeUpdate(createTable1);
			stmt.executeUpdate(createTable2);
			stmt.executeUpdate(createTable3);
			stmt.executeUpdate(createTable4);

		} catch (SQLException se) {
				// Some other problems, e.g. Server down, no permission, etc
				se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			key.closeResources();
		}
		Pstmts insert = new Pstmts();
		try {
			Class.forName(Constants.JTDS_DRIVER);
			for(int i=0;i<stid.length;i++){
				insert.insertStates(stid[i], staname[i], conn);
			}
			for(int i=0;i<did.length;i++){
				insert.insertDistrict(did[i], disname[i], disheadid[i], dissid[i], conn);
			}
			insert.insertPresident(pid, "Obama", conn);
			
			for(int i=0;i<ciid.length;i++){
				insert.insertCitizen(ciid[i], ciname[i], cage[i], citdis[i], citspo[i], citchild[i], conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			key.closeResources();
		}
		
	}
}
