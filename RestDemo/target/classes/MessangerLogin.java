package main.resources;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import main.resources.MessageLogin;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("messages")
public class MessangerLogin {
	
	@GET
	@Path("list")
	public List<MessageLogin> retrieve() throws JsonParseException, JsonMappingException, IOException{
		  ObjectMapper mapper = new ObjectMapper();
		  List<MessageLogin> messages = null;
		  messages = mapper.readValue(new File("D:\\file.json"), new TypeReference<List<MessageLogin>>(){});
		  System.out.println(messages.toString());
		  return messages;
		 }
	
	@POST
	@Path("post")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void store(List<MessageLogin> messages) throws JsonGenerationException, JsonMappingException, IOException{
		//   Message m=new Message();
		   ObjectMapper mapper = new ObjectMapper();
		   mapper.writeValue(new File("D:\\file.json"), messages);
	}
	
	@POST
	@Path("addMsg")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addMessage(MessageLogin message) throws JsonGenerationException, JsonMappingException, IOException{
		   ObjectMapper mapper = new ObjectMapper();
		   List<MessageLogin> messages = null;
		   messages = mapper.readValue(new File("D:\\file.json"), new TypeReference<List<MessageLogin>>(){});
		   messages.add(message);
		   mapper.writeValue(new File("D:\\file.json"),messages);
	}
	
	@POST
	@Path("addLike/{msgid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addLike(@PathParam("msgid") String id,Comments comment) throws JsonGenerationException, JsonMappingException, IOException{
		   ObjectMapper mapper = new ObjectMapper();
		   List<MessageLogin> messages = null;
		   messages = mapper.readValue(new File("D:\\file.json"), new TypeReference<List<MessageLogin>>(){});
		   for(MessageLogin m:messages)
		   {
			   if(id.equals(m.getMsgid()))
			   {
				   int newLikeCount=Integer.parseInt(m.getLikes())+1;
				   m.setLikes(Integer.toString(newLikeCount));
				   break;
			   }
		   }
		   mapper.writeValue(new File("D:\\file.json"),messages);
	}
	
	@POST
	@Path("addComment/{msgid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addComment(@PathParam("msgid") String id,Comments comment) throws JsonGenerationException, JsonMappingException, IOException{
		   ObjectMapper mapper = new ObjectMapper();
		   List<MessageLogin> messages = null;
		   messages = mapper.readValue(new File("D:\\file.json"), new TypeReference<List<MessageLogin>>(){});
		   for(MessageLogin m:messages)
		   {
			   if(id.equals(m.getMsgid()))
			   {
				   List<Comments> comments=m.getComments();
				   comments.add(comment);
				   m.setComments(comments);
			   }
		   }
		   mapper.writeValue(new File("D:\\file.json"),messages);
	}
	
	@GET
	@Path("listLikes/{msgid}")
	public String listLikes(@PathParam("msgid") String id) throws JsonParseException, JsonMappingException, IOException{
		  ObjectMapper mapper = new ObjectMapper();
		  List<MessageLogin> messages = null;
		  messages = mapper.readValue(new File("D:\\file.json"), new TypeReference<List<MessageLogin>>(){});
		  String likeCount=null;
		  for(MessageLogin m:messages)
		   {
			   if(id.equals(m.getMsgid()))
			   {
				   likeCount=m.getLikes();
			   }
		   }
		  return likeCount;
		 }
	
	@GET
	@Path("listComments/{msgid}")
	public List<Comments> listComments(@PathParam("msgid") String id) throws JsonParseException, JsonMappingException, IOException{
		  ObjectMapper mapper = new ObjectMapper();
		  List<MessageLogin> messages = null;
		  messages = mapper.readValue(new File("D:\\file.json"), new TypeReference<List<MessageLogin>>(){});
		  List<Comments> comments=null;
		  for(MessageLogin m:messages)
		   {
			   if(id.equals(m.getMsgid()))
			   {
				  comments=m.getComments();
			   }
		   }
		  return comments;
		 }
	
	@GET
	@Path("viewMessages")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MessageLogin> listMessages() throws JsonParseException, JsonMappingException, IOException{
		  ObjectMapper mapper = new ObjectMapper();
		  List<MessageLogin> messages = null;
		  messages = mapper.readValue(new File("D:\\file.json"), new TypeReference<List<MessageLogin>>(){});
		  int msgCount=messages.size();
		  System.out.println(msgCount);
		  System.out.println();
		  List<MessageLogin> revMsgList=new ArrayList<MessageLogin>();
		  for(int i=msgCount-1;i>=0;i--)
		  {
			  MessageLogin m=messages.get(i);
			  System.out.println(m.toString()+i);
			  revMsgList.add(m);
		  }
		  return revMsgList;
	}
	
	
	}