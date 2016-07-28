package com.au;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static ResultSet rs;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		Statement stmt = null;
		Employee user = new Employee();
		
		try {
			//register driver
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.username, Constants.password);
			
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			

			String sql;
			sql = "SELECT id, name,email,role FROM employee where id = 2";
			rs = stmt.executeQuery(sql);
			System.out.println(sql);
			
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setRole(rs.getString("role"));
			user.setEmail(rs.getString("email")); 
			System.out.println(rs.getString("email"));
			
		} catch(Exception e) {}
		
		request.setAttribute("emp", user);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/getEmployee.jsp");
		requestDispatcher.forward(request,response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
