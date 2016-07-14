package org.au.workshop.domain;

import java.sql.*;


public class AnswerS {
	
	
	public int CountCitizensFromAllStates(Statement stmt){
	   String CountingCitizens = "select count(*) from Database1.dbo.State as s,"
				+ "Database1.dbo.District as d , Database2.dbo.Citizen as c where s.id = d.state_id "
				+ "and c.district_id =d.id";
	   int count = 0;
	   try {
		ResultSet rs = stmt.executeQuery(CountingCitizens);		
		if(rs.next())
			count = rs.getInt(1);
	   } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
	 return count;
	}
	
	public void listCitizensFromState(Statement stmt,String name){
		   String CountingCitizens = "select c.name from Database1.dbo.State as s,"
					+ "Database1.dbo.District as d , Database2.dbo.Citizen as c where s.id = d.state_id "
					+ "and d.id = c.district_id and s.name = "+"'"+name+"'";
		   try {
			ResultSet rs = stmt.executeQuery(CountingCitizens);
			while(rs.next())
				System.out.println(rs.getString(1));
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
		}
	
	public void listCitizensFromDistrict(Statement stmt,String name){
		   String CountingCitizens = "select c.name from "
					+ "Database1.dbo.District as d , Database2.dbo.Citizen as c "
					+ "where d.id = c.district_id and d.name = "+"'"+name+"'";
		   try {
			ResultSet rs = stmt.executeQuery(CountingCitizens);
			while(rs.next())
				System.out.println(rs.getString(1));
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
		}
	
	public void headOfDistrict(String name,Statement stmt){
		String headDistrict = "select  c.name from Database1.dbo.District as d , Database2.dbo.Citizen as c"
				+ " where d.head_ssn = c.ssn and d.name = "+"'"+name+"'";
		try {
			ResultSet rs = stmt.executeQuery(headDistrict);
			if(rs.next())
				System.out.println(rs.getString(1));
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
	}
	
	public void changeHeadOfDistrict(Statement stmt , String DistrictName , int ssn){
		String checkDistrictOfCitizen = "select c.district_id from  Database2.dbo.Citizen as c"
				+ " where c.ssn = "+ssn+" and c.age < "+60;
		int districtIDOfCitizen = -1;
		try {
			ResultSet rs = stmt.executeQuery(checkDistrictOfCitizen);
			if(rs.next())
				districtIDOfCitizen = rs.getInt(1);
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
		if(districtIDOfCitizen != -1){
			String updateHeadOfDistrict = "update Database1.dbo.District set Database1.dbo.District.head_ssn = "
					+ ssn + " where Database1.dbo.District.id = "+districtIDOfCitizen;
			try {
				stmt.execute(updateHeadOfDistrict);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void listDistricts(Statement stmt){
		String listDistrict = "select  d.name from Database1.dbo.District as d";
		 try {
			ResultSet rs = stmt.executeQuery(listDistrict);
			while(rs.next()){
				System.out.println(rs.getString(1)+"\n");
			}
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void listStates(Statement stmt){
		String listState = "select  s.name from Database1.dbo.State as s";
		 try {
			ResultSet rs = stmt.executeQuery(listState);
			while(rs.next()){
				System.out.println(rs.getString(1)+"\n");
			}
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void RemoveDistrict(Statement stmt,String district_name){
		 String RemovingDistrict = "delete from Database1.dbo.District "
				+ "where Database1.dbo.District.name = "+"'"+district_name+"'";
		 System.out.println(RemovingDistrict);
		 try { 
			stmt.execute(RemovingDistrict);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void RemoveState(Statement stmt,String state_name){
		 String RemovingState = "delete from Database1.dbo.State  "
				+ "where Database1.dbo.State.name = "+"'"+state_name+"'";
		 try { 
			stmt.execute(RemovingState);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ageUpdate(Statement stmt,int age,int ssn){
		String updateAge = "update Database2.dbo.Citizen as c set c.age = "+age+" where c.ssn = "+ssn ; 
		try {
			stmt.execute(updateAge);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(age > 60){
				retireHead(stmt,ssn);
			}
		}
	public void retireHead(Statement stmt , int ssn){
		String updateDistrictHead = "update Database1.dbo.District as d set d.head_ssn = null where d.head_ssn = "+ssn;
		try {
			stmt.execute(updateDistrictHead);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	    }
	  }
	
	 public boolean ifVip(Statement stmt , int ssn){
		 String isVip = "select is_vip from Database2.dbo.citizen as c where c.ssn ="+ssn;
		 try {
			ResultSet rs = stmt.executeQuery(isVip);
			if(rs.getInt(1) == 0)return false;
			return true;
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	 }
	 
	 public void showDatabaseDetails(Connection conn){
		 try {
			DatabaseMetaData databaseMetaData = conn.getMetaData();
			int    majorVersion   = databaseMetaData.getDatabaseMajorVersion();
			int    minorVersion   = databaseMetaData.getDatabaseMinorVersion();
			int driverMajorVersion = databaseMetaData.getDriverMajorVersion();
			int driverMinorVersion = databaseMetaData.getDriverMinorVersion();
			String productVersion = databaseMetaData.getDatabaseProductVersion();
			
			System.out.println("majorVersion" + majorVersion + "minorVersion "+minorVersion + "productName "+"productVersion "+productVersion
					+"driverMajorVersion "+driverMajorVersion+ "driverMinorVersion "+driverMinorVersion);
			System.out.println("Tables");
			showTables(databaseMetaData);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 public void showTables(DatabaseMetaData databaseMetaData){
		 String   catalog          = null;
		 String   schemaPattern    = null;
		 String   tableNamePattern = null;
		 String[] types            = null;

		 ResultSet result;
		try {
			result = databaseMetaData.getTables(
			     catalog, schemaPattern, tableNamePattern, types );
			 while(result.next()) {
			     String tableName = result.getString(3);
			     System.out.println(tableName);
			     System.out.println("Columns under of Table "+tableName);
			     showColumns(databaseMetaData,tableName);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	 }

	public void showColumns(DatabaseMetaData databaseMetaData, String tableName) {
		// TODO Auto-generated method stub
		String   catalog           = null;
		String   schemaPattern     = null;
		String   tableNamePattern  = tableName;
		String   columnNamePattern = null;


		ResultSet result;
		try {
			result = databaseMetaData.getColumns(
			    catalog, schemaPattern,  tableNamePattern, columnNamePattern);
			while(result.next()){
			    String columnName = result.getString(4);
			    int    columnType = result.getInt(5);
			
			System.out.println("columnName "+columnName+"columnType "+columnType );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	
	public void factoryReset(){
		DropDatabases drop = new DropDatabases();
		drop.DropDatabase();
		Databases create = new Databases();
		create.createDatabases();
	}
	 
}
