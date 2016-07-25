package com.accolite.Messenger;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("likes")
public class LikeResource {
	
	LikeService likeService=new LikeService();

	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Likes> getAllLikes(@PathParam("messageId") long messageId)
	{

		return likeService.getAllLikes(messageId);
	}

	@POST
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Likes addLike(@PathParam("messageId") long messageId, Likes likes)
	{
		return likeService.addLike(messageId, likes);
	}
	
}
