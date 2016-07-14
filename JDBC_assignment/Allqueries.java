package Assignment;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.au.workshop.util.Constants;

public class Allqueries {

	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			
			switch(choice){
				
				case 1:
					
					Connection conn = null;
					CRUDState state = new CRUDState(); 		
					state.retirveAllState(conn);
					break;
					
				case 2:
					
					conn = null;
					CRUDDistrict district = new CRUDDistrict(); 		
					district.retirveAllDistrict(conn);
					
					break;
					
				case 3:
			
//					PreparedStatement pstmt = null;
//					Connection conn1 = null;
//					ResultSet rs = null;
//					
//					conn1 = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.username,Constants.password);
//					pstmt = conn1.prepareStatement("SELECT count(citizenid) from DATABASE1.dbo.state as a join DATABASE1.dbo.district as b"
//							+ " on (d.stateid=a.stateid) join DATABASE2.dbo.citizen as c on (b.districtid=c.districtid) "
//							+ " group by a.stateid");
//					
//					rs = pstmt.executeQuery();
//					while (rs.next()) {
//						System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + rs.getInt(4));
//					}
//					
//					pstmt.close();
//					conn1.close();
					
					break;
					
				case 4:
					
					conn = null;
					CRUDDistrict district1 = new CRUDDistrict();
					
					int inte = sc.nextInt();
					district1.deleteDistrict(inte,conn);
					
					break;
					
				case 5:
					
					conn = null;
					CRUDDistrict state1 = new CRUDDistrict();
					
					int inte1 = sc.nextInt();
					state1.deleteDistrict(inte1,conn);
					
					break;
					
				case 6:
					
//					PreparedStatement pstmt = null;
//					Connection conn1 = null;
//					ResultSet rs = null;
//					
//					conn1 = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.username,Constants.password);
//					pstmt = conn1.prepareStatement("SELECT c.name from DATABASE1.dbo.state as a,DATABASE1.dbo.district as b,"
//							+ "DATABASE2.dbo.citizen as c where a.stateid=b.stateid and b.districtid=c.districtid "
//							+ " and a.stateid=1");
//					
//					rs = pstmt.executeQuery();
//					while (rs.next()) {
//						System.out.println(rs.getString(1) );
//					}
//					
//					pstmt.close();
//					conn1.close();
//					
//					break;
//					
				case 7:
					
//					PreparedStatement pstmt = null;
//					Connection conn1 = null;
//					ResultSet rs = null;
//					
//					conn1 = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.username,Constants.password);
//					pstmt = conn1.prepareStatement("SELECT c.name,b.name from DATABASE1.dbo.district as b,"
//							+ "DATABASE2.dbo.citizen as c where b.districtid=c.districtid");
//					
//					rs = pstmt.executeQuery();
//					while (rs.next()) {
//						System.out.println(rs.getString(1) +" "+ rs.getString(2) );
//					}
//					
//					pstmt.close();
//					conn1.close();
//					
					break;
					
				case 8:
					
//					PreparedStatement pstmt = null;
//					Connection conn1 = null;
//					ResultSet rs = null;
//					
//					conn1 = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.username,Constants.password);
//					pstmt = conn1.prepareStatement("SELECT c.name,b.name from DATABASE1.dbo.district as b,"
//							+ "DATABASE2.dbo.citizen as c where b.headuserid=c.userid");
//					
//					rs = pstmt.executeQuery();
//					while (rs.next()) {
//						System.out.println(rs.getString(1) +" "+ rs.getString(2) );
//					}
//					
//					pstmt.close();
//					conn1.close();
//					
					
					break;
					
				case 9:
//					PreparedStatement pstmt = null;
//					Connection conn1 = null;
//					ResultSet rs = null;					
//					conn = DriverManager.getConnection(Constants.DB_URL1);
//					pstmt = conn.prepareStatement("UPDATE dbo.district set headuserid=? WHERE districtid = ?");
//					pstmt.setInt(1, headuserid);
//					pstmt.setInt(2, districtid);
//					
//
//					pstmt.executeUpdate();
//					pstmt.close();
//					conn1.close();					
//					break;
					
				case 10:
					conn = null;
					DatabaseMetaData dbmd = null;
					
						Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
						conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" + "DataBaseName=DATABASE1");
						dbmd = conn.getMetaData();
						
						System.out.println("Driver Name: "+dbmd.getDriverName());  
						System.out.println("Driver Version: "+dbmd.getDriverVersion());  
						System.out.println("UserName: "+dbmd.getUserName());  
						System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
						System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());
					break;
					
			}
		}
	}
}
