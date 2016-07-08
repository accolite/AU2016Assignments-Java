package com.accolite.jayesh;

import java.util.*;

public class LinkedHashMap {
	ArrayList<LinkedList<Node>> bucket = new ArrayList<LinkedList<Node>>(100);
	Node head;
	Node tail;
	LinkedHashMap()
	{
		for(int i = 0; i < 100; i++)
		{
			LinkedList<Node> temp = new LinkedList<Node>();
			bucket.add(temp);
		}
		
	}
	public void put(int key,String value)
	{
		Node present = new Node();
		int i = getIndex(key);
	}
	public int getIndex(int key)
	{
		return 0;
	}
	
	
}
