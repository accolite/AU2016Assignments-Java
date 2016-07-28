package com.tomcat;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class Manager
 */
@WebServlet("/Manager")
public class Manager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Manager() {
        super();
        // TODO Auto-generated constructor stub
    }
    public  String getDbConnection()
    {				String s="";


    	try {
			Context context=new InitialContext();
			Context envcontext=(Context)context.lookup("java:/comp/env");
			DataSource ds=(DataSource)envcontext.lookup("jdbc/MyDatabase");
			Connection connection=ds.getConnection();
			Statement stmt=connection.createStatement();
			String sql="select * from Employee where role=2";
			ResultSet rs=stmt.executeQuery(sql);
		
			while(rs.next()){
				s+=rs.getObject("name")+"   "+ rs.getObject("age")+"   "+ rs.getObject("email")+ "   "+ rs.getObject("address")+"<br><br><br>";
			}
    	
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return s;
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String answer=getDbConnection();
		response.getWriter().append(answer);
		request.setAttribute("answer",answer );
		request.getRequestDispatcher("Manager.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
