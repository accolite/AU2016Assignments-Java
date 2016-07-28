package com.accolite.jndi;

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
 * Servlet implementation class FetchAllEmp
 */
@WebServlet("/FetchAllEmp")
public class FetchAllEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchAllEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Context initialContext = new InitialContext();
			Context envContext = (Context) initialContext.lookup("java:/comp/env");
			DataSource dataSource =  (DataSource)envContext.lookup("jdbc/MyDatabase");
			Connection connection = dataSource.getConnection();
			Statement stmt =   connection.createStatement();
			String sql = "SELECT * FROM dbo.Employees WHERE role = " + 0;
			ResultSet rs =  stmt.executeQuery(sql);
			PrintWriter out = response.getWriter();
			while(rs.next())
			{
				out.println("EmpID: " + " " + rs.getInt("emp_id") + "\t" + "Name:" + " " + rs.getString("emp_name") + "\t" + "EmailID:" + " " + rs.getString("email_id") + "\t" + "<br/>");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
}
