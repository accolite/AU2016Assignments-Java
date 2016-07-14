package AU_JDBC.jdbc;
import java.util.Scanner;

import org.au.workshop.util.Constants;
import java.sql.*;


public class Display {
	static Connection conn = null;
	public static void main(String[] args){
		int choice;
		ResultSet rs = null;
		Statement stmt = null;
		String exit = new String("");
		//Statement stmt = null;
		Database init = new Database();
		init.createInitial();
		Pstmts key = new Pstmts();
		try{
			Class.forName(Constants.JTDS_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);
			stmt = conn.createStatement();
		
		while(true){
			Scanner input = new Scanner(System.in);
			System.out.println("-----------------------------------");
			System.out.println("-----------------------------------");
			System.out.println("What do you want to do: \n"
					+ "1: List all the States:\n2: List all the Districts\n"
					+ "3: Display the citizen count for all the states.\n"
					+ "4: Remove a State\n5:Remove a district\n6: List of citizens under State\n"
					+ "7: List of citizens under District\n"
					+ "8: Show head of a District\n9: Change head of a District\n"
					+ "10: List Technical Details\n11: Create or Restore date and tables\n12.exit");
			choice = input.nextInt();
			switch(choice){
			case 1:
				try{
					//Class.forName(Constants.JTDS_DRIVER);
					//conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);
					//stmt = conn.createStatement();
					String query= "select distinct s.name from DB1.dbo.states as s;";
					rs = stmt.executeQuery(query);
					while (rs.next()) {
						System.out.println(rs.getString(1));
					}
		
				}
				catch(Exception e){
					e.printStackTrace();
				}
				break;
			case 2:
				try{
					String query= "select distinct d.name from DB1.dbo.district as d;";
					rs = stmt.executeQuery(query);
					while (rs.next()) {
						System.out.println(rs.getString(1));
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
				break;
			case 3:
				try{
					String query= "select count(*) from DB1.dbo.states as st "
							+ "inner join DB1.dbo.district as dt on st.State_id=dt.State_id "
							+ "inner join DB2.dbo.citizen as ci on ci.District_id=dt.District_id "
							+ "group by st.State_id";
					rs = stmt.executeQuery(query);
					while (rs.next()) {
						System.out.println(rs.getString(1));
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.println("Enter the name of state Texas/NY");
				String statename = input.next();
				key.removeState(statename,conn);
				break;
			case 5:
				System.out.println("Enter the name of district:\nDallas,Pens,Oval,Mars,Washington,DC");
				String districtname = input.next();
				key.removeDistrict(districtname,conn);
				break;
			case 6:
					System.out.println("Enter the name of state Texas/NY");
					String name = input.next();
					key.stateList(name,conn);
				break;
			case 7:
				System.out.println("Enter the name of district:\nDallas,Pens,Oval,Mars,Washington,DC");
				String dname = input.next();
				key.districtList(dname, conn);
				break;
			case 8:
				System.out.println("Enter the name of district:\nDallas,Pens,Oval,Mars,Washington,DC");
				String hname = input.next();
				key.showHead(hname, conn);
				break;
			case 9:
				System.out.println("Enter the name of district:\nDallas,Pens,Oval,Mars,Washington,DC");
				String ohname = input.next();
				System.out.println("Enter new citizen_id");
				int id = input.nextInt();
				key.changeHead(ohname, id, conn);
				break;
			case 10:
			case 11:
				init.createInitial();
				break;
			case 12: System.exit(0);
			default:
				System.out.println("Invalid choice");
			}
			
			//exit = input.next();
			//exit = input.next();
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
}
	}
}
