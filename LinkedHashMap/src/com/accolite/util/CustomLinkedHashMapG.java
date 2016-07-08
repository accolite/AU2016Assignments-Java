package com.accolite.util;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

/**
 * Generic version of Custom LinkedHashMap
 * @author Rajesh R
 *
 * @param <K> - Any Class
 * @param <V> - Any Class
 */
public class CustomLinkedHashMapG<K, V>{
	
	private int MINBUCKET_SIZE = 10;
	
	ArrayList<Node> table;
	
	Node head, tail;		// To maintain insertion order
	
	class Node{
		K key;
		V value;
		Node next;
		Node before, after; 	// To maintain insertion order
		Node(K key, V value){
			this.key = key;
			this.value = value;
		}
		public K getKey() {
			return key;
		}
		public void setKey(K key) {
			this.key = key;
		}
		public V getValue() {
			return value;
		}
		public void setValue(V value) {
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
	
	public CustomLinkedHashMapG() {
		init();
	}
	
	public CustomLinkedHashMapG(int minBucketSize){
		MINBUCKET_SIZE = minBucketSize;
		init();
	}
	
	/**
	 * Initialize Hash table with bucket size
	 */
	private void init(){
		table = new ArrayList<>();
		for (int i = 0; i < MINBUCKET_SIZE; i++) {
			table.add(null);
		}
	}
	
	/**
	 * Will create a node and links it to the ordered list
	 * @param key
	 * @param value
	 * @return Created node
	 */
	private Node createNode(K key, V value){
		Node newNode = new Node(key, value);
		if(head == null){
			head = newNode;
			tail = newNode;
		}
		else{
//			System.out.println("tail is "+tail.getKey());
			tail.setAfter(newNode);
			newNode.setBefore(tail);
			tail = newNode;
//			System.out.println("tail is "+tail.getKey());
		}
		return newNode;
	}
	
	/**
	 * Will calculate hash code for the given key
	 * @param key
	 * @return Hash code
	 */
	private int hashCode(K key){
//		System.out.println("Calculating hash of "+key);
		if(key == null)
			return 0;
		int hashCode = key.hashCode();
		hashCode *= hashCode<0 ? -1 : 1;
		return hashCode % MINBUCKET_SIZE;
	}
	
	public boolean put(K key, V value){
		/*if(key==null)
			return false;*/
		int hashValue = hashCode(key);
		if(table.get(hashValue)==null){			// No linked list exists at the target bucket
			table.set(hashValue, createNode(key, value));
//			System.out.println("Successfully inserted at bucket "+hashValue);
			return true;
		}
		else{
			Node list = table.get(hashValue);
			while(list.getNext() != null && !list.getKey().equals(key)){
				list = list.getNext();
			}
			if(list.getNext() == null && list.getKey() != key && !list.getKey().equals(key)){
				list.setNext(createNode(key, value));
//				System.out.println("Successfully inserted at bucket "+hashValue);
				return true;
			}
			else{
				list.setValue(value);
//				System.out.println("Key already exist");
				return false;				
			}
		}
	}
	
	public V get(K key){
		/*if(key == null)
			return null;*/
		int hashValue = hashCode(key);
		if(table.get(hashValue)==null){
//			System.out.println("Bucket is empty");
			return null;
		}
		else{
//			System.out.println("Bucket is not empty");
			Node list = table.get(hashValue);
			while(list != null && list.getKey() != key && !list.getKey().equals(key)){
				list = list.getNext();
			}
			if(list == null){
				return null;
			}
			else
				return list.getValue();
		}
	}
	
	public List<Entry<K, V>> getInOrder(){
		if(head == null){
			return null;
		}
		else{
			List<Entry<K, V>> inOrder = new ArrayList<>();
//			Map<Integer, String> inOrder = new HashMap<>();
			Node current = head;
			do{				
				inOrder.add( new AbstractMap.SimpleEntry<K, V>(current.getKey(), current.getValue()));
				current = current.after;
			}while(current != null);
			return inOrder;
		}
	}
	
	
}
