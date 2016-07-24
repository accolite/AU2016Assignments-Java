package com.au.controller;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.au.DAO.MessageDAO;

@Path("/messages")
public class MessageController<Message> {

	MessageDAO dao = new MessageDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getAllMessages() throws ClassNotFoundException, SQLException {
		System.out.println("hellp ");
		List<Message> messages = (List<Message>) dao.getAllMessages();

		return messages;
	}

	@GET
	@Path("/comment")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean getAllComment() throws ClassNotFoundException, SQLException {

		boolean a = dao.getAllComment();
		return a;

	}

	@GET
	@Path("/like")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean getAllLike() throws ClassNotFoundException, SQLException {
		boolean a = dao.getAllLike();
		return a;

	}

	@POST
	@Path("/{userid}/{msg}")
	@Produces(MediaType.APPLICATION_JSON)
	public void addmsg(@PathParam("userid") int userid, @PathParam("msg") String msg) {

		System.out.println(userid + "aaya");
		System.out.println(msg);
		dao.addmsg(userid, msg);
	}

	@POST
	@Path("/{userid}/{msgid}/{comment}")
	@Produces(MediaType.APPLICATION_JSON)
	public void addcomment(@PathParam("userid") int userid, @PathParam("msgid") int msgid,
			@PathParam("comment") String comment) {
		System.out.println(msgid + "yahan controller");

		dao.addcomment(userid, msgid, comment);
	}

	@POST
	@Path("/likes/{userid}/{msgid}")
	@Produces(MediaType.APPLICATION_JSON)
	public void addlikes(@PathParam("userid") int userid, @PathParam("msgid") int msgid) {
		System.out.println(userid + "    " + msgid + "againnnnnnn");

		dao.Addlikes(userid, msgid);
	}
	/*
	 * @GET
	 * 
	 * @Path("/{id}")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public MessageDAO
	 * getCountryById(@PathParam("id") int id) { return
	 * countryService.getCountry(id); }
	 * 
	 * @POST
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public MessageDAO
	 * addCountry(MessageDAO country) { return
	 * countryService.addCountry(country); }
	 * 
	 * @PUT
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public MessageDAO
	 * updateCountry(MessageDAO country) { return
	 * countryService.updateCountry(country);
	 * 
	 * }
	 * 
	 * @DELETE
	 * 
	 * @Path("/{id}")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public void
	 * deleteCountry(@PathParam("id") int id) {
	 * countryService.deleteCountry(id);
	 * 
	 * }
	 */

}
