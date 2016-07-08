package com.accolite.aasignment3;

import java.lang.Object;
import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedHashMap {
	
		Object key;
		Object value;
		static ArrayList <Node> list;
		
		public LinkedHashMap()
		{
			list = new ArrayList(5);
			for(int i=0;i<5;i++)
			{
				list.add(i,null);
			}
		}
		

	
	
	Node node;
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		LinkedHashMap map = new LinkedHashMap();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		map.put(4, "d");
		map.put(5, "e");
		map.put(6, "f");
		map.get(5);
		map.get(6);
		
		
	}
	
	
	void put(Object a , Object b)
	{
		int hash = a.hashCode();
		hash = hash % 5;
		
		Node currentNode=null;
		Node newNode=null;
		
		if(list.get(hash)==null)
		{
			Node node = new Node(a,b);
			node.NodeArray.add(node);
			list.add(hash,node);
			//System.out.println(node.value);
			//System.out.println(list);
			
		}
		else
		{
			currentNode =list.get(hash);
			
			while((currentNode.next)!=null)
			{
				currentNode=currentNode.next;
			}
			
			newNode = new Node(a,b);
			Node addedNode=node.addNode(currentNode,newNode,a,b);
			node.NodeArray.add(addedNode);
			list.add(addedNode);
		}		
	}
	
	void get(Object a)
	{
		int hash=a.hashCode();
		hash=hash%5;
		
		Node currentNode=list.get(hash);
		
		while(currentNode.key!=a)
		{
			currentNode=currentNode.next;
		}
		
		System.out.println(currentNode.value);
		
	}
}
