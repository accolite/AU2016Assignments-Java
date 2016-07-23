package com.accolite.Messanger.messanger;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.accolite.Messanger.messanger.Message;

@Path("messages")

public class Messanger {
	/*
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage() {
		return "hello, world!";
	}
	*/

//	@GET
//	@Path("{id}")
//	public Response getMessageById2(@PathParam("id") String id) {
//		
//		return Response.status(200).entity("You need the message with id2: " + dojson()).build();
//	}
	public String dojson(){
		JsonParserc jp=new JsonParserc();
		return null;
	}
	@GET
	@Path("getallmessages")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Response getallmessages() {
		String allmessages="";
		JsonParserc jp=new JsonParserc();
		JSONArray ja=jp.dojson();
		Iterator<JSONObject> it = ja.iterator();
		while (it.hasNext()) {
			String st="";
			JSONObject obj=(JSONObject)it.next();
			st+="Message id:"+obj.get("id")+"</br>";
			st+=obj.get("content")+"</br>";
			st+="posted by : "+obj.get("owner")+"</br>";
			
			if(obj.containsKey("comments")){
				st+="comments : "+"</br>";
				st+="hascomments</br>";
				JSONArray comm=(JSONArray)obj.get("comments");
				Iterator<JSONObject> it2 = comm.iterator();
				while (it2.hasNext()) {
					JSONObject comment1=(JSONObject)it2.next();
					st+="comment :"+comment1.get("comment")+"</br>";
					st+="commented by :"+comment1.get("owner")+"</br>";
				}
			}
			if(obj.containsKey("likes")){
				st+="liked by </br>";
				ArrayList<String> likel=(JSONArray)obj.get("likes");
				for (int i = 0; i < likel.size(); i++) {
					st+=likel.get(i)+"</br>";
				}
			}
			
			st+="</br>";
			allmessages=st+allmessages;
		}
		return Response.status(200).entity(allmessages).build();
	}
	@GET
	@Path("getmessagebyid")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Response getMessageById(@QueryParam(value="id") String id) {
		JSONObject jo=getMessageByIdJson(id);
		return Response.status(200).entity("You need the message with id1 : "+jo.get("content")).build();
	}
	@GET
	@Path("getlikes/{id}")
	public Response getlikesById(@PathParam("id") String id) {
		JSONObject jo=getMessageByIdJson(id);
		ArrayList<String> persons=new ArrayList<>();
		String list="";
		if(jo.containsKey("likes")){
			JSONArray likearr=(JSONArray)jo.get("likes");
			Iterator<String> it = likearr.iterator();
			while (it.hasNext()) {
				String name=(String)it.next();
				list+=name+"</br>";
				persons.add(name);
			}
			//return Response.status(200).entity(list).build();
		}
		return Response.status(200).entity(list).build();
	}
	@GET
	@Path("getcomments/{id}")
	public Response getcommentById(@PathParam("id") String id) {
		JSONObject jo=getMessageByIdJson(id);
		if(jo==null){
			return Response.status(200).entity("No Comments").build();
		}
		//ArrayList<String> persons=new ArrayList<>();
		String list="";
		if(jo.containsKey("comments")){
			JSONArray likearr=(JSONArray)jo.get("comments");
			Iterator<JSONObject> it = likearr.iterator();
			while (it.hasNext()) {
				JSONObject comment=(JSONObject)it.next();
				//String name=(String)it.next();
				list+=comment.get("comment")+"</br>- "+comment.get("owner")+"</br></br>";
				//persons.add(name);
			}
		}
		return Response.status(200).entity(list).build();
	}
	
	
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("addmessage")
	public Response addmessageById(@QueryParam(value="id") String id, @QueryParam(value="content") String message,@QueryParam(value="owner") String owner ) {
			JSONParser parser = new JSONParser();
		//String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
	      try{
	         //Object obj = parser.parse(s);
	         Object obj = parser.parse(new FileReader("d:\\db.json"));
	         JSONObject jsonObject = (JSONObject) obj;
	         JSONArray ja = (JSONArray)jsonObject.get("messagelist");
	         JSONObject jsonObjectn = new JSONObject();
	         jsonObjectn.put("id",id);
	         jsonObjectn.put("content","hi");
	         jsonObjectn.put("owner","nishant");
	         ja.add(jsonObjectn);
	         //JSONArray ja=(JSONArray)jobj;
	         try {

	     		FileWriter file = new FileWriter("d:\\db.json");
	     		file.write(jsonObject.toJSONString());
	     		file.flush();
	     		file.close();
	     		return Response.status(200).entity("Success").build();

	     	} catch (IOException e) {
	     		return Response.status(200).entity("Failed").build();
	     	}
	         //System.out.println();
	         
	      }catch(Exception pe){
	    	  return Response.status(200).entity("Failed").build();
	      }
	      
	      /*
		JSONObject jo=getMessageByIdJson(id);
		ArrayList<String> persons=new ArrayList<>();
		JSONArray likearr=(JSONArray)jo.get("likes");
		if(!likearr.contains(name)){
			likearr.add(name);
		}
		try {

			FileWriter file = new FileWriter("c:\\test.json");
			file.write(obj.toJSONString());
			file.flush();
			file.close();
			return Response.status(200).entity("Success").build();
			
		} catch (IOException e) {
			e.printStackTrace();
			return Response.status(200).entity("Failed").build();
		}
		*/

		
	}
	
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("addlikebyid")
	public Response addlikeById(@QueryParam(value="id") String id,@QueryParam(value="owner") String owner ) {
		JSONParser parser = new JSONParser();
		//String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
	      try{
	         //Object obj = parser.parse(s);
	         Object obj = parser.parse(new FileReader("d:\\db.json"));
	         JSONObject jsonObject = (JSONObject) obj;
	         JSONArray ja = (JSONArray)jsonObject.get("messagelist");
	         Iterator<JSONObject> it = ja.iterator();
	 			while (it.hasNext()) {
	 			JSONObject jobj=(JSONObject)it.next();
	 			if(jobj.get("id").equals(id)){
	 				if(jobj.containsKey("likes")){
	 					JSONArray oja=(JSONArray)jobj.get("likes");
	 					oja.add(owner);
	 				}
	 				else{
	 					//JSONObject addobj=new JSONObject();
	 					JSONArray oja=new JSONArray();
	 					oja.add(owner);
	 					jobj.put("likes",oja);
	 					//jobj.put(key, value)
	 				}
	 			}
	 		}
	 			FileWriter file = new FileWriter("d:\\db.json");
	     		file.write(jsonObject.toJSONString());
	     		file.flush();
	     		file.close();
	     		return Response.status(200).entity("Success").build();
	 			
	         /*
	         JSONObject jsonObjectn = new JSONObject();
	         jsonObjectn.put("id",id);
	         jsonObjectn.put("content","hi");
	         jsonObjectn.put("owner","nishant");
	         */
	         //ja.add(jsonObjectn);
	         //JSONArray ja=(JSONArray)jobj;
	         
	      }catch(Exception pe){
	    	  return Response.status(200).entity("Failed").build();
	      }
	}
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("addcommentbyid")
	public Response addcommentById(@QueryParam(value="id") String id,@QueryParam(value="content") String msg,@QueryParam(value="owner") String owner ) {
		JSONParser parser = new JSONParser();
		//String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
	      try{
	         //Object obj = parser.parse(s);
	         Object obj = parser.parse(new FileReader("d:\\db.json"));
	         JSONObject jsonObject = (JSONObject) obj;
	         JSONArray ja = (JSONArray)jsonObject.get("messagelist");
	         Iterator<JSONObject> it = ja.iterator();
	 			while (it.hasNext()) {
	 			JSONObject jobj=(JSONObject)it.next();
	 			if(jobj.get("id").equals(id)){
	 				if(jobj.containsKey("comments")){
	 					JSONArray oja=(JSONArray)jobj.get("comments");
	 					JSONObject comjo=new JSONObject();
	 					comjo.put("owner",owner);
	 					comjo.put("comment",msg);
	 					oja.add(comjo);
	 					
	 				}
	 				else{
	 					//JSONObject addobj=new JSONObject();
	 					JSONArray oja=new JSONArray();
	 					JSONObject comjo=new JSONObject();
	 					comjo.put("owner",owner);
	 					comjo.put("comment",msg);
	 					oja.add(comjo);
	 					jobj.put("comments",oja);
	 					//jobj.put(key, value)
	 				}
	 			}
	 		}
	 			FileWriter file = new FileWriter("d:\\db.json");
	     		file.write(jsonObject.toJSONString());
	     		file.flush();
	     		file.close();
	     		return Response.status(200).entity("Success").build();
	 			
	         /*
	         JSONObject jsonObjectn = new JSONObject();
	         jsonObjectn.put("id",id);
	         jsonObjectn.put("content","hi");
	         jsonObjectn.put("owner","nishant");
	         */
	         //ja.add(jsonObjectn);
	         //JSONArray ja=(JSONArray)jobj;
	         
	      }catch(Exception pe){
	    	  return Response.status(200).entity("Failed").build();
	      }
	}
	/*
	@GET
	@Path("addlike")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addlikesById(@QueryParam(value="id") String id, @QueryParam(value="name") String name ) {
		JSONObject jo=getMessageByIdJson(id);
		ArrayList<String> persons=new ArrayList<>();
		JSONArray likearr=(JSONArray)jo.get("likes");
		if(!likearr.contains(name)){
			likearr.add(name);
		}
		try {

			FileWriter file = new FileWriter("c:\\test.json");
			file.write(obj.toJSONString());
			file.flush();
			file.close();
			return Response.status(200).entity("Success").build();
			
		} catch (IOException e) {
			e.printStackTrace();
			return Response.status(200).entity("Failed").build();
		}

		
	}
	*/
	public JSONObject getMessageByIdJson(String id){
		JsonParserc jp=new JsonParserc();
		JSONArray ja=jp.dojson();
		Iterator<JSONObject> it = ja.iterator();
		while (it.hasNext()) {
			JSONObject obj=(JSONObject)it.next();
			if(obj.get("id").equals(id)){
				return obj;
			}
		}
		return null;
		
	}
	

}
