package com.accolite.deep;

public class Node {
	private Object key;
	private Object value;
	private Node prev,next,lprev,lnext;
	
	public Node(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
		prev = next = lprev = lnext = null;
	}

	public Object getKey() {
		return key;
	}

	public void setKey(Object key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
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

	public Node getLprev() {
		return lprev;
	}

	public void setLprev(Node lprev) {
		this.lprev = lprev;
	}

	public Node getLnext() {
		return lnext;
	}

	public void setLnext(Node lnext) {
		this.lnext = lnext;
	}
	
	

}
