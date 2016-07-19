package com.accolite.ServeletBeg;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // reading the user input
        String first_no = request.getParameter("op1");
        String second_no = request.getParameter("op2");
        String operation = request.getParameter("ch");
        float first=Float.parseFloat(first_no);
        float second=Float.parseFloat(second_no);
        
        float result=0;
        PrintWriter out = response.getWriter();
        if(operation.equals("add")==true)
        {
        	result=first+second;
        }
        else if(operation.equals("sub")==true)
        {
        	result=first-second;
        }
        else if(operation.equals("mul")==true)
        {
        	result=first*second;
        }
        else 
        {
        	if(second==0)
        	{
        		out.println("Exception");
        	}
        	else
        	{
        	result=first/second;
        	}
        }
        
        out.println (
                  
                  "<html> \n" +
                    "<head> \n" +
                     
                        
                      "<title> Result </title> \n" +
                    "</head> \n" +
                    "<body> <div align='center'> \n" +
                      "<style= \"font-size=\"12px\" color='black'\"" + "\">" +
                        "Result: " + result + " <br> " + 
                  
                    "</font></body> \n" +
                  "</html>" 
                );      
        }
}
