package comm.accolite.Servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPBinding;

/**
 * Servlet implementation class Login
 */
@WebServlet(asyncSupported = true, description = "login servelet", urlPatterns = { "/Login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String pass=request.getParameter("password");
//		HashMap<String, String> map=getServletContext().getAttribute("users");
		if(UsersInfo.map.get(name).equals(pass)==false)
		{
			response.getWriter().append("Invalid Login.");
		}
		else
		{
			
			if(ActiveUsers.map.get(name)!=null&&ActiveUsers.map.get(name).equals(pass)==true)
			{
				//you are active already
				response.sendRedirect("chat.html");
			}
			else
			{
				//new user logged in
	
				ActiveUsers.map.put(name, pass);
				HttpSession sess=request.getSession(true);
				sess.setAttribute("name",name);
				sess.setAttribute("pass", pass);
				
				response.sendRedirect("chat.html");
			}
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
