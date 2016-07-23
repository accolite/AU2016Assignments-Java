/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 23, 2016

*

*  @author :: Udit Mehata

* ***************************************************************************

*/
package com.accolite.jersyDemo;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@Path("messages")
public class WebServices {

	public static void AddMessage(String name, int mid, String Content, String Owner) throws ParseException {
		try {
			JSONParser parser = new JSONParser();
			String ret = "";
			Object obj = parser.parse(new FileReader(name));

			JSONObject jsonObject = (JSONObject) obj;

			JSONArray slideContent = (JSONArray) jsonObject.get("messagelist");

			JSONObject curr = new JSONObject();
			curr.put("mid", mid + "");
			curr.put("content", Content);
			curr.put("owner", Owner);
			curr.put("likes", new JSONArray());
			curr.put("comments", new JSONArray());
			slideContent.add(curr);

			FileWriter file;
			file = new FileWriter(name);
			file.write(jsonObject.toJSONString());
			file.flush();
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void AddLikes(String name, int mid, String liker) throws ParseException {
		try {
			JSONParser parser = new JSONParser();
			String ret = "";
			Object obj = parser.parse(new FileReader(name));

			JSONObject jsonObject = (JSONObject) obj;
			JSONArray slideContent = (JSONArray) jsonObject.get("messagelist");
			Iterator i = slideContent.iterator();
			while (i.hasNext()) {
				JSONObject slide = (JSONObject) i.next();
				String mid1 = (String) slide.get("mid");
				if (Integer.parseInt(mid1) == mid) {
					JSONArray likes = (JSONArray) slide.get("likes");
					
					if( !likes.contains( liker ))
						likes.add(liker);

					FileWriter file;
					file = new FileWriter(name);
					file.write(jsonObject.toJSONString());
					file.flush();
					file.close();
					return;
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String GetLikes(String name, int id) {
		JSONParser parser = new JSONParser();
		String ret = "";
		try {
			Object obj = parser.parse(new FileReader(name));

			JSONObject jsonObject = (JSONObject) obj;

			JSONArray slideContent = (JSONArray) jsonObject.get("messagelist");
			Iterator i = slideContent.iterator();

			while (i.hasNext()) {
				JSONObject slide = (JSONObject) i.next();
				String mid = (String) slide.get("mid");
				if (Integer.parseInt(mid) == id) {
					JSONArray likes = (JSONArray) slide.get("likes");
					Iterator l = likes.iterator();
					while (l.hasNext()) {
						ret += "<u>LIKED BY :</u> " + l.next() + "<br> ";
					}
					return ret;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String GetComments(String name, int id) {
		JSONParser parser = new JSONParser();
		String ret = "";
		try {

			Object obj = parser.parse(new FileReader(name));

			JSONObject jsonObject = (JSONObject) obj;

			JSONArray slideContent = (JSONArray) jsonObject.get("messagelist");
			Iterator i = slideContent.iterator();

			while (i.hasNext()) {
				JSONObject slide = (JSONObject) i.next();
				String mid = (String) slide.get("mid");
				if (Integer.parseInt(mid) == id) {
					JSONArray comments = (JSONArray) slide.get("comments");
					Iterator c = comments.iterator();
					while (c.hasNext()) {
						JSONObject commdetails = (JSONObject) c.next();
						String comm = (String) commdetails.get("comment");
						ret += "<u>COMMENT :</u>" + comm + " <br>";
						String commowner = (String) commdetails.get("owner");
						ret += "<u>POSTED BY : </u>" + commowner + " <br><br>";
					}
					return ret;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static void addComment(String name, int mid, String comment, String commenter) throws ParseException {
		try {
			JSONParser parser = new JSONParser();
			String ret = "";
			Object obj = parser.parse(new FileReader(name));

			JSONObject jsonObject = (JSONObject) obj;
			JSONArray slideContent = (JSONArray) jsonObject.get("messagelist");
			Iterator i = slideContent.iterator();
			while (i.hasNext()) {
				JSONObject slide = (JSONObject) i.next();
				String mid1 = (String) slide.get("mid");
				if (Integer.parseInt(mid1) == mid) {

					JSONArray comments = (JSONArray) slide.get("comments");
					Iterator c = comments.iterator();

					JSONObject newcomment = new JSONObject();
					newcomment.put("owner", commenter + "");
					newcomment.put("comment", comment + "");

					comments.add(newcomment);

					FileWriter file;
					file = new FileWriter(name);
					file.write(jsonObject.toJSONString());
					file.flush();
					file.close();
					return;
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Parsemy JSON.
	 *
	 * @param name the name
	 * @return the string
	 */
	public static String parsemyJSON(String name) {
		JSONParser parser = new JSONParser();
		String ret = "";
		String msg = "";
		try {

			Object obj = parser.parse(new FileReader(name));

			JSONObject jsonObject = (JSONObject) obj;

			JSONArray slideContent = (JSONArray) jsonObject.get("messagelist");
			Iterator i = slideContent.iterator();
			while (i.hasNext()) {
				JSONObject slide = (JSONObject) i.next();
				String content = (String) slide.get("content");
				ret += "<br> <b>MESSAGE</b> - : " + content + "<br> ";
				String mid = (String) slide.get("mid");
				ret += "<b>ID</b> : " + mid + "<br> ";
				String owner = (String) slide.get("owner");
				ret += "<b>BY:</b> " + owner + " <br><b> LIKES:</b> <br>";
				JSONArray likes = (JSONArray) slide.get("likes");
				Iterator l = likes.iterator();
				while (l.hasNext()) {
					ret += " " + l.next() + " <i>LIKED THIS POST</i><br> ";
				}
				ret += "<b>COMMENTS:</b> <br>";
				JSONArray comments = (JSONArray) slide.get("comments");
				Iterator c = comments.iterator();
				while (c.hasNext()) {
					JSONObject commdetails = (JSONObject) c.next();
					String comm = (String) commdetails.get("comment");
					ret += "<i>comment</i> '" + comm + "' ";
					String commowner = (String) commdetails.get("owner");
					ret += "<b>by</b> " + commowner + " <br>";
				}
				ret += "<br><hr>";
				msg = ret + msg;
				ret = "";

			}

			return msg;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static void writemyJSON(JSONObject obj) throws ParseException {
		try {

			JSONParser parser = new JSONParser();
			Object obj1 = parser.parse(new FileReader("d://data.json"));
			JSONObject jsonObject = (JSONObject) obj1;

			FileWriter file = new FileWriter("d://dbW.json");
			file.write(jsonObject.toJSONString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response printHello() {
		try {
			writemyJSON(new JSONObject());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return parsemyJSON("d://data.json");
		return Response.status(200).entity(parsemyJSON("d://data.json")).build();
	}

	@GET
	@Path("likes")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String likeretreive(@QueryParam(value = "mid") int var1) {
		return GetLikes("d://data.json", var1);
	}

	@POST
	@Path("addm")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String addmsg(@QueryParam(value = "mid") int var1, @QueryParam(value = "content") String content,
			@QueryParam(value = "owner") String owner) {
		try {
			AddMessage("d://data.json", var1, content, owner);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "New Data Posted on Server successfully";
	}

	@POST
	@Path("addl")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String addlikes(@QueryParam(value = "mid") int var1, @QueryParam(value = "liker") String liker) {
		try {
			AddLikes("d://data.json", var1, liker);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "New Data Posted on Server successfully";
	}

	@POST
	@Path("addc")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String addComments(@QueryParam(value = "mid") int var1, @QueryParam(value = "comment") String comment,
			@QueryParam(value = "owner") String by) {
		try {
			addComment("d://data.json", var1, comment, by);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "New Data Posted on Server successfully";
	}

	@GET
	@Path("comments")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String addmsg(@QueryParam(value = "mid") int var1) {
		return GetComments("d://data.json", var1);
	}

}
