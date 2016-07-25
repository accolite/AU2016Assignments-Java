package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/Login")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
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
		ServletContext sc= request.getServletContext();
		String username = request.getParameter("username");
		List<String> allUsers = (List<String>) sc.getAttribute("usersList");
		if(allUsers == null){
			response.getWriter().append("No registered users!");
			return;
		}
		if(!allUsers.contains(username)){
			response.getWriter().append("Not a registered user!");
			return;
		}
		
		;
		
		
		
		if(this.getServletContext().getAttribute("usersLoggedin") == null){
			List<String> l = new ArrayList<>();
			l.add(request.getParameter("username"));
			this.getServletContext().setAttribute("usersLoggedin", l);
		} else {
			List<String> l = (List<String>) sc.getAttribute("usersLoggedin");
			if(l.contains(username))
				return;
			l.add(username);
			sc.setAttribute("usersloggedin", l);
		}
		request.getSession().setAttribute("user", request.getParameter("username"));
		response.sendRedirect("ChatApp.jsp");
	}

}
