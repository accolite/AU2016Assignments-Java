package com.au.restandsoap.webapp;

import java.sql.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.au.restandsoap.model.Comment;
import com.au.restandsoap.model.Likes;
import com.au.restandsoap.model.ListComment;
import com.au.restandsoap.model.ListLikes;
import com.au.restandsoap.model.ListMessage;
import com.au.restandsoap.model.Message;
import com.au.restandsoap.util.Constants;

@Path("messages")
public class Application {
	@GET
	@Path("display")
	@Produces(MediaType.TEXT_PLAIN)
	public String displayMessage(){
		return "this is a test message inside first function";
	}
	Statement stmt = null;
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstat;
	@POST
    @Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("addMessage")
	public String addmessage(Message message) {
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL, Constants.username, Constants.password);
			stmt = conn.createStatement();
			String sql;
			sql = "insert into Message values (?,?,?)";
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1,message.getMessageID());
			pstat.setInt(2, message.getPersonID());
			pstat.setString(3,message.getMessage());
			pstat.executeUpdate();
			return "Your message has been posted!";
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "Error : your message could not be posted!";
	}
	
	@POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("ViewallMessages")
	public ListMessage viewmessage() {
		List<Message> ListMessage = new ArrayList<Message>();
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL, Constants.username, Constants.password);
			stmt = conn.createStatement();
			String sql;
			sql = "select * from Message";
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
		    while(rs.next()){
	                int messageID = rs.getInt(1);
	                String message = rs.getString(2);
	                int personID = rs.getInt(3);
	                Message Message = new Message(messageID,personID,message);
	                ListMessage.add(Message);
	            }
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ListMessage ListMessage1 = new ListMessage();
		ListMessage1.setListmessage(ListMessage);
        return ListMessage1;
	}
	
	 @POST
	 @Produces(MediaType.TEXT_PLAIN)
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Path("addCommentToMessage")
	public String addcomment(Comment comment) {
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL, Constants.username, Constants.password);
			stmt = conn.createStatement();
			String sql;
			sql = "insert into Comment values (?,?,?,?)";
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, comment.getCommentID());
			pstat.setInt(2, comment.getMessageID());
			pstat.setInt(3, comment.getPersonID());
			pstat.setString(4, comment.getComment());
			pstat.executeUpdate();
			 return "Your comment has been posted!";
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		 return "Error : your comment could not be posted!";
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("likeAMessage")
	public String addlike(Likes like) {
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL, Constants.username, Constants.password);
			stmt = conn.createStatement();
			String sql;
			sql = "insert into Likes values (?,?,?,?)";
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1,like.getLikeID());
			pstat.setInt(2, like.getPersonID());
			pstat.setInt(3, like.getMessageID());
			pstat.executeQuery();
			return "You liked a message!";
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "Error : Your like could not be recorded!";
	}
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.TEXT_PLAIN)
	  @Path("viewAllCommentsOnMessage")
	public ListComment viewcomment(int messageID) {
		List<Comment> commentList = new ArrayList<Comment>();
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL, Constants.username, Constants.password);
			stmt = conn.createStatement();
			String sql;
			sql = "select * from Comment where messageID=?";
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, messageID);
			rs = pstat.executeQuery();
			 while(rs.next()){
	                int commendID = rs.getInt(1);
	                String comment = rs.getString(2);
	                Comment comment1 = new Comment(commendID,comment);
	                commentList.add(comment1);
	            }
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		 ListComment listComment = new ListComment();
	     listComment.setListcomment(commentList);
	        return listComment;
	}
	
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.TEXT_PLAIN)
	 @Path("viewAllLikesOnMessage")
	public ListLikes viewlikes(int messageID) {
		List<Likes> likesList = new ArrayList<Likes>();
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL, Constants.username, Constants.password);
			stmt = conn.createStatement();
			String sql;
			sql = "select * from Likes where messageID=?";
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, messageID);
			rs = pstat.executeQuery();
			while(rs.next()){
                int commendID = rs.getInt(1);
                String comment = rs.getString(2);
                Likes likes = new Likes(messageID);
                likesList.add(likes);
            }
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ListLikes listLikes = new ListLikes();
        listLikes.setListlikes(likesList);
        return listLikes;
	}

	
	// public static void main(String[] args) {
	// Application app=new Application();
	// app.addmessage(4,2,"New Message!");
	// //app.viewmessage(4);
	// //app.addcomment(2, 4, 3, "first comment!");
	// //app.viewcomment(4);
	// }
}
