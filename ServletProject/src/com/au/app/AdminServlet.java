package com.au.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(description = "Admin can add prohibited text", urlPatterns = { "/AdminServlet" })
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
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
		        String words=request.getParameter("prohibwords");  
		        String[] prohibwords = words.split(","); 
			    int n=prohibwords.length;
		        DatabaseConnect db=new DatabaseConnect();
		        System.out.println(n);
			    for(int i=0;i<n;i++){
			    	 db.insertWord(prohibwords[i]);
				}
		    
		       	        
               
		        request.getRequestDispatcher("adminlogin.html").include(request, response);  
		        out.close();
	}

}
