package com.Chat;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
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
 * Servlet implementation class Register
 */
@WebServlet(name = "Register", urlPatterns = { "/Register" })

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	File file;
	JSONParser parser;
	static ArrayList<String> a=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
 

    public static ArrayList<String>getLogin() {
		// TODO Auto-generated constructor stub
		if(a==null)
		a=new ArrayList<String>();
		
			return a;
		
	}
	
	 void populateJson(JSONObject message) {
	    	
			Object obj;
			try {

				JSONObject jsonObj = new JSONObject();
				jsonObj.put("message", message.get("message"));
				List<String> list = Files.readAllLines(Paths.get("D:\\Files\\Message.json"));
				list.add(list.size() - 2, ","+jsonObj.toJSONString());
				Files.write(Paths.get("D:\\Files\\Message.json"), list);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 void populateUser(String a,String b) {
	    	
			Object obj;
			try {
				List<String> list = Files.readAllLines(Paths.get("D:\\Files\\Users.json"));

				JSONObject jsonObj = new JSONObject();
				jsonObj.put("name", a);
				jsonObj.put("password", b);
				jsonObj.put("id", "id_name");
				list.add(list.size() - 2, ","+jsonObj.toJSONString());
				Files.write(Paths.get("D:\\Files\\Users.json"), list);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		getLogin();
		boolean exist = false;
		boolean password_exist = false;
		String user = request.getParameter("userName");
		System.out.println(user);
		 ServletContext context=getServletContext();
		String password = request.getParameter("password");
		try {
			parser=new JSONParser();
			File file = new File("D:\\Files\\Users.json");
			Object jsonObject = parser.parse(new FileReader(file));
			JSONObject obj = (JSONObject) jsonObject;
			String user_added="";
			JSONArray array = (JSONArray) obj.get("Users");
			for (int i = 0; i < array.size(); i++) {
				JSONObject use = (JSONObject) array.get(i);
				if (user.equals(use.get("name"))) {
					 {
						
						exist = true;
						break;
					}
				}

			}
			if (exist == true) {
				// notify
				response.getWriter().append("user exist ").append(request.getContextPath());

				
			}

			 else {
				// no such user
				HttpSession session = request.getSession();
				session.setAttribute("name", user);
				a.add(user);
				user_added="<div id='added'>"+user+"</div>";
				
				context.setAttribute("names_list", a);
				JSONObject obj2=new JSONObject();
				
				String message="user "+user+" has registered";
				obj2.put("message", message);
				populateJson(obj2);
				populateUser(user,password);
				response.getWriter().append("hiuser");

			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
