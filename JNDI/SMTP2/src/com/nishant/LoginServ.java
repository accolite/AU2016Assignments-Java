package com.nishant;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;
@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println(request.getUserPrincipal().toString().contains("roles=\"Manager\""));
		if(request.getUserPrincipal().getName().equals("Manager")){
			//response.sendRedirect("");
			String s=doConnectionDemo("Manager");
			//request.getRequestDispatcher("").include(request, response);
			request.setAttribute("Data",s);
			//request.getRequestDispatcher("").include(request, response);
			//PrintWriter pw=new PrintWriter(ou);
			response.setContentType("Text/HTML");
			PrintWriter out=response.getWriter();
			out.print(s);
			//response.sendRedirect("http://localhost:8082/SMTP2/Manager.html");
		}
		else{
			response.setContentType("Text/HTML");
			String s=doConnectionDemo("Employee");
			PrintWriter out=response.getWriter();
			out.print(s);
			//response.sendRedirect("http://localhost:8082/SMTP2/Employee.html");
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public String doConnectionDemo(String name){
		System.out.println(name);
		try{
			Context initialContext=new InitialContext();
			Context envContext=(Context) initialContext.lookup("java:/comp/env");
			DataSource ds=(DataSource) envContext.lookup("jdbc/MyDatabase");
			java.sql.Connection connection=ds.getConnection();
			Statement stmt=connection.createStatement();
			String sql="";
			if(name.equals("Manager")){
				sql="select * from Users2";
			}
			else{
				sql="select * from Users2 where name='"+name+"' and ismanager=0";
			}
			
			ResultSet rs=stmt.executeQuery(sql);
			String s="";
			while(rs.next()){
				
				s+="Employee id "+rs.getInt("id")+"</br>Name "+rs.getString("name")+"</br>Email "+rs.getString("email")+"</br>Status ";
				if(rs.getInt("ismanager")==1){
					s+="Manager";
				}
				else{
					s+="Employee";
				}
				s+="</br></br>";
			}
			if(name.equals("Manager")){
				s+="<form action=\"/SMTP2/demo_form?name=\">Username: <input type=\"text\" name=\"name\"><br>Email:<input type=\"text\" name=\"email\"><br><input type=\"submit\" value=\"Submit\"></form>";
			}
			return s;
			//Integer count=(Integer) envContext.lookup("count");
			//System.out.println("Count: "+count);
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}

}
