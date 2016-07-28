package com.accolite.jndi.assignment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.microsoft.sqlserver.jdbc.SQLServerResultSetMetaData;

/**
 * Servlet implementation class Employee
 */
@WebServlet(description = "Shows the list of employees", urlPatterns = { "/Employee" })
public class Employee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Employee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//response.getWriter().append("Hello world!!!");
		Context initialContext;
		JSONArray jsonArray = null;
		try {
			initialContext = (Context) new InitialContext(env);
			Context envContext = (Context) (initialContext).lookup("java:/comp/env");

			DataSource dataSource = (DataSource) envContext.lookup("jdbc/MyDatabase");
			Connection connection = dataSource.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement("use EmployeeDB select * from employee where employeeName = ?");
			
			HttpSession session = request.getSession();
			String name = (String) session.getAttribute("name");
			session.invalidate();
			
			preparedStatement.setString(1, name);
			ResultSet rSet = preparedStatement.executeQuery();
			
			jsonArray = resultSetToJsonObject(rSet);
			
			response.getWriter().append(jsonArray.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
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
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
