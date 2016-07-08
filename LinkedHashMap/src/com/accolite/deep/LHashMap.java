package com.accolite.deep;

import java.util.ArrayList;

public class LHashMap {
	
	private ArrayList<Node> table;
	private int N;
	private Node lstart = null;
	private Node lend = null;
	public LHashMap() {
		table = new ArrayList<Node>(N);
		N = 10;
		for (int i = 0; i < N; i++) {
			table.add(null);
		}
	}
	
	public void put(Object key, Object value){
		
		int bucket = key.hashCode()%N;
		Node node = new Node(key,value);
		
		if(table.get(bucket) == null){
			table.set(bucket, node);
			if(lstart == null)
				lstart = node;
			node.setLprev(lend);
			if(lend!=null)
				lend.setLnext(node);
			lend=node;
		} else {
			Node current = table.get(bucket);
			if(current.getKey().equals(key)){
				current.setValue(value);
				return;
			}
			while(current.getNext() != null){
				if(current.getKey().equals(key)){
					current.setValue(value);
					return;
				}
				current = current.getNext();
			}
			node.setPrev(current);
			node.setLprev(lend);
			lend.setLnext(node);
			current.setNext(node);
			lend=node;
			
		}
		
	}
	
	public Object get(Object key){
		int bucket = key.hashCode()%N;
		Node current = table.get(bucket);
		while(current != null){
			if(current.getKey().equals(key))
				return current.getValue();
			current = current.getNext();
		}
		return null;
	}
	

	public void showAll(){
		if(lstart == null)
			System.out.println("Empty List");
		Node current = lstart;
		while(current != null){
			System.out.println(current.getKey() + "->" + current.getValue());
			current = current.getLnext();
		}
	}
}
