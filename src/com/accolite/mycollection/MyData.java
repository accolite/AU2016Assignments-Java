package com.accolite.mycollection;


public class MyData {
	private MyData prev;
	private Object key;
	private Object value;
	private MyData next;
	
	public MyData(Object key, Object value) {
		// TODO Auto-generated constructor stub
		this.key = key;
		this.value = value;
	}
	
	public MyData(MyData prev,Object key, Object value, MyData next){
		this.key = key;
		this.value = value;
		this.prev = prev;
		this.next = next;
	}
	
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
	public MyData getPrev() {
		return prev;
	}
	public void setPrev(MyData prev) {
		this.prev = prev;
	}
	public Object getKey() {
		return key;
	}
	public void setKey(Object key) {
		this.key = key;
	}
	public MyData getNext() {
		return next;
	}
	public void setNext(MyData next) {
		this.next = next;
	}
	
}
