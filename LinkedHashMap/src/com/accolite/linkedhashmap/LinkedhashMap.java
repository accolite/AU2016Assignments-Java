/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 8, 2016

*

*  @author :: SaiCharan Movva
works Only for Integers only
* ***************************************************************************

*/
package com.accolite.linkedhashmap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class LinkedhashMap.
 */
public class LinkedhashMap {
	
	/** The a. */
	static ArrayList< LinkedList<Type> > A;
	
	/** The last. */
	public Type first,last;
	
	/** The size. */
	public static int size;
	
	/** The tail. */
	public static Type head, tail;
	
	/**
	 * Instantiates a new linkedhash map.
	 *
	 * @param size the size
	 */
	public LinkedhashMap(int size){
		this.size = size;
		A = new ArrayList<LinkedList<Type>>(size);
		for(int i=0;i<size;i++){
			A.add(new LinkedList<Type>());
		}
		
	}
	
	/**
	 * Put.
	 *
	 * @param key the key
	 * @param value the value
	 */
	public void put(Integer key,Integer value){
		Integer hashValue=(key.hashCode())%size;
		Type tp=new Type(key,value,null);
		maintainorder(tp);
		if(A.get(hashValue).isEmpty()){
			A.get(hashValue).add(tp);
		}
		else{
			A.get(hashValue).addFirst(tp);
		}
		
	}
	
	/**
	 * Gets the.
	 *
	 * @param key the key
	 * @return the integer
	 */
	public Integer get(Integer key){
		Integer hashValue=(key.hashCode())%size;
		LinkedList<Type> li= A.get(hashValue);
		for(Type t:li){
			if(t.key.equals(key)){
				return t.value;
			}
		}
		return null;
	}
	
	/**
	 * Maintainorder.
	 *
	 * @param t the t
	 */
	public static void maintainorder(Type t){
		if(head==null){
			head=t;
			tail=t;
		}
		else{
			tail.next=t;
			t.prev=tail;
			tail=t;
		}
	}
	 
 	/**
 	 * Display.
 	 */
 	public static void display(){
	       
	       Type currentEntry=head;
	       while(currentEntry!=null){
	           System.out.print("{"+currentEntry.key+"="+currentEntry.value+"}" +" ");
	           currentEntry=currentEntry.next;
	       }
	 }
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]){
		
		Scanner S=new Scanner(System.in);
		System.out.println("Enter the No of integrs to enter(Less than 100)\n");
		size=S.nextInt();
		LinkedhashMap linkedhashmap= new LinkedhashMap(size);
		while(true){
			System.out.println("1:Add\n2:Get\n3:Display\n");
			int choice=S.nextInt();
			int key,value;
			switch(choice){
			case 1:
				
				key=S.nextInt();
				value=S.nextInt();
				linkedhashmap.put(key,value);
				break;
			case 2:
				
				key=S.nextInt();
				System.out.println(linkedhashmap.get(key));
				break;
			case 3:
				display();
				System.out.println();
				break;
			}
			
		}
	}
	
}
