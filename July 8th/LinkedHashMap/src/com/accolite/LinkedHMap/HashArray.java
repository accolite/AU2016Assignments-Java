/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 8, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************
*/

package com.accolite.LinkedHMap;

// TODO: Auto-generated Javadoc
/**
 * The Class HashArray.
 */
public class HashArray {
	
	/** The hash header. */
	//public int hashvalue;
	Node[] hashHeader=new Node[100];
	
	/** The current node. */
	static Node firstNode,currentNode;
	
/**
 * Instantiates a new hash array.
 */
/*	public HashArray() {
		super();
		hashvalue=0;
		firstNode=null;
	}
*/
	public HashArray() {
		super();
		//this.hashvalue = hashvalue;
		this.firstNode = null;
		this.currentNode = null;
	}
	
	/**
	 * Put.
	 *
	 * @param key the key
	 * @param value the value
	 */
	public void put(Object key,Object value){
		int hashval=key.hashCode()%100;
		if(hashHeader[hashval]==null){
			Node newNode=new Node(null,currentNode,key,value);
			if(currentNode!=null)
					currentNode.nextInOrder=newNode;
			else{
				firstNode=newNode;
			}
			currentNode=newNode;
			hashHeader[hashval]=newNode;
				
		}
		else{
			Node rider=hashHeader[hashval];
			//Node rider=firstNode;
			while(rider.next!=null && rider.key!=key)
				rider=rider.next;
			if(rider.key==key)
				rider.value=value;
			else
			{
			Node newNode=new Node(currentNode,null,key,value);
			rider.next=newNode;
			newNode.prev=rider;
			currentNode.nextInOrder=newNode;
			currentNode=newNode;
			}
		}
	}
	
	/**
	 * Gets the.
	 *
	 * @param key the key
	 * @return the object
	 */
	public Object get(Object key){
		int hashval=key.hashCode()%100;
		Node rider=hashHeader[hashval];
		if(rider==null)
		{
			System.out.println("This is not a key");
			return 0;
		}
		while(rider!=null && rider.next!=null && rider.key!=key)
			rider=rider.next;
		return rider.value;
	}
		
	/**
	 * Prints the in order.
	 */
	public void PrintInOrder(){
		Node rider=firstNode;
		while(rider!=currentNode){
			System.out.println(rider.key+"   "+rider.value);
			rider=rider.nextInOrder;
		}
		System.out.println(currentNode.key+"   "+currentNode.value);
	}
}
