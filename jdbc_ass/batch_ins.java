
package pckg;
import java.sql.*;
import java.io.*;

//JDBC Batch Processing
public class batch_ins {
	public static void main(String[] args) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		//----------------------------------------------------president
		System.out.println("For president");
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.uname,Constants.pwd);
			pstmt = conn.prepareStatement("INSERT INTO dbo.President values(?,?,?)");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				System.out.println("enter id");
				String s1 = br.readLine();
				int id = Integer.parseInt(s1);

				System.out.println("enter fname");
				String firstname = br.readLine();

				System.out.println("enter last name");
				String lastname = br.readLine();

				pstmt.setInt(1, id);
				pstmt.setString(2, firstname);
				pstmt.setString(3, lastname);

				pstmt.addBatch();

				System.out.println("Want to add more records ? y/n");

				String ans = br.readLine();
				if (ans.equals("n")) {
					break;
				}
			}
			pstmt.executeBatch();
			System.out.println("Record Successfully saved");
			conn.close();
			pstmt.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//----------------------------------------------------------------states
		System.out.println("For state");
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.uname,Constants.pwd);
			pstmt = conn.prepareStatement("INSERT INTO dbo.State values(?,?,?,?)");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				System.out.println("enter id");
				String s1 = br.readLine();
				int id = Integer.parseInt(s1);

				System.out.println("enter name");
				String s2 = br.readLine();

				System.out.println("enter pres_id");
				String s3 = br.readLine();
				int id1 = Integer.parseInt(s3);

				System.out.println("enter dist_id");
				String s4 = br.readLine();
				int id2 = Integer.parseInt(s4);

				pstmt.setInt(1, id);
				pstmt.setString(2, s2);
				pstmt.setInt(3, id1);
				pstmt.setInt(4, id2);

				pstmt.addBatch();

				System.out.println("Want to add more records ? y/n");

				String ans = br.readLine();
				if (ans.equals("n")) {
					break;
				}
			}
			pstmt.executeBatch();
			System.out.println("Record Successfully saved");
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//-------------------------------------------------------------ditrict

		System.out.println("For district");
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.uname,Constants.pwd);
			pstmt = conn.prepareStatement("INSERT INTO dbo.District values(?,?,?,?)");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				System.out.println("enter id");
				String s1 = br.readLine();
				int id = Integer.parseInt(s1);

				System.out.println("enter name");
				String s2 = br.readLine();

				System.out.println("enter head_id");
				String s3 = br.readLine();
				int id1 = Integer.parseInt(s3);

				System.out.println("enter state_id");
				String s4 = br.readLine();
				int id2 = Integer.parseInt(s4);

				pstmt.setInt(1, id);
				pstmt.setString(2, s2);
				pstmt.setInt(3, id1);
				pstmt.setInt(4, id2);

				pstmt.addBatch();

				System.out.println("Want to add more records ? y/n");

				String ans = br.readLine();
				if (ans.equals("n")) {
					break;
				}
			}
			pstmt.executeBatch();
			System.out.println("Record Successfully saved");
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
