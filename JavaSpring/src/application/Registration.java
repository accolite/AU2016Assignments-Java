package application;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		request.getSession().setAttribute("user", request.getParameter("username"));
		if(this.getServletContext().getAttribute("usersList") == null){
			Map<String,String> l = new HashMap<>();
			l.put(username,password);
			this.getServletContext().setAttribute("usersList", l);
		} else {
			Map<String,String> usersList = (Map<String,String>) this.getServletContext().getAttribute("usersList");
			if(!usersList.containsKey(username))
				usersList.put(username,password);
			this.getServletContext().setAttribute("usersList",usersList);
		}
		response.sendRedirect("Login.jsp");
	}

}
