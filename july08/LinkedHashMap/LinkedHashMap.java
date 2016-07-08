/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 8, 2016
*
*  @author :: Sharukh Mohamed
* ***************************************************************************
*/
package com.accolite.LinkedHashMap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class LinkedHashMap.
 */

public class LinkedHashMap {

	/* Prime used for HashCode */
	static final int PRIME= 23;

	/** The internal hashmap. */
	ArrayList<LinkedList<Node>> hashmap;
	
	/** The ordered prev maintained */
	Node orderedPrev;
	
	/** The first object inserted */
	Node first;
	
	/* Get first Object inserted */
	Node getFirst(){
		return first;
	}
	
	/* Internal hashcode used */
	int hashCode(Object object){
		/* Use of PRIME fields of LinkedList */
		return (object.hashCode()%PRIME);
	}
	
	/* Instantiates a linked Hashmap */
	LinkedHashMap(){
		hashmap = new ArrayList<>();
		orderedPrev = null;
		first = null;
		/* Use PRIME fields of LinkedList */
		for(int i=0;i<PRIME;i++){
			hashmap.add(new LinkedList<Node>());
		}
	}
	
	/* Sorted Printing of LinkedHashMap */
	void printSorted(){
		Node node = getFirst();
		while(node!=null){
			System.out.println(node.getKey()+" "+node.getValue());
			node = node.getOrderedNext();
		}
	}
	
	/* Insert into LinkedHashMap */
	void put(Object key, Object value){
		
		LinkedList<Node> list = hashmap.get(hashCode(key));
		
		/* Check for existing */
		try{
			
		
			if(list!=null){
				Node node = list.getFirst();
				
				/* Replace value if existing */
				while(node!=null){
					if(node.getKey().equals(key)){
						node.setValue(value);
						return;
					}
					node = node.getNext();
				}
			}
		}catch(Exception e){
			
		}
		
		Node newNode = new Node(key, value);
		
		/* If first is null, initialize */
		if(getFirst()==null){
			first = newNode;
			orderedPrev = newNode;
			
			/* Add first to list and return */
			list.add(newNode);
			return;
		}
		
		/* Set ordered references */
		newNode.setOrderedPrev(orderedPrev);
		orderedPrev.setOrderedNext(newNode);
		
		/* Add to list */
		list.add(newNode);
		orderedPrev = newNode;
	}
	
	/* Get Value at key */
	Node get(Object key){
		Node node = hashmap.get(hashCode(key)).getFirst();
		if(!(node.equals(null))){
			while(!(node.equals(null))){
				if((node.getKey()).equals(key)){
					return node;
				}
				node = node.getNext();
			}
		}
		return null;
	}
	
	
	/* The Main Program */
	public static void main(String args[]){
		LinkedHashMap m = new LinkedHashMap();

		boolean ctnue = true;
		Scanner input = new Scanner(System.in);
		System.out.println("Put items");
		while(ctnue){
			System.out.print("Enter Key: ");
			Integer key = input.nextInt();
			System.out.print("Enter Value: ");
			Integer value = input.nextInt();
			m.put((Object)key, (Object)value);
			System.out.print("Continue y/n? ");
			String next = input.next();
			if(next.equals("y")) continue;
			else break;
		}
		System.out.println("Get items");
		try{
			while(ctnue){
				System.out.print("Enter Key: ");
				Integer key = input.nextInt();
				System.out.println(m.get(key).getValue());
				System.out.print("Continue y/n? ");
				String next = input.next();
				if(next.equals("y")) continue;
				else break;
			}
		}catch(Exception e){
			System.out.println("Not available");
		}
		
		input.close();
		m.printSorted();
	}
}
