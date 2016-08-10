package com.accolite.au.VideoPortal.Templates;

import com.accolite.au.VideoPortal.model.Event;

public interface EventInterface {
	
	public int CreateEvent(Event event);

	public int DeleteEvent(Event event);
	
	public Event RetrieveEvent(String eventName);
}
