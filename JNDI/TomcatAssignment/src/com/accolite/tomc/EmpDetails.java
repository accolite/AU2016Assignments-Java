package com.accolite.tomc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class EmpDetails
 */
@WebServlet("/EmpDetails")
public class EmpDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpDetails() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
	    String id1=request.getParameter("eid");
	    int id=Integer.parseInt(id1);
		try {
    		
			Context initialContext=new InitialContext();
			Context envContext=(Context) initialContext.lookup("java:/comp/env");
			DataSource dataSource=(DataSource) envContext.lookup("jdbc/MyDatabase");
			Connection connection=dataSource.getConnection();
			Statement stmt=connection.createStatement();
			String sql="Select * from dbo.Employee where EmpId="+id1;
			ResultSet rSet=stmt.executeQuery(sql);
			while(rSet.next()){
				out.println("Employee ID: "+rSet.getInt("EmpId")+"<br> Name: "+rSet.getString("EmpName")+"<br> Email: "+rSet.getString("Email")+"<br>");
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
