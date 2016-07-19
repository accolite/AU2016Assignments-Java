package com.accolite.servletassignment;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculateServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException , ServletException{
		//PrintWriter pr=res.getWriter();
		
		/**
		 * Initialize buffer output
		 */
		
		res.setContentType("text/html");
		StringBuffer utilOutput = new StringBuffer();
		String stat="";
		
		try{
			/**
			 * Get initial options and parameters
			 */
			String option = req.getParameter("operation");
			int x=Integer.parseInt(req.getParameter("number1"));
			String num2 = req.getParameter("number2");
			int y=Integer.parseInt(num2==null?"0":num2);
			
			/**
			 * Operations
			 */
			if(option.equals("sum"))
				stat = "The addition of numbers is "+ (x+y);
			else if(option.equals("difference"))
				stat = "The difference of numbers is "+ (x-y);
			else if(option.equals("multiply"))
				stat = "The product of numbers is "+ (x*y);
			else
				stat = "The quotient of numbers is "+ (x/y);
			
			/**
			 * Any Exception 
			 */
		} catch(Exception e){
			stat = "Invalid Input";
		}
		
		/**
		 * Forward request back to requestor
		 */
		utilOutput.append(stat + "\n");
		req.setAttribute("utilOutput", utilOutput.toString());
		req.getRequestDispatcher("/Calculate.jsp").forward(req, res);

		
	} 
}