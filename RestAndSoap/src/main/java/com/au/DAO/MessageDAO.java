package com.au.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.au.connection.Constants;
import com.au.model.Message;

public class MessageDAO {

	public List<Message> getAllMessages() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement stmt = null;
		List<Message> messages = new ArrayList<>();
		try {

			Message message = new Message();
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			// stmt = conn.createStatement();

			String sql;
			sql = "SELECT *FROM dbo.messages";
			System.out.println(Constants.DB_URL_WITHOUT_DB_NAME + "\t" + sql);
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("resultset done!");
			System.out.println("UserID" + "     " + "msg     " + "   " + "likes");
			while (rs.next()) {

				String msg = rs.getString("msg");
				int userid = rs.getInt("userid");
				int likes = rs.getInt("likes");
				message.setLikes(likes);
				message.setMsg(msg);

				message.setUserid(userid);
				// Display values
				System.out.println(userid + "\t" + msg + "\t" + likes);
				messages.add(message);
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
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
		return messages;

	}

	public void addmsg(int userid, String msg) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		Connection conn = null;
		Statement stmt = null;
		List<Message> messages = new ArrayList<>();
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL);
			pstmt = conn.prepareStatement("INSERT INTO dbo.messages values(?,?,?)");
			pstmt.setInt(1, userid);
			pstmt.setString(2, msg);
			pstmt.setInt(3, 0);

			pstmt.executeUpdate();

			// STEP 6: Clean-up environment

			pstmt.close();
			conn.close();
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

	}

	public void Addlikes(int userid, int msgid) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		Connection conn = null;
		Statement stmt = null;
		System.out.println("Yahan bhi" + msgid);
		String sql;
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL);

			sql = "SELECT likes FROM dbo.messages where msgid=" + msgid;
			System.out.println("yahi hai " + sql);
			@SuppressWarnings("null")
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int likes = rs.getInt("likes");
				likes++;
				sql = "UPDATE dbo.messages SET likes =" + likes + "where msgid=" + msgid;

				stmt.execute(sql);
			} /*
				 * else { pstmt = conn.prepareStatement(
				 * "INSERT INTO dbo.user_msg values(?,?,?,?)"); pstmt.setInt(1,
				 * userid); pstmt.setInt(2, msgid); pstmt.setString(3, "");
				 * pstmt.setInt(4, 1);
				 * 
				 * 
				 * pstmt.executeUpdate(); }
				 */

			// STEP 6: Clean-up environment
			pstmt.close();
			stmt.close();
			conn.close();
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

	}

	public void addcomment(int userid, int msgid, String comment) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		Connection conn = null;
		Statement stmt = null;
		List<Message> messages = new ArrayList<>();
		System.out.println(msgid + "nahin again");
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL);
			pstmt = conn.prepareStatement("INSERT INTO dbo.user_msg values(?,?,?,?)");
			pstmt.setInt(1, userid);
			pstmt.setInt(2, msgid);
			pstmt.setString(3, comment);
			pstmt.setInt(4, 0);

			pstmt.executeUpdate();

			// STEP 6: Clean-up environment

			pstmt.close();
			conn.close();
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

	}

	public boolean getAllComment() {
		Connection conn = null;
		Statement stmt = null;
		// List<Message> messages = new ArrayList<>();
		try {

			Message message = new Message();
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			// stmt = conn.createStatement();

			String sql;
			sql = "SELECT *FROM dbo.messages JOIN dbo.user_msg ON dbo.messages.msgid = dbo.user_msg.msgid";
			System.out.println(Constants.DB_URL_WITHOUT_DB_NAME + "\t" + sql);
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("resultset done!");
			System.out.println("msgid       " + "   " + "msg               " + "comment");
			while (rs.next()) {

				String msg = rs.getString("msg");
				int msgid = rs.getInt("msgid");
				String comment = rs.getString("comment");

				System.out.println(msgid + "\t" + msg + "\t" + comment);

			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
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
		return true;

	}

	public boolean getAllLike() {
		Connection conn = null;
		Statement stmt = null;
		// List<Message> messages = new ArrayList<>();
		try {

			Message message = new Message();
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			// stmt = conn.createStatement();

			String sql;
			sql = "SELECT *FROM dbo.messages";
			System.out.println(Constants.DB_URL_WITHOUT_DB_NAME + "\t" + sql);
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("resultset done!");
			System.out.println("userid" + "\t" + "msgid" + "\t" + "msg" + "\t" + "likes");
			while (rs.next()) {

				String msg = rs.getString("msg");
				int userid = rs.getInt("userid");
				int msgid = rs.getInt("msgid");
				int likes = rs.getInt("likes");

				System.out.println(userid + "\t" + msgid + "\t" + msg + "\t" + likes);

			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
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
		return true;

	}

}