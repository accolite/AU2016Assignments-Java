/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 24, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************/

package com.accolite.Messenger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class ProfileService.
 */
public class ProfileService
{
	
	/**
	 * Instantiates a new profile service.
	 */
	public ProfileService()
	{
		profiles.put("Jegan", new Profile(1, "jegan", "jegan", "muthaiah"));
		profiles.put("Loki", new Profile(2, "log10", "lokesh", "k"));

	}

	/** The profiles. */
	private Map<String, Profile> profiles = new DatabaseClass().getProfiles();

	/**
	 * Gets the all profiles.
	 *
	 * @return the all profiles
	 */
	public List<Profile> getAllProfiles()
	{
		return new ArrayList<Profile>(profiles.values());
	}

	/**
	 * Gets the profile.
	 *
	 * @param profileName the profile name
	 * @return the profile
	 */
	public Profile getProfile(String profileName)
	{
		return profiles.get(profileName);
	}


}
