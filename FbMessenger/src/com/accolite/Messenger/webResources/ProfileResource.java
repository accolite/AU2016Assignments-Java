/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 24, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************/


package com.accolite.Messenger.webResources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.accolite.Messenger.classfiles.Profile;
import com.accolite.Messenger.services.ProfileService;


// TODO: Auto-generated Javadoc
/**
 * The Class ProfileResource.
 */
@Path("profiles")

public class ProfileResource
{

	/** The profile service. */
	ProfileService profileService = new ProfileService();

	/**
	 * Gets the profiles.
	 *
	 * @return the profiles
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getProfiles()
	{
		return profileService.getAllProfiles();
	}

}
