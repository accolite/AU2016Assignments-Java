package com.accolite.fb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.microsoft.sqlserver.jdbc.SQLServerResultSetMetaData;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.eclipse.persistence.internal.jpa.parsing.jpql.antlr.JPQLParser.selectItem_return;

import com.mysql.jdbc.ResultSetMetaData;





@Path("messages")
public class Messages {
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet rs = null;
	public Messages() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(Constants.JTDS_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public String getMessage(){
//		return "Hello world 123";
//	}
	
	
	@POST
	@Path("createaccount")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String createAccount(@QueryParam(value="name") String name){
		Connection connection = null;
		DBConnection dbConnection = new DBConnection();
		int id = 0;
		try {
			connection = dbConnection.getConnection();
			System.out.println(connection == null);
			preparedStatement = connection.prepareStatement("Insert into dbo.users(username) values(?)");
			preparedStatement.setString(1, name);
			preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement("select userid from dbo.users where username=?");
			preparedStatement.setString(1, name);
			rs = preparedStatement.executeQuery();
			rs.next();
			id = rs.getInt(1);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "unsuccessful";
			
		}
		
		return Integer.toString(id);
	}
	
	
	@POST
	@Path("create")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String addMessage(@QueryParam(value="uid") int uid,@QueryParam(value="content") String content){
		
		if(uid == 0){
			return "please enter correct userid or refresh the page";
		}
		
		Connection connection = null;
		DBConnection dbConnection = new DBConnection();
		try {
			connection = dbConnection.getConnection();
			
			System.out.println(connection.toString()+(connection == null));
			
			preparedStatement = connection.prepareStatement("insert into dbo.messages (userid,msgcontent) values(?,?)");
			preparedStatement.setInt(1, uid);
			preparedStatement.setString(2, content);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "unsuccessful";
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "successfully added";
	}
	
	public JSONArray resultSetToJsonObject(ResultSet rs){
		JSONArray jsonArray = new JSONArray();
		JSONObject obj = null;
		SQLServerResultSetMetaData rsmd = null;
		System.out.println(rs == null);
		try {
			rsmd =  (SQLServerResultSetMetaData) rs.getMetaData();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
		try{
		
		int numColumns = rsmd.getColumnCount();
		while(rs.next()){
			obj = new JSONObject();
			for (int i=1; i<numColumns+1; i++) {
		        String column_name = rsmd.getColumnName(i);
		        System.out.println(column_name);
		        if(rsmd.getColumnType(i)==java.sql.Types.ARRAY){
		         obj.put(column_name, rs.getArray(column_name));
		        }
		        else if(rsmd.getColumnType(i)==java.sql.Types.BIGINT){
		         obj.put(column_name, rs.getInt(column_name));
		        }
		        else if(rsmd.getColumnType(i)==java.sql.Types.BOOLEAN){
		         obj.put(column_name, rs.getBoolean(column_name));
		        }
		        else if(rsmd.getColumnType(i)==java.sql.Types.BLOB){
		         obj.put(column_name, rs.getBlob(column_name));
		        }
		        else if(rsmd.getColumnType(i)==java.sql.Types.DOUBLE){
		         obj.put(column_name, rs.getDouble(column_name)); 
		        }
		        else if(rsmd.getColumnType(i)==java.sql.Types.FLOAT){
		         obj.put(column_name, rs.getFloat(column_name));
		        }
		        else if(rsmd.getColumnType(i)==java.sql.Types.INTEGER){
		        	System.out.println(rs.getString(column_name));
		         obj.put(column_name, rs.getInt(column_name));
		        }
		        else if(rsmd.getColumnType(i)==java.sql.Types.NVARCHAR){
		         obj.put(column_name, rs.getNString(column_name));
		        }
		        else if(rsmd.getColumnType(i)==java.sql.Types.VARCHAR){
		        	System.out.println(rs.getString(column_name));
		         obj.put(column_name, rs.getString(column_name));
		        }
		        else if(rsmd.getColumnType(i)==java.sql.Types.TINYINT){
		         obj.put(column_name, rs.getInt(column_name));
		        }
		        else if(rsmd.getColumnType(i)==java.sql.Types.SMALLINT){
		         obj.put(column_name, rs.getInt(column_name));
		        }
		        else if(rsmd.getColumnType(i)==java.sql.Types.DATE){
		         obj.put(column_name, rs.getDate(column_name));
		        }
		        else if(rsmd.getColumnType(i)==java.sql.Types.TIMESTAMP){
		        obj.put(column_name, rs.getTimestamp(column_name));   
		        }
		        else{
		         obj.put(column_name, rs.getObject(column_name));
		        }
		      }
		System.out.println("this is:"+obj);
		jsonArray.put(obj);
		System.out.println("this is json array:"+jsonArray);
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return jsonArray;
	}
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage(@QueryParam(value="id") int userid){
		
		if(userid == 0){
			return "please enter correct userid or refresh the page";
		}
		
		
		JSONObject jsonObject = null;
		DBConnection dbConnection = new DBConnection();
		JSONArray json = new JSONArray();
		SQLServerResultSetMetaData rsmd = null;
		System.out.println("id is:"+userid);

		try{
			connection = dbConnection.getConnection();
			preparedStatement = connection.prepareStatement("select msgcontent,msgid from dbo.messages where userid = ? order by msgid desc");
			preparedStatement.setInt(1, userid);
			rs = preparedStatement.executeQuery();
			rsmd =  (SQLServerResultSetMetaData) rs.getMetaData();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		json= resultSetToJsonObject(rs);
		
		
		System.out.println(json);
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json.toString();
	}
	
	@POST
	@Path("getComments")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String commentsForMessage(@QueryParam(value="msgid") int msgid){
		
		if(msgid == 0){
			return "please enter correct msgid";
		}
		
		
		DBConnection dbConnection= new DBConnection();
		connection = dbConnection.getConnection();
		JSONArray jsonArray = new JSONArray();
		
		System.out.println(msgid);
		
		try{
			preparedStatement = connection.prepareStatement("select commentid, cmt from dbo.comment where msgid = ?");
			preparedStatement.setInt(1, msgid);
			rs = preparedStatement.executeQuery();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		jsonArray = resultSetToJsonObject(rs);
		System.out.println(jsonArray);
		return jsonArray.toString();
	}
	
	
	@POST
	@Path("getLikes")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String likesForMessage(@QueryParam(value="msgid") int msgid){
		
		if(msgid == 0){
			return "please enter correct msgid";
		}
		
		DBConnection dbConnection= new DBConnection();
		connection = dbConnection.getConnection();
		JSONArray jsonArray = new JSONArray();
		
		System.out.println(msgid);
		
		try{
			preparedStatement = connection.prepareStatement("select userid from dbo.likes where msgid = ?");
			preparedStatement.setInt(1, msgid);
			rs = preparedStatement.executeQuery();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		jsonArray = resultSetToJsonObject(rs);
		return jsonArray.toString();
	}
	
	
	@POST
	@Path("comment")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String commentMessage(@QueryParam(value="msgid") int msgid, @QueryParam(value="userid") int userid, @QueryParam(value="comment") String comment){
		
		if(msgid == 0){
			return "please enter correct msgid";
		}
		if(userid == 0){
			return "please enter correct userid or refresh the page";
		}
		
		
		DBConnection dbConnection = new DBConnection();
		try{
			connection = dbConnection.getConnection();
			preparedStatement = connection.prepareStatement("insert into comment(msgid,userid,cmt) values(?,?,?)");
			preparedStatement.setInt(1, msgid);
			preparedStatement.setInt(2, userid);
			preparedStatement.setString(3, comment);
			preparedStatement.executeUpdate();
			connection.close();
		}
		catch(Exception e){
			e.printStackTrace();
			return "unsuccessful";
		}
		return "successful";
	}
	
	
	@POST
	@Path("like")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String likeMessage(@QueryParam(value="msgid") int msgid, @QueryParam(value="userid") int userid){
		
		if(msgid == 0){
			return "please enter correct msgid";
		}
		if(userid == 0){
			return "please enter correct userid or refresh the page";
		}
		
		DBConnection dbConnection = new DBConnection();
		try{
			connection = dbConnection.getConnection();
			
			preparedStatement = connection.prepareStatement("select userid from likes where msgid = ? and userid= ?");
			preparedStatement.setInt(1, msgid);
			preparedStatement.setInt(2, userid);
			rs = preparedStatement.executeQuery();
			
			System.out.println("hello out");
			
			if(rs.next()){
				System.out.println("hello");
				return "already liked";
			}
			else{
			preparedStatement = connection.prepareStatement("insert into likes(msgid,userid) values(?,?)");
			preparedStatement.setInt(1, msgid);
			preparedStatement.setInt(2, userid);
			preparedStatement.executeUpdate();
			connection.close();
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return "unsuccessful";
		}
		return "successful";
	}
	
	
	
}
