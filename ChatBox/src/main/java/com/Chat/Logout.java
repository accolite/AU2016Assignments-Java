package com.Chat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class Logout
 */
@WebServlet(name = "Logout", urlPatterns = { "/Logout" })

public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }
    void populateJson(String message) {

		Object obj;
		try {

			JSONObject jsonObj = new JSONObject();
			jsonObj.put("message",message);
			List<String> list = Files.readAllLines(Paths.get("D:\\Files\\Message.json"));
			list.add(list.size() - 2, "," + jsonObj.toJSONString());
			Files.write(Paths.get("D:\\Files\\Message.json"), list);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext context=getServletContext();
		System.out.println("hello");
		
		String user=(String) request.getParameter("user");
		System.out.println(user);
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println(Login.a);
		HttpSession session = request.getSession(true);
		Login.a.remove(Login.a.indexOf(user));
		String s1="user "+user+" has left";
		populateJson(s1);
		session.invalidate();

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
