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
		map.put(0, "a");
		map.put(5, "g");
		map.put(2, "c");
		map.put(3, "d");
		map.put(4, "e");
		map.put(0, "f");
		map.get(5);
		map.get(6);
		map.put(1, "g");
		map.get(4);
		
		
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
			list.remove(hash);
			list.add(hash,node);
			//System.out.println(node.value);
			System.out.println(list);
			
		}
		else
		{
			currentNode =list.get(hash);
			System.out.println(currentNode);
			
			if(currentNode.key.equals(a))
			{
				currentNode.value=b;
			}
			int flag=1;
			
			while((currentNode.next)!=null)
			{
				if(currentNode.key.equals(a))
				{
					flag=0;
					System.out.println(currentNode.value);
					
					break;
					
				}
				currentNode=currentNode.next;
			}
			
			if(flag==1)
			{
				newNode = new Node(a,b);
				newNode.key=a;
				newNode.value=b;
				newNode.next=null;
				newNode.previous=currentNode;
				//node.NodeArray.add(addedNode);
				currentNode.next=newNode;
				//list.add(addedNode);	
			}
			
		}		
	}
	
	void get(Object a)
	{
		int hash=a.hashCode();
		hash=hash%5;
		
		if(list.get(hash)==null)
		{
			System.out.println("Invalid Key");
		}
		
		else
		{
			Node currentNode=list.get(hash);
			
			while((currentNode.key)!=a)
			{
				currentNode=currentNode.next;
			}
			
			System.out.println(currentNode.value);
			
		}
		
	}
}
