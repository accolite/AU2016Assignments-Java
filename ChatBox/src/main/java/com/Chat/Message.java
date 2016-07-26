package com.Chat;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.myMessanger.Sort;

/**
 * Servlet implementation class Message
 */
@WebServlet(name = "Message", urlPatterns = { "/Message" })

public class Message extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Message() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    void populateJson(JSONObject message) {
    	
		Object obj;
		try {

			JSONObject jsonObj = new JSONObject();
			jsonObj.put("name", message.get("name"));
			jsonObj.put("message", message.get("message"));
			jsonObj.put("message_id", message.get("message_id"));
			jsonObj.put("user_id", message.get("user_id"));
			jsonObj.put("time", message.get("time"));
			List<String> list = Files.readAllLines(Paths.get("D:\\Files\\Message.json"));
			list.add(list.size() - 2, ","+jsonObj.toJSONString());
			Files.write(Paths.get("D:\\Files\\Message.json"), list);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONParser parser = new JSONParser();
		String all_msg = "";
		try {
			File file = new File("D:\\Files\\Message.json");
			Object obj = parser.parse(new FileReader(file));
			ArrayList<Sort> sortit = new ArrayList<Sort>();

			JSONObject jsonObject = (JSONObject) obj;

			JSONArray messages = (JSONArray) jsonObject.get("Message");
			for (Object object : messages) {
				JSONObject m = (JSONObject) object;
				String message_json = (String) m.get("message");
				String time = (String) m.get("name");
			
			
				all_msg += time+" :"+message_json+"<br>";
			}
			System.out.println(all_msg);
			response.getWriter().append(all_msg).append(request.getContextPath());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			JSONObject obj=(JSONObject)new JSONParser().parse(request.getParameter("objarray"));
			populateJson(obj);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
