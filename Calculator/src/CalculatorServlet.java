import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.*;
import javax.servlet.http.HttpServletResponse;
 
public class CalculatorServlet extends HttpServlet
{
        
        public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
        {
                
                PrintWriter out = response.getWriter();
                //out.println("hello");
                String n1 = request.getParameter("no1");
                String n2 = request.getParameter("no2");
                String opt = request.getParameter("opt");                
               if(opt.equals("p"))
                        out.println(Integer.parseInt(n1) + Integer.parseInt(n2));
                else if(opt.equals("m"))
                       out.println(Integer.parseInt(n1) - Integer.parseInt(n2));
                else if(opt.equals("mul"))
                		out.println(Integer.parseInt(n1) * Integer.parseInt(n2));
                else if(opt.equals("d")) 
               		out.println(Integer.parseInt(n1) / Integer.parseInt(n2));
              			
        }
        
        public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
        {
                doPost(request,response);
        }
        
}