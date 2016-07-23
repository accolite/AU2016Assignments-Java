package com.au.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.au.messenger.database.DatabaseClass;
import com.au.messenger.model.Comment;
import com.au.messenger.model.Message;

public class CommentService {

	private Map<Integer,Message> messages = DatabaseClass.getMessages();
	
	public List<Comment> getAllComments(int msgId){
		return messages.get(msgId).getComments();
		
	}
	
	public Comment addComment(int msgId,Comment comment){
		List<Comment> comments = messages.get(msgId).getComments();
		if(comments == null)
			comments = new ArrayList<>();
		comment.setId(comments.size()+1);
		comments.add(comment);
		messages.get(msgId).setComments(comments);
		DatabaseClass.store();
		return comment;
	}
	
}
