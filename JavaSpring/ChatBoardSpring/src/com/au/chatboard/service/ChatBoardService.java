package com.au.chatboard.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.chatboard.bean.Message;
import com.au.chatboard.bean.User;
import com.au.chatboard.dao.ActiveListManager;
import com.au.chatboard.dao.MessageManager;
import com.au.chatboard.dao.RestrictedWordsManager;
import com.au.chatboard.dao.UserManager;

@Service
public class ChatBoardService {

	@Autowired
	UserManager userManager;
	
	@Autowired
	MessageManager messageManager;
	
	@Autowired
	ActiveListManager activeListManager;
	
	@Autowired
	RestrictedWordsManager restrictedWordsManager;
	
	public Boolean addUser(String username, String password){
		if(!userManager.isExist(username)){
			User user = new User(username, password);
			return (userManager.addUser(user) > 0) ;
		}
		return false;
	}
	
	public Boolean addMessage(String username, String message){
		Message messageObj = new Message(username, message);
		return (messageManager.addMessage(messageObj) >0);
	}
	
	public Boolean validate(String username, String password){
		User user = new User(username, password);
		return userManager.checkUser(user);
	}
	
	public String getUsersList(String username){
		return activeListManager.getUsersList(username);
	}
	
	public boolean addUserToActiveList(String username){
		return activeListManager.addUser(username);
	}
	
	public void addRestrictedWords(String words){
		String[] wordslist = words.split(",");
		Set<String> restrictedWords = new HashSet<>();
		for(String word: wordslist){
			System.out.println(word);
			restrictedWords.add(word);
		}
		restrictedWordsManager.setRestrictedWords(restrictedWords);
	}
	
	public String[] getRestrictedWords(){
		Set<String> restrictedWords = restrictedWordsManager.getRestrictedWords();
		return restrictedWords.toArray(new String[restrictedWords.size()]);
	}
	
	public String getChatList(String username){
		StringBuilder sb = new StringBuilder();
		List<Message> messages = messageManager.retrieve();
		if(messages!=null){
			for(Message message: messages){
				if(message.getUsername().equals(username))
					sb.append("<p><b>"+message.getUsername()+"</b> "+message.getMessage()+"</p>");
				else
					sb.append("<b>"+message.getUsername()+"</b> "+message.getMessage()+"<br/>");
			}
		}
		return sb.toString();
	}
}
