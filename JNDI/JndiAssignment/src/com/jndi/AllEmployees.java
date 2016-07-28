/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 28, 2016

*

*  @author :: Sachin Gupta

* ***************************************************************************

*/
package com.jndi;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class AllEmployees.
 */
@WebServlet("/AllEmployees")
public class AllEmployees extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
    /**
     * Instantiates a new all employees.
     *
     * @see HttpServlet#HttpServlet()
     */
    public AllEmployees() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter pw=response.getWriter();
		Hashtable env=new Hashtable();
		Context init;
		Context envContext;
	
			try {
				init = new InitialContext(env);
				envContext = (Context) init.lookup("java:comp/env");
				DataSource dataSource=(DataSource) envContext.lookup("jdbc/jndiAssign");
				Connection conn=dataSource.getConnection();
				Statement stmt=conn.createStatement();
				String query="Select * from dbo.Employees";
				ResultSet rs=stmt.executeQuery(query);
				while (rs.next()) {
					pw.append("Name: "+rs.getString("Name")+" emailId: "+rs.getString("email"));
					pw.append("<br>");
				
				}
				
			} catch (NamingException e) {
				pw.append("aksdjfaf");
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
					  

	}

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
