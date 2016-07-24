package com.accolite.webService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.accolite.java.Comment;
import com.accolite.java.Like;
import com.accolite.java.ListComment;
import com.accolite.java.ListLike;
import com.accolite.java.ListMessage;
import com.accolite.java.ListUser;
import com.accolite.java.Message;
import com.accolite.java.User;
import com.accolite.util.Constants;


@Path("/facebookAssignment")
public class Assignment {
	
	Statement stmt = null;
	PreparedStatement pstmt = null;
	Connection conn = null;
	ResultSet rs=null;
	String sql;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/viewAllUsers")
	public ListUser viewAllUsers() throws SQLException, ClassNotFoundException
	{
		Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		conn = DriverManager.getConnection(Constants.DB_URL,"sa","accolite");
		stmt = conn.createStatement();
		sql="select * from dbo.person";
		rs = stmt.executeQuery(sql);
		List<User> lstUser=new ArrayList<>();
		while (rs.next()){
			User message=new User();
			message.setPersonName(rs.getString("personName"));
			message.setPersonId(rs.getInt("personId"));
			
			lstUser.add(message);
		}
		ListUser lu=new ListUser();
		lu.setLstUser(lstUser);;
		return lu;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addMsg")
	public void addMessage(Message message) throws SQLException, ClassNotFoundException
	{
		Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		conn = DriverManager.getConnection(Constants.DB_URL,"sa","accolite");
		stmt = conn.createStatement();
		sql="insert into dbo.message(message, personId) values(?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, message.getMessage());
		pstmt.setInt(2, message.getPersonId());
		pstmt.executeUpdate();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/viewAllMsgs")
	public ListMessage viewAllMessages() throws SQLException, ClassNotFoundException
	{
		Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		conn = DriverManager.getConnection(Constants.DB_URL,"sa","accolite");
		stmt = conn.createStatement();
		sql="select * from dbo.message";
		rs = stmt.executeQuery(sql);
		List<Message> lstMessage=new ArrayList<>();
		while (rs.next()){
			Message message=new Message();
			message.setMessage(rs.getString("message"));
			message.setMessageId(rs.getInt("messageId"));
			message.setPersonId(rs.getInt("personId"));
			
			lstMessage.add(message);
		}
		ListMessage lm=new ListMessage();
		lm.setLstMessage(lstMessage);
		return lm;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addCommentOnMsg")
	public void addCommentOnMessage(Comment comment) throws SQLException, ClassNotFoundException
	{
		Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		conn = DriverManager.getConnection(Constants.DB_URL,"sa","accolite");
		stmt = conn.createStatement();
		sql="insert into dbo.comment(comment, personId, messageId) values(?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, comment.getComment());
		pstmt.setInt(2, comment.getPersonId());
		pstmt.setInt(3, comment.getMessageId());
		pstmt.executeUpdate();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addLikeOnMsg")
	public void addLikeOnMessage(Like likeObject) throws SQLException, ClassNotFoundException
	{
		Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		conn = DriverManager.getConnection(Constants.DB_URL,"sa","accolite");
		stmt = conn.createStatement();
		sql="insert into dbo.likes(personId, messageId) values(?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, likeObject.getPersonId());
		pstmt.setInt(2, likeObject.getMessageId());
		pstmt.executeUpdate();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/viewAllComms")
	public ListComment viewAllComments() throws SQLException, ClassNotFoundException
	{
		Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		conn = DriverManager.getConnection(Constants.DB_URL,"sa","accolite");
		stmt = conn.createStatement();
		sql="select * from dbo.comment";
		rs = stmt.executeQuery(sql);
		List<Comment> lstComment=new ArrayList<>();
		while (rs.next()){
			Comment comment=new Comment();
			comment.setComment(rs.getString("comment"));
			comment.setCommentId(rs.getInt("commentId"));
			comment.setMessageId(rs.getInt("messageId"));
			comment.setPersonId(rs.getInt("personId"));
			lstComment.add(comment);
		}
		ListComment lc=new ListComment();
		lc.setLstComment(lstComment);
		return lc;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/viewAllLis")
	public ListLike viewAllLikes() throws SQLException, ClassNotFoundException
	{
		Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		conn = DriverManager.getConnection(Constants.DB_URL,"sa","accolite");
		stmt = conn.createStatement();
		sql="select * from dbo.likes";
		rs = stmt.executeQuery(sql);
		List<Like> lstLike=new ArrayList<>();
		while (rs.next()){
			Like likeObejct=new Like();
			likeObejct.setLikeId(rs.getInt("likeId"));
			likeObejct.setMessageId(rs.getInt("messageId"));
			likeObejct.setPersonId(rs.getInt("personId"));
			lstLike.add(likeObejct);
		}
		ListLike ll=new ListLike();
		ll.setLstLike(lstLike);
		return ll;
	}
	
//	public void deleteMessage(int messageId) throws SQLException
//	{
//		conn = DriverManager.getConnection(Constants.DB_URL,"sa","accolite");
//		stmt = conn.createStatement();
//		sql="delete from dbo.message where messageId=?";
//		pstmt = conn.prepareStatement(sql);
//		pstmt.setInt(1, messageId);
//		pstmt.executeUpdate();
//	}
//	
//	public void deleteComment(int commentId) throws SQLException
//	{
//		conn = DriverManager.getConnection(Constants.DB_URL,"sa","accolite");
//		stmt = conn.createStatement();
//		sql="delete from dbo.comment where commentId=?";
//		pstmt = conn.prepareStatement(sql);
//		pstmt.setInt(1, commentId);
//		pstmt.executeUpdate();
//	}
//	
//	public void deleteLike(int likeId) throws SQLException
//	{
//		conn = DriverManager.getConnection(Constants.DB_URL,"sa","accolite");
//		stmt = conn.createStatement();
//		sql="delete from dbo.like where likeId=?";
//		pstmt = conn.prepareStatement(sql);
//		pstmt.setInt(1, likeId);
//		pstmt.executeUpdate();
//	}
	
	
}
