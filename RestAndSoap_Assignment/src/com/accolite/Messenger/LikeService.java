package com.accolite.Messenger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class LikeService {
	
	/** The messages. */
	private Map<Long, Message> messages = new DatabaseClass().getMessages();
	
	/** The Likes. */
	private Map<Long, Likes> likes = new DatabaseClass().getLikes();

	
	public List<Likes> getAllLikes(long messageId)
	{
		Map<Long, Likes> likes = messages.get(messageId).getLikes();

		return new ArrayList<Likes>(likes.values());

	}

	public Likes addLike(long messageId, Likes like)
	{
		Map<Long, Likes> likes = messages.get(messageId).getLikes();

		like.setId(likes.size() + 1);
		like.setCreated(new Date());
		likes.put(like.getId(), like);
		return like;

	}


}
