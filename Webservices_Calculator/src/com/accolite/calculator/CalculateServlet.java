package com.accolite.calculator;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculateServlet
 */
@WebServlet("/CalculateServlet")
public class CalculateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculateServlet() {
    	
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
    	  PrintWriter out = response.getWriter();
    	  
    	  int input1=Integer.parseInt(request.getParameter("display1"));
    	  //out.println(input1);
    	  
    	  int input2=Integer.parseInt(request.getParameter("display2"));
    	  //out.println(input2);
    	  
    	  String operation=request.getParameter("option");
    	  //out.println(operation);
    	  
    	  int result;
    	  
    	  if(operation.equals("add"))
    	  {
    	   result=input1+input2;
    	   out.println(result);
    	   
    	  }
    	  
    	  if(operation.equals("subtract"))
    	  {
    	   result=input1-input2;
    	   out.println(result);
    	  }
    	  
    	  if(operation.equals("multiply"))
    	  {
    	   result=input1*input2;
    	   out.println(result);
    	  }
    	  
    	  if(operation.equals("divide"))
    	  {
    		  try{ float resultF=input1/input2;
       	   out.println(resultF);
    			  
    		  }
    		  catch(Exception e)
    		  {
    			  out.println("NOT POSSIBLE TO DIVIDE BY ZERO!!");
    		  }
    		  
    	  
    	  }
    	  
    	        
    	 }
}
