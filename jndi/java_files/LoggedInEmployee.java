package com.accolite.jndi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.google.gson.Gson;


/**
 * Servlet implementation class LoggedInEmployee
 */
@WebServlet("/LoggedInEmployee")
public class LoggedInEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoggedInEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void executeDB(Context envContext, HttpServletResponse response, String user){
    	try{
    		/**
    		 * Initialize connection with DataSourceFactory
    		 */
	    	DataSource ds= (DataSource) envContext.lookup("jdbc/soaprest");
			Connection connection = ds.getConnection();
			Statement stmt = connection.createStatement();
			
			
			/**
			 * Select all employees
			 */
			String query = "SELECT * from employees where name='"+user+"';";
			ResultSet rs = stmt.executeQuery(query);
			
			
			Map<String, Map<String,Object>> map = new HashMap<>();
			Map<String, Object> submap = null;
			
			/**
			 * Employee authority
			 */
			submap = new HashMap<>();
			submap.put("EMPLOYEE", user);
			map.put("-25", submap);
			
			/**
			 * Get his results
			 */
			while(rs.next()){
				submap = new HashMap<>();
				submap.put("name", rs.getString("name"));
				submap.put("age", rs.getInt("age"));
				submap.put("designation", rs.getString("designation"));
				submap.put("email", rs.getString("email"));
				map.put(new Integer(rs.getInt("emp_id")).toString(), submap);
			}
			
			/**
			 * JSONify response
			 */
			String json = new Gson().toJson(map);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
    	}catch(SQLException | NamingException | IOException e){
    		Map<String, Map<String,Object>> map = new HashMap<>();
			Map<String, Object> submap = null;
			
			/**
			 * Failed due to exception
			 */
			submap = new HashMap<>();
			submap.put("status", "Failed due to "+e.getMessage());
			map.put("-25", submap);
    		String json = new Gson().toJson(map);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
		    try {
				response.getWriter().write(json);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			
			/**
			 * Get context
			 */
			Context initialContext = new InitialContext();
			Context envContext = (Context) initialContext.lookup("java:comp/env");
			/**
			 * Execute employee request
			 */
			executeDB(envContext, response, (String) request.getAttribute("user"));
		}catch(NamingException e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
