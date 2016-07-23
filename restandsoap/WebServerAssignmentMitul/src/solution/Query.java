package solution;

import com.accolite.Comment;
import com.accolite.Likes;
import com.accolite.NewMessage;
import constant.Constants;

import javax.ws.rs.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.*;

/**
 * Created by Mitul Kapoor on 7/22/2016.
 */
@Path("social")
public class Query {

	@POST
	@Path("display")
	@Produces(MediaType.TEXT_PLAIN)
	public String displayMessage(){
		return "this is a test message inside first function";
	}
	
	
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("addMessage")
    public String addMessage(int messageID,String message,int personID) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        String insertTableSQL = "INSERT INTO NewMessage VALUES(?,?,?)";

        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(1, messageID);
            preparedStatement.setString(2, message);
            preparedStatement.setInt(3, personID);
            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            return "Your message has been posted!";

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }
        return "Error : your message could not be posted!";
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("allMessagesSortedByTime")
    public List<NewMessage> allMessagesSortedByTime() throws SQLException {
        Connection conn = null;
        Statement stmt;
        List<NewMessage> newMessageList = new ArrayList<NewMessage>();
        try {
            //register driver
            Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
            conn = DriverManager.getConnection(Constants.DB_URL, "sa", "accolite");
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql;
            sql = "select * from NewMessage";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int messageID = rs.getInt(1);
                String message = rs.getString(2);
                int personID = rs.getInt(3);
                NewMessage newMessage = new NewMessage(messageID,message,personID);
                newMessageList.add(newMessage);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            conn.close();
        }
        return newMessageList;
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("addCommentToMessage")
    public String addCommentToMessage(int commentID,String comment,int messageID,int personID) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        String insertTableSQL = "INSERT INTO Comment VALUES(?,?,?,?)";

        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(1, commentID);
            preparedStatement.setString(2, comment);
            preparedStatement.setInt(3, messageID);
            preparedStatement.setInt(4, personID);
            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            return "Your comment has been posted!";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
        return "Error : your comment could not be posted!";
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("likeAMessage")
    public String likeAMessage(int likeID,int personID,int messageID) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        String insertTableSQL = "INSERT INTO Likes VALUES(?,?,?)";
        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(1, likeID);
            preparedStatement.setInt(2, personID);
            preparedStatement.setInt(3, messageID);
            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            return "You like a message!";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
        return "Error : your like could not be recorded!";
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("viewAllCommentsOnMessage")
    public List<Comment> viewAllCommentsOnMessage(int messageID) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        String insertTableSQL = "select * from Comment where messageID=?;";
        List<Comment> commentList = new ArrayList<Comment>();
        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            preparedStatement.setInt(1, messageID);
            // execute insert SQL stetement
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int commendID = resultSet.getInt(1);
                String comment = resultSet.getString(2);
                Comment comment1 = new Comment(commendID,comment);
                commentList.add(comment1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
        return commentList;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("viewAllLikesOnMessage")
    public List<Likes> viewAllLikesOnMessage(int messageID) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        String insertTableSQL = "select * from Likes where messageID = ?;";
        List<Likes> likesList = new ArrayList<Likes>();
        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            preparedStatement.setInt(1, messageID);
            // execute insert SQL stetement
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int commendID = resultSet.getInt(1);
                String comment = resultSet.getString(2);
                Likes likes = new Likes(messageID);
                likesList.add(likes);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
        return likesList;
    }

    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("error : " + e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(Constants.DB_URL, "sa", "accolite");
            return dbConnection;
        } catch (SQLException e) {
            System.out.println("exception aa gyi" + e.getMessage());
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

}
