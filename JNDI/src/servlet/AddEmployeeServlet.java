package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.Employee;

/**
 * Servlet implementation class AddEmployeeServlet
 */
@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeServlet() {
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
		
		Hashtable env=new Hashtable<>();
		env.put(Context.INITIAL_CONTEXT_FACTORY,"org.apache.naming.java.javaURLContextFactory");
		try{
			
			Context initialContext=new InitialContext(env);
			Context envContext=(Context)initialContext.lookup("java:/comp/env");
			DataSource dataSource=(DataSource)envContext.lookup("jdbcBlue");
			Connection connection=dataSource.getConnection();
			String sql="Use Employee; insert into dbo.employee(name, email, address) values(?,?,?)";
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("txtName"));
			pstmt.setString(2, request.getParameter("txtEmail"));
			pstmt.setString(3, request.getParameter("taAddress"));
			pstmt.executeUpdate();
			response.sendRedirect("MailServlet?email="+request.getParameter("txtEmail"));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
		
	}

}
