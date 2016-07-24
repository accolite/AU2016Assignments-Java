package pkg;

import java.io.*;
import java.util.*;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Path("gag")
public class Main {

	List<Msg> msg = new ArrayList<>();
	
	ObjectMapper mapper;
	@GET
	@Path("get_msg")
	@Produces(MediaType.APPLICATION_JSON)
	public Msg[] getMessages(){
		msg = retrieve();
		return msg.toArray(new Msg[msg.size()]);
	}
	
	@Path("comments/{msgid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Cmt[] getComments(@PathParam("msgid") String msgid){
		msg = this.retrieve();
		for(Msg message: msg){
			if(message.getMsgid().equals(msgid))
				return message.getComments().toArray(new Cmt[message.getComments().size()]);
		}
		return new Cmt[1];
	}
	
	@Path("likes/{msgid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Like[] getLikes(@PathParam("msgid") String msgid){
		msg = this.retrieve();
		for(Msg message: msg){
			if(message.getMsgid().equals(msgid))
				return message.getLikes().toArray(new Like[message.getLikes().size()]);
		}
		return new Like[1];
		
	}
	
	@Path("like/{msgid}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void addLike(@PathParam("msgid") String msgid, Like like){
		msg = this.retrieve();
		for(Msg message: msg){
			if(message.getMsgid().equals(msgid)){
				List<Like> likes = message.getLikes();
				if(likes == null){
					likes = new ArrayList<>();
				}
				likes.add(like);
				message.setLikes(likes);
				message.setNoLikes(message.getNoLikes()+1);
				break;
			}
		}
		store(msg);
		
	}
	
	@Path("add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMessage(String messageS) throws JsonParseException, JsonMappingException, IOException{
		mapper = new ObjectMapper();
		Msg message = mapper.readValue(messageS, Msg.class);
		msg = retrieve();
		if(msg==null)
			message.setMsgid("0");
		else	
			message.setMsgid(""+msg.size());
		message.setNoLikes(0);
		message.setLikes(new ArrayList<Like>());
		message.setComments(new ArrayList<Cmt>());
		msg.add(message);
		store(msg);
		return Response.ok().build();
	}
	
	@Path("addc/{msgid}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addComment(@PathParam("msgid") String msgid, Cmt comment){
		msg = this.retrieve();
		for(Msg message: msg){
			if(message.getMsgid().equals(msgid)){
				List<Cmt> comments = message.getComments();
				if(comments == null){
					comments = new ArrayList<>();
				}
				comments.add(comment);
				message.setComments(comments);
				break;
			}
		}
		store(msg);
		return Response.ok().build();
	}
	public void store(List<Msg> messages){
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File("file.json"), messages);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Msg> retrieve(){
		ObjectMapper mapper = new ObjectMapper();
		List<Msg> messages = null;
		try {
			messages = mapper.readValue(new File("file.json"), new TypeReference<List<Msg>>(){});
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(messages==null)
			return new ArrayList<Msg>();
		return messages;
	}
	
}