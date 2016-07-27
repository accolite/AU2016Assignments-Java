package application;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Chat
 */
@WebServlet("/Chat")
public class Chat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append((String)this.getServletContext().getAttribute("chatString"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String username = request.getParameter("username");
		String username = (String) request.getSession().getAttribute("user");
		//String msg = (String) request.getAttribute("msg");
		String msg = (String) request.getParameter("msg");
		String newmsg = username + " : " + msg + "<br>";
		if(this.getServletContext().getAttribute("chatString")==null){
			this.getServletContext().setAttribute("chatString","");
		}
		this.getServletContext().setAttribute("chatString",this.getServletContext().getAttribute("chatString")+newmsg);
		response.getWriter().append((String)this.getServletContext().getAttribute("chatString"));
	}

}
