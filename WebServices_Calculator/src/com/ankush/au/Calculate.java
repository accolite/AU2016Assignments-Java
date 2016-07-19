package com.ankush.au;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculate
 */
@WebServlet({ "/Calculate", "/mapping" })
public class Calculate extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		
		PrintWriter out = response.getWriter();
		
		String no1 = request.getParameter("no1");
		String no2 = request.getParameter("no2");
		
		String option = request.getParameter("option");
		
		int n1 = Integer.parseInt(no1);
		int n2 = Integer.parseInt(no2);
		
		switch(option){
			
			case "1":
				int sum = n1+n2;
				out.println("Sum is "+sum);
				break;
				
			case "2":
				int diff = n1-n2;
				out.println("Diff is "+diff);
				break;
				
			case "3":
				int mul = n1*n2;
				out.println("Prod is "+mul);
				break;
				
			case "4":
				int div = n1/n2;
				out.println("Div is "+div);
				break;
		}
		
		out.println("</br><a href = \"http://localhost:8080/Calculator/index.html\"> Again </a>");
		
		doGet(request, response);
	}

}
