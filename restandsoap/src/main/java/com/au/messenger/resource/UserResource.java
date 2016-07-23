package com.au.messenger.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.au.messenger.model.User;
import com.au.messenger.service.UserService;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
	int id;
	String name;
	
	UserService userService = new UserService();
	
	@GET

	public List<User> getAll(){
		return  userService.getAllUsers();
	}

}
