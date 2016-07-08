package com.accolite.linkedHashMap;

public class Node {
	Object key;
	Object value;
	Node prev_addr;
	Node next_addr;
	
	Node(Object key,Object value,Node prev_addr,Node next_addr){
		this.key = key;
		this.value = value;
		this.prev_addr = prev_addr;
		this.next_addr = next_addr;
	}
	
	Node getPrev(){
		return this.prev_addr;
	}
	
	Node getNext(){
		return this.next_addr;
	}
}
