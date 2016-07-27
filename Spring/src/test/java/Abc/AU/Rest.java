package Abc.AU;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
public class Rest {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage(){
    	return "hello";
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message saveMessage(Message message){
    	message.setValue("your message "+message.getValue()+" with id "+message.getId());
    	return message;
    }
}
