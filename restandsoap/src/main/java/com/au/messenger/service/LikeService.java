package com.au.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.au.messenger.database.DatabaseClass;
import com.au.messenger.model.Like;
import com.au.messenger.model.Message;

public class LikeService {

	private Map<Integer,Message> messages = DatabaseClass.getMessages();
	
	public List<Like> getAllLikes(int msgId){
		List<Like> c = messages.get(msgId).getLikes();
		return c;
	}
	
	public Like addLike(int msgId,Like like){
		List<Like> likes = messages.get(msgId).getLikes();
		if(likes == null)
			likes=new ArrayList<Like>();
		like.setId(likes.size()+1);
		likes.add(like);
		messages.get(msgId).setLikes(likes);
		DatabaseClass.store();
		return like;
	}
	
}
