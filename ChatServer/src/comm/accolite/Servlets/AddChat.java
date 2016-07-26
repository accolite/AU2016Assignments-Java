package comm.accolite.Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddChat
 */
@WebServlet(asyncSupported = true, description = "adds the chat", urlPatterns = { "/AddChat" })
public class AddChat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddChat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("koljhb");
		getServletContext().setAttribute("chatarray",ChatArray.chats);
		System.out.println(request.getParameter("new_chat")+" "+request.getRequestURI());
		String message=request.getParameter("new_chat");
		for (int b = 0; b < RestrictedWords.restricted.size(); b++) {
			message = message.replaceAll( RestrictedWords.restricted.get(b).toString(), "");
		}
		
		Chat temp=new Chat(request.getSession().getAttribute("name").toString(),message);
		ChatArray.chats.add(temp);
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
