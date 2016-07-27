package com.au.chatboard.dao;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.au.chatboard.bean.RestrictedWords;

@Component
public class RestrictedWordsManager {

	@Autowired
	RestrictedWords restrictedWords;
	
	public void setRestrictedWords(Set<String> words){
		restrictedWords.setRestrictedWords(words);
	}
	
	public Set<String> getRestrictedWords(){
		return restrictedWords.getRestrictedWords();
	}
	
}
