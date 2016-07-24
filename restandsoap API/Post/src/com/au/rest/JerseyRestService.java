package com.au.rest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.au.rest.Parsing;

@Path("jsonfb")
public class JerseyRestService {
 
	
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public String getMessage(){
//		Messages msg = new Messages();
//		msg.setValue("myname");
//		msg.setId("23");
//		return msg.getValue();
//	}
//	
		public String forParse(){
    		Parsing jp=new Parsing();
    		return null;
    	}
		
		@GET
		@Path("getmsg/all")
		public Response getAll(){
			Parsing jParser=new Parsing();
    		JSONArray jArray=jParser.forParse();
    		Iterator<JSONObject> it = jArray.iterator();
    		String msg="";
    		while (it.hasNext()) {
    			JSONObject obj=(JSONObject)it.next();
    			msg+=" "+obj.get("id")+" :" +obj.get("owner")+"<br> "+obj.get("content")+"<br><br>";
    			
    		}
			return Response.status(200).entity(msg).build();
		}
		
    	@GET
    	@Path("getmsg/{id}")
    	//@Consumes(MediaType.TEXT_PLAIN)
    	//@Produces(MediaType.TEXT_PLAIN)
    	public Response getMessage(@PathParam("id") String id) {
    		JSONObject jObject=getMessageJson(id);
    		
    		return Response.status(200).entity("Message with id : "+id+" is<br> "+jObject.get("content")+" --By: "+jObject.get("owner")+"<br>").build();
    	}
    	@GET
    	@Path("getlke/{id}")
    	public Response getlikes(@PathParam("id") String id) {
    		JSONObject jObject=getMessageJson(id);
    		ArrayList<String> persons=new ArrayList<>();
    		JSONArray likelist=(JSONArray)jObject.get("likes");
    		Iterator<String> it = likelist.iterator();
    		String list="";
    		while (it.hasNext()) {
    			String name=(String)it.next();
    			list+=name+"<br><br>";
    			persons.add(name);
    		}
    		return Response.status(200).entity(list).build();
    	}
    	@GET
    	@Path("getcomments/{id}")
    	public Response getcomment(@PathParam("id") String id) {
    		JSONObject jo=getMessageJson(id);
    		//ArrayList<String> persons=new ArrayList<>();
    		JSONArray commentlist=(JSONArray)jo.get("comments");
    		Iterator<JSONObject> it = commentlist.iterator();
    		String list="";
    		while (it.hasNext()) {
    			JSONObject comment=(JSONObject)it.next();
    			//String name=(String)it.next();
    			list+=comment.get("comment")+"\n- "+comment.get("owner")+"<br>";
    			//persons.add(name);
    		}
    		return Response.status(200).entity(list).build();
    	}
    	
    	
    	@GET
    	@Path("addmsg/{id}/{name}/{content}")
    	public Response addmessageById(@PathParam("id") String id,@PathParam("name") String name,@PathParam("content") String content){
    			JSONParser parser = new JSONParser();
    		
    	      try{
    	         
    	         Object obj = parser.parse(new FileReader("C:/Users/Shailendra Kumar/Desktop/data.json"));
    	         JSONObject jsonObject = (JSONObject) obj;
    	         JSONArray jArray = (JSONArray)jsonObject.get("messagelist");
    	         JSONObject jsonObjectnew = new JSONObject();
    	         JSONArray nArray = new JSONArray();
    	         jsonObjectnew.put("id",id);
    	         jsonObjectnew.put("content",content);
    	         jsonObjectnew.put("owner",name);
    	         jsonObjectnew.put("comments",new JSONArray());
    	         jsonObjectnew.put("likes", nArray);
    	         jArray.add(jsonObjectnew);
    	         //JSONArray ja=(JSONArray)jobj;
    	         

    	     		FileWriter file = new FileWriter("C:/Users/Shailendra Kumar/Desktop/data.json");
    	     		file.write(jsonObject.toJSONString());
    	     		file.flush();
    	     		file.close();
    	     		return Response.status(200).entity("Added Message").build();

    	     	} catch (IOException e) {
    	     		return Response.status(200).entity("Failed").build();
    	     	}
    	         
    	      catch(Exception pe){
    	    	  return Response.status(200).entity("Failed").build();
    	      }
    	      
    		}

    	
    	
    	@GET
    	@Path("addlike/{id}/{name}")
    	
    	public Response addlikesById(@PathParam("id") String id, @PathParam("name") String name ) throws FileNotFoundException, IOException, ParseException {
  		
    		
    		JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("C:/Users/Shailendra Kumar/Desktop/data.json"));

			JSONObject jObject = (JSONObject) obj;

			JSONArray jArray = (JSONArray) jObject.get("messagelist");
			Iterator i = jArray.iterator();
			while (i.hasNext()) {
				JSONObject slide = (JSONObject) i.next();
				String mid1 = (String) slide.get("id");
				if (mid1.equals(id)) {
					JSONArray likes = (JSONArray) slide.get("likes");
					
					if( !likes.contains( name ))
						likes.add(name);

			FileWriter file;
			file = new FileWriter("C:/Users/Shailendra Kumar/Desktop/data.json");
			file.write(jObject.toJSONString());
			file.flush();
			file.close();
				}
			}
    		return Response.status(200).entity("Like Added").build();
    	
    }
    
    	@GET
    	@Path("addcomment/{id}/{name}/{comment}")
    	
    	public Response addCommentById(@PathParam("id") String id, @PathParam("name") String name,@PathParam("comment") String comment ) throws FileNotFoundException, IOException, ParseException {
  		

    		JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("C:/Users/Shailendra Kumar/Desktop/data.json"));

			JSONObject jObject = (JSONObject) obj;

			JSONArray jArray = (JSONArray) jObject.get("messagelist");
			Iterator i = jArray.iterator();
			while (i.hasNext()) {
				JSONObject slide = (JSONObject) i.next();
				String mid1 = (String) slide.get("id");
				if (mid1.equals(id)) {
					JSONArray cmmentArray = (JSONArray) slide.get("comments");
					JSONObject nwcommnt = new JSONObject();
					nwcommnt.put("owner", name);
					nwcommnt.put("comment", comment);
					cmmentArray.add(nwcommnt);

			FileWriter file;
			file = new FileWriter("C:/Users/Shailendra Kumar/Desktop/data.json");
			file.write(jObject.toJSONString());
			file.flush();
			file.close();
				}
			}
    		return Response.status(200).entity("Comment Added").build();
    	
    }	
    	
    	public JSONObject getMessageJson(String id){
    		Parsing jParser=new Parsing();
    		JSONArray jArray=jParser.forParse();
    		Iterator<JSONObject> it = jArray.iterator();
    		while (it.hasNext()) {
    			JSONObject obj=(JSONObject)it.next();
    			if(obj.get("id").equals(id)){
    				return obj;
    			}
    		}
    		return null;
    		
    	}
    	


}
