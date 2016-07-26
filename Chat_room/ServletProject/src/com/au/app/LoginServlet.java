package com.au.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "login by user", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String name=request.getParameter("name");  
        String password=request.getParameter("password");  
        DatabaseConnect db=new  DatabaseConnect();
        
        if(db.verifyuser(name,password)){  
        out.print("Welcome, "+name);  
        HttpSession session=request.getSession();  
        session.setAttribute("uname",name); 
        session.setAttribute("name", db.getName(name)); 
      
        ServletContext app = getServletConfig().getServletContext();
 
        if(app.getAttribute("name")==null){
        	 ArrayList<String> al= new ArrayList();
             al.add(db.getName(name));
             app.setAttribute("name",al); 
        }
        else{
        	 ArrayList<String> active=(ArrayList<String>) app.getAttribute("name");
             active.add(db.getName(name));
             app.setAttribute("name",active); 
        }
       
           
        request.getRequestDispatcher("chat.html").include(request, response);  
        }  
        else{  
            out.print("Sorry, username or password error!");  
            request.getRequestDispatcher("login.html").include(request, response);  
        }  
        out.close();  
    }  
		
}		

