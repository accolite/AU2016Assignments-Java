package com.accolite.Assignment;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentDetails {

	public Map<Integer, Messsage> messages;
	public Map<Integer, Comment> comments;
	
	
	public CommentDetails() {
		super();
		messages=new HashMap<Integer, Messsage>();
		comments=new HashMap<Integer, Comment>();
		
	}

	public Comment addComment(int messageId, Comment comment)
	{
		Map<Integer, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comment.setCreated(new Date());
		comments.put(comment.getId(), comment);
		return comment;

	}
	
	public List<Comment> getAllComments(int messageId)
	{
		Messsage msg=messages.get(messageId);
		Map<Integer, Comment> comments = msg.getComments();

		return new ArrayList<Comment>(comments.values());

	}
	
	public Comment getComment(int messageId, int commentId)
	{
		Map<Integer, Comment> comments = messages.get(messageId).getComments();
		return comments.get(commentId);
	}
	
}
