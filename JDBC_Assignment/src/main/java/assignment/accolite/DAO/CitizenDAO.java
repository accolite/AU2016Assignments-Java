package assignment.accolite.DAO;

import assignment.accolite.structure.Citizen;
import constants.Constants;

import java.sql.*;
import java.util.Scanner;

import static constants.Constants.PASS;
import static constants.Constants.USER;

/**
 * Created by Mitul Kapoor on 7/14/2016.
 */
public class CitizenDAO {
    private Citizen citizen;
    private Connection conn;
    private Statement stmt;
    public CitizenDAO(){
        citizen = new Citizen();
    }

    public void populateCitizenData() throws SQLException {
        PreparedStatement pstmt = null;
        try {
            conn = DriverManager.getConnection(Constants.DB_URL,USER,PASS);
            int personId[] = {1,2,3,4,5,6};
            String name[] = {"Diksha","Mitul","Arnika","Anshika","Ankita","Sanjali"};
            int districtID[] = {1,2,3,1,2,1};
            int age[] = {23,23,21,23,21,23};
            String status[] = {"1","1","1","1","1","1"};

            for(int i=0;i<personId.length;i++){
                pstmt = conn.prepareStatement("INSERT INTO Citizen values(?,?,?,?,?)");
                pstmt.setInt(1, personId[i]);
                pstmt.setString(2, name[i]);
                pstmt.setInt(3, districtID[i]);
                pstmt.setInt(4, age[i]);
                pstmt.setString(5, status[i]);
                pstmt.executeUpdate();
            }
                    } catch (Exception e) {
            e.printStackTrace();
        } finally {
           conn.close();
        }

    }

    public void insertCitizen(){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter person id : ");
        citizen.setPersonID(input.nextInt());

        System.out.println("Enter person name : ");
        citizen.setName(input.nextLine());

        System.out.println("Enter person district id: ");
        citizen.setDistrictID(input.nextInt());

        System.out.println("Enter person age : ");
        citizen.setAge(input.nextInt());

        System.out.println("Enter person status : ");
        citizen.setPersonID(input.nextInt());

        try {
            Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
            conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,USER,PASS);
            stmt = conn.createStatement();
            //
            String sqlCreate = "INSERT INTO Citizen VALUES("
                    + citizen.getPersonID() + ","
                    + citizen.getName() + "," +
                    citizen.getDistrictID() + ","
                    + citizen.getAge() + ","
                    + citizen.getStatus() + ")";
            Statement stmt = conn.createStatement();
            stmt.execute(sqlCreate);
            //
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
