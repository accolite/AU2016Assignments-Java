package com.au;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManagerServlet
 */
@WebServlet("/manager")
public class ManagerServlet extends HttpServlet {
	
	static ResultSet rs;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServlet() {
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
		Employee user;
		List<Employee> employees = new ArrayList<Employee>();
		
		try {
			//register driver
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.username, Constants.password);
			
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			//stmt = conn.createStatement();

			
			String sql;
			sql = "SELECT id, name, password, email, role FROM employee";
			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				user = new Employee();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				user.setEmail(rs.getString("email"));
				employees.add(user);
				System.out.println("name :"  + user.getName());
			}
		}
		catch(Exception e) {}
		
		request.setAttribute("list", employees);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/getemployees.jsp");
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
