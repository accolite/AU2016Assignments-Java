package assignment.accolite.DAO;

import constants.Constants;

import java.sql.*;

import static constants.Constants.PASS;
import static constants.Constants.USER;

/**
 * Created by Mitul Kapoor on 7/14/2016.
 */
public class VipDAO {
    private Connection conn;
    private Statement smnt;

    public void populateVipData() throws SQLException {
        PreparedStatement pstmt = null;
        try {
            conn = DriverManager.getConnection(Constants.DB_URL,USER,PASS);
            int personId[] = {1,2};
            int relativeID[] = {4,5};
            String relation[] = {"Child","Wife"};

            for(int i=0;i<personId.length;i++){
                pstmt = conn.prepareStatement("INSERT INTO VIP values(?,?,?)");
                pstmt.setInt(1, personId[i]);
                pstmt.setInt(2, relativeID[i]);
                pstmt.setString(3, relation[i]);

                pstmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }


    }

}
