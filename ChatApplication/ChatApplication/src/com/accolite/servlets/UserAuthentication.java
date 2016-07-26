package com.accolite.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.accolite.java.ActiveUsers;
import com.accolite.java.Message;
import com.accolite.java.MessageList;
import com.accolite.java.User;
import com.accolite.java.UserList;

/**
 * Servlet implementation class UserAuthentication
 */
@WebServlet("/UserAuthentication")
public class UserAuthentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAuthentication() {
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
		
		
		String username=request.getParameter("txtUsername");
		String password=request.getParameter("txtPassword");
		
		request.getSession().setAttribute("User", username);
		
		UserList lst=new UserList();
		ActiveUsers actList=new ActiveUsers();
		MessageList msgList=new MessageList();
		lst= (UserList) getServletConfig().getServletContext().getAttribute("USERS");
		msgList=(MessageList) getServletConfig().getServletContext().getAttribute("MESSAGES");
		int j=0;
		for(int i=0;i<lst.getUserLst().size();i++)
		{
			String usr=lst.getUserLst().get(i).getUsername();
			String pwd=lst.getUserLst().get(i).getPassword();
			if(username.equals(usr) && password.equals(pwd))
			{
				j=1;
				actList=(ActiveUsers) getServletConfig().getServletContext().getAttribute("ACTIVE_USERS");
				//System.out.println(actList);
				User user=new User();
				user.setPassword(password);
				user.setUsername(username);
				actList.getActiveUsers().add(user);
				getServletConfig().getServletContext().setAttribute("ACTIVE_USERS",actList);
				
				Message msg=new Message();
				msg.setMessage("Logged in");
				msg.setUsername(username);
				msgList.getMessageLst().add(msg);
				getServletConfig().getServletContext().setAttribute("MESSAGES",msgList);
				response.sendRedirect("ChatInterface.jsp?username="+username);
			}
			
		}
		if(j==0)
			response.sendRedirect("Login.jsp?msg='Invalid Username and Password'");
		
	}

}
