package com.acco.JndiAssign;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class LookUp extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		DataSource dataSource;
		Connection conn =null;;
		PrintWriter out = null;
		try {
			InitialContext ctx = new InitialContext( );
			dataSource = (DataSource)ctx.lookup("java:comp/env/TestDB");
			int a = (int)ctx.lookup("java:comp/env/maxExemptions");
			conn = dataSource.getConnection();
			out  = response.getWriter();
			MyBean bean = (MyBean) ctx.lookup("java:comp/env/MyBeanFactory");
			out.println("foo = " + bean.getFoo() + ", bar = " +
			               bean.getBar());
			out.println(conn.getMetaData()+"a is "+a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{		
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
