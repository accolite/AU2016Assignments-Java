package com.Chat;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Servlet implementation class Login
 */
@WebServlet(name = "Login", urlPatterns = { "/Login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	File file;
	JSONParser parser;

	/**
	 * Default constructor.
	 */
	public Login() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean exist = false;
		boolean password_exist = false;
		String user = request.getParameter("userName");
System.out.println(user);
String password = request.getParameter("password");
		try {
			parser=new JSONParser();
			File file = new File("D:\\Files\\Users.json");
			Object jsonObject = parser.parse(new FileReader(file));
			JSONObject obj = (JSONObject) jsonObject;

			JSONArray array = (JSONArray) obj.get("Users");
			for (int i = 0; i < array.size(); i++) {
				JSONObject use = (JSONObject) array.get(i);
				if (user.equals(use.get("name"))) {
					if (password.equals(use.get("password"))) {
						HttpSession session = request.getSession();
						session.setAttribute("name", user);
						session.setAttribute("user_id",use.get("user_id"));
						exist = true;
						password_exist = true;
						break;
					}
				}

			}
			if (exist == true && password_exist == true) {
				// notify
				request.setAttribute("Message", "hiuser");
			//	request.getRequestDispatcher("/Message.jsp").forward(request, response);
				
				response.getWriter().append("hiuser");

			} else if (exist == true) {
				// wrong password
				response.getWriter().append("wrong password").append(request.getContextPath());

			} else {
				// no such user
				response.getWriter().append("no such user").append(request.getContextPath());

			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

