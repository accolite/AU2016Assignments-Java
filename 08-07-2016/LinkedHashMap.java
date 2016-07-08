/*
 * /****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 8, 2016

*

*  @author :: Loghithavani

* ***************************************************************************

 */
package com.accolite.model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LinkedHashMap {
	public Node prev; //To update the previous pointer
	public Node next; //To update the next pointer
	public Node head;
	public int maxSize = 100;
	public ArrayList<Node> arraylist;
	public int hashcode;
	
	//Constructor for initializing arraylist and nodes
	public LinkedHashMap(){
		this.arraylist = new ArrayList<Node>(maxSize);
		for( int i=0;i<maxSize;i++){
			this.arraylist.add(i,null);
		}
		this.prev = null;
		this.next = null;
	}
	
	//Generate hash code
	public int generateHashCode(){
		int n=0;
		for(int i=0;i<5;i++){
	    	Random rand = new Random();
	    	 n = 1 + rand.nextInt(9);
	    }
		return n;
	}
	
	//Put an element in linked hashmap
	public void put(int key,int value){
		hashcode = generateHashCode();
		//System.out.println("Hashcode:"+this.hashcode);
		Node node = new Node(key,value);
		Node temp=null;
		
		if(arraylist.get(hashcode)==null){
			prev = node;   //New node is the first node
			next = node;   //New node is the last node
			this.arraylist.add(hashcode,node);
			temp = arraylist.get(hashcode);
			temp.after = node;
		}
		
		//There exists node already at that index 
		else{
			while(temp.after != null){
				temp = temp.after;
			}
			temp.after = node;
			node.previous = temp;
		}
	}
	/*void put(int key, int value) {
		hashcode = generateHashCode();
		Node node = new Node(key, value);
		if (prev == null) {
			head = node;
		}
		if (this.arraylist.get(hashcode) == null) {
			prev = node;
			this.arraylist.add(hashcode, node);
		} else {

			node.previous = prev;
			prev.next = node;
			prev = node;
			Node temp;
			temp = arraylist.get(hashcode);
			while (temp.after != null) {
				temp = temp.after;
			}
			temp.after = node;

		}
	}*/
	
	void iterate() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
	
	/**
	 * Gets the.
	 *
	 * @param key the key
	 */
	//Get function
	public void get(int key){
		Node temp;
		temp = arraylist.get(this.hashcode);
		if(temp == null){
			System.out.println("Node not found");
		}
		else{
			while(temp!=null){
				if(temp.key == key){
					System.out.println("Node value with key:"+temp.key+":"+temp.value);
					return;
				}
				else{
					temp = temp.after;
				}
			}
		}
		
	}
	
	
	//main function
	public static void main(String a[]){
		LinkedHashMap h = new LinkedHashMap();
		int inputKey;
		int inputValue;
		int choice;
		
		Scanner s = new Scanner(System.in);
		do{
		 System.out.println("Enter key:");
		 inputKey = s.nextInt();
		
		 System.out.println("Enter value:");
		 inputValue = s.nextInt();
		
		 h.put(inputKey, inputValue);
		
		 
		 System.out.println("Do you want to continue??Press 1-Yes 0-No");
		 choice = s.nextInt();
		}while(choice==1);
		System.out.println("Enter key:");
		 inputKey = s.nextInt();
		 h.get(inputKey);
	}
	
	
}
