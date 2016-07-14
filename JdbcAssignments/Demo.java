package org.au.workshop.domain;

import java.sql.*;
import java.util.Scanner;

import org.au.workshop.util.Constants;

public class Demo {
	static Connection conn = null;

	public static void main(String... strings) {
		/*Databases create = new Databases();
		create.createDatabases();
		TablesCreation tableCreate = new TablesCreation();
		tableCreate.createTables();*/
		int choice;
		ResultSet rs = null;
		Statement stmt = null;
		AnswerS answers = new AnswerS();
		String exit = new String("");
		// Statement stmt = null;
		try {
			Class.forName(Constants.JTDS_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME, Constants.userName,
					Constants.password);
			stmt = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		while (true) {
			Scanner input = new Scanner(System.in);
			System.out.println("Select a work: \n" + "1: List all the States:\n2: List all the Districts\n"
					+ "3: Display the citizen count for all the states.\n"
					+ "4: Remove a district\n5: Remove a State\n6: List of citizens under State\n"
					+ "7: List of citizens under District\n"
					+ "8: Show head of a District\n9: Change head of a District\n"
					+ "10: List Technical Details\n11: Create or Restore date and tables\n12.exit");
			choice = input.nextInt();
			switch (choice) {
			case 1:
				try {
					conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME, Constants.userName,
							Constants.password);
					stmt = conn.createStatement();
					answers.listStates(stmt);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						stmt.close();
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			case 2:
				try {
					conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME, Constants.userName,
							Constants.password);
					stmt = conn.createStatement();
					answers.listDistricts(stmt);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						stmt.close();
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			case 3:
				try {
					conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME, Constants.userName,
							Constants.password);
					stmt = conn.createStatement();
					System.out.println(answers.CountCitizensFromAllStates(stmt));
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						stmt.close();
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			case 4:
				try {
					conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME, Constants.userName,
							Constants.password);
					stmt = conn.createStatement();
					Scanner in = new Scanner(System.in);
					String district_name = in.next();
					answers.RemoveDistrict(stmt, district_name);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						stmt.close();
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			case 5:
				try {
					conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME, Constants.userName,
							Constants.password);
					stmt = conn.createStatement();
					Scanner in = new Scanner(System.in);
					String state_name = in.next();
					answers.RemoveDistrict(stmt, state_name);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						stmt.close();
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			case 6:
				try {
					conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME, Constants.userName,
							Constants.password);
					stmt = conn.createStatement();
					Scanner in = new Scanner(System.in);
					String state_name = in.next();
					answers.listCitizensFromState(stmt, state_name);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						stmt.close();
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			case 7:
				try {
					conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME, Constants.userName,
							Constants.password);
					stmt = conn.createStatement();
					Scanner in = new Scanner(System.in);
					String district_name = in.next();
					answers.listCitizensFromDistrict(stmt, district_name);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						stmt.close();
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			case 8:
				try {
					conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME, Constants.userName,
							Constants.password);
					stmt = conn.createStatement();
					Scanner in = new Scanner(System.in);
					String district_name = in.next();
					answers.headOfDistrict(district_name, stmt);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						stmt.close();
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			case 9:
				try {
					conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME, Constants.userName,
							Constants.password);
					stmt = conn.createStatement();
					Scanner in = new Scanner(System.in);
					String district_name = in.next();
					int ssn = in.nextInt();
					answers.changeHeadOfDistrict(stmt, district_name, ssn);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						stmt.close();
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			case 10:
				try {
					conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME, Constants.userName,
							Constants.password);
					answers.showDatabaseDetails(conn);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			case 11:
				answers.factoryReset();
				break;
			case 12:
			default:
				System.out.println("Invalid choice");
			}
			System.out.println("Do you want to exit y/n:\n");
			// exit = input.next();
			exit = input.next();
		}
	}
}
