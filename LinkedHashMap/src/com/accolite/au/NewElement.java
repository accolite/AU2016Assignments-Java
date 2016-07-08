package com.accolite.au;

public class NewElement {
	private int key;
	private Object value;
	
	private NewElement previous;
	private NewElement next;
	
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public NewElement getPrevious() {
		return previous;
	}

	public void setPrevious(NewElement previous) {
		this.previous = previous;
	}

	public NewElement getNext() {
		return next;
	}

	public void setNext(NewElement next) {
		this.next = next;
	}

	
	
	public int hashval(int key){
		return key%100;
	}
	
	
	
}
