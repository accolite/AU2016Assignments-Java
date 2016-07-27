package com.springdemo.tutorial;

import java.util.List;

public class Question {
	
	private List<String> values;
	
	public Question(List<String> values){
		this.values = values;
	}

	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}
}
