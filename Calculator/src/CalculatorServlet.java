import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet {

 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String num1 = request.getParameter("no1");
        String num2 = request.getParameter("no2");
        String option = request.getParameter("opt");                
        if(option.equals("plus"))
                out.println((Integer.parseInt(num1) + Integer.parseInt(num2)));
         if(option.equals("minus"))
               out.println((Integer.parseInt(num1) - Integer.parseInt(num2)));
        else if(option.equals("mul"))
        	out.println((Integer.parseInt(num1) * Integer.parseInt(num2)));
        else if(option.equals("div"))
        {
        	
        	try
        	{
        	out.println(Integer.parseInt(num1) /Integer.parseInt(num2));
        	}
        	catch(Exception e)
        	{
        		out.println("Invalid Choice");
        	}
        }
        	
 }
 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	  doPost(request,response);
	 }

}