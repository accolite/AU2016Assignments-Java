package com.accolite.au.VideoPortal.Templates;

public interface LoginInterface {
	
	public int emailInDB(String email);
	public int retrieveUserId(String email);
}
