package assignment.accolite.DAO;

import constants.Constants;

import java.sql.*;

import static constants.Constants.PASS;
import static constants.Constants.USER;

/**
 * Created by Mitul Kapoor on 7/14/2016.
 */
public class StateDAO {
    private Connection conn;
    private Statement smnt;

    public void populateStateData() throws SQLException {
        PreparedStatement pstmt = null;
        try {
            conn = DriverManager.getConnection(Constants.DB_URL,USER,PASS);
            int stateId[] = {1,2,3,4};
            String StateName[] = {"Punjab","Haryana","Himachal","UP"};
            String status[] = {"1","1","1","1"};

            for(int i=0;i<stateId.length;i++){
                pstmt = conn.prepareStatement("INSERT INTO States values(?,?,?)");
                pstmt.setInt(1, stateId[i]);
                pstmt.setString(2, StateName[i]);
                pstmt.setString(3, status[i]);

                pstmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }


    }

}
