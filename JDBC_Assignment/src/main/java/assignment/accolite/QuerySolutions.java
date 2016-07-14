package assignment.accolite;

import assignment.accolite.database.Database;
import constants.Constants;

import java.sql.*;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created by Mitul Kapoor on 7/14/2016.
 */
public class QuerySolutions {

    public void Ques1() throws SQLException {
        Connection conn = null;
        Statement stmt;
        try {
            //register driver
            Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);

            conn = DriverManager.getConnection(Constants.DB_URL, "sa", "accolite");

            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //stmt = conn.createStatement();

            String sql;
            sql = "select distinct(stateName) from States where status=1";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("stateName"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            conn.close();
        }
    }

    public void Ques2() throws SQLException {
        Connection conn = null;
        Statement stmt;
        try {
            //register driver
            Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
            conn = DriverManager.getConnection(Constants.DB_URL, "sa", "accolite");
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //stmt = conn.createStatement();

            String sql;
            sql = "select districtName from Districts where status=1";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("districtName"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            conn.close();
        }
    }

    public void Ques3() throws SQLException {
  /*      select count(state.stateID) from
        citizen inner join district on
        citizen.districtID = district.districtId inner join state on
        state.stateID = district.stateID
        group by state.stateID;
  */
        Connection conn = null;
        Statement stmt;
        try {
            //register driver
            Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
            conn = DriverManager.getConnection(Constants.DB_URL, "sa", "accolite");
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //stmt = conn.createStatement();

            String sql;
            sql = "select count(States.stateID) from citizen " +
                    "inner join Districts on " +
                    "citizen.districtID = Districts.districtID inner join States " +
                    "on States.StateID = Districts.StateID " +
                    "group by States.stateID;";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getInt(1));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            conn.close();
        }
    }

    public void Ques4() throws SQLException {

        Connection conn = null;
        PreparedStatement stmt;
        try {
            //register driver
            Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
            conn = DriverManager.getConnection(Constants.DB_URL, "sa", "accolite");
           // stmt = (PreparedStatement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //stmt = conn.createStatement();

            String sql;
            ///////
            System.out.println("Enter state name : ");
            Scanner input = new Scanner(in);
            String name = input.nextLine();
            sql = "update Districts set status=0 where districtName like ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,name);
            conn.prepareStatement(sql);
            //stmt.executeQuery(sql);

            sql = "update Citizen " +
                    "set status=0 where districtID IN (" +
                    "select districtID from Districts " +
                    "where districtName like ?" +
                    ")";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,name);
            //stmt.executeQuery(sql);
            conn.prepareStatement(sql);


            sql = "select * from Districts";
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                System.out.println("ID : " + resultSet.getInt(1)
                + "Name : " + resultSet.getString(2)
                + "State Id : " + resultSet.getInt(3)
                + "Status : " + resultSet.getString(4)
                );
            }


            sql = "select * from Citizen";
            statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                System.out.println("ID : " + resultSet.getInt(1)
                        + "Name : " + resultSet.getString(2)
                        + "District Id : " + resultSet.getInt(3)
                        + "Age : " + resultSet.getInt(4)
                        + "Status : " + resultSet.getString(5)
                );
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            conn.close();
        }
    }

    public void Ques5() throws SQLException {

        Connection conn= DriverManager.getConnection(Constants.DB_URL, "sa", "accolite");
        System.out.println("Enter state to delete");
        Scanner in = new Scanner(System.in);
        String state=in.nextLine();
        String sql = "update States set status=0 where stateName like ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, state);
        pstmt.executeUpdate();

        sql="update Districts set status=0 where stateID IN (select stateID from States where stateName like ?)";
        pstmt=conn.prepareStatement(sql);
        pstmt.setString(1, state);
        pstmt.executeUpdate();

        sql="update Citizen set Citizen.status=0 where Citizen.status IN (select Citizen.status from Citizen inner join Districts "
                + "on Citizen.districtID = Districts.districtID where Districts.status=0)";
        pstmt=conn.prepareStatement(sql);
        pstmt.executeUpdate();
    }

    public void Ques6() throws SQLException {
        Connection conn= DriverManager.getConnection(Constants.DB_URL, "sa", "accolite");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter state id");
        int stateIdToList=in.nextInt();
        String sql = "select Citizen.name AS name from Citizen inner join Districts "
                + "on Citizen.districtID = Districts.districtID inner join States "
                + "on States.stateID = Districts.stateID where States.stateID=? AND Citizen.status=1;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, stateIdToList);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString("name")+"\n");

        }
    }

    public void Ques7() throws SQLException {
        Connection conn= DriverManager.getConnection(Constants.DB_URL, "sa", "accolite");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter district id");
        int districtIdToList=in.nextInt();
        String sql = "select Citizen.name AS name from Citizen inner join Districts "
                + "on Citizen.districtID = Districts.districtID inner join States "
                + "on States.stateID = Districts.stateID where Districts.districtId=? AND Citizen.status=1;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, districtIdToList);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString("name")+"\n");
        }

    }

    public void Ques9() throws SQLException {

        Connection conn = null;
        Statement stmt;
        try {
            //register driver
            Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
            conn = DriverManager.getConnection(Constants.DB_URL, "sa", "accolite");
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //stmt = conn.createStatement();

            Scanner input = new Scanner(in);
            System.out.println("Enter name of district : ");
            String name = input.nextLine();
            System.out.println("Enter person id : ");
            int person = input.nextInt();


            String sql;
            sql = " update district " +
                    "set districtHeadID=? " +
                    "where district.name like ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,person);
            preparedStatement.setString(2,name);
            conn.prepareStatement(sql);
            // ResultSet rs = preparedStatement.executeQuery(sql);
            System.out.println("Head Updated!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            conn.close();
        }

    }

    public void Ques8() throws SQLException {
         Connection conn = null;
        PreparedStatement stmt;
        try {
            //register driver
            Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
            conn = DriverManager.getConnection(Constants.DB_URL, "sa", "accolite");
            //stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //stmt = conn.createStatement();

            String sql;
            sql = "select Citizen.name,Districts.districtName " +
                    "from Citizen inner join Districts on " +
                    "Citizen.personID = Districts.personID " +
                    "where Districts.status=1";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                System.out.println("citizen : " + rs.getString(1));
                System.out.println(" district : " + rs.getString(2));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            conn.close();
        }
    }

    public void Ques10() throws SQLException {
        Connection conn = null;
        Statement stmt;
        try {
            //register driver
            Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
            conn = DriverManager.getConnection(Constants.DB_URL, "sa", "accolite");
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //stmt = conn.createStatement();

            String sql;

            System.out.println("District:\n");
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Districts");
            ResultSet rs = pstmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("Total columns: "+rsmd.getColumnCount());
            System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));
            System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1));

            System.out.println("Citizen:\n");
            pstmt = conn.prepareStatement("SELECT * FROM Citizen");
            rs = pstmt.executeQuery();
            rsmd = rs.getMetaData();
            System.out.println("Total columns: "+rsmd.getColumnCount());
            System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));
            System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1));


            System.out.println("State:\n");
            pstmt = conn.prepareStatement("SELECT * FROM States");
            rs = pstmt.executeQuery();
            rsmd = rs.getMetaData();
            System.out.println("Total columns: "+rsmd.getColumnCount());
            System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));
            System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1));


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            conn.close();
        }
    }

    public void Ques11() throws SQLException {

        Database database = new Database();
    }
}
