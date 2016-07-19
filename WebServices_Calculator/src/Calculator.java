

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculator
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
		PrintWriter out = response.getWriter();
        //out.println("hello");
        String n1 = request.getParameter("no1");
        String n2 = request.getParameter("no2");
        String opt = request.getParameter("opt");                
        if(opt.equals("p"))
                out.println(Double.parseDouble(n1) + Double.parseDouble(n2));
        else if(opt.equals("m"))
               out.println(Double.parseDouble(n1) - Double.parseDouble(n2));
        else if(opt.equals("mul"))
            out.println(Double.parseDouble(n1) * Double.parseDouble(n2));
        else if(opt.equals("d"))
            out.println(Double.parseDouble(n1) /  Double.parseDouble(n2));
        out.println("\n<a href = \"http://localhost:8080/AppServers/index.html\"> Back </a>" );
		
	

}
}
