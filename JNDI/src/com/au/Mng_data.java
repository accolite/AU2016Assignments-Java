package com.au;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ManagerData
 */
@WebServlet("/Mng_data")
public class Mng_data extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mng_data() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ArrayList<Employee> dbConnection() {
		ArrayList<Employee> list=new ArrayList<Employee>();
		try {
			Hashtable env = new Hashtable();
			env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
			Context initialContext = new InitialContext(env);
			Context context = (Context) initialContext.lookup("java:/comp/env");
			DataSource dataSource = (DataSource) context.lookup("jdbc");
			Connection connection = dataSource.getConnection();
			Statement stmt = connection.createStatement();
			String sql = "select * from dbo.Emp";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Employee e=new Employee();
				e.setId(rs.getInt(1));
				e.setEmailId(rs.getString(2));
				e.setName(rs.getString(3));
				list.add(e);
			}

		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Mng_data md=new Mng_data();
		ArrayList<Employee> list=md.dbConnection();
		PrintWriter out=response.getWriter();
		String s="";
		for(Employee e:list){
			s=s+"<br><br>"+(e.getId()+"  "+e.getName()+"   "+e.getEmailId());
		}
		response.getWriter().append(s);
	 	request.setAttribute("message", s);
        request.getRequestDispatcher("Output.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
