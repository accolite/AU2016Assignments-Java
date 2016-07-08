package com.accolite.util;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class CustomLinkedHashMap{
	
	private int MINBUCKET_SIZE = 10;
	
	ArrayList<Node> table;
	
	Node head, tail;		// To maintain insertion order
	
	class Node{
		Integer key;
		String value;
		Node next;
		Node before, after; 	// To maintain insertion order
		Node(Integer key, String value){
			this.key = key;
			this.value = value;
		}
		public Integer getKey() {
			return key;
		}
		public void setKey(Integer key) {
			this.key = key;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public Node getBefore() {
			return before;
		}
		public void setBefore(Node before) {
			this.before = before;
		}
		public Node getAfter() {
			return after;
		}
		public void setAfter(Node after) {
			this.after = after;
		}
		
	}
	
	public CustomLinkedHashMap() {
		init();
	}
	
	public CustomLinkedHashMap(int minBucketSize){
		MINBUCKET_SIZE = minBucketSize;
		init();
	}
	
	private void init(){
		table = new ArrayList<>();
		for (int i = 0; i < MINBUCKET_SIZE; i++) {
			table.add(null);
		}
	}
	
	private Node createNode(Integer key, String value){
		Node newNode = new Node(key, value);
		if(head == null){
			head = newNode;
			tail = newNode;
		}
		else{
			System.out.println("tail is "+tail.getKey());
			tail.setAfter(newNode);
			newNode.setBefore(tail);
			tail = newNode;
			System.out.println("tail is "+tail.getKey());
		}
		return newNode;
	}
	
	private int hashCode(Integer key){
		System.out.println("Calculating hash of "+key);
		return key % MINBUCKET_SIZE;
	}
	
	public boolean put(Integer key, String value){
		if(key == null)
			return false;
		int hashValue = hashCode(key);
		if(table.get(hashValue)==null){			// No linked list exists at the target bucket
			table.set(hashValue, createNode(key, value));
			System.out.println("Successfully inserted at bucket "+hashValue);
			return true;
		}
		else{
			Node list = table.get(hashValue);
			while(list.getNext() != null && !list.getKey().equals(key)){
				list = list.getNext();
			}
			if(list.getNext() == null && !list.getKey().equals(key)){
				list.setNext(createNode(key, value));
				System.out.println("Successfully inserted at bucket "+hashValue);
				return true;
			}
			else{
				System.out.println("Key already exist");
				return false;				
			}
		}
	}
	
	public String get(Integer key){
		if(key == null)
			return null;
		int hashValue = hashCode(key);
		if(table.get(hashValue)==null){
			System.out.println("Bucket is empty");
			return null;
		}
		else{
			System.out.println("Bucket is not empty");
			Node list = table.get(hashValue);
			while(list != null && !list.getKey().equals(key)){
				list = list.getNext();
			}
			if(list == null){
				return null;
			}
			else
				return list.getValue();
		}
	}
	
	public List<Entry<Integer, String>> getInOrder(){
		if(head == null){
			return null;
		}
		else{
			List<Entry<Integer, String>> inOrder = new ArrayList<>();
//			Map<Integer, String> inOrder = new HashMap<>();
			Node current = head;
			do{				
				inOrder.add( new AbstractMap.SimpleEntry<Integer, String>(current.getKey(), current.getValue()));
				current = current.after;
			}while(current != null);
			return inOrder;
		}
	}
	
	
}
