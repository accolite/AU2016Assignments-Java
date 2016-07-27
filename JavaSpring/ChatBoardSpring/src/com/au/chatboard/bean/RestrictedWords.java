package com.au.chatboard.bean;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class RestrictedWords {
	
	Set<String> restrictedWords;
	
	RestrictedWords(){
		restrictedWords = new HashSet<>();
	}
	
	public Set<String> getRestrictedWords() {
		return restrictedWords;
	}

	public void setRestrictedWords(Set<String> restrictedWords) {
		this.restrictedWords = restrictedWords;
	}
	
}
