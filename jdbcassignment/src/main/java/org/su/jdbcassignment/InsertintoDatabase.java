package org.su.jdbcassignment;

import java.sql.*;

public class InsertintoDatabase {
	PreparedStatement pstmt = null;
	Connection conn = null ;
	InsertintoDatabase()
	{
		try{
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		insertCitizen(1,26,"Arnika",10);
		insertCitizen(2,27,"Anshika",12);
		insertCitizen(3,30,"Diksha",10);
		insertCitizen(4,21,"Safiya",11);
		insertCitizen(5,55,"Amit",12);
		insertCitizen(6,65,"Mitul",14);
		insertCitizen(7,45,"Harsh",13);
		insertCitizen(8,60,"Rashmi",13);
		insertDistrict(10,2,"Meerut",1);
		insertDistrict(11,4,"Moradabad",1);
		insertDistrict(12,5,"Bhatinda",2);
		insertDistrict(13,6,"Ludhiana",2);
		insertDistrict(14,7,"Shimla",3);
		insertState(1,"UP");
		insertState(2,"Punjab");
		insertState(3,"Haryana");
		insertPresident(3);
		insertVIP(1,1,"Father",2);
		closeResources();
	}
	
	private void insertCitizen(int CitizenID, int Age, String Name,int DistrictID) {
		try {
			
			pstmt = conn.prepareStatement("use ARNIKA INSERT INTO dbo.Citizen(CitizenID,Age,Name,DistrictID) values(?,?,?,?)");
			pstmt.setInt(1, CitizenID);
			pstmt.setInt(2, Age);
			pstmt.setString(3,Name);
			pstmt.setInt(4, DistrictID);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void insertDistrict(int DistrictID,int DistrictHeadID,String Name,int StateID ) {
		try {
			pstmt = conn.prepareStatement("use ARNIKA INSERT INTO dbo.District(DistrictID,DistrictHeadID,Name,StateID) values(?,?,?,?)");
			pstmt.setInt(1, DistrictID);
			pstmt.setInt(2, DistrictHeadID);
			pstmt.setString(3,Name);
			pstmt.setInt(4, StateID);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void insertState(int StateID,String Name) {
		try {
			
			pstmt = conn.prepareStatement("use ARNIKA INSERT INTO dbo.State(StateID,Name) values(?,?)");
			pstmt.setInt(1, StateID);
			pstmt.setString(2,Name);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void insertPresident(int PresidentID) {
		try {
			pstmt = conn.prepareStatement("use ARNIKA INSERT INTO dbo.President(PresidentID) values(?)");
			pstmt.setInt(1, PresidentID);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void insertVIP(int RelationID, int CitizenID, String Relation,int RelatedID) {
		try {
			
			pstmt = conn.prepareStatement("use ARNIKA INSERT INTO dbo.VIP(RelationID,CitizenID,Relation,RelatedID) values(?,?,?,?)");
			pstmt.setInt(1, RelationID);
			pstmt.setInt(2, CitizenID);
			pstmt.setString(3,Relation);
			pstmt.setInt(4, RelatedID);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}


	private void closeResources() {
		try {
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException se2) {
			se2.printStackTrace();
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

}
