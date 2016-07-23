package com.accolite;

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

	@GET
	@Path("display")
	@Produces(MediaType.TEXT_PLAIN)
	public String displayMessage(){
		return "this is a test message inside first function";
	}
	
	
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("addMessage")
    public String addMessage(NewMessage newMessage) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        String insertTableSQL = "INSERT INTO NewMessage VALUES(?,?,?)";

        System.out.println("values inside function: "+ newMessage.getMessageID() + " message : " + newMessage.getMessage());
        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(1, newMessage.getMessageID());
            preparedStatement.setString(2, newMessage.getMessage());
            preparedStatement.setInt(3, newMessage.getPersonPostingID());
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
    public NewMessageList allMessagesSortedByTime() throws SQLException {
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
        NewMessageList newMessageList1 = new NewMessageList();
        newMessageList1.setNewMessageList(newMessageList);
        return newMessageList1;
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("addCommentToMessage")
    public String addCommentToMessage(Comment comment) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        String insertTableSQL = "INSERT INTO Comment VALUES(?,?,?,?)";
        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(1,comment.getCommentID());
            preparedStatement.setString(2,comment.getComment());
            preparedStatement.setInt(3, comment.getMessageID());
            preparedStatement.setInt(4, comment.getPersonPostingID());
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
    public String likeAMessage(Likes like) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        String insertTableSQL = "INSERT INTO Likes VALUES(?,?,?)";
        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(1, like.getLikeID());
            preparedStatement.setInt(2, like.getPersonLikeID());
            preparedStatement.setInt(3, like.getMessageID());
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
    public ListComment viewAllCommentsOnMessage(int messageID) throws SQLException {
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
        ListComment listComment = new ListComment();
        listComment.setCommentList(commentList);
        return listComment;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("viewAllLikesOnMessage")
    public ListLikes viewAllLikesOnMessage(int messageID) throws SQLException {
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
        ListLikes listLikes = new ListLikes();
        listLikes.setLikesList(likesList);
        return listLikes;
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
