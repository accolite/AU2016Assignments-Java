package com.myMessanger;

import com.myMessanger.Message;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@Path("messages")

public class Messenger {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage() {
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
				String time = (String) m.get("time");
				Sort sort = new Sort(message_json, time);
				System.out.println(sort.message);
				sortit.add(sort);
			}
			Collections.sort(sortit, new Compare());
			for (Sort s : sortit) {
				System.out.println(s.message + " " + s.time);
				all_msg += s.message + " at  " + s.time +"<br>";
			}
			System.out.println(all_msg);

			return all_msg;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "hello, world!";
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message saveMessage(Message message) {
		message.setMessage(message.getMessage());
		populateJson(message);
		return message;

	}

	@GET
	@Path("{id}")
	public Response getMessageById(@PathParam("id") String id) {

		return Response.status(200).entity("You need the message with id : " + id).build();
	}

	void populateJson(Message message) {
		Object obj;
		try {

			JSONObject jsonObj = new JSONObject();
			jsonObj.put("message", message.getMessage());
			jsonObj.put("message_id", message.getMessage_id());
			jsonObj.put("user_id", message.getUser_id());
			jsonObj.put("time", message.getTime());
			List<String> list = Files.readAllLines(Paths.get("D:\\Files\\Message.json"));
			list.add(list.size() - 2, ","+jsonObj.toJSONString());
			Files.write(Paths.get("D:\\Files\\Message.json"), list);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
