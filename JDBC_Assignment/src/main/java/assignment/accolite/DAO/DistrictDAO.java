package assignment.accolite.DAO;

import constants.Constants;

import java.sql.*;

import static constants.Constants.PASS;
import static constants.Constants.USER;

/**
 * Created by Mitul Kapoor on 7/14/2016.
 */
public class DistrictDAO {

    private Connection conn;
    private Statement smnt;

    public void populateDistrictData() throws SQLException {
        PreparedStatement pstmt = null;
        try {
            conn = DriverManager.getConnection(Constants.DB_URL,USER,PASS);
            int districtId[] = {1,2,3};
            String districtName[] = {"Barnala","Sangror","Hissar"};
            int stateID[] = {1,1,2};
            String status[] = {"1","1","1"};
            int personId[] = {2,3,4};

            for(int i=0;i<districtId.length;i++){
                pstmt = conn.prepareStatement("INSERT INTO Districts values(?,?,?,?,?)");
                pstmt.setInt(1, districtId[i]);
                pstmt.setString(2, districtName[i]);
                pstmt.setInt(3, stateID[i]);
                pstmt.setString(4, status[i]);
                pstmt.setInt(5, personId[i]);
                pstmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }
}
