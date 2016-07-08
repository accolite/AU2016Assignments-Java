package com.accolite.LinkedHMap;

public class Node {

	public Node prev,next,nextInOrder,prevInOrder;
	Object key,value;
	
	public Node(Node nextInOrder, Node prevInOrder, Object key, Object value) {
		super();
		this.prev = null;
		this.next = null;
		this.nextInOrder = nextInOrder;
		this.prevInOrder = prevInOrder;
		this.key = key;
		this.value = value;
	}
	
	public Node getPrev() {
		return prev;
	}
	public void setPrev(Node prev) {
		this.prev = prev;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Object getValue(Object key) {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	

}
