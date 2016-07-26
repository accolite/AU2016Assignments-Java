package com.accolite.servletAssignment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.microsoft.sqlserver.jdbc.SQLServerResultSetMetaData;

/**
 * Servlet implementation class GetMessage
 */
@WebServlet(description = "gets new Messages", urlPatterns = { "/getMessage" })
public class GetMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		int id = Integer.parseInt(request.getParameter("id"));
		//System.out.println(id);
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select messageid, message, username from chat where messageid > ? order by messageid asc");
			preparedStatement.setInt(1, id);
			ResultSet rSet = preparedStatement.executeQuery();
			JSONArray jsonArray = resultSetToJsonObject(rSet);
			response.setContentType("application/json");
			response.getWriter().write(jsonArray.toString());
			connection.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			try {
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}
	
	public JSONArray resultSetToJsonObject(ResultSet rs){
		JSONArray jsonArray = new JSONArray();
		JSONObject obj = null;
		SQLServerResultSetMetaData rsmd = null;
		//System.out.println(rs == null);
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
		       // System.out.println(column_name);
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
		        	//System.out.println(rs.getString(column_name));
		         obj.put(column_name, rs.getInt(column_name));
		        }
		        else if(rsmd.getColumnType(i)==java.sql.Types.NVARCHAR){
		         obj.put(column_name, rs.getNString(column_name));
		        }
		        else if(rsmd.getColumnType(i)==java.sql.Types.VARCHAR){
		        	//System.out.println(rs.getString(column_name));
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
		//System.out.println("this is:"+obj);
		jsonArray.put(obj);
		//System.out.println("this is json array:"+jsonArray);
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return jsonArray;
	}
	

}
