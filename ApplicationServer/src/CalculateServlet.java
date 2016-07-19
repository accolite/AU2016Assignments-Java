
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculateServlet")
public class CalculateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CalculateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// display();
         PrintWriter out = response.getWriter();
         //out.println("hello");
         String a = request.getParameter("no1");
         String b = request.getParameter("no2");
         String operation = request.getParameter("opt");                
         if(operation.equals("p"))
                 out.println(Integer.parseInt(a) + Integer.parseInt(b));
         else if(operation.equals("m"))
                out.println(Integer.parseInt(a) - Integer.parseInt(b));
         else if(operation.equals("mul"))
             out.println(Integer.parseInt(a) * Integer.parseInt(b));
         else if(operation.equals("d"))
             out.println(Double.parseDouble(a) / Double.parseDouble(b));
	}

}
