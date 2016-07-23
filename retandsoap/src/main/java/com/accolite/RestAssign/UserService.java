package com.accolite.RestAssign;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

@Path("/UserService")
public class UserService {

	UserDao userDao = new UserDao();

	@GET
	@Path("/user")
	@Produces(MediaType.TEXT_PLAIN)
	public String getUser(@DefaultValue("-1") @QueryParam("id") int id) {
		if (id == -1)
			return userDao.getAllUsers();
		else
			return userDao.getUserById(id);

	}
}
