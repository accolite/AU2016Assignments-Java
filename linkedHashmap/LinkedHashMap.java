package com.accolite.au16.linkedHashmap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class LinkedHashMap {
	ArrayList<LinkedList<Node>> array;
	Node start; // its for the first node in order of insertion
		public LinkedHashMap() {
		super();
		array= new ArrayList<LinkedList<Node>>();
		start=new Node();
		
	} 
	
	void put(Object key, Object value)
	{	
		int hashValue = key.hashCode();
		int index=hashValue%100;
		Node newNode= new Node();
		newNode.key= key;
		newNode.value=value;
		if(array.get(index).isEmpty())
		{ // create a link list and save the head at this location
			LinkedList<Node> ll= new LinkedList<Node>();
			ll.addFirst(newNode);
			array.add(index, ll);
			
		}
		else
		{	
			LinkedList<Node> ll=array.get(index);
			ll.addFirst(newNode);
		}
		
	}
	void putFirst(Object key, Object value)
	{	
		Node node= new Node();
		node.key=key;
		node.value=value;
		start=node;
		int hashValue = key.hashCode();
		int index=hashValue%100;
		LinkedList<Node> ll= new LinkedList<Node>();
		ll.addFirst(node);
		array.add(index, ll);
	}
	Node get(Object key)
	{	int hashValue = key.hashCode();
		int index=hashValue%100;
		LinkedList<Node> ll=array.get(index);
		ListIterator<Node> listIterator = ll.listIterator();
        while (listIterator.hasNext()) {
        	if(key.equals(listIterator))
        		return listIterator;
        	else
        		listIterator.next();
        }
           
        }
		
	public static void main(String[] args)
	{	LinkedHashMap linkedListHash= new LinkedHashMap();
		System.out.println("to put enter 1, to get enter 2, to exit press 3 ");
		Scanner input =new Scanner(System.in);
		int choice=input.nextInt();
		String str;
		String key;
		boolean ifFirst=true;
		while(choice!=3)
		{
		switch(choice)
		{	case 1: System.out.println("enter key");
				str=input.nextLine();
				 key=str.toString();
				System.out.println("enter value");
				str=input.nextLine();
				String value=str.toString();
				if(ifFirst)
				{
					linkedListHash.putFirst(key, value);
				}
				else
					linkedListHash.put(key, value);
				break;
		case 2:
			System.out.println("enter key");
			str=input.nextLine();
			 key=str.toString();
			Node node=linkedListHash.get(key);
			System.out.println(node.value);
			break;
		case 3:
				break;
			
			
		}
		System.out.println("to put enter 1, to get enter 2, to exit press 3 ");

		}
		
		
		
	}
	
	

}
