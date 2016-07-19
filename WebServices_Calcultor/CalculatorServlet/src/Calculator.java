

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class calculator2
 */
@WebServlet("/Calculator")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculator() {
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
		
		        try
		        {
		        response.setContentType("text/html");
		        PrintWriter out= response.getWriter();
		        int a1= Integer.parseInt(request.getParameter("n1"));
		        int a2= Integer.parseInt(request.getParameter("n2"));
		        String str=request.getParameter("oper");
		        if(str.equals("add"))
		        {
		            out.println("<h1>After Addition: </h1>"+(a1+a2));
		        }
		        else  if(str.equals("sub"))
		        {
		            out.println("<h1>After Substraction:</h1>"+(a1-a2));
		        }
		        else if(str.equals("mul"))
		        {
		            out.println("<h1>After Multiplication:</h1>"+(a1*a2));
		        }
		        else if(str.equals("div"))
		        {
		        	if(a2==0)
		        		out.println("<h1> Invalid !!Can't divide by zero</h1>");
		        	else 
		        	{
		        		     out.println("<h1> After Division is </h1>"+(a1/a2));
		        	}
		       }
		       else if(str.equals("sin"))
		        	out.println("<h1>After sin(x):</h1>"+Math.sin(a1));
		       else if(str.equals("log"))
		       {
		    	   if(a1<=0)
		    		   out.println("<h1> Invalid Input !!</h1>");
		    	   else 
		    		   out.println("<h1>After Log(x):</h1>"+Math.log(a1));
		       
		       }
		        else 
		        	out.println("<h1> After cos(x):</h1>"+Math.cos(a1));
		        }
		        catch(Exception e)
		        {

		        }
		    }
		
		//doGet(request, response);
	

}
