package com.au.tomcatassignment;

import java.io.IOException;
import java.security.Principal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Hello");
		Hashtable env=new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
		
		try{
			
			Principal p=request.getUserPrincipal();
			String user=p.getName();
			
			Context initialContext=new InitialContext(env);
			Context envContext=(Context) initialContext.lookup("java:/comp/env");
			DataSource dataSource=(DataSource) envContext.lookup("jdbc/MyDatabase");
			java.sql.Connection connection=dataSource.getConnection();
			java.sql.Statement stmt=connection.createStatement();
			
			if(user.equals("manager"))
			{
				
				System.out.println("IN manager");
				String sql="select * from Employee;";
				ResultSet rs=stmt.executeQuery(sql);
				/*request.setAttribute("emplist", rs);
				RequestDispatcher rd = request.getRequestDispatcher("Manager.jsp");
	             rd.include(request, response);*/
	             
				/*while(rs.next())
				{
					System.out.println(rs.getString("empname"));
				}*/
	            
				/* ArrayList<ArrayList<String>> Rows=null;
				try{
	             Rows = new ArrayList();

	             while (rs.next()){
	             ArrayList row = new ArrayList();
	             for (int i = 1; i <= 1 ; i++){
	                     row.add(rs.getString(i));
	             }

	             Rows.add(row);
	             }
				}catch(Exception e){
	               System.out.println("Exception in making list");	 
	             
	            	 }*/
				List<Employee> list=new ArrayList<Employee>();
				Employee emp=null;
	            while (rs.next()) {   

	                emp =new Employee();  
	                emp.setEmpId(rs.getInt("empid"));
	                emp.setEmpName(rs.getString("empname"));
	                emp.setPassword(rs.getString("pwd"));
	                emp.setRole(rs.getString("role"));
	                emp.setEmail(rs.getString("email"));
	                list.add(emp);
	                System.out.println("in while loop");

	            }
				
				request.setAttribute("empList", list);
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/Manager.jsp");
				System.out.println("Hello");
				requestDispatcher.forward(request,response);
	             
	             
			}
			else if(user.equals("employee"))
			{
				System.out.println("IN employee");
				String sql="select * from Employee where empname='"+user+"';";
				ResultSet rs=stmt.executeQuery(sql);
				Employee emp=null;
	            while (rs.next()) {   

	                emp =new Employee();  
	                emp.setEmpId(rs.getInt("empid"));
	                emp.setEmpName(rs.getString("empname"));
	                emp.setPassword(rs.getString("pwd"));
	                emp.setRole(rs.getString("role"));
	                emp.setEmail(rs.getString("email"));
	                System.out.println("in while loop");

	            }
				
				request.setAttribute("empObj", emp);
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/Employee.jsp");
				System.out.println("Hello");
				requestDispatcher.forward(request,response);
	             
				
			}
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
		//getEMployeeBean
		
		/*try{
			Context initialContext=new InitialContext(env);
			Context envContext=(Context) initialContext.lookup("java:/comp/env");
			Student student=(Student) envContext.lookup("bean/MyBeanFactory");
			student.setId(11);
			student.setName("Gouthami");
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getSchool());
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
